<?php 
require_once "pessoa.php";
    class Professor extends Pessoa{
        private $especialidade, $salario;

        public function receberAumento($n){
            $n /= 100;
            $this->setSalario($this->getSalario() + ($n*$this->getSalario()));
        }

# CONSTRUCT
        public function __construct($e, $s){
            $this->setEspecialidade($e);
            $this->setSalario($s);
        }

# GETTERS
        public function getEspecialidade(){
            return $this->especialidade;
        }
        public function getSalario(){
            return $this->salario;
        }

# SETTERS
        public function setEspecialidade($e){
            $this->especialidade = $e;
        }
        public function setSalario($s){
            $this->salario = $s;
        }
    }
?>