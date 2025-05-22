document.addEventListener("DOMContentLoaded", function() {
    const fechaInput = document.getElementById("fecha");
    const horaInicioInput = document.getElementById("hora-inicio");
    const horaFinInput = document.getElementById("hora-fin");
    const guardarBtn = document.getElementById("guardar-btn");
    const sesionSiBtn = document.getElementById("sesion-si");
    const sesionNoBtn = document.getElementById("sesion-no");
    const atrasBtn = document.querySelector(".botones-abajo button"); // Selecciona el botón "Atrás"
    let esSesion = null;

    // Establecer la fecha actual por defecto
    const hoy = new Date().toISOString().split("T")[0];
    fechaInput.value = hoy;

    // Marcar sesión como Sí o No
    sesionSiBtn.addEventListener("click", function() {
        esSesion = true;
        sesionSiBtn.style.backgroundColor = "darkgreen";
        sesionNoBtn.style.backgroundColor = "red";
    });

    sesionNoBtn.addEventListener("click", function() {
        esSesion = false;
        sesionSiBtn.style.backgroundColor = "green";
        sesionNoBtn.style.backgroundColor = "darkred";
    });

    guardarBtn.addEventListener("click", function() {
        const fecha = fechaInput.value;
        const horaInicio = horaInicioInput.value;
        const horaFin = horaFinInput.value;

        if (!fecha || !horaInicio || !horaFin || esSesion === null) {
            alert("Por favor, completa todos los campos.");
            return;
        }

        alert(`Asistencia guardada:\nFecha: ${fecha}\nHorario: ${horaInicio} - ${horaFin}\nSesión: ${esSesion ? "Sí" : "No"}`);
        // Aquí podrías redirigir a otra página después de guardar
        // window.location.href = "otra_pagina.html";
    });

    // Redirigir a dashboard al hacer clic en el botón "Atrás"
    atrasBtn.addEventListener("click", function() {
        window.location.href = "dashboard.html"; // Reemplaza "dashboard.html" con la URL correcta de tu página de dashboard
    });
});