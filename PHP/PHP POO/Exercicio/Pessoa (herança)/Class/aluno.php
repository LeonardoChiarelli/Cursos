<?php 
    require_once "pessoa.php";
    class Aluno extends Pessoa{
        private $matricula, $curso;

        public function pagarMensalidade($v){
            echo "<p>Mensalidade do aluno <strong>{$this->getNome()}</strong> no valor de R\$" . number_format($v, 2, ",", ".") . " paga com sucesso</p>";
        }

// CONSTRUCT
        public function __construct($n, $i, $s, $m, $c){
            $this->setNome($n);
            $this->setIDade($i);
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