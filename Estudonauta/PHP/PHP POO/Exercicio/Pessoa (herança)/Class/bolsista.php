<?php 
    require_once "aluno.php";
    class Bolsista extends Aluno{
        private $bolsa;
        
        public function renovarBolsa(){
            echo "<p>Bolsa do aluno <strong>{$this->getNome()}<strong> renovada!</p>";
        }
        public function pagarMensalidade($v){
            $v -= $this->getBolsa();
            echo "<p>Mensalidade do aluno <strong>{$this->getNome()}</strong> no valor de R\$". number_format($v, 2, ",", ".") ." paga com sucesso <small>(bolsa de R\${$this->getBolsa()} já aplicada)</small></p>";   
        }

// CONSTRUCT
        public function __construct($n, $i, $s, $m, $c, $b){
            $this->setNome($n);
            $this->setIDade($i);
            $this->setSexo($s);
            $this->setMatricula($m);
            $this->setCurso($c);
            $this->setBolsa($b);
        }

// GETTERS
        public function getBolsa(){
            return $this->bolsa;
        }

// SETTERS
        public function setBolsa($b){
            $this->bolsa = $b;
        }
    }
?>