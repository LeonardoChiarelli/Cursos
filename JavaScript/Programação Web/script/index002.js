// FUNÇÕES


// Função de soma
function soma(valor1, valor2){

    return valor1 + valor2
}

var total = soma(200, 37)
document.getElementById("texto").innerHTML = total


// Função de cotação
function realParaDolar(real, cotacao_dolar){
    return real * cotacao_dolar
}

var total = realParaDolar(6, 5.26)
document.getElementById("texto").innerHTML += `<p>$${total}</p>` // ou colocar a função direto aqui


// Função através de um botão no html

function clicar(){
    document.getElementById("texto").innerHTML += "<p>Você clicou!</p>"
    document.body.style.backgroundColor = 'yellow'
}

function alertHello(){
    alert("Hello")
}

function semBotao(){
    document.getElementById("texto").innerHTML += "<p>Função chamada diretamente pelo código e não pelo botão</p>"
}

semBotao(); // Podemos chamar as funções diratamente pelo código, sem a necessidade de tocar no botão por exemplo

function paraCelsius(valorFahrenheit){
    return (5/9) * (valorFahrenheit - 32)
}

var x = paraCelsius(77);
document.getElementById("texto").innerHTML += `${x} ºC`



// OBJETOS
// Prática comum usar 'const' para determinar arrays

const carro = {
    marca: "Ford",
    modelo: "Ka",
    ano: 2015,        // Exemplo de objeto literal, quando o dev. determina os valores
    cor: "Branco",
    placa: "ABC-1234",
    buzina: function(){ // Método (propriedade que tem uma função)
        alert("Biiiiiiiiiiiiiiiiiiiii")
    },
    completo: function(){
        return `A marca é ${this.marca} e o modelo é: ${this["modelo"]}`
    } // 'this' significa "este", portanto nesse caso são as propriedades dessa variável, ou melhor, 'the propiets of THIS variable'
}
// Neste caso, marca, modelo, ano, cor e placa são as propriedades do objeto carro, e cada propriedade tem seu valor

document.getElementById("texto2").innerHTML = `<p>Eu tenho um ${carro.marca} ${carro.modelo} ${carro["ano"]} ${carro.cor}, a placa é ${carro["placa"]}</p>` // Duas maneiras de mostrar o valor do array

console.log(carro.completo()); // dentro do console (devTools)