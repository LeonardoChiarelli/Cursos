<?php 
require_once "reptil.php";
    class Tartaruga extends Réptil{
        public function locomover(){
            echo "<p>A tartaruga, de forma bem lenta, está andando</p>";
        }

# CONSTRUCT
    public function __construct($p, $i, $m, $CE){
        $this->setPeso($p);
        $this->setIdade($i);
        $this->setMembros($m);
        $this->setCorEscama($CE);
    }
    }
?>