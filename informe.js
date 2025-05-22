document.addEventListener("DOMContentLoaded", function () {
    // Simulación de datos obtenidos de una API o base de datos
    const informe = {
        horasSemana: 5,
        horasMes: 12,
        sesiones: 3,
        abonado: true
    };

    // Asignar valores a la UI
    document.getElementById("horas-semana").textContent = `${informe.horasSemana}h`;
    document.getElementById("horas-mes").textContent = `${informe.horasMes}h`;
    document.getElementById("sesiones").textContent = `${informe.sesiones} Ses`;

    // Mostrar estado del pago
    const abonadoTag = document.getElementById("abonado");
    abonadoTag.innerHTML = informe.abonado ? '<span class="tag">Sí</span>' : '<span class="tag" style="background-color: red;">No</span>';
});
