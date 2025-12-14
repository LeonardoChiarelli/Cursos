<?php 
require_once "pessoa.php";
    class Funcionario extends Pessoa{
        private $setor, $trabalhando;

        public function mudarTrabalho($t){
            $this->setTrabalhando($t);
        }

// CONSTRUCT
        public function __construct($n, $i, $sex, $s, $t){
            $this->setNome($n);
            $this->setIdade($i);
            $this->setSexo($sex);
            $this->setSetor($s);
            $this->setTrabalhando($t);
        }

// GETTERS
        public function getSetor(){
            return $this->setor;
        }
        public function getTrabalhando(){
            return $this->trabalhando;
        }

// SETTERS
        public function setSetor($s){
            $this->setor = $s;
        }
        public function setTrabalhando($t){
            $this->trabalhando = $t;
        }
    }
?>