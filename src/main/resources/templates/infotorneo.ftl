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
        <h3>Competitivo estándar</h3>
        <div class="panel-datos">
            <div class="panel-datos-texto">
                <h4>Día</h4>
                <p>11/02/2026</p>
            </div>
            <div class="panel-datos-texto">
                <h4>Hora</h4>
                <p>16:30</p>
            </div>
            <div class="panel-datos-texto">
                <h4>Rondas</h4>
                <p>B03</p>
            </div>
            <div class="panel-datos-texto">
                <h4>Descripción</h4>
                <p>Formato estándar V6G no expandido de batallas PVP equilibrados con rotación de expansiones.</p>
            </div>
        </div>
        <div class="maestros">
            <h4>Maestros inscritos</h4>
            <a href="">Inscribir</a>
            <div class="tarjeta">
                <div class="pic">
                <img src="imgs/fotoperfil2.png" alt="fotoperfil">                </img>
                </div>
                <div class="txt">Álvaro Marturet<br> ID: 213121EF</div>
                <div class="btns">
                    <button class="btn1">···</button>
                    <button class="btn2"></button>
                </div>
            </div>
        </div>
    </div>


    <#include "/templates/inc/navbar.ftl"/>
</body>
</html>