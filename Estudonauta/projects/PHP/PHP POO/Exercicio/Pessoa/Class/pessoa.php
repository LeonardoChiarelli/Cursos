<?php 
    class Pessoa{
        private $nome, $idade, $sexo;

        public function fazerAniversário(){
            $this->setIdade($this->getIdade() + 1);
        }

// CONTRUCT
        public function __construct($n, $i, $s){
            $this->setNome($n);
            $this->setIDade($i);
            $this->setSexo($s);
        }
// GETTERS
        public function getNome(){
            return $this->nome;
        }
        public function getIdade(){
            return $this->idade;
        }
        public function getSexo(){
            return $this->sexo;
        }

// SETTERS
        public function setNome($n){
            $this->nome = $n;
        }
        public function setIdade($i){
            $this->idade = $i;
        }
        public function setSexo($s){
            $this->sexo = $s;
        }

// Método Mágico __toString()
        /* public function __toString(){
            return $this->getNome();
        } */
    }
?>