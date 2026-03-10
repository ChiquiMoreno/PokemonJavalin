<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Torneo</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body class="torneo">
    <header>
    <#include "/templates/inc/header_nombre_apellidos.ftl"/>
</header>
    <div class="panel">
        <h3>${liga.tipo}</h3>
        <div class="panel-datos">
            <div class="panel-datos-texto">
                <h4>Día y hora</h2>
                <p>${liga.tipo}</p>
            </div>
            <div class="panel-datos-texto">
                <h4>Lugar</h4>
                <p>${liga.lugar}</p>
            </div>
            <div class="panel-datos-texto">
                <h4>Rondas</h4>
                <p>${liga.rondas}</p>
            </div>
            <div class="panel-datos-texto">
                <h4>Descripción</h4>
                <p>${liga.descripcion}</p>
            </div>
        </div>
        <div class="maestros">
            <h4>Maestros inscritos</h4>
            <#list jugadores as jugador>
                <div class="tarjeta">
                    <div class="pic">
                    <img src="./imgs/fotoperfil2.png" alt="fotoperfil"> </img>
                    </div>
                    <div class="txt">${jugador.nombreJugador}<br> ${jugador.aliasJugador}</div>
                    <div class="btns">
                        <button class="btn1">···</button>
                        <button class="btn2"></button>
                    </div>
                </div>

            </#list>

        </div>
        
    </div>
<#include "/templates/inc/navbar.ftl"/>

    
</body>
</html>