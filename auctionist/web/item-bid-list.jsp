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
                    <div class="col-8">
                        <img src="imgs/W4U_A4-S.png" alt="logo_auctionist"/>
                    </div>
                    <div class="col-1 menu">
                        <a href="list-item">INÍCIO</a>
                    </div>
                    <div class="col-3 menu">
                        <a href="create-item">CADASTRAR ITEM</a>
                    </div>
                </div>
            </div>
        </div>

        <div id="cont" class="container">
            <div class="row items-container">
                <div class="col-12">
                    <div class="row top-spaced" style="margin-bottom: 2rem;">
                        <div class="col-1"></div>
                        <div class="col-1" style="text-align: right;">
                            <c:if test="${isOwner == true}">
                                <h4><a href="delete-item?id=${currentItem.id}" style="color: red;">X</a></h4>
                            </c:if>
                        </div>
                        <div class="col-5">
                            <h3>${currentItem.name}</h3>
                        </div>
                        <!--<div class="col-3" style="text-align: right;">
                            <h5>Imagem (se tiver)</h5>
                        </div>-->
                    </div>
                    <div class="row top-spaced">
                        <div class="col-2"></div>
                        <div class="col-3">
                            <h6>Lance inicial: R$ ${currentItem.initialAmount}</h6>
                        </div>
                    </div>
                    <form method="POST" action="add-bid?id=${currentItem.id}">
                        <div class="row top-spaced">
                            <div class="col-2"></div>                        
                            <div class="col-3">                           
                                <h6>Maior lance: R$ ${currentItem.highestBid}</h6>
                            </div>
                            <div class="col-2"></div>
                            <div class="col-2">
                                <input type="number" class="form-control" placeholder="Valor" name="txtBidValue" />
                            </div>
                            <div class="col-2">
                                <input type="submit" class="form-control btn btn-block btn-primary" value="Dar um lance" />
                            </div>
                        </div>
                    </form>
                    <div class="row">
                        <div class="col-12" style="text-align: center; margin-top: 2rem;"><h4>Lances desta venda</h4></div>
                    </div>
                    <hr style="width: 80%; margin-top: 1rem;"/>

                    <div style="max-height: 500px; overflow-y: scroll; overflow-x: hidden;">   
                        <!-- ITEM BIDS -->
                        <c:forEach var="itemBid" items="${currentItem.bids}">
                            <div class="row" style="min-height: 50px;">
                                <div class="col-2"></div>
                                <div class="col-8" style="padding: 1rem;">
                                    <p>O usuário <strong>${itemBid.bidder.name}</strong> deu um lance de <strong>${itemBid.bidAmount}</strong></p>
                                </div>
                            </div>
                            <hr style="width: 80%; margin-top: 1rem;"/>
                        </c:forEach> 
                    </div> 

                </div>
            </div>
        </div>
        <div clas="row" style="margin-top: 0.5rem;">
            <div class="col-12 footer">
                <p>Acadêmicos: Fabrício M. Somini e Guilherme Corrêa Milak</p>
            </div>
        </div>
    </body>
</html>
