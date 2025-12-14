<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../../style.css">
    <link rel="shortcut icon" href="../../../favicon.ico" type="image/x-icon">
    <title>Resultado</title>
</head>
<body>
    <main>
    <h1 style="text-align: center;">Conversor R$ - U$</h1>
        <?php 
            $real = $_REQUEST["real"] ?? 0;


            // API para pegar a cotação do dólar atual 

            $inicio = date("m-d-Y", strtotime("-7 days")); # Para pegar 7 dias antes
            $fim = date("m-d-Y");

            $url = 'https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoDolarPeriodo(dataInicial=@dataInicial,dataFinalCotacao=@dataFinalCotacao)?@dataInicial=\''. $inicio .'\'&@dataFinalCotacao=\''. $fim .'\'&$top=1&$orderby=dataHoraCotacao%20desc&$format=json&$select=cotacaoCompra,dataHoraCotacao';
    
            $dados = json_decode(file_get_contents($url), true); # true -> joga os dados dentro de um array, false -> joga os dados dentro de um object

            $cotação = $dados["value"][0]["cotacaoCompra"];
            
            // FIM DA API

            $dólar = $real / $cotação;

            $padrão = numfmt_create("pt_BR", NumberFormatter::CURRENCY);

            echo "<p>Seus " .numfmt_format_currency($padrão, $real, "BRL") . " equivalem a <strong>" .numfmt_format_currency($padrão, $dólar, "USD") ."</strong></p>";

        ?>
        <button onclick="history.go(-1)">Voltar</button>
    </main>
</body>
</html>