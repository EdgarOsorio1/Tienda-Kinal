function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
    document.body.style.backgroundColor = "#0a0a0a";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft = "0";
    document.body.style.backgroundColor = "#121212";
}


function openModal() {
    document.getElementById("actionModal").style.display = "block";
    resetForm();
}

function closeModal() {
    document.getElementById("actionModal").style.display = "none";
}

window.onclick = function(event) {
    var modal = document.getElementById("actionModal");
    if (event.target === modal) { closeModal(); }
}

function resetForm() {
    const form = document.getElementById('userForm');
    form.reset();


    const inputs = form.querySelectorAll('input');
    inputs.forEach(input => {
        input.disabled = true;
        input.required = false;
    });

    document.getElementById('submitBtn').style.display = 'none';
    document.getElementById('modalTitle').innerText = 'Menú de Acciones';
}

function setMode(mode) {
    const idInput = document.getElementById('userId');
    const nameInput = document.getElementById('userName');
    const lastnameInput = document.getElementById('userLastname');
    const ageInput = document.getElementById('userAge');
    const submitBtn = document.getElementById('submitBtn');
    const form = document.getElementById('userForm');
    const title = document.getElementById('modalTitle');

    submitBtn.style.display = 'block';


    idInput.disabled = false;
    nameInput.disabled = false;
    lastnameInput.disabled = false;
    ageInput.disabled = false;

    if (mode === 'add') {
        title.innerText = "Agregar Nuevo Usuario";

        idInput.readOnly = true;
        idInput.required = false;
        idInput.placeholder = "Automático";

        nameInput.required = true;
        lastnameInput.required = true;
        ageInput.required = true;

        submitBtn.innerText = "Guardar Usuario";
        submitBtn.style.backgroundColor = "#217346";
        form.action = "/usuarios/guardar";

    } else if (mode === 'update') {
        title.innerText = "Actualizar Usuario Existente";

        idInput.readOnly = false;
        idInput.required = true;
        idInput.placeholder = "Escribe el ID";

        nameInput.required = true;
        lastnameInput.required = true;
        ageInput.required = true;

        submitBtn.innerText = "Guardar Cambios";
        submitBtn.style.backgroundColor = "#0078d4";
        form.action = "/usuarios/guardar";

    } else if (mode === 'delete') {
        title.innerText = "Eliminar Usuario";

        idInput.readOnly = false;
        idInput.required = true;
        idInput.placeholder = "ID a eliminar";


        nameInput.disabled = true;
        nameInput.required = false;
        lastnameInput.disabled = true;
        lastnameInput.required = false;
        ageInput.disabled = true;
        ageInput.required = false;

        submitBtn.innerText = "Confirmar Eliminación";
        submitBtn.style.backgroundColor = "#d83b01";
        form.action = "/usuarios/eliminar";
    }
}