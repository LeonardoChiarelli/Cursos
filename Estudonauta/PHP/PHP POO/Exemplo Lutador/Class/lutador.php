<?php 
    class Lutador{
    /* ATRIBUTOS */ private $nome , $nacionalidade, $idade, $altura, $peso, $categoria, $vitorias, $derrotas, $empates; /* ATRIBUTOS */

//  MÉTODOS
        public function apresentar(){
            echo "<p><><><><><><><><><><><><><><><><><><></li>";

            echo "<ul><li>Lutador: {$this->getNome()}</li>";
            echo "<li>Origem: {$this->getNacionalidade()}</li>";
            echo "<li>{$this->getIdade()} anos</li>";
            echo "<li>{$this->getAltura()}m</li>";
            echo "<li>{$this->getPeso()}kg</li>";
            echo "<li>Ganhou: {$this->getVitorias()} vezes</li>";
            echo "<li>Perdeu: {$this->getDerrotas()} vezes</li>";
            echo "<li>Empatou: {$this->getEmpates()} vezes</li></ul>";

            echo "<p><><><><><><><><><><><><><><><><><><></p>";
        }
        public function status(){
            echo "<p><><><><><><><><><><><><><><><><><><></p>";

            echo "<ul><li>Lutador: {$this->getNome()}</li>";
            echo "<li>Categoria: Peso <strong>{$this->getCategoria()}</strong></li>";
            echo "<li>Cartel: {$this->getVitorias()} - {$this->getEmpates()} - {$this->getDerrotas()}</li></ul>";

            echo "<p><><><><><><><><><><><><><><><><><><></p>";
        }
        public function ganharLuta(){
            $this->setVitorias($this->getVitorias() + 1);
        }
        public function perderLuta(){
            $this->setDerrotas($this->getDerrotas() + 1);
        }
        public function empatarLuta(){
            $this->setEmpates($this->getEmpates() + 1);
        }

// CONSTRUCT
        public function __construct($nome, $nacionalidade, $idade, $altura, $peso, $vitorias, $derrotas, $empates){
            $this->setNome($nome);
            $this->setNacionalidade($nacionalidade);
            $this->setIdade($idade);
            $this->setAltura($altura);
            $this->setPeso($peso);
            $this->setVitorias($vitorias);
            $this->setDerrotas($derrotas);
            $this->setEmpates($empates);
        }

// GETTERS
        public function getNome(){
            return $this->nome;            
        }
        public function getNacionalidade(){
            return $this->nacionalidade;
        }
        public function getIdade(){
            return $this->idade;
        }
        public function getAltura(){
            return $this->altura;
        }
        public function getPeso(){
            return $this->peso;
        }
        public function getCategoria(){
            return $this->categoria;
        }
        public function getVitorias(){
            return $this->vitorias;
        }
        public function getDerrotas(){
            return $this->derrotas;
        }
        public function getEmpates(){
            return $this->empates;
        }
        public function getStatus(){
            return $this->status();
        }

// SETTERS
        public function setNome($nome){
            $this->nome = $nome;
        }
        public function setNacionalidade($nacionalidade){
            $this->nacionalidade = $nacionalidade;
        }
        public function setIdade($idade){
            $this->idade = $idade;
        }
        public function setAltura($altura){
            $this->altura = $altura;
        }
        public function setPeso($peso){
            $this->peso = $peso;
            $this->setCategoria();
        }
        private function setCategoria(){
            if($this->peso < 52.2){
                echo "<p>Lutador leve demais, categoria inválida</p>";
                $this->categoria = "Inválido";
            } elseif($this->peso <= 70.3){
                $this->categoria = "Leve";
            } elseif($this->peso <= 83.9){
                $this->categoria = "Médio";
            } elseif($this->peso <= 120.2) {
                $this->categoria = "Pesado";
            } else{
                echo "<p>Lutador pesado demais, categoria inválida</p>";
                $this->categoria = "Inválido";
            }
        }
        public function setVitorias($vitorias){
            $this->vitorias = $vitorias;
        }
        public function setDerrotas($derrotas){
            $this->derrotas = $derrotas;
        }
        public function setEmpates($empates){
            $this->empates = $empates;
        }
    }
?>