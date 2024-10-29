<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Operadores de Atribuição</title>
        <style>
            *{
                line-height: 1.5em;
                text-indent: 10px;  
            }
        </style>
    </head>
    <body>
        <h1></h1>
        <?php 
            $a = 5; $b = 3; $c = $a + $b; $c += 5; // A própria variável + 5 vai ser armazenada dentro dela mesma 
            $b -= $a;  $a++; // onde a variável é usada e depois é incrementado 1 (pós-incremento); a-- é ao contrário
            ++$a; // onde a variável incrementa antes de qualquer coisa (pré-incremento), podendo ser decremento também (--$a)

            $produto = $_GET["p"];
            echo "<p>O produto custa R$" .number_format($produto, 2, "," , ".");
            $produto += $produto * 0.1;
            echo ", com a inflação, o preço do produto sofreu um aumento de 10%, passando a ser R$" .number_format($produto, 2, "," , "."). "</p>";

            $data = date("Y"); // date("Y-M-D") para a data completa
            echo "<p> O ano atual é $data";
            $data--;
            echo ", portanto o ano anterior é $data";
            $data += 2;
            echo ", seguindo essa lógica o ano seguinte é $data </p>";

            $A = 3;
            $B = &$A; # A variável B vai ser uma referência para A
            $B += 5; # Esse comando modifica tanto a variável A quanto a variável B, as duas passando a valer 8, por termos ligado a variável A com a B pelo &
            echo "<p>Variável A = $A e variável B = $B</p>";

            $nome = "Leonardo";
            $$nome = " Chiarelli"; # $ antes de uma variável vão criar variáveis variantes, dentro do servidor será criada uma variável e o nome dessa variável será o conteúdo da primeira variável, nesse caso "Leonardo" e o valor atribuído será "Chiarelli"
            echo "<p>$nome $Leonardo</p>"
        ?>
        <ul>
            <li>Operadores:</li>
            <ul>
                <li>Adição - $a += $b</li>
                <li>Subtração - $a -= $b</li>
                <li>Divisão - $a /= $b</li>
                <li>Multiplicação - $a *= $b</li>
                <li>Módulo - $a %= $b</li>
                <li>Concatenação - $a .= $b</li>
            </ul>
            <li>Incremento e Decremento:</li>
            <ul>
                <li>Pré Incremento e Decremento</li>
                    <ul>
                        <li>++x;</li>
                        <li>--x;</li>
                    </ul>
                <li>Pós Incremento e Decremento</li>
                    <ul>
                        <li>x++;</li>
                        <li>x--;</li>
                    </ul>
            </ul>
            <li>Variáveis Referenciadas:</li>
            <ul>
                <li>Usando o '&' na frente de uma variável podemos fazer referência a outra variável</li>
                <li>Exemplo:</li>
                    <ul>
                        <li>$A = 3; <br> $B = &$A; # A variável B vai ser uma referência para A <br> $B += 5; # Esse comando modifica tanto a variável A    quanto a variável B, as duas passando a valer 8, por termos ligado a variável A com a B pelo &</li>
                    </ul>
            </ul>
            <li>Variáveis de variáveis</li>
                <ul>
                    <li>'$' Antes de uma variável vão criar variáveis variantes, dentro do servidor será criada uma variável e o nome dessa variável será o conteúdo da primeira variável, no caso abaixo "Leonardo" e o valor atribuído será "Chiarelli"</li>
                    <li>Código:</li>
                        <ul>
                            <li>$nome = "Leonardo"; <br> $$nome = " Chiarelli";</li>
                        </ul>
                </ul>

        </ul>
        </body>
</html>