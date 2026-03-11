<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pantalla 41</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>

<body class="perfil">


<div class="usuarioSup"></div>


<div class="contenedortarjetas podioliga">

    <div class="titulomesa">

        <i>Nombre y apellido</i><br>${nombreApellido}<br><br><i>Alias</i><br>${alias}<br><br>
        <div class="opciones-user">
            <a href="./editar-perfil" class="editar"> Editar</a>
            <a href="/logout" class="editar"> Logout</a>
        </div>

        <i>CAMPEONATOS</i><br><br>

        <div class="tarjeta blanco">

            <div class="txt">Competitivo estándar<br>11/01/2026<br>Comics Pamplona</div>
            <div class="btns">
                <div class="ligapokemon"></div>
            </div>
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