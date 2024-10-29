<?php
require_once "pessoa.php";
require_once "interface/publicar.php";
    class Livro implements Publicar{
        private $titulo, $autor, $totPaginas, $pagAtual, $aberto, $leitor;

        public function detalhes(){
            echo "<hr>";
            echo "<ul><li>Título: {$this->getTitulo()}</li>";
            echo "<li>Autor: {$this->getAutor()}</li>";
            echo "<li>Total de Páginas: {$this->getTotPaginas()}</li>";
            echo "<li>Página Atual: {$this->getPagAtual()} <small>(faltam apenas ". $this->getTotPaginas() - $this->getPagAtual() ." páginas a serem lidas)</small></li>";
            echo "<li>Leitor: {$this->getLeitor()->getNome()}</li></ul>";
            echo "<hr>";
        }
        public function abrir(){
            $this->setAberto(true);
        }
        public function fechar(){
            $this->setAberto(false);
        }
        public function folhear($p){
            if($p > $this->getTotPaginas()){
                $this->setPagAutal(0);
                echo "<h4>O livro '{$this->getTitulo()}' tem somente {$this->getTotPaginas()} páginas</h4>";
            } else{
                $this->setPagAutal($p);
            }
        }
        public function avançarPag(){
            if($this->getPagAtual() == $this->getTotPaginas()){
                echo "<h4>Você já está na última página</h4>";
            }else{
                $this->setPagAutal($this->getPagAtual() + 1);
            }
        }
        public function voltarPag(){
            if($this->getPagAtual() == 0){
                echo "<h4>Você já está na primeira página</h4>";
            } else{
                $this->setPagAutal($this->getPagAtual() - 1);
            }
        }

// CONTRUCT
        public function __construct($t, $a, $TP, $l){
            $this->setTitulo($t);
            $this->setAutor($a);
            $this->setAberto(false);
            $this->setPagAutal(0);
            $this->setTotPaginas($TP);
            $this->setLeitor($l);
        }

//GETTERS
        public function getTitulo(){
            return $this->titulo;
        }
        public function getAutor(){
            return $this->autor;
        }
        public function getTotPaginas(){
            return $this->totPaginas;
        }
        public function getPagAtual(){
            return $this->pagAtual;
        }
        public function getAberto(){
            $this->aberto;
        }
        public function getLeitor(){
            return $this->leitor;
        }

//SETTERS
        public function setTitulo($t){
            $this->titulo = $t;
        }
        public function setAutor($a){
            $this->autor = $a;
        }
        public function setTotPaginas($TP){
            $this->totPaginas = $TP;
        }
        public function setPagAutal($PA){
            $this->pagAtual = $PA;
        }
        public function setAberto($TF){
            $this->aberto = $TF;
        }
        public function setLeitor($n){
            $this->leitor = $n;
        }
    }
?>