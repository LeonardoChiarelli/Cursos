<?php 
session_start();

if (!isset($_SESSION['user'])){
    $_SESSION['user'] = "";
    $_SESSION['nome'] = "";
    $_SESSION['tipo'] = "";
}

    function criptografia($senha){
        $cripto = '';
        for($posicao = 0; $posicao < strlen($senha); $posicao++){
            $letra = ord($senha[$posicao]) + 1;
            $cripto .= chr($letra);
        }
        return $cripto;
    }

    function gerarHash($senha){
        $senCrip = criptografia($senha);
        $hash = password_hash($senCrip, PASSWORD_DEFAULT);
        return $hash;
    }

    function testarHash($senha, $hash){
        $ok = password_verify(criptografia($senha), $hash);
        return $ok;
    }

    function logout(){
        unset($_SESSION['user']);
        unset($_SESSION['nome']);
        unset($_SESSION['tipo']);
    }

    function is_logado(){
        if(empty($_SESSION['user'])){
            return false;
        } else{
            return true;
        }
    }

    function is_admin(){
        $tipo = $_SESSION['tipo'] ?? null;
        if(is_null($tipo)){
            return false;
        } else {
            if($tipo == 'admin'){
                return true;
            } else{
                return false;
            }
        }
    }

    function is_editor(){
        $tipo = $_SESSION['tipo'] ?? null;
        if(is_null($tipo)){
            return false;
        } else {
            if($tipo == 'editor'){
                return true;
            } else{
                return false;
            }
        }
    }

    function is_leitor(){
        $tipo = $_SESSION['tipo'] ?? null;
        if(is_null($tipo)){
            return false;
        } else {
            if($tipo == 'leitor'){
                return true;
            } else{
                return false;
            }
        }
    }
?>