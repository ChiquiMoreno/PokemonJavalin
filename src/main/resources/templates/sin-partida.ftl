<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Amonestacion</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body> 
    <header>
        <div class="encabezado1">
            <h1>Torneos</h1>
            <img src="/imgs/logo2.png" alt="Insignia de torneo" class="logo-playpokemon">   
        </div>
        <div class="horizontal">
            <h2>Aitor Amigot PROV</h2>
            <img src="/imgs/pikachu.png" alt="pikachu" class="encabezado1-pikachu">
        </div>
    </header>
            <div class="amonestacion-formulario sin-partida" action="" method="post">
                <div class="campo">
                    No hay una liga en curso<br>¿Desea iniciar una liga?
                
                    <form action="/logueado/torneos" method="get">
                        <div class="botones">
                            <button class="btn-aplicar amarillo" type="submit">Iniciar</button>
                    </form>
                </div>
            </div>
    <#include "/templates/inc/navbarbtn1red.ftl"/>
           
</body>
</html>
