<?php 
require_once "animal.php";
    class Ave extends Animal{
        private $corPena;

        public function locomover(){
            echo "<p>A ave está vooando!</p>";
        }
        public function alimentar(){
            echo "<p>A ave está comendo!</p>";
        }
        public function emitirSom(){
            echo "<p>A ave emitiu um som</p>";
        }
        public function fazerNinho(){
            echo "<p>A ave fez um ninho</p>";
        }

# CONSTRUCT
        public function __construct($p, $i, $m, $CP){
            $this->setPeso($p);
            $this->setIdade($i);
            $this->setMembros($m);
            $this->setCorPena($CP);
        }

# GETTERS
        public function getCorPena(){
            return $this->corPena;
        }

# SETTERS
        public function setCorPena($CP){
            $this->corPena =$CP;
        }
    }
?>