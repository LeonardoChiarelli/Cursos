<?php 
    abstract class Animal{
        protected $tipo, $peso, $idade, $membros;

        public abstract function locomover();
        public abstract function alimentar();
        public abstract function emitirSom();

# CONSTRUCT
        public function __construct($p, $i, $m){
            $this->setPeso($p);
            $this->setIdade($i);
            $this->setMembros($m);
        }

# GETTERS
        public function getTipo(){
            return $this->tipo;
        }
        public function getPeso(){
            return $this->peso;
        }
        public function getIdade(){
            return $this->idade;
        }
        public function getMembrod(){
            return $this->membros;
        }

#SETTERS
        public function setTipo($t){
            $this->tipo = $t;
        }
        public function setPeso($p){
            $this->peso = $p;
        }
        public function setIdade($i){
            $this->idade = $i;
        }
        public function setMembros($m){
            $this->membros = $m;
        }
    }
?>