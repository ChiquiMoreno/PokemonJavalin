<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pantalla 63</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
    <header>
    <#include "/templates/inc/header_nombre_apellidos.ftl"/>
    </header>
    <form action="/logueado/nuevaligaJugadores" method="post">
    <input type="hidden" name="ligaId" value="${ligaId}">
    <#if error??>
        <div class="mensaje-error">
            ${error}
        </div>
    </#if>
    <div class="contenedortarjetas">
        <input class="busqueda" placeholder="Buscar" />
        <div class="maestrosapuntados">
        </div>
        <#list usuarioList as usuario>
        <div class="tarjeta <#if usuario?index % 2 == 1>morado</#if>">
            <input 
                    type="checkbox" 
                    name="usuariosSeleccionados" 
                    value="${usuario.alias}"
                    <#if usuariosSeleccionados?? && usuariosSeleccionados?seq_contains(usuario.alias?string)>checked</#if>
                />
            <div class="pic">
            <img src="/imgs/fotoperfil2.png" alt="fotoperfil" />
            </div>
            <div class="txt">${usuario.nombre!""}<br>${usuario.alias!""}</div>
        </div>
        </#list>
         <div class="botones">
        <button class="btn-aplicar" type="submit">Aplicar</button>
        <div class="btn-cancelar">Cancelar</div>
    </div>
    </div>
    </form>
</body>
</html>