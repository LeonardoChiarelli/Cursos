<?php 
require_once "mamifero.php";
    class Canguru extends Mamífero{
        public function usarBolsa(){
            echo "<p>O canguru guardou seu filhote na bolsa</p>";
        }
        public function locomover(){
            echo "<p>O canguru está pulando</p>";
        }

# CONSTRUCT
    public function __construct($p, $i, $m, $CP){
        $this->setPeso($p);
        $this->setIdade($i);
        $this->setMembros($m);
        $this->setCorPelo($CP);
    }
    }
?>