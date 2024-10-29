<?php 
require_once "peixe.php";
    class Goldfish extends Peixe{
        

# CONSTRUCT
    public function __construct($p, $i, $m, $CE){
        $this->setPeso($p);
        $this->setIdade($i);
        $this->setMembros($m);
        $this->setCorEscama($CE);
    }
    }

?>