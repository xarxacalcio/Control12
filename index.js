document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("loginForm").addEventListener("submit", function (event) {
        event.preventDefault();

        let email = document.getElementById("email").value;
        let password = document.getElementById("password").value;

        if (email === "profesor@email.com" && password === "123456") {
            window.location.href = "dashboard.html";
        } else {
            alert("Credenciales incorrectas");
        }
    });
});
