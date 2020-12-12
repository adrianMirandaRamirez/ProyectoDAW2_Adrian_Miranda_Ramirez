<%-- 
    Document   : Buscador
    Created on : 27-sep-2020, 10:08:11
    Author     : adrian
--%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />

<!DOCTYPE html>
<html>
    <head>
        <jsp:directive.include  file="../../INC/metas.inc"/> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="StyleSheet" href="CSS/estilos.css" type="text/css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <jsp:useBean id="hoteles" scope="page"  class="es.albarregas.beans.Hotel" />    
        <jsp:useBean id="usuario" scope="page"  class="es.albarregas.beans.Usuario" />    
        <jsp:useBean id="actividades" scope="page"  class="es.albarregas.beans.Actividad" />    

        <title>Hoteles</title>
    </head>
    <body style="background-color: white">
        <c:set var="usuario" value="${sessionScope.usuario}"/>
        <div class="container-fluid" style="border: groove 10px greenyellow">
            <div class="row cabecera">
                <div class="col-4 ">
                    <img id="logo" src="Imagenes/boeing-159589_640.png" >

                </div>
                <div class="col-4 ">

                    <p  id="titulo"><strong>World Travel</strong></p>
                </div>
                <div class="col-4 ">

                    <strong style="color: white;margin-left: 200px">Usuario:${usuario.nombre}</strong>
                    <form action="Redireccion" method="post">
                        <button  class="btn btn-danger cerrarSesion" name="cerrarSesion" id="cerrarSesion" >Cerrar sesion</button>
                    </form>
                </div>

            </div>

            <div class="row cuerpo" >
                <div class="col-12">
                    <p><label for="buscador"><h2>Viaja con nosotros y descubriras sitios increibles</h2></label></p>

                </div>
            </div>

            <div class="row">

                <div class="col-12">
                    <h2 id="tituloList">Listado de hoteles</h2>


                    <p>
                    <h3 id="mensaje">${requestScope.mensajeHotel}</h3>
                    </p>
                    <c:forEach var="elemento" items="${requestScope.hoteles}">

                        <c:choose>
                            <c:when test="${fn:startsWith(elemento.fotoHotel, defaultH)}">
                                <img src="${contexto}/Imagenes/hoteles/${elemento.fotoHotel}" width="150" height="150" >
                                <strong style="font-size: 30px">
                                    Nombre: Hotel ${elemento.nombreHotel},${elemento.lugar}
                                </strong>

                                <strong style="font-size: 17px">
                                    <p>Precio: ${elemento.precio}<br>
                                        Telefono: ${elemento.telefono}<br>
                                        Correo: ${elemento.correo} 
                                    </p>
                                </strong> 
                                <!-- style="margin-left: 500px;margin-top: 10px;"-->
                                <form action="Reserva">
                                    <input type="hidden" name="idUsuario" value="${usuario.idUsuario}"/>
                                    <input type="hidden" name="idHotel" value="${elemento.idHotel}"/>
                                    <label for="fecha"><strong>Fecha de la reserva</strong></label><br>
                                    <input type="date" name="fecha" style="width: 400px">
                                    <p><input type="submit" name="reservarHotel" value="Reservar" class="btn col-2 btn-primary" /></p>
                                </form>


                                <br><hr style="border: 1px solid black">
                            </c:when>

                            <c:when test="${fn:endsWith(elemento.fotoHotel, png)}">
                                <img src="${contexto}/Imagenes/hoteles/FotoH${elemento.idHotel}.png" width="150" height="150" >

                                <strong>
                                    Nombre: Hotel ${elemento.nombreHotel},${elemento.lugar}


                                </strong>

                                <strong style="font-size: 17px">
                                    <p>Precio: ${elemento.precio}<br>
                                        Telefono: ${elemento.telefono}<br>
                                        Correo: ${elemento.correo} 
                                    </p>
                                </strong> 
                                <form action="Reserva">
                                    <input type="hidden" name="idUsuario" value="${usuario.idUsuario}"/>
                                    <input type="hidden" name="idHotel" value="${elemento.idHotel}"/>
                                    <label for="fecha"><strong>Fecha de la reserva</strong></label><br>
                                    <input type="date" name="fecha" style="width: 400px">
                                    <p><input type="submit" name="reservarHotel"  value="Reservar" class="btn col-2 btn-primary" /></p>
                                </form>
                                <br><hr style="border: 1px solid black">
                            </c:when>

                            <c:when test="${fn:endsWith(elemento.fotoHotel, jpg)}">
                                <img src="${contexto}/Imagenes/hoteles/FotoH${elemento.idHotel}.jpg" width="150" height="150" >

                                <strong>
                                    Nombre: Hotel${elemento.nombreHotel},${elemento.lugar}


                                </strong>
                                <strong style="font-size: 17px">
                                    <p>Precio: ${elemento.precio}<br>
                                        Telefono: ${elemento.telefono}<br>
                                        Correo: ${elemento.correo} 
                                    </p>
                                </strong> 
                                <form action="Reserva">
                                    <input type="hidden" name="idUsuario" value="${usuario.idUsuario}"/>
                                    <input type="hidden" name="idHotel" value="${elemento.idHotel}"/>
                                    <label for="fecha"><strong>Fecha de la reserva</strong></label><br>
                                    <input type="date" name="fecha" style="width: 400px" >
                                    <p><input type="submit" name="reservarHotel"  value="Reservar" class="btn col-2 btn-primary" /></p>
                                </form>
                                <br><hr style="border: 1px solid black">
                            </c:when>
                        </c:choose>

                    </c:forEach>





                </div>

                <form action="Redireccion" method="post">
                    <button  type="submit" class="btn btn-success" name="menuHotelActividad" id="menu">Menu inicial</button>
                </form>

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
