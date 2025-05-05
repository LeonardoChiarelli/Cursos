<?php 
    function tumb($arq){
        $caminho = "tools/photos/$arq";
        if(is_null($arq) || !file_exists($caminho)){
            return "tools/photos/indisponivel.png";
        } else{
            return $caminho;
        }
    }
