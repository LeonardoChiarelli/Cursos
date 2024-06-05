// FUNÇÕES

function soma(valor1, valor2){

    return valor1 + valor2
}

var total = soma(200, 37)

function realParaDolar(real, cotacao_dolar){
    return real * cotacao_dolar
}

var total = realParaDolar(10, 5.62)
document.getElementById("texto").innerHTML = total // ou colocar a função direto aqui