<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/styles.css">
    <#include "/templates/inc/head.ftl"/>
    <title>Registro</title>
</head>
<body class="reg">
    <div class="regSup">
    </div>
    <div class="regPanel">
        <form action="../registro" method="post">
            <label for="alias">Alias</label>
            <input type="text" name="alias" id="alias" required>
            <label for="password">Contraseña</label>
            <input type="password" name="password" id="password" required>
            <label for="nombre">Nombre</label>
            <input type="text" name="nombre" id="nombre" required>
            <label for="apellido">Apellido</label>
            <input type="text" name="apellido" id="apellido" required>


            <div class="reg_submit">
                <a href="/" class="registroCan">Cancelar</a>
                <input type="submit" value="Crear" class="crear">
            
            </div>
            
        </form>
    </div>

    <img src="/imgs/fotoperfil1.png" class="imgReg">
</body>
</html>