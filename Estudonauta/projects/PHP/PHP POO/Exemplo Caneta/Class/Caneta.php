<?php 
    class Caneta{

/* ATRIBUTOS */
        public $modelo;
        public $cor;
        private $ponta;
        protected $carga;
        protected $tampada;

/* MÉTODOS */
        public function escrever(){
            if($this->tampada == true){
                echo "<p>Destampe a caneta para poder escrever</p>";
            } else {
                echo "<p>A caneta <strong>$this->modelo</strong> na cor <strong>$this->cor</strong> está escrevendo: \"Olá, Mundo!\"</p>";
            }
        }
        public function rabiscar(){
            if($this->tampada == true){
                echo "<p>Destampe a caneta para poder escrever</p>";
            } else {
                echo "<p>A caneta <strong>$this->modelo</strong> na cor <strong>$this->cor</strong> está rabiscando...</p>";
            }
        }
        public function pintar(){
            if($this->tampada == true){
                echo "<p>Destampe a caneta para poder escrever</p>";
            } else {
                echo "<p>A caneta <strong>$this->modelo</strong> na cor <strong>$this->cor</strong> está <mark>pintando...</mark>";
            }
        }
        public function tampar(){
            $this->tampada = true; /* Apenas 1 '=' */
        }
        public function destampar(){
            $this->tampada = false; 
        }

/* MÉTODOS GETTERS E SETTERS */
        public function getModelo(){
            return $this->modelo;
        }
        public function setModelo($m){
            $this->modelo = $m;
        }

        public function getCor(){
            return $this->cor;
        }
        public function setCor($cor){
            $this->cor = $cor;
        }

        public function getPonta(){
            return $this->ponta;
        }
        public function setPonta($p){
            $this->ponta = $p;
        }

        public function getCarga(){
            return $this->carga;
        }
        public function setCarga($carga){
            $this->carga = $carga;
        }

        public function getTampada(){
            return $this->tampada;
        }
        public function setTampada($t){
            $this->tampada = $t;
        }

/* MÉTODO CONSTRUCT */
        public function __construct($m, $cor, $p){ // O método é '__construct'
            $this->setModelo($m);
            $this->setCor($cor);
            $this->setPonta($p);
            $this->tampar();
        }
    }
?>