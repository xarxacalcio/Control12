document.addEventListener('DOMContentLoaded', function() {
    const searchInput = document.getElementById('search');
    const studentsTableBody = document.getElementById('studentsTableBody');
    const logoutButton = document.getElementById('logout');
    const apiUrl = '/control12api/alumno/vertodos'; // Reemplaza con la URL correcta de tu API
    let allStudentsData = [];
    let selectedStudent = null; // Variable para almacenar el alumno seleccionado

    function fetchStudents() {
        fetch(apiUrl)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .then(data => {
                allStudentsData = data;
                renderStudents(allStudentsData);
            })
            .catch(error => {
                console.error('Error fetching students:', error);
                studentsTableBody.innerHTML = '<tr><td colspan="2">Error al cargar los alumnos.</td></tr>';
            });
    }

    function handleStudentSelection(student) {
        console.log('Alumno seleccionado:', student);
        selectedStudent = student; // Guarda el alumno seleccionado
        // Aquí puedes actualizar la interfaz para indicar la selección
        // Por ejemplo, resaltar la fila seleccionada
        const rows = studentsTableBody.querySelectorAll('tr');
        rows.forEach(row => row.classList.remove('selected')); // Deselecciona filas previas
        const selectedRow = Array.from(rows).find(row => row.dataset.studentId == student.id);
        if (selectedRow) {
            selectedRow.classList.add('selected');
        }
        // Puedes realizar otras acciones al seleccionar (mostrar detalles, etc.)
    }

    function renderStudents(students) {
        studentsTableBody.innerHTML = '';
        const hasActionsColumn = document.querySelector('#studentsTable th:nth-child(2)') && document.querySelector('#studentsTable th:nth-child(2)').textContent === 'Acciones';

        students.forEach(student => {
            const row = studentsTableBody.insertRow();
            row.dataset.studentId = student.id; // Guarda el ID del alumno en la fila

            const nameCell = row.insertCell();
            nameCell.textContent = student.nombre; // Ajusta 'nombre' al campo correcto de tu API

            if (hasActionsColumn) {
                const actionsCell = row.insertCell();
                actionsCell.classList.add('actions');
                const selectButton = document.createElement('button');
                selectButton.textContent = 'Seleccionar';
                selectButton.classList.add('select-btn');
                selectButton.addEventListener('click', function() {
                    handleStudentSelection(student);
                });
                actionsCell.appendChild(selectButton);
            } else {
                row.style.cursor = 'pointer';
                row.addEventListener('click', function() {
                    handleStudentSelection(student);
                });
            }
        });

        // Si hay alumnos filtrados y no hay ninguno seleccionado aún,
        // selecciona automáticamente el primero de la lista filtrada
        if (students.length > 0 && !selectedStudent && searchInput.value.length > 0) {
            handleStudentSelection(students[0]);
        }
    }

    fetchStudents();

    searchInput.addEventListener('input', function() {
        const searchTerm = searchInput.value.toLowerCase();
        const filteredStudents = allStudentsData.filter(student =>
            student.nombre.toLowerCase().startsWith(searchTerm) // Ajusta 'nombre' al campo correcto
        );
        renderStudents(filteredStudents);
        selectedStudent = null; // Resetear la selección al escribir
    });

    // Preguntar antes de cerrar sesión
    logoutButton.addEventListener('click', function(event) {
        event.preventDefault(); // Evita la acción predeterminada del botón (si es un submit)
        if (confirm('¿Estás seguro de que quieres cerrar sesión?')) {
            window.location.href = 'index.html'; // Redirige a la página de inicio de sesión
        }
    });
});
