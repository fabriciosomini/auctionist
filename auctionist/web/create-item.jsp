<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Auctionist! - Cadastrar um item</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                        <a href="signout">SAIR</a>
                    </div>
                </div>
            </div>
        </div>
        <div id="cont" class="container">
            <div class="row">
                <div class="col-12 new-item-container" style="text-align: center;">
                    <h3>Cadastrar um novo item</h3>
                    <form action="save-item" method="POST" accept-charset="iso-8859-1">
                        <div class="row">
                            <div class="col-3"></div>
                            <div class="col-6">
                                <input type="text" name="itemName" class="form-control" placeholder="Informe um nome para o item" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-3"></div>
                            <div class="col-6">
                                <textarea name="itemDescription" class="form-control" placeholder="Informe uma descrição detalhada para o item" style="min-height: 50px; max-height: 300px; height: 150px;"></textarea>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-3"></div>
                            <div class="col-3">
                                <input type="number" name="itemPrice" class="form-control" placeholder="Informe um lance inicial" />
                            </div>
                        </div>
                        <div class="row" style="margin-top: 4rem;">
                            <div class="col-4"></div>
                            <div class="col-3">
                                <input type="submit" name="btnSave" class="form-control btn btn-block btn-success" value="Salvar" />
                            </div>
                            <div class="col-2">
                                <a href="list-item" class="form-control btn btn-block btn-secondary">Cancelar</a>
                            </div>
                        </div>
                    </form>
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
