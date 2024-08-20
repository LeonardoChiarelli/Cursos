<?php 
require_once "aluno.php";
    class Tecnico extends Aluno{
        private $registroProfissional;

        public function praticar(){

        }

// CONSTRCUT
        public function __construct($RP){
            $this->setRegistroProfissional($RP);
        }

// GETTERS
        public function getRegistroProfissional(){
            return $this->registroProfissional;
        }

// SETTERS
        public function setRegistroProfissional($RP){
            $this->registroProfissional = $RP;
        }
    }
?>