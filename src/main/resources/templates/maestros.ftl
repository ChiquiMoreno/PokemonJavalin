<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/styles.css">
    <#include "/templates/inc/head.ftl"/>
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
        <div class="enlace"><a href="./perfil">Mi cuenta</a></div>
        <#list usuarios as usuario>
        <div class="tarjeta flexrow">
            <div class="pic">
            <img src="/imgs/fotoperfil2.png" alt="fotoperfil"></img>
            </div>
            <div class="txt">${usuario.nombre} ${usuario.apellido}<br> ${usuario.alias}</div>
            <div class="btns">
                <form action="./perfil/${usuario.alias}" method="get">
                    <button class="btn1">···</button>
                </form>
                <form action="./adm/eliminar-perfil/${usuario.alias}" method="get">
                    <button class="btn2"></button>
                </form>

            </div>
        </div>
        </#list>
    </div>
<#include "/templates/inc/navbarbtn3red.ftl"/>


</body>
</html>