<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="/css/loginStyle.css">
    <#include "/templates/inc/head.ftl"/>
</head>
<body class="login">
    <#if error??> <#-- si el usuario es incorrecto y existe el error mostrarlo-->
    <div class="error">
        <img src="/imgs/caratriste.png" alt="caratriste.png">
        <p>Ups... el ID y la contraseña no coinciden</p>
    </div>
    </#if>
    <div class="contenedor">
        <div class="imgLogin">
            <img src="/imgs/logo2.png" alt="">
        </div>
    </div>
    
    <div class="loginPanel">
        <form action="autenticar" method="post">
            <input type="text" name="alias" id="alias" placeholder="Alias" required>

            <input type="password" name="password" id="password" placeholder="Contraseña" required>

            <input type="submit" value="LOGIN">
            <a href="/registro">Crear una cuenta</a>
        </form>    
    </div>


</body>
