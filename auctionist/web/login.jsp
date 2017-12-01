<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Auctionist!</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
    </head>
    <body>
        <div class="container">           
            <div class="row modal-login">
                <div class="col-12">
                    <div class="row">
                        <div class="col-12 img-logo">
                            <img src="imgs/logo_big.png" alt="logo" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4"></div>
                        <div class="col-4">
                            <form method="POST" action="signin-submit">
                                <input type="text" class="form-control" name="txtLogin" placeholder="Nome de usuário" />
                                <input type="password" class="form-control" name="txtPass" placeholder="Senha" />
                               <div style="color: red" ${ signInResult ? 'style="visibility: hidden"'
                                       : 'style="visibility: visible"'}
                                    >${signInResult}</div>
                                <input type="submit" class="form-control btn btn-block btn-dark btn-login" name="btnLogin" value="Entrar" />
                                

                            </form>
                        </div>
                        <div class="col-4"></div>
                    </div>
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
