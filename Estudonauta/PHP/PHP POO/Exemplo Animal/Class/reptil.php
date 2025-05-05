<?php 
require_once "animal.php";
    class Réptil extends Animal{
        private $corEscama;

        public function locomover(){
            echo "<p>O réptil está correndo!</p>";
        }
        public function alimentar(){
            echo "<p>O réptil está comendo!</p>";
        }
        public function emitirSom(){
            echo "<p>O réptil emitiu um som!</p>";
        }

# CONSTRUCT
        public function __construct($p, $i, $m, $CE){
            $this->setPeso($p);
            $this->setIdade($i);
            $this->setMembros($m);
            $this->setCorEscama($CE);
        }

# GETTERS
        public function getCorEscama(){
            return $this->corEscama;
        }

# SETTERS
        public function setCorEscama($CE){
            $this->corEscama = $CE;
        }
    }
?>