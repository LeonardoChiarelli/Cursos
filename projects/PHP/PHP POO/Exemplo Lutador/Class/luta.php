<?php 
    require_once "lutador.php";
    class Luta{

        /* ATRIBUTOS */ private $desafiado, $desafiante, $rounds, $aprovada; /* ATRIBUTOS */
    
    // MÉTODOS
            public function marcarLuta($l1, $l2){
                if($l1->getCategoria() === $l2->getCategoria() and $l1 !== $l2){
                    $this->setAprovada(true);
                    $this->setDesafiado($l1);
                    $this->setDesafiante($l2);
                } else {
                    $this->setAprovada(false);
                    $this->setDesafiado(null);
                    $this->setDesafiante(null);
                }
            }
            public function lutar(){
                if($this->getAprovada() === true){
                    $this->desafiado->apresentar();
                    $this->desafiante->apresentar();

                    if($this->desafiado->getPeso() > $this->desafiante->getPeso() and $this->desafiado->getAltura() > $this->desafiante->getAltura() and $this->desafiado->getVitorias() > $this->desafiante->getVitorias()){
                        echo "<p>O campeão da luta de hoje foi o desafiado <strong>{$this->desafiado->getNome()}</strong></p>";
                        $this->desafiado->ganharLuta();
                        $this->desafiante->perderLuta();
                    } elseif($this->desafiante->getPeso() > $this->desafiado->getPeso() and $this->desafiante->getAltura() > $this->desafiado->getAltura() and $this->desafiado->getVitorias() > $this->desafiante->getVitorias()){
                        echo "<p>O campeão da luta de hoje foi o desafiante <strong>{$this->desafiante->getNome()}</strong></p>";
                        $this->desafiante->ganharLuta();
                        $this->desafiado->perderLuta();
                    } else{
                        $vencedor = rand(0,2);
                        switch($vencedor){
                            case 0:
                                echo "<p>EMPATE!</p>";
                                $this->desafiado->empatarLuta();
                                $this->desafiante->empatarLuta();
                                $this->desafiado->status();
                                $this->desafiante->status();
                            break;
                            case 1:
                                echo "<p>Vencedor: {$this->desafiado->getNome()}</p>";
                                $this->desafiado->ganharLuta();
                                $this->desafiante->perderLuta();
                                $this->desafiado->status();
                            break;
                            case 2:
                                echo "<p>Vencedor: {$this->desafiante->getNome()}</p>";
                                $this->desafiado->perderLuta();
                                $this->desafiante->ganharLuta();
                                $this->desafiante->status();
                        }
                    }
                } else {
                    echo "<p>Luta não pode acontecer, por divergência de categoria, ou por igualdade de lutador</p>";
                }
            }
    
    // CONSTRUCT
            /* public function __construct($desafiado, $desafiante, $rounds, $aprovada){
                $this->setDesafiado($desafiado);
                $this->setDesafiante($desafiante);
                $this->setRounds($rounds);
                $this->setAprovada($aprovada);
            } */
    
    // GETTERS
            public function getDesafiado(){
                return $this->desafiado;
            }
            public function getDesafiante(){
                return $this->desafiante;
            }
            public function getRounds(){
                return $this->rounds;
            }
            public function getAprovada(){
                return $this->aprovada;
            }
    
    // SETTERS
            public function setDesafiado($nome){
                $this->desafiado = $nome;
            }
            public function setDesafiante($nome){
                $this->desafiante = $nome;
            }
            public function setRounds($rounds){
                $this->rounds = $this->getRounds() + $rounds;
            }
            public function setAprovada($TF){
                $this->aprovada = $TF;
            }
    
        }
?>