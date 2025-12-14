<?php 
require_once "gafanhoto.php"; require_once "video.php";
    class Visualizacao{
        private $filme, $espectador; # filme (video) ; espectador (gafanhoto)

        public function avaliar(){
            $this->filme->setAvaliacao(5);
        }
        public function avaliarNota($n){
            $this->filme->setAvaliacao($n);
        }
        public function avaliarPorcent($p){
            $nota = 0;
            if($p <= 20){
                $nota = 3;
            } elseif($p <= 50){
                $nota = 5;
            } elseif($p <= 90){
                $nota = 8;
            } else {
                $nota = 10;
            }
            $this->filme->setAvaliacao($nota);
        }

# CONSTRUCT 
        public function __construct($espec, $fil){
            $this->setEspectador($espec);
            $this->setFilme($fil);

            $this->filme->setViews($this->filme->getViews() + 1);
            $this->filme->play();

            $this->espectador->viuMaisUm();
        }

# GETTERS
        public function getEspectador(){
            return $this->espectador;
        }
        public function getFilme(){
            return $this->filme;
        }

# SETTERS
        public function setEspectador($e){
            $this->espectador = $e;
        }
        public function setFilme($f){
            $this->filme = $f;
        }
    }
?>