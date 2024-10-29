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
        <title>Login de Usuário</title>
    </head>
    <body>
        <div id="corpo">
            <?php 
                $user = $_REQUEST['user'] ?? null;
                $pass = $_REQUEST['senha'] ?? null;

                if(is_null($user) || is_null($pass)){
                    require_once "../tools/includes/tela-login.php";
                } else{
                    $query = "SELECT usuário, nome, senha, tipo FROM usuários WHERE usuário = '$user' LIMIT 1";
                    $busca = $banco->query($query);
                    if(!$busca){
                        echo msg_erro('Falha ao acessar o banco!');
                    } else {
                        if($busca->num_rows > 0){
                        $registro = $busca->fetch_object();
                        if(testarHash($pass, $registro->senha)){
                            echo msg_sucesso('Logado com sucesso');
                            $_SESSION['user'] = $registro->usuário;
                            $_SESSION['nome'] = $registro->nome;
                            $_SESSION['tipo'] = $registro->tipo;
                        } else {
                            echo msg_erro('Senha inválida!');
                        }
                    } else {
                        echo msg_erro('Usuário não existe');
                    }
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