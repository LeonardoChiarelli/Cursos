<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="../style/style.css">
        <link rel="shortcut icon" href="../favicon.ico" type="image/x-icon">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
        <title>Detalhes</title>
    </head>
    <body>
        <?php 
            require_once "../tools/includes/acessoDatabase.php";
            require_once "../tools/includes/funcoes.php";
            require_once "../tools/includes/hash.php";
        ?>
        <div id="corpo">
        <?php 
            include_once "../tools/includes/header2.php";
            $codigo = $_REQUEST["cod"] ?? 0;
            $busca = $banco->query("select * from jogos where cod='$codigo'");
        ?>
            <table class='detalhes'>
                <?php
                    if (!$busca){
                        echo "<p>Infelizmente a busca deu errado</p>";
                    } else{
                        if($busca->num_rows == 1){
                            $registro = $busca->fetch_object();
                            $t = tumb($registro->capa);
                            echo "
                                <tr>
                                    <th rowspan='2'><img src='$t' class='full'></th>
                                    <th class='nomeXnota'><h2 class='nome'>$registro->nome</h2><p class='nota'>Nota: " .number_format($registro->nota, 1, ",") ."/10,0</p></th>
                                    ";

                                if(is_admin()){
                                    echo "<th scope='colgroup' rowspan='3' class='acesso'><span class='material-icons'>edit</span>  <span class='material-icons'>delete</span></th></tr>";
                                } elseif(is_editor()){
                                    echo "<th scope='colgroup' rowspan='3' id='editor' class='acesso'><span class='material-icons'>edit</span></th></tr>";
                                } elseif(is_leitor()){
                                    echo "";
                                };

                                echo "<tr>
                                    <th><p class='desc'>$registro->descrição</p></th>
                                </tr>
                                <tr>
                                    <th class='botão' colspan='2'>". botao() ."</th>
                                </tr>
                            ";
                        }else{
                            echo "
                                <tr>
                                    <th>Nenhum registro encontrado</th>
                                </tr>
                            ";
                        }
                    }
                ?>
            </table>
        </div>
        <?php include_once "../tools/includes/footer.php"?>
    </body>
</html>