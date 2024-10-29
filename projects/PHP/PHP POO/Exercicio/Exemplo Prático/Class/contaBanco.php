<?php 
date_default_timezone_set("America/Sao_Paulo");
    class Banco{
// ATRIBUTOS
        public $numConta;
        protected $tipo;
        private $pessoa;
        private $saldo;
        private $status;

// MÉTODOS
        public function abrirConta($t){
            $this->setTipo($t);
            $this->setStatus(true);
            if($t == "CC"){
                $this->setSaldo(50);
            } elseif($t == "CP"){
                $this->setSaldo(150);
            } else {
                echo "ERRO";
            }
        }
        public function fecharConta(){
            if($this->getSaldo() > 0){
                echo "<p>Você tem saldo na conta, saque-o para poder fechar sua conta</p>";
            } elseif($this->getSaldo() < 0){
                echo "<p>Conta em débito</p>";
            } else {
                echo "<p>Conta de {$this->getPessoa()} fechada com sucesso!</p>";
                $this->setNumConta(null);
                $this->setPessoa(null);
                $this->setSaldo(null);
                $this->setTipo(null);
                $this->setStatus(false);
            }
        }
        public function depositar($num){
            if ($this->getStatus() == true){
                $this->setSaldo($this->getSaldo() + $num);
                echo "<p>Depósito de R\$" .number_format($num, 2, ",") ." realizado na conta de {$this->getPessoa()} às " .date('G:i:s') ."</p>";
            } else {
                echo "<p>Abra uma conta para poder fazer o depósito</p>";
            }
        }
        public function sacar($num){
            if($this->getSaldo() == true and $this->getSaldo()>=$num){
                $this->setSaldo($this->getSaldo() - $num);
                echo "<p>Saque de R\$" .number_format($num, 2, ",") ." autorizado na conta de {$this->getPessoa()} às " .date('G:i:s') ,"</p>";
            } elseif($this->getSaldo() < $num and $this->getStatus() == true) {
                echo "<p><strong>Saldo insuficiente</strong> <br> Saque no valor de R\$" .number_format($num, 2, ",", ".") . " negado na conta de {$this->getPessoa()}</p>";
            } else {
                echo "<p>Abra uma conta para poder fazer o saque</p>";
            }
        }
        public function pagarMensal(){
            if($this->getStatus() == true and $this->getTipo() == "CC" and $this->getSaldo() > 12){
                $this->setSaldo($this->getSaldo() - 12);
                echo "<p>Mensalidade no valor de R\$" .number_format(12, 2, ",") ." debitada da conta de {$this->getPessoa()}</p>";
            } elseif($this->getStatus() == true and $this->getTipo() == "CP" and $this->getSaldo() > 20){
                $this->setSaldo($this->getSaldo() - 20);
                echo "<p>Mensalidade no valor de R\$" .number_format(20, 2, ",") ." debitada da conta de {$this->getPessoa()}</p>";
            } elseif($this->getStatus() == false){
                echo "<p>Abra uma conta para pagar a mensalidade";
            } elseif($this->getTipo() == 'CC' and $this->getSaldo() < 12){
                echo "<p>Saldo insuficiente, realize um depósito</p>";
            } elseif ($this->getTipo() == 'CP' and $this->getSaldo() < 20){
                echo "<p>Saldo insuficiente, realize um depósito</p>";
            } else {
                echo " ";
            }
        }

// MÉTODOS ESPECIAIS
        public function getNumConta(){
            return $this->numConta;
        }
        public function setNumConta($num){
            $this->numConta = $num;
        }
        public function getTipo(){
            return $this->tipo;
        }
        public function setTipo($t){
            $this->tipo = $t;
        }
        public function getPessoa(){
            return $this->pessoa;
        }
        public function setPessoa($nome){
            $this->pessoa = $nome;
        }
        public function getSaldo(){
            return $this->saldo;
        }
        public function setSaldo($din){
            $this->saldo = $din;
        }
        public function getStatus(){
            return $this->status;
        }
        public function setStatus($AF){
            $this->status = $AF;
        }

        public function __construct(){
            $this->setSaldo(0);
            $this->setStatus(false);
        }
    }
?>