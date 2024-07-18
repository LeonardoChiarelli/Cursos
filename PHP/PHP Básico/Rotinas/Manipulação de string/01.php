<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="shortcut icon" href="../../../favicon.ico" type="image/x-icon">
        <title>Manipulação de String</title>
        <style>
            body{
                background-color: antiquewhite;
            }
        </style>
    </head>
    <body>
        <?php 
            $prod = "leite";
            $preço = 4.5;
            printf("O %s está custando R$%.2f <br>", $prod, $preço); # Usado para escrever coisas na tela já com formatação

            $x = [4, 3, 8]; # Podemos criar um vetor desta outra forma: $x = array (4, 3, 8);
            print_r($x); # Mostra detalhes de uma variável, principalmente se ela for um vetor, útil em períodos de teste, pode-se usar 'var_export()' também
            var_dump($x); # Mesma coisa do 'print_r' mas mostra mais detalhadamente

            $txt = "Este é um exemplo de string gigante criado pelo PHP que vai mostrar o funcionamento da função 'wordwrap'";
            $res = wordwrap($txt, 8, "<br>\n", false); # Basicamente cria quebra de linhas dentro do código HTML gerado, passando o parâmetro '<br>' a quebra de linha se torna visual mas é excluida do código fonte, porém passando o parâmetro '\n' ao lado do <br> a quebra de linha volta ao código fonte, adicionando o boolean 'false' palavras com mais caracteres do que o passado não serão quebras, já com o 'true' elas serão quebradas
            echo $res;

            $s = "Olá";
            $t = strlen($s); # Calcula o comprimento de uma string, para resolver o problema de caracteres acentuados contarem 1, basta usar 'mb_strlen($s, "utf-8");
            $T = mb_strlen($s, "utf-8");
            echo "<p>O comprimento da palavra '$s' sem mb_strlean é igual a $t, já com mb_strlen é igual a $T(O esperado)</p>";

            $nome = "   José da Silva   ";
            echo "<p>O valor contido na variável nome ($nome) sem o parâmetro 'trim' é " .mb_strlen($nome, "utf-8") ."</p>";
            $novo = trim($nome); # Útil para dados vindos de formulários, usada basicmente para excluir espaços desnecessários no começo e no fim da variável
            echo "<p>Já com o 'trim' em uso a variável nome ($nome) tem " .mb_strlen($novo, "utf-8") ."</p>";
            $Novo = ltrim($nome); # Mesma coisa do 'trim' mas elimina apenas os espaços à esquerda, o 'rtrim' é igual, mas elimina os espaços à direita
            echo "<p>Com o do 'ltrim' em uso a variável nome ($nome) tem " .mb_strlen($Novo, "utf-8") ."</p>";

            $frase = "Eu estou estudando PHP agora";
            $count = str_word_count($frase, 0); # Entrega a quantidade de palavras que existem dentro da string # Existem os valores 0, 1 e 2; o valor 0 simplesmente conta as palavras, o valor 1 gera um vetor, o valor 2 também cria um vetor, mas mostra em qual posição cada palavra começa
            echo "<p> A frase '$frase' tem $count palavras</p>";
            $Count = str_word_count($frase, 1);
            var_dump($Count);
            $count = str_word_count($frase, 2);
            var_dump($Count);

            $site = "Curso em Vídeo";
            $vetor = explode(" ", $site); # Basicamente uma versão "mais nova" do 'str_word_count', vai procurar espaços e qual a string que vai ser "explodida"
            var_dump($vetor);
            

            $vetor = str_split($novo); # Vai separar cada letra e colocar dentro de um índice do vetor  
            var_dump($vetor);

            $vetor = ['Curso', 'em', 'Vídeo'];
            $texto = implode("#", $vetor); #Pega um vetor e transforma em uma string, dentro das "" você coloca com que quer separar as palavras -> podemos usar o parâmetro 'join()' que irá funcionar da mesma forma 
            print $texto;


            $letra = chr(64); # Vai mostrar exatamente que letra esta no código colocado, neste caso 64 -> @
            echo "<p>O código da $letra é 64</p>";

            $letra = ord("A"); # Vai mostrar o código da letra, neste caso A -> 65
            echo "<p>A letra A tem código $letra</p>";
        ?>
    </body>
</html> 