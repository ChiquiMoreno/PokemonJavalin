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

                <button class="boton-anadir" type="button">
                    <img src="imgs/iconomas.png" alt="Añadir torneo">
                </button>

            </div>

            <div class="lista-torneos">

                <div class="tarjeta-torneo">
                        <h3>Amistoso</h3>
                        <span class="tarjeta-torneo-estado iniciar">iniciar</span>
                    <div class="tarjeta-torneo-detalle">
                        <p>0/07/2026</p>
                        <p>Comics Pamplona</p>
                        <p>Ganador:</p>
                    </div>
                    <a class="tarjeta-torneo-link" href="/torneos">Más información</a>
                    <div class="tarjeta-torneo-acciones">
                        <button type="button" class="button-agregar">
                            <img src="imgs/persona.png" alt="Participantes">
                        </button>
                        <button type="button" class="button-eliminar">
                            <img src="imgs/papelera.png" alt="Eliminar">
                        </button>
                    </div>
                </div>

            </div>
        </section>

<#include "/templates/inc/navbar.ftl"/>
  <#--  <footer class="navbar">
            <a href="/">
                <img src="imgs/salirRojo.png" alt="cerrar-sesion">
            </a>
            <a href="/torneos">
                <img src="imgs/pokeballred.png" alt="pokeballred">
            </a>
            <a href="/maestros">
                <img src="imgs/persona.png" alt="persona">
            </a>
    </footer>-->

    </main>
</body>
</html>
