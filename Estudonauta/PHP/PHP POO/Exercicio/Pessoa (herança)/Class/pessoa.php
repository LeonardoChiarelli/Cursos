<?php 
    abstract class Pessoa{ // Classe abstrata, não pode ser instanciada (virar objeto)
        private $nome, $idade, $sexo;

        public final function fazerAniv(){ // Método final, não pode ser sobrescrito
            $this->setIdade($this->getIdade() + 1);
        }
# CONSTRUCT 
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
    }
?>