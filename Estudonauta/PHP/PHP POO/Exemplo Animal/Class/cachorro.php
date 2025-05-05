<?php 
require_once "lobo.php";
    class Cachorro extends Lobo{
        public function reagirFrase($frase){
            if($frase === "Vem comer" || $frase === "Olá"){
                echo "<p>O cachorro abanou o rabo e latiu</p>";
            } else {
                echo "<p>O cachorro rosnou</p>";
            }
        }
        public function reagirHora($hora, $min){
            if($hora < 12){
                echo "<p>O cachorro abanou o rabo</p>";
            } elseif($hora >= 18){
                echo "<p>O cahorro ignorou você</p>";
            } else {
                echo "<p>O cachorro abanou o rabo e latiu</p>";
            }
        }
        public function reagirDono($dono){
            if($dono === true){
                echo "<p>O cachorro abanou o rabo</p>";
            } else{
                echo "<p>O cachorro rosnou e latiu</p>";
            }
        }
        public function reagirIP($idade, $peso){
            if($idade < 5){
                if($peso < 10){
                    echo "<p>O cachorro abanou o rabo</p>";
                } else {
                    echo "<p>O cachorro latiu</p>";
                }
            } else{
                if($peso < 10){
                    echo "<p>O cachorro rosnou</p>";
                } else{
                    echo "<p>O cachorro ignorou você</p>";
                }
            } 
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