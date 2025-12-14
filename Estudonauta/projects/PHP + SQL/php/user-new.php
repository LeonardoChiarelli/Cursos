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
        <title>Novo Usuário</title>
    </head>
    <body>
        <div id="corpo">
            <?php 
                if(!is_admin()){
                   echo msg_erro('Área apenas para administradores!');
                } elseif(!isset($_REQUEST['usuário'])){
                    require_once "../tools/includes/user-new-form.php";
                } else {
                    $user = $_REQUEST['usuário'] ?? null;
                    $nome = $_REQUEST['nome'] ?? null;
                    $senha1 = $_REQUEST['senha1'] ?? null;
                    $senha2 = $_REQUEST['senha2'] ?? null;
                    $tipo = $_REQUEST['tipo'] ?? null;

                    if ($senha1 === $senha2){
                        if(empty($user) || empty($nome) || empty($senha1) || empty($senha2) || empty($tipo)){
                            echo msg_aviso('Há campos sem dados, repita o procedimento');
                        } else{
                            $senha = gerarHash($senha1);
                            $query = "INSERT into usuários (usuário, nome, senha, tipo) values ('$user', '$nome', '$senha', '$tipo')";
                            if($banco->query($query)){
                                echo msg_sucesso("Usuário \"$nome\" cadastrado com êxito!");
                            } else {
                                msg_erro("Falha ao cadastrar o usuário $user, talvez o user já esteja em uso, repita o procedimento.");
                            }
                        }
                    } else {
                        echo msg_aviso('Senhas divergentes, repita o procedimento!');
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