/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endpoint;

import Controladores.VideojuegosJpaController;
import Controladores.exceptions.NonexistentEntityException;
import Entidades.Rentasvideojuegos;
import Entidades.Videojuegos;
import java.util.ArrayList;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Zannie
 */
@ServerEndpoint("/endpoint")
public class Endpoint {

    VideojuegosJpaController facade = new VideojuegosJpaController();

    @OnMessage
    public String onMessage(String message) {
        System.out.println(message);
        updateVideogame(message);

        return null;
    }

    @OnOpen
    public void onOpen() {
        System.out.println("The user has been disconnected");
    }

    @OnError
    public void onError(Throwable t) {
          System.out.println("Error WebSocket");

    }

    @OnClose
    public void onClose() {
        System.out.println("The user has been disconnected");
        facade.closeFactory();
    }

    private void updateVideogame(String message) {
        try {
            String[] values = splitMessage(message);
            Videojuegos videogame = getVideogame(values);

            facade.edit(videogame);
        } catch (NonexistentEntityException ex) {
            System.out.println("aaaaaa");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private Videojuegos getVideogame(String[] values) {
        Videojuegos videogame = new Videojuegos();
        videogame.setNumCatalogo(values[0]);
        videogame.setTitulo(values[1]);
        videogame.setGenero(values[2]);
        videogame.setClasificacion(values[3]);
        videogame.setConsola(values[4]);
        videogame.setFabricante(values[5]);
        videogame.setVersion(Integer.parseInt(values[6]));
        videogame.setRentasvideojuegosList(new ArrayList<Rentasvideojuegos>());

        return videogame;
    }

    private String[] splitMessage(String message) {
        String[] values = new String[7];
        String[] attributes = message.split(",");

        for (int i = 0; i < attributes.length; i++) {
            String[] valuesTemp = attributes[i].split(":");
            values[i] = getCharacters(valuesTemp[1]);
            System.out.println(values[i]);

        }

        return values;
    }

    private String getCharacters(String string) {
        String temp = "";
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i)) || Character.isLetter(string.charAt(i))) {
                temp += String.valueOf(string.charAt(i));
            }
        }

        return temp;
    }

}
