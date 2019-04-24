<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="templates/head.jsp" %>
</head>
<body>
 <div class="wrapper">
        <header>
        	<%@ include file="templates/supervisorSidebar.jsp" %>
        </header>
        <main id="content">
        	<%@ include file="templates/navbarSupervisor.jsp" %>
        	
            <section class="text-center mt-3">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-5 centerVertical">
                            <div class="line"></div>
                        </div>
                        <div class="col-2">
                            <img src="assets/request.svg" alt="Icono solicitudes" class="page-icon">
                        </div>
                        <div class="col-5 centerVertical">
                            <div class="line"></div>
                        </div>
                    </div>
                </div>
            </section>

            <div class="container">
                <div class="position-relative">
                    <a class="back-container centerBoth" href="supervisorSolicitudesViaje.php">
                        <img src="assets/back.svg" alt="Flecha atrás" class="back-icon">
                        <span class="ml-3">Volver atrás</span>
                    </a>

                    <div class="fontBig text-center headText my-3">
                        Autorización de Viaje
                    </div>
                </div>

                <section class="col-8 centerHorizontal">
                    <form>
                        <div class="form-row">
                            <div class="form-group col-12 col-md-6">
                                <div class="fontBig info-header">Nombre del empleado:</div>
                                <span>Juan Carlos Dueñas</span>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-12 col-md-6">
                                <div class="fontBig info-header">Origen del viaje:</div>
                                <span>Madrid</span>
                            </div>
                            <div class="form-group col-12 col-md-6">
                                <div class="fontBig info-header">Destino del viaje:</div>
                                <span>Londres</span>
                            </div>
                        </div>
                        <div class="form-group form-row">
                            <div class="col-12 col-md-6">
                                <div class="fontBig info-header">Fecha de Inicio:</div>
                                <span>15/04/2019</span>
                            </div>
                            <div class="form-group col-12 col-md-6">
                                <div class="fontBig info-header">Fecha de Fin:</div>
                                <span>06/11/2039</span>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-12">
                                <div class="fontBig mb-2 info-header">Descripción del viaje:</div>
                                <div class="bordered">
                                    <span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Culpa debitis ea molestias veniam. Ab dolore excepturi ipsam, laboriosam libero magnam modi nemo quibusdam quod ut. Blanditiis consectetur delectus dolorum in.</span>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-12 col-md-6">
                                <div class="fontBig info-header">Precio Aproximado:</div>
                                <span>1.000.000€</span>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group text-center col-12">
                                <button type="submit" class="btn fontBig">Aceptar</button>
                                <button type="submit" class="btn fontBig">Rechazar</button>
                            </div>
                        </div>
                    </form>
                </section>
            </div>
        </main>
    </div>
    
    <!-- Web page main Scripts -->
    <%@ include file="templates/supervisorSidebar.jsp" %>
    
    <!-- Script changing html title -->
	<script>
        $('title').html("Autorizar viaje");
    </script>

    <!-- Script changing active sidenav li -->
    <script>
        $("#sidebar ul li:first-child").addClass('active');
    </script>
    
    
</body>
</html>