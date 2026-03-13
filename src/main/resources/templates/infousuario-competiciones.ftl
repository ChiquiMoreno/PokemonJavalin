<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pantalla 41</title>
    <link rel="stylesheet" href="/css/styles.css">
    <#include "/templates/inc/head.ftl"/>
</head>

<body class="perfil">


<div class="usuarioSup"></div>
<div class= "barranegra"> </div>

<div class="contenedortarjetas podioliga">
        <div class="botones-perfil">
            <a href="/logout" class="logout"><img src="/imgs/salir.png" alt="Logout"></a>
            <a href="./editar-perfil" class="editarperfil" ><img src="/imgs/llave.png" alt="Editar perfil"></a>
        </div>

    <div class="titulomesa">

        <div class="usuario-nombre">
            <p class="italica">Nombre y apellido</p>
            <p>${nombreApellido}</p>
        </div>
        <div class="usuario-apellido">
            <p class="italica">Alias</p>
            <p>${alias}</p>
        </div>

        </div>

        <p class="italica">CAMPEONATOS</p>
        
        <div class="ligasUser">
            <#list ligas as liga>
                <div class="tarjeta blanco" >
                    <div class="txt">${liga.tipo}<br>${liga.fecha}<br>${liga.lugar}<br>
                    <a class="tarjeta-torneo-link" href="/logueado/torneos/${liga.idLiga}">Más información</a>
                    </div>
                    <div class="btns">
                        <div class="ligapokemon"></div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</div>

<div class="botones">
    <div class="btn-aplicar">Cerrar liga</div>
</div>

<div class="img-perfil">
    <img src="/imgs/fotoperfil1.png" alt="">
</div>
<div class="img-logo-perfil">
    <img src="/imgs/logo2.png" alt="">
</div>

<#include "/templates/inc/navbarbtn3red.ftl"/>
</body>
</html>