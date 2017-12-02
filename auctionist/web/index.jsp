<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<jsp:include page="/list-item" />
<html>
    <head>
        <title>Auctionist! - Items</title>
        <meta charset=UTF-8">
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
                        <a name="btnLogout" href="auctionist">SAIR</a>
                    </div>
                </div>
            </div>
        </div>

        <div id="cont" class="container">
            <div class="row items-container">                
                <!-- ITEM CONTAINER -->
                <div class="col-12">
                    <div class="row">
                        <div class="col-1">
                            <a href="list-item"><img src="imgs/Refresh_icon.png" alt="refresh"/></a>                                                        
                        </div>
                        <div class="col-10" style="text-align: center; margin-bottom: 1rem;">
                            <h4>Lista de Leilões</h4>
                        </div>
                        <div class="col-1"></div>
                    </div>
                    <div class="row" style="height: 50px;">
                        <div class="col-1"></div>
                        <div class="col-8"><h5>Item a venda</h5></div>
                        <div class="col-2" style="text-align: right;"><h5>Maior Lance</h5></div>
                    </div>
                    <c:forEach var="item" items="${itemCollection}">
                        <h6>
                            <a class="item-link" href="list-bids?id=${item.id}" style="height: 30px;">
                                <div class="row top-spaced">
                                    <div class="col-1"></div>
                                    <div class="col-8">${item.name}</div>
                                    <div class="col-2" style="text-align: right;">${item.highestBid}</div>
                                </div>
                            </a>
                        </h6>
                        <div class="row">
                            <div class="col-1"></div>
                            <div class="col-8"><p>${item.description}</p></div>
                        </div>
                        <hr />
                    </c:forEach>
                </div>                
            </div>
            <div clas="row" style="margin-top: 0.5rem;">
                <div class="col-12 footer">
                    <p>Acadêmicos: Fabrício M. Somini e Guilherme Corrêa Milak</p>
                </div>
            </div>
        </div>
    </body>
</html>
