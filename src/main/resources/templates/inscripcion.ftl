<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pantalla 63</title>
    <link rel="stylesheet" href="/css/styles.css">
    <#include "/templates/inc/head.ftl"/>
</head>
    <header>
    <#include "/templates/inc/header_nombre_apellidos.ftl"/>
    </header>
    <form action="/logueado/adm/nuevaligaJugadores" method="post">
    <input type="hidden" name="ligaId" value="${ligaId}">
    <#if error??>
        <div class="error-loguearse">
            <img src="/imgs/caratriste.png" alt="caratriste.png">
            <p>${error}</p>
        </div>
    </#if>
    <div class="contenedortarjetas">
        <#--  <input class="busqueda" placeholder="Buscar" />  -->
        <div class="titulo">Agregar usuarios</div>

        <div class="lista-agregar-usuarios">
            <#list usuarioList as usuario>
            <div class="tarjeta">
                
            <label class="label-usuarios" for="${usuario.alias}">
                <div class="user-check-container">
                    <div class="primer-contenedor">
                        <div class="pic">
                            <img src="/imgs/fotoperfil2.png" alt="fotoperfil" />
                        </div>

                        <div class="txt">${usuario.nombre!""} ${usuario.apellido!""}</div>
                    </div>
                    <div>            
                        <div class="check-box-usuario-icon">
                            <input type="checkbox" class="check-box-usuarios" id="${usuario.alias}" name="usuariosSeleccionados" value="${usuario.alias}" <#if usuariosSeleccionados?? && usuariosSeleccionados?seq_contains(usuario.alias?string)>checked</#if>/>
                        </div>
                    </div>
                </div>
            </label>
            </div>
            </#list>
        </div>
         <div class="botones-crear-liga">
            <div class="btn-cancelar">
                <a href="./torneos">Cancelar</a>
            </div>
            <button class="btn-aplicar btn-base" type="submit">Aplicar</button>
        </div>

    </div>
    </form>
</body>
</html>