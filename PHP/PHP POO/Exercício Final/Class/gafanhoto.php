<?php 
require_once "pessoa.php";
    class Gafanhoto extends Pessoa{
        private $login, $totAssistido;

        public function viuMaisUm(){
            $this->setTotAssistido($this->getTotAssistido() + 1);
            $this->ganharExp();
        }

# CONSTRUCT
        public function __construct($n, $i, $s, $l){
            $this->setTotAssistido(0);
            $this->setExperiencia(0);
            parent::__construct($n, $i, $s);
            $this->setLogin($l);
        }

# GETTERS
        public function getLogin(){
            return $this->login;
        }
        public function getTotAssistido(){
            return $this->totAssistido;
        }

# SETTERS
        public function setLogin($l){
            $this->login = $l;
        }
        public function setTotAssistido($tA){
            $this->totAssistido = $tA;
        }
    }
?>