<%-- 
    Document   : paginaInicial
    Created on : 18-sep-2020, 19:20:54
    Author     : adrian
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />
<c:set var="contexto" value="${pageContext.servletContext.contextPath}" scope="application"/>
<c:url var="estilo" value="/CSS/estilos.css" scope="application"/>
<!DOCTYPE html>
<html>
    <head>
        <jsp:directive.include  file="../../INC/metas.inc"/> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="StyleSheet" href="CSS/estilos.css" type="text/css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>paginaInicial</title>
    </head>
    <body style="background-color: white">
        <div class="container-fluid" style="border: groove 10px greenyellow">
            <div class="row cabecera">
                <div class="col-4 ">
                    <form method="post" action="VerReservas">
                        <button  class="btn btn-danger" id="carrito" name="carrito">Carrito</button>
                    </form>
                    
                    

                </div>
                <div class="col-4 ">
                    
                    <p  id="titulo"><strong>World Travel</strong></p>
                </div>
                <div class="col-4 ">
                    <c:set var="usuario" value="${sessionScope.usuario}"/>
                    <strong style="color: white;margin-left: 200px">Usuario:${usuario.nombre}</strong>
                     <form action="Redireccion" method="post">
                        <button  class="btn btn-danger cerrarSesion" name="cerrarSesion" id="cerrarSesion" >Cerrar sesion</button>
                    </form>
                </div>

            </div>

            <div class="row cuerpo" >
                <div class="col-12">
                    <p><label for="buscador"><h2>Viaja con nosotros y descubriras sitios increibles</h2></label></p>
                   <form action="Buscador" method="post">
                        <input type="text" id="busqueda" placeholder="Introduzca su destino" name="destino">
                        <input type="submit" name="buscar" value="Buscar" class="btn col-2 btn-primary"  style="margin-left: 500px;margin-top: 10px;"/>
                    </form>
                </div>
            </div>

           <div class="row">
                
                <div class="col-6" id="hotel">
                    
                    <i class="fas fa-hotel " ></i>
                    <form action="Reservar" method="post">
                        <input type="submit"  name="reserHotel" value="Reservar Hotel" class="btn col-6 btn-primary"  style="margin-left: 100px;margin-top: 10px;"/>
                    </form>
                </div>
                
                <div class="col-6" id="actividades">
                    <i class="fas fa-skiing-nordic" ></i>
                    <form action="Reservar" method="post">
                    <input type="submit"  name="reserActividad" value="Reservar Actividad" class="btn col-6 btn-primary"  style="margin-left: 100px;margin-top: 10px;"/>
                    </form>
                </div>
            </div>

            <div class="row pie" >
                <div class="col-4" >
                    <p class="informacion">
                        <strong>Informacion personal</strong>
                    </p>

                    <p><strong>
                            Telefono: 924568213<br>
                            Correo electronico: WorldTravel@gmail.com<br>
                            Direccion: calle Juan Carlos I 

                        </strong>
                    </p>
                </div>
                <div class="col-4" >
                    <img id="logoPie" src="Imagenes/boeing-159589_640.png" >
                </div>
                <div class="col-4" >
                    <p class="informacion"><strong>Redes sociales</strong></p>
                    <p>
                        <i class="fab fa-facebook-square" id="facebook"></i>
                        <i class="fab fa-twitter-square" id="twitter"></i>
                        <i class="fab fa-youtube" id="youtube"></i>
                        <i class="fab fa-instagram" id="instagram"></i>
                    </p>

                </div>
            </div>
        </div>
    </body>
</html>
