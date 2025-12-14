<?php 
require_once "acoesVideo.php";
    class Vídeo implements AcoesVideo{
        private $titulo, $avaliacao, $views, $curtidas, $reproduzindo;

        public function play(){
                $this->setReproduzindo(true);
        }
        public function pause(){
                $this->setReproduzindo(false);
        }
        public function like(){
            $this->setCurtidas($this->getCurtidas() + 1);
        }

# CONSTRUCT
        public function __construct($t){
            $this->setReproduzindo(false);
            $this->setAvaliacao(1);
            $this->setViews(0);
            $this->setCurtidas(0);
            $this->setTitulo($t);
        }

# GETTERS
        public function getTitulo(){
            return $this->titulo;
        }
        public function getAvaliacao(){
            return $this->avaliacao;
        }
        public function getViews(){
            return $this->views;
        }
        public function getCurtidas(){
            return $this->curtidas;
        }
        public function getReproduzindo(){
            $this->reproduzindo;
        }

# SETTERS
        public function setTitulo($t){
            $this->titulo = $t;
        }
        public function setAvaliacao($a){
            $media = ($this->getAvaliacao() + $a) / 2;
            $this->avaliacao = $media; 
        }
        public function setViews($v){
            $this->views = $v;
        }
        public function setCurtidas($c){
            $this->curtidas = $c;
        }
        public function setReproduzindo($r){
            $this->reproduzindo = $r;
        }
    }
?>