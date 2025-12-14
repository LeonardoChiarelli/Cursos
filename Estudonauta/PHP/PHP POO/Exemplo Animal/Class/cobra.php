<?php 
require_once "reptil.php";
    class Cobra extends Réptil{
        public function locomover(){
            echo "<p>A cobra está rastejando</p>";
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