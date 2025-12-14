<?php 
require_once "animal.php";
    class Mamífero extends Animal{
        private $corPelo;

        public function locomover(){
            echo "<p>O mamífero está correndo!</p>";
        }
        public function alimentar(){
            echo "<p>O mamífero está comendo!</p>";
        }
        public function emitirSom(){
            echo "<p>O mamífero emitiu um som!</p>";
        }

# CONSTRUCT 
        public function __construct($p, $i, $m, $CP){
            $this->setPeso($p);
            $this->setIdade($i);
            $this->setMembros($m);
            $this->setCorPelo($CP);
        }

# GETTERS
        public function getCorPelo(){
            return $this->corPelo;
        }

# SETTERS
        public function setCorPelo($CP){
            $this->corPelo = $CP;
        }
    }
?>