<?php 
require_once "pessoa.php";
    class Aluno extends Pessoa{
        private $matricula, $curso;

        public function cancelarMatricula(){
            if($this->getCurso() >= 1){
                $this->setMatricula(0);
                $this->setCurso(null);
                echo "<p>Matrícula cancelada com sucesso</p>";
            } else {
                echo "<p>Você não tem cursos para cancelar</p>";
            }
        }
// CONSTRUCT
        public function __construct($n, $i, $s, $m, $c){
            $this->setNome($n);
            $this->setIdade($i);
            $this->setSexo($s);
            $this->setMatricula($m);
            $this->setCurso($c);
        }

// GETTERS
        public function getMatricula(){
            return $this->matricula;
        }
        public function getCurso(){
            return $this->curso;
        }

// SETTERS
        public function setMatricula($m){
            $this->matricula = $m;
        }
        public function setCurso($c){
            $this->curso = $c;
        }
    }
?>