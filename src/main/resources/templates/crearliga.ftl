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
        <form class="formulario" action="/logueado/nuevaliga" method="post">
            <label>Tipo*<br> <select required name="tipo">
                <option value="" selected disabled hidden>- - -</option >
                <option value="1" >Competitivo estándar</option >
                <option value="2" >Expandido</option >
                <option value="3" >Desafío líder de gimnasio</option >
                <option value="4" >Amistoso</option >
            </select></label>
            <div class="inputsmedianos">
                <label>Día*<br> 
                    <input type="date" name="dia" class="mediano" required placeholder="09/01/2025"></label>
                <label>Hora*<br> 
                    <input type="time" name="hora" class="mediano" required placeholder="16:30"></label>
            </div>
            <label>Lugar*<br> <select name="lugar" required>
                    <option value="" selected disabled hidden>- - -</option >
                <option value="Comics Pamplona" >Comics Pamplona</option >
                <option value="D20 Juegos" >D20 Juegos</option >
                </select  required></label>
            <label>Rondas<br> <select name="rondas" required>
                    <option value="" selected disabled hidden>- - -</option >
                <option value="Bo1" >Bo1</option >
                <option value="Bo3" >Bo3</option >
                <option value="Bo5" >Bo5</option >
                </select required></label>
            <#--  <label>Maximo de jugadores*<br> <select required>
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
            </select></label>  -->
            <#--  <div class="btn-aplicar">Siguiente</div>  -->
           
                <button class="btn-aplicar" type ="submit">Siguiente</button>
                <div class="btn-cancelar">Cancelar</div>
  
        </form>             
    </div>
</body>
</html>