<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>

</head>
<body>
 <nav class="navbar navbar-expand-sm btn-primary navbar-dark">

        <a class="navbar-brand" href="#">Nomina</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Hoja de vida
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/bienestaruniversitario/module/admin/view/ustaprograma.php">Crear</a>
                        <a class="dropdown-item" href="/bienestaruniversitario/module/admin/view/generarreporte.php">Listar</a>
                        <a class="dropdown-item" href="/bienestaruniversitario/module/admin/view/horabienestar.php">Eliminar</a>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Contrato
                    </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/bienestaruniversitario/module/admin/view/ustaprograma.php">Crear</a>
                        <a class="dropdown-item" href="/bienestaruniversitario/module/admin/view/generarreporte.php">Listar</a>
                        <a class="dropdown-item" href="/bienestaruniversitario/module/admin/view/horabienestar.php">Eliminar</a>
                    </div>
                </li>

                 <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Nomina
                    </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/bienestaruniversitario/module/admin/view/ustaprograma.php">Crear</a>
                        <a class="dropdown-item" href="/bienestaruniversitario/module/admin/view/generarreporte.php">Listar</a>
                        <a class="dropdown-item" href="/bienestaruniversitario/module/admin/view/horabienestar.php">Eliminar</a>
                    </div>
                </li>

                
            </ul>

        </div>

    </nav>
    <div class="jumbotron">
  <h1>Bienvenidos a nomina</h1> 
  <p>En este modulo usted podr� crear, listar y eliminar las diferentes opciones que se deseen ejecutar.</p> 
</div>
</body>
</html>