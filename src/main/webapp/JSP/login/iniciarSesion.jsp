<%-- 
    Document   : iniciarSesion
    Created on : 17-sep-2020, 11:31:05
    Author     : adrian
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />
<!DOCTYPE html>
<html>
    <head>
        <jsp:directive.include  file="../../INC/metas.inc"/> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="StyleSheet" href="${estilo}" type="text/css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.0.min.js"></script>  
        <title>IniciarSesion</title>
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

                </div>

            </div>

            <div class="row cuerpo" >
                <div class="col-12">
                    <p><label for="buscador"><h2>Viaja con nosotros y descubriras sitios increibles</h2></label></p>

                </div>
            </div>

            <div class="row">
                
                <!--Aqui empezaria el formulario que el usuario debe rellenar para registrarse en la pagina -->
                <div class="col-12">
                    <h1 style="text-align: center">Introduzca los siguientes datos</h1><br>
                    
                    <form action="Loguearse" method="post" name="formulario" id="formulario">
                        <div class="form-row">


                            <div class="form-group col-md-6">

                                <label for="correo"><strong>Correo</strong></label><br>
                                <input type="text" class="form-control" id="correo" name="correo" placeholder="Introduzca su correo  " maxlength="30" >
                            </div>

                            <div class="form-group col-md-4">

                                <label for="contrasenia"><strong>Contrase&ntilde;a</strong></label><br>
                                <input type="password" class="form-control" id="contrasenia" name="contrasenia" placeholder="Introduzca sus contraseña  " maxlength="30" >
                            </div>
                        </div>
                       
                        
                       
                        
                        <div id="mensaje" style="margin-left: 420px;font-size: 20px;font-weight: bold "></div>
                        <div>
                             <button  class="btn btn-success" name="iniciarSesion" id="iniciarSesion" style="margin-left: 450px">Iniciar sesion</button>
                             <button  class="btn btn-danger cancelar" name="cancelar" id="cancelar" >Cancelar</button>
                        </div>
                        
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

