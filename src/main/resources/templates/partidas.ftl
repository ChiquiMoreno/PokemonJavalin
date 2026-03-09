<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pantalla 50</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>

<body class="alinear">

<header>
<#include "/templates/inc/header_nombre_apellidos.ftl"/>
</header>

<div class="contenedortarjetas">

    <div class="flex-tituloliga">
        <div class="tituloliga">Partidas</div>
        <div class="puntuacionpartida">1/5</div>
    </div>

    <div class="envoltorio">

        <div class="titulomesa">
            Mesa 1
            <div class="tarjetasmesas">
                <div class="tarjetamesa">
                    <div class="txt">Urko<br>Martinez<br><br>Puntos: 0</div>
                    <div class="btns">
                        <div class="botonmesa1"></div>
                        <div class="botonmesa2"></div>
                        <div class="botonmesa3"></div>
                    </div>
                </div>
                <div class="tarjetamesa">
                    <div class="txt">Urko<br>Martinez<br><br>Puntos: 0</div>
                    <div class="btns">
                        <div class="botonmesa1"></div>
                        <div class="botonmesa2"></div>
                        <div class="botonmesa3"></div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <div class="botones">
        <div class="btn-aplicar">Siguiente</div>
    </div>

</div>
<#include "/templates/inc/navbarbtn2red.ftl"/>
</body>
</html>