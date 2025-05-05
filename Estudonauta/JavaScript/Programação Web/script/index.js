// MANEIRAS DE IMPRESSÃO NA TELA
document.getElementById("texto").innerHTML = "Primeiro ensinamento de saída no <strong>JS</strong>"
// alert(10 + 5)
console.log("Olá desenvolvedor");
// FIM DAS MANEIRAS


// INÍCIO DAS VARIÁVEIS 
var pote = "Bombom"
// alert(pote);


// Delcaração das variáveis
var nome, sobrenome, nomeCompleto, idade

// Atribuição de valores
nome = "Leonardo"
sobrenome = "Chiarelli"
nomeCompleto = nome + " " + sobrenome // pode ser feito com `${nome} ${sobrenome}`
idade = 18

// Impressão na tela
document.querySelector("#texto1").innerHTML = `Meu nome completo é ${nomeCompleto} e eu tenho ${idade} anos`

// DIFERENÇA DE LET, VAR E CONST

let permitirRedeclaraçao = false // variável "única", não permite redeclaração - mais seguro - obedece o escopo
var permiteRedeclaraçao = true // variável que permite redelcarações conforme o código roda
const podeMudar = false // const significa 'constante', ou seja, não pode mudar


// OPERADOR DE ATRIBUIÇÃO

var valor1, valor2, total

valor1 = 5
valor2 = 2

valor1 += valor2 // mesma coisa que 'valor1 = valor1 + valor2'
valor2 -= valor1 // mesma coisa que 'valor2 = valor2 - valor1'

total = valor1 + valor2
document.getElementById("texto2").innerHTML = total

var num1, num2, Total

num1 = 10
num2 = 5

num1 *= num2 // mesma coisa que 'num1 = num1 * num2'
num2 /= num1 // mesma coisa que 'num2 = num2 / num 1'

Total = num1 + num2

document.getElementById("texto2").innerHTML += ` /// ${Total}`


// OPERADOR TERNÁRIO - condição dada à uma variável no momento da declaração

var idade, eleitor
idade = 18
eleitor = (idade<=16) ? "Não pode votar" : "Pode votar" // (condição) ? 'true' : 'false'

document.getElementById("texto2").innerHTML += `<p>${eleitor}</p>`

// !(codição) - significa que tudo dentro do parênteses é "ao contrário"