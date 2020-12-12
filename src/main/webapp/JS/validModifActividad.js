
$(document).ready(function () {
    let original = $('#previa').attr('src');
    let selloTiempo = new Date();

    $('#previa').attr('src', original + '?' + selloTiempo);
    $('#foto').on('change', function () {
        $("#nuevoEquipo").prop("disabled", false);
        readURL(this);
    });
});



function validarForm(form){
    
    var boolean=true;
    form.action="ModificarActividad";
    form.submit();
       
    
    return boolean;
}


function validarCampos(){
    var nombreA = document.getElementById('nombreA').value;
    var descripcion=document.getElementById('descripcion').value;
    var lugar = document.getElementById('lugar').value;
    var telefono = document.getElementById('telefono').value;
    var booleana = false;

    var mensaje = document.getElementById('mensaje');

    //Comprobamos si hay algun campo que este vacio
    if (nombreA === "" || lugar === "" || telefono === "" || descripcion === "" ) {
        $('#nombreA').css('borderColor', 'red');
        $('#lugar').css('borderColor', 'red');
        $('#telefono').css('borderColor', 'red');
        $('#descripcion').css('borderColor', 'red');
        
        mensaje.innerHTML = 'Todos los campos son obligatorios';
        booleana = false;
        
    }else{
        $('#nombreA').css('borderColor', 'green');
        $('#lugar').css('borderColor', 'green');
        $('#telefono').css('borderColor', 'green');
        $('#descripcion').css('borderColor', 'green');
        
        booleana=true;
    }
    
    return booleana;
}



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

