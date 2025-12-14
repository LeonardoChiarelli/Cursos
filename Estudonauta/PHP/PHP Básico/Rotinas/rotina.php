<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
    <title>Rotinas (Funções)</title>
</head>
<body>
    <?php 
        function soma($a, $b){
            return $a+$b;
        }
        $r = soma(1,3);
        echo "<p>A soma vale $r";

        function S0ma(...$p){ # Função com multiplos parâmetros # pega todos os argumentos e coloca dentro de um vetor, nesse caso 'p'
            $tot = func_num_args(); # retorna o número de argumentos que foram passados, para este exemplo, a variável vai receber 5 argumentos
            $s = 0; # soma dos valores
            for($i=0; $i < $tot; $i++){
                $s += $p[$i]; # variável 's' vai receber ela mesma + a variével 'p' no índice 'i'
            }
            return $s;
        }

        $r = S0ma(3, 4, 8, 1, 2); # $p[0], $p[1] ...
        echo "<p>A soma dos valores é $r";
    ?>
</body>
</html>