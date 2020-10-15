/*
    * EsTuMatricula App - Develope Mode (05/10/2020)
    * Todos los derechos reservados bajo las licencias otorgadas.
    * Start Bootstrap - SB Admin v6.0.1 (https://startbootstrap.com/templates/sb-admin)
    * Copyright 2013-2020 Start Bootstrap
    * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-sb-admin/blob/master/LICENSE)
*/
$(document).ready(function() {
    "use strict";
    // Agrega la clase 'active' a los enlaces de manera dinámica 
    var path = window.location.href; // porque la propiedad 'href' del elemento DOM es la ruta absoluta
    $("#layoutSidenav_nav .sb-sidenav a.nav-link").each(function() {
        if (this.href === path) {
            $(this).addClass("active");
        }
    });
    // Controla cuando se oculta el navbar-menu
    $("#sidebarToggle").on("click", function(e) {
        e.preventDefault();
        $("body").toggleClass("sb-sidenav-toggled");
    });
    // Verificamos si se está usando el plugin dataTable.
    if ($('#dataTable').length){
        // Si se está usando, se instancia y activa.
        $('#dataTable').DataTable();
        console.log("Modo desarrollo: dataTable plugin activado");
    }else{
        console.log("No se activó el plugin DataTable debido a que no está usándose en la página actual.");
    }
});

// Función para cambiar el color y/o tema del navbar lateral izquierdo
const btnTheme = document.getElementById('btnThemeChange');
btnTheme.onclick = function(){
    console.log("Presionado");
    var x = document.getElementById('sidenavAccordion');
    if (x.classList.contains('sb-sidenav-light')) {
        x.classList.remove('sb-sidenav-light');
        x.classList.add('sb-sidenav-dark');
        btnTheme.innerText = "Tema claro";
    }else{
        x.classList.remove('sb-sidenav-dark');
        x.classList.add('sb-sidenav-light');
        btnTheme.innerText = "Tema oscuro";
    }
}