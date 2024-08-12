<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Vetores e Matrizes 02</title>
    <style>
        body{
            background-color: antiquewhite;
        }
    </style>
</head>
<body>
    
    <?php 
        $n = [3, 5, 8, 2];
        $n[] = 6;
        foreach($n as $valor){ # Podemos ler assim: "Para cada item(foreach) do vetor n considere como valor" 
            echo "$valor, ";
        }
        echo "<br>O vetor 'n' tem " .count($n) ." itens"; # Para mostrar na tela quantos itens tem o vetor

        array_push($n, 9); # Outra maneira de colocar itens no final de um vetor
        array_unshift($n,10); # Uma maneira dec colocar itens no início do vetor
        var_dump($n);

        array_pop($n); # Para retirar o ultimo elemento do array
        array_shift($n); # Para retirar o primeiro item de um array
        var_dump($n);

        sort($n); # Colocar os elementos em ordem
        var_dump($n);
        rsort($n); # Colocar em ordem reversa
        var_dump($n);

        $n = [3, 5, 8, 2];
        asort($n); # Ordenação Associativa, vai ordenar os itens e manter os índices
        var_dump($n);
        arsort($n); # Ordenação Associativa reversa
        var_dump($n);

        $n = [ 
            3=> "C", 
            2 => "E", 
            0=> "H",
            1=> "B"
        ];
        var_dump($n);
        ksort($n); # Para colocar em ordem de acordo com as chaves(índices) ; krsort($n) também existe, porém ordena os indices em ordem reversa
        var_dump($n);

    ?>

</body>
</html>