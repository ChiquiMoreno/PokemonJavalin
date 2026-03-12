<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/styles.css">
    <title>Modificar perfil</title>
    <#include "/templates/inc/head.ftl"/>
</head>
<body class="reg">
    
    <div class="regSup">
        <div class="edit-profpic">
        <img src="/imgs/fotoperfil1.png">
        <div class="botoneditar"></div>
        </div>
    </div>

    <#if error??> <#-- si error existe mostrar el error-->
        <div class="error">
            <img src="/imgs/caratriste.png" alt="caratriste.png">
            <p>Ups... la contraseña es incorrecta</p>
        </div>
        </#if>
    <div class="regPanel">
        
        <form action="./editar-perfil" method="post">
            <p>Alias</p>
            <p class="aliasperfil">${alias}</p>
            <label for="nombre">Nombre</label>
            <input type="text" name="nombre" id="nombre" required>
            <label for="apellido">Apellido</label>
            <input type="text" name="apellido" id="apellido" required>
            <label for="password">Contraseña</label>
            <input type="password" name="password" id="password" required>
            <div class="reg_submit">
                <a href="./perfil" class="cancelar">Cancelar</a>
                <input type="submit" name="opcion" value="Modificar" class="crear">
            
            </div>
            
        </form>
    </div>
    
   
</body>
</html>