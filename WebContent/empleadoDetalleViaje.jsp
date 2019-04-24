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
        	<%@ include file="templates/empleadoSidebar.jsp" %>
        </header>
        <main id="content">
        	<%@ include file="templates/navbarEmpleado.jsp" %>

            <section class="text-center mt-3">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-5 centerVertical">
                            <div class="line"></div>
                        </div>
                        <div class="col-2">
                            <img src="assets/bill.svg" alt="Icono facturas" class="page-icon">
                        </div>
                        <div class="col-5 centerVertical">
                            <div class="line"></div>
                        </div>
                    </div>
                </div>
            </section>

            <div class="container">
                <div class="position-relative">
                    <a class="back-container centerBoth" href="empleadoViajes.php">
                        <img src="assets/back.svg" alt="Flecha atrás" class="back-icon">
                        <span class="ml-3">Volver atrás</span>
                    </a>

                    <div class="fontBig text-center headText my-3">
                        Detalle del Viaje
                    </div>
                </div>

                <section class="col-8 centerHorizontal">
                    <div class="row mb-2">
                        <div class="col-12 col-md-5">
                            <div class="fontBig info-header">Origen del viaje:</div>
                            <span>Madrid</span>
                        </div>
                        <div class="col-md-2"></div>
                        <div class="col-12 col-md-5">
                            <div class="fontBig info-header">Destino del viaje:</div>
                            <span>Londres</span>
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-12 col-md-5">
                            <div class="fontBig info-header">Fecha de inicio:</div>
                            <span>15/04/2019</span>
                        </div>
                        <div class="col-md-2"></div>
                        <div class="col-12 col-md-5">
                            <div class="fontBig info-header">Fecha de fin:</div>
                            <span>06/11/2039</span>
                        </div>
                    </div>
                    <div class="fontBig info-header mt-5">Lista de gastos:</div>
                </section>

                <section>
                    <div id="table-viajes">
                        <table class="table table-hover table-white text-center" id="table">
                            <thead>
                                <tr>
                                    <th scope="col" class="col-icons"></th>
                                    <th scope="col" class="col-bill-regular">Fecha</th>
                                    <th scope="col" class="col-bill-concept">Concepto</th>
                                    <th scope="col" class="col-bill-price">Precio</th>
                                    <th scope="col" class="col-bill-regular">Factura</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-usd black-icon"></span>
                                    </td>
                                    <td>25/11/2019</td>
                                    <td>Billete de avión</td>
                                    <td>300€</td>
                                    <td>
                                        <a href="">Descargar</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-usd black-icon"></span>
                                    </td>
                                    <td>25/11/2019</td>
                                    <td>Billete de avión</td>
                                    <td>300€</td>
                                    <td>
                                        <a href="">Descargar</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-usd black-icon"></span>
                                    </td>
                                    <td>25/11/2019</td>
                                    <td>Billete de avión</td>
                                    <td>300€</td>
                                    <td>
                                        <a href="">Descargar</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-usd black-icon"></span>
                                    </td>
                                    <td>25/11/2019</td>
                                    <td>Billete de avión</td>
                                    <td>300€</td>
                                    <td>
                                        <a href="">Descargar</a>
                                    </td>
                                </tr>
                                <tr>
                                    <form id="billForm">
                                        <td>
                                            <span class="glyphicon glyphicon-usd black-icon"></span>
                                        </td>
                                        <td>
                                            <input id="date" name="date" type="date" class="form-control required" placeholder="DD/MM/YYYY" required>
                                        </td>
                                        <td>
                                            <input id="department" name="department" type="text" class="form-control required" placeholder="Descripción" required>
                                        </td>
                                        <td>
                                            <input id="price" name="price" type="number" class="form-control required" placeholder="Precio en euros" required>
                                        </td>
                                        <td>
                                            <input id="bill" name="bill" type="file" class="form-control required" required>
                                        </td>
                                    </form>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <div class="text-center col-12">
                            <input type="submit" form="billForm" class="btn fontBig" value="Agregar factura">
                        </div>
                    </div>
                </section>

                <section class="col-8 centerHorizontal">
                    <div class="row">
                        <div class="col-12 col-md-5">
                            <div class="fontBig info-header mt-3">Gastos totales:</div>
                            <span>1.000.000€</span>
                        </div>
                        <div class="col-md-7"></div>
                    </div>
                </section>

            </div>
        </main>
    </div>
    <!-- Web page main Scripts -->
    <%@ include file="templates/scripts.jsp" %>

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