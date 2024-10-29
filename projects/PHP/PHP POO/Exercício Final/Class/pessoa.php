<?php 
    abstract class Pessoa{
        protected $nome, $idade, $sexo, $experiência;

        protected function ganharExp(){
            $this->setExperiencia($this->getExperiencia() + 1);
        }

// CONSTRUCT
    public function __construct($n, $i, $s){
        $this->setExperiencia(0);
        $this->setNome($n);
        $this->setIdade($i);
        $this->setSexo($s);
    }

// GETTERS
    public function getNome(){
        return $this->nome;
    }
    public function getIdade(){
        return $this->idade;
    }
    public function getSexo(){
        return $this->sexo;
    }
    public function getExperiencia(){
        return $this->experiência;
    }

// SETTERS
    public function setNome($n){
        $this->nome = $n;
    }
    public function setIdade($i){
        $this->idade = $i;
    }
    public function setSexo($s){
        $this->sexo = $s;
    }
    public function setExperiencia($e){
        $this->experiência = $e;
    }
    }
?>