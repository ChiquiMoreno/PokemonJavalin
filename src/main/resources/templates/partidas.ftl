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
        <div class="puntuacionpartida">${(numRondaActual!1)}/${(numRondasTotales!5)}</div>
    </div>

    <div class="envoltorio">
        <#assign hayPartida = partida?? && partida.partida??>

        <#if hayPartida>
            <#list 1..10 as mesaId>
                <#assign mesa = partida.getMesaById(mesaId)>
                <#if mesa??>
                    <div class="titulomesa">
                        Mesa ${mesaId}
                        <div class="tarjetasmesas">
                            <#assign jugadorA = mesa.jugadorA!>
                            <#assign jugadorB = mesa.jugadorB!>

                            <div class="tarjetamesa <#if mesa.ganadorMesa?? && jugadorA?? && mesa.ganadorMesa == jugadorA.aliasJugador>morado</#if>">
                                <div class="txt">
                                    ${(jugadorA.nombreJugador)!'-'}<br>
                                    Alias: ${(jugadorA.aliasJugador)!'-'}<br><br>
                                    Puntos: ${(jugadorA.puntaje)!0}
                                </div>
                            </div>

                            <div class="tarjetamesa <#if mesa.ganadorMesa?? && jugadorB?? && mesa.ganadorMesa == jugadorB.aliasJugador>morado</#if>">
                                <div class="txt">
                                    ${(jugadorB.nombreJugador)!'-'}<br>
                                    Alias: ${(jugadorB.aliasJugador)!'-'}<br><br>
                                    Puntos: ${(jugadorB.puntaje)!0}
                                </div>
                            </div>
                        </div>

                        <form method="post" action="/logueado/partidas/${idLiga}/resultado" class="btns" style="margin-top:8px; display:flex; gap:8px;">
                            <input type="hidden" name="mesaId" value="${mesaId}">
                            <button type="submit" name="resultado" value="A" class="botonmesa1">Gana A</button>
                            <button type="submit" name="resultado" value="E" class="botonmesa2">Empate</button>
                            <button type="submit" name="resultado" value="B" class="botonmesa3">Gana B</button>
                        </form>
                    </div>
                </#if>
            </#list>
        <#else>
            <div class="titulomesa">
                No hay partidas disponibles todavía.
            </div>
        </#if>

    </div>

    <div class="botones">
        <form method="post" action="/logueado/partidas/${idLiga}/siguiente">
            <button type="submit" class="btn-aplicar">Siguiente ronda</button>
        </form>
    </div>

</div>
<#include "/templates/inc/navbarbtn2red.ftl"/>
</body>
</html>
