<!DOCTYPE html>
<html lang="pt-br">
<?php 
    require_once "../tools/includes/acessoDatabase.php";
    require_once "../tools/includes/funcoes.php";
    require_once "../tools/includes/hash.php";
?>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="../style/style.css">
        <link rel="shortcut icon" href="../favicon.ico" type="image/x-icon">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
        <title>Login Usuário</title>
        <style>
            #corpo{
                display: flex;
            }
        </style>
    </head>
    <body>
            <form action="<?=$_SERVER['PHP_SELF']?>" method="post" id="login">
                <fieldset>
                    <legend>Login</legend>
                    <label for="iuser">Usuário: </label>
                    <input type="text" name="user" id="iuser" minlength="3" maxlength="80" size="19px" required placeholder="email"> <br>
                    <label for="isenha">Senha: </label>
                    <input type="password" name="senha" id="isenha" minlength="4" maxlength="8" required> <br>
                    <input type="submit" value="Entrar"> <br>
                </fieldset>
            </form>
    </body>
</html>