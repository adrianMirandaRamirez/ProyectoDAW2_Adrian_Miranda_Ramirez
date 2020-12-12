<%-- 
    Document   : infoActivEliminacion
    Created on : 22-sep-2020, 18:02:21
    Author     : adrian
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />

<!DOCTYPE html>
<html>
    <head>
        <jsp:directive.include  file="../../../INC/metas.inc"/> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="StyleSheet" href="CSS/estilos.css" type="text/css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <jsp:useBean id="actividades" scope="page"  class="es.albarregas.beans.Actividad" />    
        <title>ListarActividades</title>
    </head>
    <body style="background-color: white">
        <div class="container-fluid" style="border: groove 10px greenyellow">
            <div class="row cabecera">
                <div class="col-4 ">
                    <img id="logo" src="Imagenes/boeing-159589_640.png" >

                </div>
                <div class="col-4 ">

                    <p  id="titulo"><strong>World Travel</strong></p>
                </div>
                <div class="col-4 ">
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
                    <h2 id="tituloList">Listado de Actividades</h2>
                    <table id="t01">
                                <tr>                             
                                    <th>IdActividad</th> 
                                    <th>Nombre de la actividad</th>
                                    <th>Descripcion</th>
                                    <th>Lugar</th>
                                    <th>Telefono </th>
                                    <th>Correo </th>
                                    <th>Precio(€)</th>
                                    <th>Fecha </th>

                                </tr>


                                <c:forEach var="elemento" items="${requestScope.actividades}">

                                    <tr>
                                        <td><strong>${elemento.idActividad}</strong></td>
                                        <td><strong>${elemento.nombreActiv}</strong></td>
                                        <td><strong>${elemento.descripcion}</strong></td>
                                         <td><strong>${elemento.lugar}</strong></td>
                                        <td><strong>${elemento.telefono}</strong></td>
                                        <td><strong>${elemento.correo}</strong></td>
                                          <td><strong>${elemento.precio}</strong></td>
                                        <td><strong>${elemento.fecha}</strong></td>
                                    </tr>
                                    
                                </c:forEach>

                            </table>

                </div>

                <form action="OperacionEliminar" method="post">
                    <button  type="submit" class="btn btn-success " name="eliminarA" id="menu">Eliminar</button>
                    <button  type="submit" class="btn btn-danger" name="cancelar" >Cancelar</button>
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


