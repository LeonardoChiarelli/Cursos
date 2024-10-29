<?php 
require_once "animal.php";
    class Peixe extends Animal{
        private $corEscama;

        public function locomover(){
            echo "<p>O peixe peixe está nadando!</p>";
        }
        public function alimentar(){
            echo "<p>O peixe está comendo!</p>";
        }
        public function emitirSom(){
            echo "<p>Peixes não emitem sons</p>";
        }
        public function soltarBolha(){
            echo "<p>O peixe soltou uma bolha</p>";
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