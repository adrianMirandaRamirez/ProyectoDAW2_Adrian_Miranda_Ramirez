<%--   
    Document   : index
    Created on : 15-sep-2020, 10:14:45
    Author     : adrian
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />
<c:set var="contexto" value="${pageContext.servletContext.contextPath}" scope="application"/>
<c:url var="estilo" value="/CSS/estilos.css" scope="application"/>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="JS/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="JS/jqueryTranslator.js"></script>

       <jsp:directive.include  file="INC/metas.inc"/> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="StyleSheet" href="CSS/estilos.css" type="text/css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>index</title>
    </head>
    <body style="background-color: white">
        <div class="container-fluid" style="border: groove 10px greenyellow">
            <div class="row cabecera">
              
                <div class="col-4 ">
                    <img src="Imagenes/idiomas/espania.png" id="espania" class="banderas" >
                    <img src="Imagenes/idiomas/alemania.png" id="alemania" class="banderas">
                    <img src="Imagenes/idiomas/italia.png"  id="italia" class="banderas">
                    <img src="Imagenes/idiomas/reinoUnido.png" id="reinoUnido" class="banderas" >
                    <!--<img id="logo" src="Imagenes/boeing-159589_640.png" >-->
                       
                </div>
                <div class="col-4 ">
                        
                    <p  id="titulo"><strong>World Travel</strong></p>
                </div>
                <div class="col-4 ">
                    <form action="Loguearse" method="post">
                        <input type="submit" name="login" id="registrarse" value="Registrarse" class="btn col-3 btn-primary " data-translate="registrarse" />
                        <input type="submit" name="login" id="iniciarSesion" value="Iniciar sesion" class="btn col-5 btn-primary " data-translate="iniciarSesion" />

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
                    <form action="Redireccion" method="post">
                        <input type="submit" disabled="" name="boton" value="Reservar Hotel" class="btn col-6 btn-primary"  style="margin-left: 100px;margin-top: 10px;"/>
                    </form>
                </div>
                
                <div class="col-6" id="actividades">
                    <i class="fas fa-skiing-nordic" ></i>
                    <input type="submit" disabled="" name="boton" value="Reservar Actividad" class="btn col-6 btn-primary"  style="margin-left: 100px;margin-top: 10px;"/>
                </div>
            </div>
            
            <div class="row pie" >
                <div class="col-4" >
                    <p class="informacion" >
                        <strong data-translate="personal" >Informacio personal</strong>
                    </p>
                    
                    <p><strong data-translate="telefono">
                        Telefono</strong>: 924568213<br>
                    <strong data-translate="correo">Correo electronico</strong>: WorldTravel@gmail.com<br>
                    <strong data-translate="direccion">Direccion</strong> : calle Juan Carlos I
                        
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
    <script type="text/javascript" src="JS/cambiarIdioma.js"></script>

</html>
