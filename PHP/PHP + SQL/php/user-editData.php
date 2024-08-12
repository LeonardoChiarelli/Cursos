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
        <title>Editando Dados do Usuário</title>
    </head>
    <body>
        <div id="corpo">
            <?php 
                if (!is_logado()){
                    echo msg_erro("Efetue o <a href='login.php'>LOGIN</a> para acessar esta página.");
                } else {
                    if(!isset($_REQUEST['usuário'])){
                        require_once "../tools/includes/user-editData-form.php";
                    } else {
                        $user = $_REQUEST['usuário'] ?? null;
                        $nome = $_REQUEST['nome'] ?? null;
                        $tipo = $_REQUEST['tipo'] ?? null;
                        $senha1 = $_REQUEST['senha1'] ?? null;
                        $senha2 = $_REQUEST['senha2'] ?? null;
                
                        $query = "UPDATE usuários SET usuário = '$user', nome = '$nome'";
                
                        if (empty($senha1) || is_null($senha1)){
                            echo msg_aviso("Senha antiga foi mantida");
                        } elseif($senha1 === $senha2){
                            $senha = gerarHash($senha1);
                            $query .= ", senha = '$senha', tipo = '$tipo'";
                        } else {
                            echo msg_erro("Senhas não idênticas, a senha anterior será mantida!");
                        }
                
                        $query .= " WHERE usuário = '" . $_SESSION['user'] ."'";
                
                        if($banco->query($query)){
                            echo msg_sucesso("Dados alterados com sucesso!");
                            logout();
                            echo msg_aviso("Para a sua segurança, efetue o <a href='login.php'>LOGIN</a> novamente");
                        } else{
                            echo msg_erro("Erro ao alterar os dados, refaça o procedimento.");
                        }
                    }
                    echo botao();
                }
            ?>
        </div>
        <?php 
            require_once "../tools/includes/footer.php";
        ?>
    </body>
</html>