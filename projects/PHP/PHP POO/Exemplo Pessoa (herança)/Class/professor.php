<?php
require_once "pessoa.php"; 
    class Professor extends Pessoa{
        private $especialidade, $salario;

        public function receberAumento($n){
            $n = ($n/100) * $this->getSalario();
            $this->setSalario($this->getSalario() + $n);
        }

// CONTRUCT
        public function __construct($n, $i, $sex, $e, $s){
            $this->setNome($n);
            $this->setIdade($i);
            $this->setSexo($sex);
            $this->setEspecialidade($e);
            $this->setSalario($s);
        }

// GETTERS
        public function getEspecialidade(){
            return $this->especialidade;
        }
        public function getSalario(){
            return $this->salario;
        }

// SETTERS
        public function setEspecialidade($e){
            $this->especialidade = $e;
        }
        public function setSalario($s){
            $this->salario = $s;
        }
    }
?>