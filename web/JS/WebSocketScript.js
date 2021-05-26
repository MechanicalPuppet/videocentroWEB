/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var url = "ws://localhost:8080/videocentroWEB/endpoint";
var webSocket = new WebSocket(url);
var jsonUpdate;


function sendMyMessage() {
    makeJSON();
    webSocket.send(jsonUpdate);

}

function makeJSON() {
    var numCatalogo = document.getElementById("numCatalogo").value;
    var titulo = document.getElementById("titulo").value;
    var genero = document.getElementById("genero").value;
    var clasif = document.getElementById("clasif").value;
    var consola = document.getElementById("consola").value;
    var fabricante = document.getElementById("fabricante").value;
    var version = document.getElementById("version").value;
    
    
    jsonUpdate = JSON.stringify({
        numCatalogo: numCatalogo,
        titulo: titulo,
        genero: genero,
        clasif: clasif,
        consola: consola,
        fabricante: fabricante,
        version: version
    });
}
