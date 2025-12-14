<?php 
    interface Controlador{
    // MÉTODOS ABSTRATOS
            public function ligar();
            public function desligar();
            public function abrirMenu();
            public function fecharMenu();
            public function maisVolume();
            public function menosVolume();
            public function ligarMudo();
            public function desligarMudo();
            public function play();
            public function pause();
        }

    class ControleRemoto implements Controlador{
    
    // ATRIBUTOS
        private $volume;
        private $ligado;
        private $tocando;

    // MÉTODOS
    public function ligar(){
        $this->setLigado(true);
    }
    public function desligar(){
        $this->setLigado(false);
    }
    public function abrirMenu(){
        if($this->getLigado() == true){
            echo "<h3>----- MENU -----</h3>";
            echo "<p>Está Ligado? " . ($this->getLigado() ? "SIM</p>" : "NÃO</p>");
            echo "<p>Está Tocando? " .($this->getTocando() ? "SIM</p>" : "NÃO</p>");
            echo "<p>Volume: " .$this->getVolume();
            for($i = 0; $i <= $this->getVolume(); $i+=10){
                echo "|";
            }
            echo "<h3>----- MENU -----</h3>";
        } else {
            echo "<p>Ligue o controle para abrir o Menu</p>";
        }
    }
    public function fecharMenu(){
        echo "<Fechando Menu...</p>";
    }
    public function maisVolume(){
        if($this->getLigado() == true){
            $this->setVolume($this->getVolume() + 10);
        }
    }
    public function menosVolume(){
        if($this->getLigado() == true){
            $this->setVolume($this->getVolume() + 10);
        }
    }
    public function ligarMudo(){
        if($this->getLigado() == true and $this->getVolume() > 0){
            $this->setVolume(0);
        }
    }
    public function desligarMudo(){
        if($this->getLigado() == true and $this->getVolume() == 0){
            $this->setVolume(50);
        }
    }
    public function play(){
        if($this->getLigado() == true and $this->getTocando(false)){
            $this->setTocando(true);
        }
    }
    public function pause(){
        if($this->getLigado() == true and $this->getTocando() == true){
            $this->setTocando(false);
        }
    }

    // MÉTODOS ESPECIAIS
    public function __construct(){
        $this->setVolume(50);
        $this->setLigado(false);
        $this->setTocando(false);
    }

    private function getVolume(){
        return $this->volume;
    }
    private function setVolume($v){
        $this->volume = $v;
    }

    private function getLigado(){
        return $this->ligado;
    }
    private function setLigado($TF){
        $this->ligado = $TF;
    }

    private function getTocando(){
        return $this->tocando;
    }
    private function setTocando($TF){
        $this->tocando = $TF;
    }
}
?>