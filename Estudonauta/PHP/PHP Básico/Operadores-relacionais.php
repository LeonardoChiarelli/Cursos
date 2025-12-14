<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device=width, inital-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../favicon.ico" type="image/x-icon">
        <title>Operadores Relacionais</title>
        <style>

        </style>
    </head>
    <body>
        <?php 
            $a = $_GET["a"];
            $b = $_GET["b"];
            $m = ($_GET["a"] + $_GET["b"]) / 2;
            $num1 = $_GET["n1"];
            $num2 = $_GET["n2"];
            $tipo = $_GET["op"];
            $ano = $_GET["an"];
            $idade = date("Y") - $ano;
            $maior = $a > $b ? $a : $b; # Se 'a' for maior que 'b' escreva 'a', senão escreva 'b';
            $soma = $a > $b ? $a+$b : $a-$b;
            $media = $m >= 6 ? "Aprovado" : "Reprovado";
            $eleição = $idade >= 18 && $idade <= 70 ? "voto é <strong>obritório</strong>" : "voto é opcional";  
            echo "<p>O maior valor é $maior <br> A soma dos dois valores é $soma</p>";
            echo "<p>A primeira nota do aluno foi $a e a segunda nota foi $b, o aluno ficou com média $m, portanto ele está <strong>$media</strong></p>";
            echo "<p>Os valores passados foram $num1 e $num2 e o resultado das suas escolhas foi " .($tipo == "s" ? $num1 + $num2 : $num1 * $num2) ."</p>"; # Podemos colocar a expressão diretamente no echo por concatenação, colocando toda a expressão entre (), sem a necessidade da criação de uma variável
            echo "<p>Como você já tem $idade anos então seu $eleição</p>"
        ?>
        <ul>
            <li>Operador Ternário:</li>
                <ul>
                    <li>(expressão) ? (valor para verdadeiro) : (valor para falso)</li>
                </ul>
            <li>Operador Lógicos</li>
                <ul>
                    <li>&& ou and - Uma condição E a outra tem que ser verdadeiras</li>
                    <li>|| ou or - Uma condição OU outra tem que ser verdadeiras</li>
                    <li>xor - Apenas UMA condição pode ser verdadeira</li>
                    <li>! - Se a condição é verdadeira então irá retornar falso <!-- Mesma coisa ao contrário --></li>
                </ul>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </body>    
</html>