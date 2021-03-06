
$(document).ready(function () {
    let original = $('#previa').attr('src');
    let selloTiempo = new Date();

    $('#previa').attr('src', original + '?' + selloTiempo);
    $('#foto').on('change', function () {
        $("#nuevoEquipo").prop("disabled", false);
        readURL(this);
    });
});


$('#crear').click(validarForm);
$('#cancelar').click(function () {
    var form = document.getElementById('formulario');
    form.action = "RedireccionCancelar";
    form.submit();

    return true;
    
});

function validarForm(form){
    var boolean=false;
     var email = document.getElementById('correo').value;
    if(validarCampos()){
        if (email !== "") {
            form.action = "crearHotel";
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
    var nombreH = document.getElementById('nombreH').value;
    var lugar = document.getElementById('lugar').value;
    var telefono = document.getElementById('telefono').value;
    var correo = document.getElementById('correo').value;
    var precio = document.getElementById('precio').value;

    var booleana = false;

    var mensaje = document.getElementById('mensaje');

    //Comprobamos si hay algun campo que este vacio
    if (nombreH === "" || lugar === "" || telefono === "" || precio ==="") {
        $('#nombreH').css('borderColor', 'red');
        $('#lugar').css('borderColor', 'red');
        $('#telefono').css('borderColor', 'red');
        
        $('#correo').css('borderColor', 'red');
        mensaje.innerHTML = 'Todos los campos son obligatorios';
        booleana = false;
        
    }else{
         $('#nombreH').css('borderColor', 'green');
        $('#lugar').css('borderColor', 'green');
        $('#telefono').css('borderColor', 'green');
        $('#correo').css('borderColor', 'green');
        booleana=true;
    }
    
    return booleana;
}






$("#correo").change(function () {
    var valEmail = /^([a-zA-Z0-9])+\@(([a-zA-Z0-9])+\.)+([a-zA-Z0-9]{2,4})+$/;
    var mensaje = document.getElementById('mensaje');
    var emailIntroducido = $(this).val();
    var boolean = valEmail.test(emailIntroducido);

    if (boolean === true) {
        $.ajax({
            type: "POST",
            url: "EmailHotelAjax",
            data: {
                parametro: "emailH",
                emailH: emailIntroducido
            },
            success: function (data) {

                if (data.tipo === 'existe') {
                    $("#correo").val('');
                    mensaje.innerHTML = 'El email ya existe en la base de datos';
                }

            },
            error: function () {
                $("#correo").val('');
                mensaje.innerHTML = 'Hay un fallo';
            }
        });

    } else {
        $("#correo").val('');
        mensaje.innerHTML = 'El formato de email no es el correcto';
    }

});


















function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            imagenInput = e.target.result;
//            let selloTiempo = new Date();
//            $("#myimg").attr("src", "/myimg.jpg?"+d.getTime());
//            $('#previa').attr('src', e.target.result+'?'+selloTiempo.getTime());
            $('#previa').attr('src', e.target.result);
        };
        reader.readAsDataURL(input.files[0]);
    }
}
