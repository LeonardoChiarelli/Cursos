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
        <title>Novo Jogo</title>
    </head>
    <body>
        <div id="corpo">
            <?php 
                if(!is_admin()){
                    echo msg_erro("Área apenas para administradores!");
                } elseif (!isset($_REQUEST['usuário'])){
                    require_once "../tools/includes/game-new-form.php";
                } else{
                    $nome = $_REQUEST['nome'] ?? null;
                    $genero = $_REQUEST['genero'] ?? null;
                    $produtora = $_REQUEST['produtora'] ?? null;
                    $descricao = $_REQUEST['descricao'] ?? null;
                    $nota = $_REQUEST['nota'] ?? null;
                    $capa = $_REQUEST['capa'] ?? null;

                    $query = "INSERT into jogos (cod, nome, gênero, produtora, descrição, capa) values ('default', '$nome', '$genero', '$produtora', '$descricao', '$nota', '$capa')";
                    if($banco->query($query)){
                        echo msg_sucesso("O jogo <strong>$nome</strong> foi adicionado com sucesso");
                    } else{
                        echo msg_erro("Falha ao cadastrar o jogo <strong>$nome</strong>, repita o processo.");
                    }
                }
                echo botao();
            ?>
        </div>
        <?php 
            require_once "../tools/includes/footer.php";
        ?>
    </body>
</html>