<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="style/style.css">
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
        <title>Listagem de Jogos</title>
    </head>
    <body>
        <?php 
            require_once "tools/includes/acessoDatabase.php";
            require_once "tools/includes/funcoes.php";
            require_once "tools/includes/hash.php";
            $ordem = $_REQUEST["o"] ?? 0;
            $buscar = $_REQUEST["buscar"] ?? "";
        ?>
        <div id="corpo">
            <?php include_once "tools/includes/header.php" ?>
            <h1 id="animacao">Escolha seu jogo!</h1>
            <form action="<?=$_SERVER['PHP_SELF']?>" method="get" id="buscar" autocomplete="off">
                <label for="iord">Ordenar:</label>
                    <a href="index.php?o=1&buscar=<?=$buscar?>">Nome(reverso)</a> |
                    <a href="index.php?o=2&buscar=<?=$buscar?>">Produtora</a> |
                    <a href="index.php?o=3&buscar=<?=$buscar?>">Nota(crescente)</a> |
                    <a href="index.php?o=4&buscar=<?=$buscar?>">Nota(decrescente)</a> |
                    <a href="index.php">Mostrar Todos</a> |
                <label for="ibusca">Buscar: </label>
                <input type="text" name="buscar" id="ibusca" size="10" maxlength="40" placeholder="Aventura">
                <input type="submit" value="&#x1F50D;" id="lupa">
            </form>
            <table class="listagem">
                <?php 
                    $query = "select j.cod, j.nome, g.gênero, j.capa, p.produtora from jogos as j join gênero as g on j.gênero = g.cod join produtoras as p on j.produtora = p.cod ";

                    if(!empty($buscar)){
                        $query .= "where j.nome like '%$buscar%' or p.produtora like '%$buscar%' or g.gênero like '%$buscar%'";
                    }

                    switch($ordem){
                        case 1:
                            $query .= "order by j.nome desc";
                        break;
                        case 2:
                            $query .= "order by p.produtora";
                        break;
                        case 3:
                            $query .= "order by j.nota";
                        break;
                        case 4:
                            $query .= "order by j.nota desc";
                        break;
                        default: $query .= "order by j.nome";
                    };
                    $busca = $banco->query($query);
                    if(!$busca){
                        echo "<th><td>Infelizmente a busca deu errado</th></tr>";
                    } else{
                        if($busca->num_rows == 0){
                            echo "<tr><th>Nenhum registro foi encontrado</th></tr>";
                        } else{
                            while($registro=$busca->fetch_object()){
                                $t = thumb($registro->capa);
                                echo "<tr>
                                        <th scope='col'><img src='$t' class='fotoMin'></th>
                                        <th scope='col'><a href='php/detalhes.php?cod=$registro->cod' class='linkNome'>$registro->nome</a> <br> <div class='genXprod'>Gênero: $registro->gênero. <br> Produtora: $registro->produtora.</div></th>
                                    ";
                                    if(is_admin()){
                                        echo "<th scope='colgroup' class='acesso'><span class='material-icons'>edit</span>  <span class='material-icons'>delete</span></th></tr>";
                                    } elseif(is_editor()){
                                        echo "<th scope='colgroup' id='editor' class='acesso'><span class='material-icons'>edit</span></th></tr>";
                                    } elseif(is_leitor()){
                                        echo "";
                                    }
                            }
                        }
                    }
                ?>
            </table>
        </div>
        <?php include_once "tools/includes/footer.php"?>
    </body>
</html>