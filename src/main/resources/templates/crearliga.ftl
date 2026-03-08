<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pantalla 31</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>

<header>
<#include "/templates/inc/header_nombre_apellidos.ftl"/>
</header>
<body class="overflow">
    <div class="contenedortarjetas">
        <div class="titulo">Crear liga</div>
            <form class="formulario">
                <label>Tipo*<br> <select required>
                    <option value="" selected disabled hidden>- - -</option >
                    <option value="CE" >Competitivo estándar</option >
                    <option value="E" >Expandido</option >
                    <option value="3" >Desafío líder de gimnasio</option >
                </select></label>
                <div class="inputsmedianos"><label>Día*<br> <input class="mediano" required placeholder="09/01/2025"></label>
                     <label>Hora*<br> <input class="mediano" required placeholder="16:30"></label>
                </div>
                <label>Lugar*<br> <select>
                      <option value="" selected disabled hidden>- - -</option >
                    <option value="CP" >Comics Pamplona</option >
                    <option value="2" >D20 Juegos</option >
                    </select  required></label>
                <label>Rondas<br> <select>
                      <option value="" selected disabled hidden>- - -</option >
                    <option value="3" >Bo3</option >
                    <option value="5" >Bo5</option >
                    </select required></label>
                <label>Maximo de jugadores*<br> <select required>
                      <option value="" selected disabled hidden>- - -</option >
                    <option value="2" >2</option >
                    <option value="4" >4</option >
                    <option value="6" >6</option >
                    <option value="8" >8</option >
                    <option value="10" >10</option >
                    <option value="12" >12</option >
                    <option value="14" >14</option >
                    <option value="16" >16</option >
                    <option value="18" >18</option >
                    <option value="20" >20</option >
                </select></label>
            </form>
             <div class="botones">
            <div class="btn-aplicar">Guardar</div>
            <div class="btn-cancelar">Cancelar</div>
        </div>    
        </div>
</body>
</html>