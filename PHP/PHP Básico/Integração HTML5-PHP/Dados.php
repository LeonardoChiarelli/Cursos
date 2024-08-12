<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
    <title>Dados</title>
</head>
<body>

    <?php
        $nome = isset($_POST["nome"]) ? $_POST["nome"] : "[Não informado]"; # Caso o nome seja configurado a variável vai receber o valor de nome ou "não informado"
        $aN = isset($_POST["aN"]) ? $_POST["aN"] : "[Não informado]";
        $sexo = isset($_POST["sexo"]) ? $_POST["sexo"] : "[Não informado]";
        $idade = date("Y") - $aN;
            
        echo "<p>Seus dados: <br> $nome <br> $idade anos <br>" .(($sexo == 'M') ? "Masculino" : "Feminino") ."</p>";
    ?>
</body>
<a href="Dados.html">Voltar</a>
</html>