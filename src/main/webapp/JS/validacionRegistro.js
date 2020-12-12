
$('#loguearse').click(validarForm);
$('#cancelar').click(function () {
    var form = document.getElementById('formulario');
    form.action = "index.jsp";
    form.submit();

});


function validarForm(form) {
    var boolean = false;
    var email = document.getElementById('correo').value;
    if (validarCampos()) {
        if (email !== "") {
            form.action = "Registrarse";
            form.submit();
            boolean = true;
        } else {
            boolean = false;
        }
    }
    return boolean;
}






function validarCampos() {

    var form = document.getElementById('formulario');
    var nombre = document.getElementById('nombre').value;
    var apellidos = document.getElementById('apellidos').value;
    var correo = document.getElementById('correo').value;
    var nif = document.getElementById('nif').value;
    var telefono = document.getElementById('telefono').value;
    var contrasenia = document.getElementById('contrasenia').value;
    var booleana = false;

    var mensaje = document.getElementById('mensaje');


    //Comprobamos si hay algun  campo que este vacio 
    if (nombre === "" || apellidos === "" || telefono === "" || contrasenia === "") {
        $('#nombre').css('borderColor', 'red');
        $('#apellidos').css('borderColor', 'red');
        $('#correo').css('borderColor', 'red');
        $('#nif').css('borderColor', 'red');
        $('#telefono').css('borderColor', 'red');
        $('#contrasenia').css('borderColor', 'red');
        mensaje.innerHTML = 'Todos los campos son obligatorios';
        booleana = false;

    } else {

        if (nif === "") {
            $('#nombre').css('borderColor', 'green');
            $('#apellidos').css('borderColor', 'green');
            $('#correo').css('borderColor', 'green');
            $('#nif').css('borderColor', 'red');
            $('#telefono').css('borderColor', 'green');
            $('#contrasenia').css('borderColor', 'green');
            booleana = false;
        } else {
            if (validarNif(nif) === true) {
                $('#nif').css('borderColor', 'green');
                booleana = true;
            } else {
                $('#nif').css('borderColor', 'red');
                booleana = false;
            }
        }

    }

    return booleana;
}

function validarNif(nif) {
    var expRegular = /^[0-9]{8}[A-Z]{1}$/;
    var mensaje = document.getElementById('mensaje');
    var boolean = false;

    if (expRegular.test(nif) === true) {

        boolean = true;
    } else {
        $('#nif').css('borderColor', 'red');
        boolean = false;
        mensaje.innerHTML = 'El nif debe tener la siguiente estructura 12345678A';
    }

    return boolean;
}


// Comprobamos que el email tiene el formato correcto y tambien comprobamos usando Ajax que el email introducido no se encuentra en la base de datos  
$("#correo").change(function () {
    var valEmail = /^([a-zA-Z0-9])+\@(([a-zA-Z0-9])+\.)+([a-zA-Z0-9]{2,4})+$/;
    var mensaje = document.getElementById('mensaje');
    var emailIntroducido = $(this).val();
    var boolean = valEmail.test(emailIntroducido);

    if (boolean === true) {
        $.ajax({
            type: "POST",
            url: "EmailAjax",
            data: {
                parametro: "email",
                email: emailIntroducido
            },
            success: function (data) {

                if (data.tipo === 'existe') {
                    $("#correo").val('');
                    mensaje.innerHTML = 'El email ya existe en la base de datos';
                }

            },
            error: function () {
                $("#correo").val('');
            }
        });

    } else {
        $("#correo").val('');
        mensaje.innerHTML = 'El formato de email no es el correcto';
    }

});