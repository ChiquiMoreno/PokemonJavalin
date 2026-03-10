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
<#--  <#include "/templates/inc/header_nombre_apellidos.ftl"/>  -->
</header>

<div class="contenedortarjetas">

    <div class="flex-tituloliga">
        <div class="tituloliga">Partidas</div>
        <div class="puntuacionpartida">${numRondaActual}/${numRondasTotales}</div>
    </div>

    <form method="post" action="/logueado/partidas/${idLiga}/siguiente" class="form-ronda">
        <div class="envoltorio">
            <#assign hayPartida = partida?? && partida.partida??>

            <#if hayPartida>
            <#assign totalMesas = partida.partida?size>
            <#list 1..totalMesas as mesaId>
                    <#assign mesa = partida.getMesaById(mesaId)>
                    <#if mesa??>
                        <#assign jugadorA = mesa.jugadorA!>
                        <#assign jugadorB = mesa.jugadorB!>
                        <div class="titulomesa">Mesa ${mesaId}</div>
                        <div class="tarjetasmesas">
                            <label class="tarjetamesa selectable <#if mesa.ganadorMesa?? && jugadorA?? && mesa.ganadorMesa == jugadorA.aliasJugador>morado</#if>">
                                <input type="radio" name="resultadoMesa_${mesaId}" value="A" class="winner-radio" <#if mesa.ganadorMesa?? && jugadorA?? && mesa.ganadorMesa == jugadorA.aliasJugador>checked</#if>>
                                <div class="txt">
                                    ${(jugadorA.nombreJugador)!'-'}<br>
                                    ${(jugadorA.apellidosJugador)!''}<br><br>
                                    Puntos: ${(jugadorA.puntaje)!0}
                                </div>
                                <span class="winner-crown" aria-hidden="true"></span>
                            </label>

                            <label class="tarjetamesa selectable <#if mesa.ganadorMesa?? && jugadorB?? && mesa.ganadorMesa == jugadorB.aliasJugador>morado</#if>">
                                <input type="radio" name="resultadoMesa_${mesaId}" value="B" class="winner-radio" <#if mesa.ganadorMesa?? && jugadorB?? && mesa.ganadorMesa == jugadorB.aliasJugador>checked</#if>>
                                <div class="txt">
                                    ${(jugadorB.nombreJugador)!'-'}<br>
                                    ${(jugadorB.apellidosJugador)!''}<br><br>
                                    Puntos: ${(jugadorB.puntaje)!0}
                                </div>
                                <span class="winner-crown" aria-hidden="true"></span>
                            </label>
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
            <button type="submit" class="btn-aplicar">Siguiente ronda</button>
        </div>
    </form>

</div>
<#include "/templates/inc/navbarbtn1red.ftl"/>

<script>
    document.querySelectorAll('.winner-radio').forEach((radio) => {
        radio.addEventListener('change', () => {
            const mesa = radio.name;
            document.querySelectorAll('input[name="' + mesa + '"]').forEach((option) => {
                option.closest('.tarjetamesa').classList.toggle('morado', option.checked);
            });
        });
    });
</script>
</body>
</html>
