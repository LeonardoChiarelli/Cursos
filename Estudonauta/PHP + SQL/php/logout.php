<!DOCTYPE html>
<?php 
    require_once "../tools/includes/acessoDatabase.php";
    require_once "../tools/includes/funcoes.php";
    require_once "../tools/includes/hash.php";
?>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="../style/style.css">
        <link rel="shortcut icon" href="../favicon.ico" type="image/x-icon">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
        <title>Logout</title>
    </head>
    <body>
        <div id="corpo">
            <?php 
                logout();
                echo msg_sucesso('Usuário desconectado com sucesso');
                echo botao();
            ?>
        </div>
            <?php 
            require_once "../tools/includes/footer.php";
            ?>
    </body>
</html>