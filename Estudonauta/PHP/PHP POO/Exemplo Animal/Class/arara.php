<?php 
require_once "ave.php";
    class Arara extends Ave{
        

# CONSTRUCT
    public function __construct($p, $i, $m, $CP){
        $this->setPeso($p);
        $this->setIdade($i);
        $this->setMembros($m);
        $this->setCorPena($CP);
    }
    }

?>