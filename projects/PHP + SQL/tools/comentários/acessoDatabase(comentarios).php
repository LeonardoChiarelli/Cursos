<?php 
    /* CRIAÇÃO DO OBJETO */

    $banco = new mysqli("localhost", "root", "", "bd_games"); # (HOST, USUÁRIO, SENHA, BANCO) - informações dentro dos ()
    
    /* FIM */

    /* CRIAÇÃO DE UMA MENSAGEM MAIS FÁCIL DE ENTENDER CASO HAJA ALGUM ERRO */

    if($banco -> connect_errno){
        echo "<p>Encontrei um erro $banco->error --> $banco->connect_error</p>";
        die(); # Forçando o programa a parar cajo haja algum erro   
    }
    
    /* FIM */

/*  COMANDOS PARA CASO HAJA INCOMPATIBILIDADE COM CARACTERES ESPECIAIS */

$banco->query("SET NAMES 'utf8'");
$banco->query("SET character_set_connection=utf8");
$banco->query("SET character_set_client=utf8");
$banco->query("SET character_set_results=utf8"); 

/* FIM */

/* COLOCANDO UM COMANDO MYSQL DENTRO DE 'QUERY' PARA PODERMOS JOGAR O RESULTADO DENTRO DE UMA VARIÁVEL */

    $busca = $banco->query("select * from gênero");

/* FIM */
    
/* MENSAGEM PARA CASO DÊ ERRO | ESCREVENDO O RESULTADO DA BUSCA CASO DÊ CERTO | USANDO 'FETCH_OBJECT' PARA PEGAR OS DADOS E FAZER COM QUE ELES CAIBAM DENTRO DE OUTRO OBJETO */

    if(!$busca){
        echo "<p>Falha na busca! $banco->error</p>";
    } else{
        while($registro = $busca->fetch_object()){; # Colocando dentro de um loop para escrever todos os resultados existentes dentro do objeto
        print_r($registro);
        }
    }

/* FIM */
?>