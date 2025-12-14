<?php 
    function tumb($arq){
        $caminho = "../tools/photos/$arq";
        if(is_null($arq) || !file_exists($caminho)){
            return "../tools/photos/indisponivel.png";
        } else{
            return $caminho;
        }
    }

    function thumb($arq){
        $caminho = "tools/photos/$arq";
        if(is_null($arq) || !file_exists($caminho)){
            return "tools/photos/indisponivel.png";
        } else{
            return $caminho;
        }
    }

    function botao(){
        return "<a href='../index.php' class='back'><span class='material-icons'>keyboard_backspace</span></a>";
    }

    function msg_sucesso($msg){
        $resposta = "<div class='sucesso'> <span class='material-icons'>task_alt</span> $msg</div>";
        return $resposta;
    }

    function msg_aviso($msg){
        $resposta = "<div class='aviso'> <span class='material-icons'>error</span> $msg</div>";
        return $resposta;
    }

    function msg_erro($msg){
        $resposta = "<div class='erro   '> <span class='material-icons'>warning</span> $msg</div>";
        return $resposta;
    }