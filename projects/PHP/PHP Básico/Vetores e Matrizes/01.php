<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../../favicon.ico" type="image/x-icon">
        <title>Vetores e Matrizes 01</title>
        <style>
            body{
                background-color: antiquewhite;
            }
        </style>
    </head>
    <body>

            <?php 
                $n = [3, 5, 8, 2];
                var_dump($n);

                $c = range(5, 20, 1.5); # 1º número é o começo do array, o 2º é o último e o 3º número é o passo
                foreach($c as $valor){ # Para mostrar os valores do array na tela, para cada elemento de $c tratado como valor
                    echo "<pre>$valor</pre>";
                }

                $n = [1=>"A", 3=>"B", 6=>"C", 10=>"D"]; # Chaves personalizadas
                $n[] = "E";
                unset($n[11]); # Para apagar um índice do array, caso seja vazio ele apagará o último
                print_r($n);

                $cadastro =[
                    "Nome" => "Leonardo",
                    "Idade" => 18,
                    "Peso" => 56.4
                ];
                $cadastro["Fuma"] = true;
                var_dump($cadastro);
                $res = $cadastro["Fuma"] == true ? "Sim" : "Não";
                /* foreach($cadastro as $campo => $valor){
                    echo "O valor de $campo é $valor ";
                } */
                echo "<p>Nome: $cadastro[Nome] <br> Idade: $cadastro[Idade] anos <br> Peso: $cadastro[Peso]kg <br> Fumante? $res</p>";

                $n = [
                    [3,4],
                    [2,3],
                    [9,5]
                ];
                $n[2][0] = $n[1][1]; # 1º n(vetor cheio de vetores), [2][0] significa linha 2 coluna 0 vai receber n[1][1], ou seja, o valor contido na linha 1 coluna 1
                var_dump($n);
                
            ?>

    </body>
</html>