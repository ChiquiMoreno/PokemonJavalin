<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#include "/templates/inc/head.ftl"/>
    <title>Sin-partida</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body> 
    <header>
          <#include "/templates/inc/encabezado1.ftl"/>
    </header>
            <div class="amonestacion-formulario sin-partida" action="" method="post">
                <div class="campo">
                    No hay una liga en curso<br>¿Desea iniciar una liga?
                
                    <form action="/logueado/torneos" method="get">
                        <div class="botones-sin">
                            <button class="btn-iniciar btn-grande sin-partida" type="submit">Iniciar</button>
                    </form>
                </div>
            </div>
    <#include "/templates/inc/navbarbtn1red.ftl"/>
           
</body>
</html>
