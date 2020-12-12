<%-- 
    Document   : modificarHotel
    Created on : 24-sep-2020, 17:49:20
    Author     : adrian
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />
<!DOCTYPE html>
<html>
    <head>
        <jsp:directive.include  file="../../../INC/metas.inc"/> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="StyleSheet" href="CSS/estilos.css" type="text/css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.0.min.js"></script> 
         <script type="text/javascript" src="../../../JS/jqueryTranslator.js"></script>
          <jsp:useBean id="hotel" scope="page"  class="es.albarregas.beans.Hotel" /> 

        <title>ModificarHotel</title>
    </head>
    <body style="background-color: white">
        <c:set var="hotel" value="${requestScope.hotel}"/>
        <div class="container-fluid" style="border: groove 10px greenyellow">
            <div class="row cabecera">
                <div class="col-4 ">
                    <img src="Imagenes/idiomas/espania.png" id="espania" class="banderas" >
                    <img src="Imagenes/idiomas/alemania.png" id="alemania" class="banderas">
                    <img src="Imagenes/idiomas/italia.png"  id="italia" class="banderas">
                    <img src="Imagenes/idiomas/reinoUnido.png" id="reinoUnido" class="banderas" >

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
                    <p><label for="buscador"><h2 data-translate="eslogan">Viaja con nosotros y descubriras sitios increibles</h2></label></p>

                </div>
            </div>

            <div class="row">

                <!--Aqui empezaria el formulario que el usuario debe rellenar para registrarse en la pagina -->
                <div class="col-12">
                    <h1 style="text-align: center" data-translate="datosH">Introduce los datos del hotel</h1><br>

                    <form onsubmit="return validarForm(this);" method="post" name="formulario" id="formulario" enctype="multipart/form-data">
                        <div class="form-row">

                            <input type="hidden" name="idHotel" value="<c:out value="${hotel.idHotel}"/>">


                            <div class="form-group col-md-5">

                                <label for="nombreH"  ><strong data-translate="nombreH" >Nombre del hotel</strong></label>
                                <input type="text" class="form-control" id="nombreH" name="nombreH" placeholder="Introduzca el nombre   " maxlength="30" data-translate="p_nombreH" value="<c:out value="${hotel.nombreHotel}"/>">
                            </div>

                            <div class="form-group col-md-5">

                                <label for="lugar"><strong data-translate="lugar">Lugar</strong></label><br>
                                <input type="text" class="form-control" value="<c:out value="${hotel.lugar}"/>"    id="lugar" name="lugar" placeholder="Introduzca donde se encuentra el hotel  " maxlength="50" data-translate="p_lugar">
                            </div>
                        </div>

                        <div class="form-row">


                            <div class="form-group col-md-5">

                                <label for="telefono"><strong data-translate="telefono">Telefono</strong></label><br>
                                <input type="text" class="form-control" id="telefono" value="<c:out value="${hotel.telefono}"/>"   name="telefono" placeholder="Introduzca el telefono del hotel  " maxlength="9"  style="margin-top: 15px">
                            </div>

                            <div class="form-group col-md-4">

                                <label for="correo"><strong data-translate="correo">Correo</strong></label><br>
                                <input type="text" class="form-control"   id="correo"  value="<c:out value="${hotel.correo}"/>" data-translate="correo" name="correo" placeholder="Introduzca el correo  " maxlength="50"  >
                            </div>
                        </div>


                        <div class="form-row">


                            <div class="form-group col-md-5">

                                <label for="precio"><strong data-translate="precio">Precio</strong></label><br>
                                <input type="number" class="form-control" id="precio"  value="<c:out value="${hotel.precio}"/>"  data-translate="precio" name="precio" placeholder="Introduzca el precio  "  value="0" min="0">
                            </div>

                            <div class="form-group col-md-5">

                                <label for="foto"><strong data-translate="fotoH">Foto del hotel</strong></label><br>
                                <input type="file" class="form-control" id="foto" name="foto" >
                                
                            </div>
                        </div>



                        <div class="form-row">


                            <div class="form-group col-md-12">
                                <img src='<c:url value="/Imagenes/default.png"/>' 
                                     width="200" height="200" id="previa" />
                            </div>
                        </div>

                        <div id="mensaje" style="margin-left: 420px;font-size: 20px;font-weight: bold "></div>

                        <button  class="btn btn-success" name="modHotel" id="modHotel" style="margin-left: 500px" data-translate="crear">Modificar</button>
                        <button type="submit" class="btn btn-danger" name="cancelar" id="cancelar" data-translate="cancelar">Cancelar</button>
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
    <script type="text/javascript" src="${contexto}/JS/cambiarIdioma.js"></script>
    <script type="text/javascript" src="${contexto}/JS/validModifHotel.js"></script>

</html>


