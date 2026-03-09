<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Torneo</title>
    <link rel="stylesheet" href="/css/styles.css">
    
</head>
<body>
    <main class="pantalla-torneos">
        <header>
        <#include "/templates/inc/encabezado1.ftl"/>

        </header>

        <!-- Revisar si cambiamos checkbox por radio button -->
        <section class="torneos">
            <div class="menutorneos">
                <div class="desptorneo">
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
                </div>
                <form action="/logueado/crearliga" method="get">
                    <#--  <button class="boton-anadir" type="submit">  -->
                     <button type="submit">
                        <!--<img src="imgs/iconomas.png" alt="Añadir torneo">-->
                        Añadir torneo
                    </button>
                </form>
            </div>

            <div class="lista-torneos">
                <#list listaLigas as liga>
                    <div class="tarjeta-torneo">
                            <h3>${liga.tipo}</h3>
                            <span class="tarjeta-torneo-estado iniciar">${liga.estado}</span>
                        <div class="tarjeta-torneo-detalle">
                            <p>${liga.fecha}</p>
                            <p>${liga.lugar}</p>
                            <p>Ganador:</p>
                        </div>
                        <a class="tarjeta-torneo-link" href="/torneos/${liga.idLiga}">Más información</a>
                        <div class="tarjeta-torneo-acciones">
                            <button type="button" class="button-agregar">
                                <img src="imgs/persona.png" alt="Participantes">
                            </button>
                            <button type="button" class="button-eliminar">
                                <img src="imgs/papelera.png" alt="Eliminar">
                            </button>
                        </div>
                    </div>
                </#list>

            </div>
        </section>

<#include "/templates/inc/navbar.ftl"/>


    </main>
</body>
</html>
