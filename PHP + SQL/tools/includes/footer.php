<?php 
    echo "
    <footer>
    <p>Acessado por IP(". $_SERVER['REMOTE_ADDR'] .") em ". date('d/m/Y') .". <br> Desenvolvido por <strong>Leonardo Chiarelli</strong> &copy; 2024.</p>
    </footer>";
    $banco->close();
    