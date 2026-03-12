<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#include "/templates/inc/head.ftl"/>
    <title>Torneo</title>
    <link rel="stylesheet" href="/css/styles.css">
    
</head>
<body>
    <main class="pantalla-torneos">
        <header>
        <#include "/templates/inc/encabezado1.ftl"/>

        </header>

        <#if error??> <#-- si la liga esta en curso lo muestra-->
            <div class="error">
                <img src="/imgs/caratriste.png" alt="caratriste.png">
                <p>Ups... la liga ya esta en curso.</p>
            </div>
            </#if>

        <!-- Revisar si cambiamos checkbox por radio button -->
        <section class="torneos">
            <div class="menutorneos">
                <!-- <div class="desptorneo">
                    <input type="checkbox" id="anio">
                    <label for="anio">AÑO</label>
                    <div class="despAnios">
                        <select>
                            <option>2026</option>
                            <option>2025</option>
                            <option>2024</option>
                            <option>2023</option>
                            <option>2022</option>
                            <option>2021</option>
                            <option>2020</option>
                        </select>
                    </div>
                </div>

                <div class="desptorneo">
                    <input type="checkbox" id="mes">
                    <label for="mes">MES</label>
                    <div class="despCalendario">
                        <select>
                            <option>Enero</option>
                            <option>Febrero</option>
                            <option>Marzo</option>
                            <option>Abril</option>
                            <option>Mayo</option>
                            <option>Junio</option>
                            <option>Julio</option>
                            <option>Agosto</option>
                            <option>Septiembre</option>
                            <option>Octubre</option>
                            <option>Noviembre</option>
                            <option>Diciembre</option>
                        </select>
                    </div>
                </div>

                <div class="desptorneo">
                    <input type="checkbox" id="tipo">
                    <label for="tipo">TIPO</label>
                    <div class="despTipo">
                        <select>
                            <option>Competitivo estándar</option>
                            <option>Expandido</option>
                            <option>Desafío lider de gimnasio</option>
                            <option>Amistoso</option>
                        </select>
                    </div>
                </div> -->
                <form action="/logueado/torneos-filtrado" method="post">
                    <select name="tipo" id="tipo" class="tipo">
                        <option value="Competitivo estándar">Competitivo estándar</option>
                        <option value="Expandido">Expandido</option>
                        <option value="Desafío lider de gimnasio">Desafío lider de gimnasio</option>
                        <option value="Amistoso">Amistoso</option>
                    </select>
                    <input type="submit" value="🔍" class="tipo tiposubmit">
                </form>

                <form action="/logueado/crearliga" method="post">
                    <button class="boton-anadir" type="submit">
                        <img src="/imgs/iconomas.png" alt="Añadir torneo">
                    </button>
                </form>

            </div>

            <#-- mostrar primero los torneos en curso, luego los que no han iniciado y por último los finalizados -->
            <div class="lista-torneos">
                <#list listaLigas as liga>
                    <#if liga.estado == 1>               
                            <div class="tarjeta-torneo">
                                    <h3>${liga.tipo}</h3>
                                    <a href="/logueado/partidas/${liga.idLiga}" class="tarjeta-torneo-estado en-curso">${liga.estadoStr}</a>
                                <div class="tarjeta-torneo-detalle">
                                    <p>${liga.fecha}</p>
                                    <p>${liga.lugar}</p>
                                </div>
                                <a class="tarjeta-torneo-link" href="/logueado/torneos/${liga.idLiga}">Más información</a>
                                <div class="tarjeta-torneo-acciones">
                                        <#--  ya no se pueden agregar participantes a los torneos, por lo que se ha comentado el botón de agregar -->
                                        <#--  <button type="button" class="button-agregar">
                                            <img src="/imgs/persona.png" alt="Participantes">
                                        </button>  -->

                                </div>
                            </div>
                        </#if>

                </#list>

            <div class="lista-torneos">
                <#list listaLigas as liga>
                    <#if liga.estado == 0 || liga.estado == 2>

                            <div class="tarjeta-torneo">
                                    <h3>${liga.tipo}</h3>
                                    <#if liga.estado == 0>
                                    <form action="/logueado/partidas/${liga.idLiga}" method="post">
                                        <button type="submit" class="tarjeta-torneo-estado iniciar" <#if ligaEnCursoId??>disabled</#if>>${liga.estadoStr}</button>
                                    </form>
                                    <#if ligaEnCursoId??>
                                        <small>Ya hay una liga en curso.</small>
                                    </#if>
                                    <#else>
                                    <a href="/logueado/torneos/${liga.idLiga}" class="tarjeta-torneo-estado finalizado">${liga.estadoStr}</a>
                                    </#if>

                                <div class="tarjeta-torneo-detalle">
                                    <p>${liga.fecha}</p>
                                    <p>${liga.lugar}</p>
                                </div>
                                <a class="tarjeta-torneo-link" href="/logueado/torneos/${liga.idLiga}">Más información</a>
                                <div class="tarjeta-torneo-acciones">
                                        <#--  ya no se pueden agregar participantes a los torneos, por lo que se ha comentado el botón de agregar -->
                                        <#--  <button type="button" class="button-agregar">
                                            <img src="/imgs/persona.png" alt="Participantes">
                                        </button>  -->
                                    <form action="./eliminar-liga/${liga.idLiga}" method="get">
                                        <button type="submit" class="button-eliminar">
                                            <img src="/imgs/papelera.png" alt="Eliminar">
                                        </button>
                                    </form>
                                </div>
                            </div>
                    </#if>
                </#list>

            </div>
        </section>

<#include "/templates/inc/navbarbtn2red.ftl"/>


    </main>
</body>
</html>
