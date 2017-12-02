<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Auctionist! - Items</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
    </head>
    <body>
        <div class="top-index">
            <div class="container">
                <div class="row">
                    <div class="col-6">
                        <img src="imgs/W4U_A4-S.png" alt="logo_auctionist"/>
                    </div>
                    <div class="col-1 menu">
                        <a href="list-item">INÍCIO</a>
                    </div>
                    <div class="col-3 menu">
                        <a href="create-item">CADASTRAR ITEM</a>
                    </div>
                    <div class="col-2 menu">
                        <a href="#">MENU 3</a>
                    </div>
                </div>
            </div>
        </div>

        <div id="cont" class="container">
            <div class="row items-container">
                <div class="col-12">
                    <div class="row top-spaced" style="margin-bottom: 2rem;">
                        <div class="col-2"></div>
                        <div class="col-5">
                            <h3>Nome do item</h3>
                        </div>
                        <div class="col-3" style="text-align: right;">
                            <h5>Imagem (se tiver)</h5>
                        </div>
                    </div>
                    <div class="row top-spaced">
                        <div class="col-2"></div>
                        <div class="col-3">
                            <h6>Lance inicial: R$ 5,20</h6>
                        </div>
                    </div>
                    <div class="row top-spaced">
                        <div class="col-2"></div>
                        <div class="col-3">
                            <h6>Maior lance: R$ 7,00</h6>
                        </div>
                    </div>
                </div>

                <c:forEach var="item" items="${itemCollection}">

                </c:forEach>
            </div>
        </div>
        <div clas="row" style="margin-top: 0.5rem;">
            <div class="col-12 footer">
                <p>Acadêmicos: Fabrício M. Somini e Guilherme Corrêa Milak</p>
            </div>
        </div>
    </body>
</html>
