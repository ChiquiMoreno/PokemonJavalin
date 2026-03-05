<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css">
    <title>Document</title>
</head>
<body>
    <header>
    <#include "/templates/inc/encabezado1.ftl"/>

    </header>

    <div class="panelMaestros">
        <form action="">
            <input type="text" placeholder="🔍 Buscar" class="barra-busqueda">
        </form>
        <div class="enlace"><a href="../perfil">Mi cuenta</a></div>
        <div class="tarjeta">
            <div class="pic">
            <img src="imgs/fotoperfil2.png" alt="fotoperfil"></img>
            </div>
            <div class="txt">Álvaro Marturet<br> ID: 213121EF</div>
            <div class="btns">
                <button class="btn1">···</button>
                <button class="btn2"></button>
            </div>
        </div>
    </div>
<#include "/templates/inc/navbar.ftl"/>
    <#--<footer class="navbar">
                <a href="/">
                    <img src="imgs/salirRojo.png" alt="cerrar-sesion">
                </a>
                <a href="/torneos">
                    <img src="imgs/pokeballred.png" alt="pokeballred">
                </a>
                <a href="/maestros">
                    <img src="imgs/persona.png" alt="persona">
                </a>
        </footer>-->

</body>
</html>