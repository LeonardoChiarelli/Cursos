const lista = ["arroz","macarrão","feijão", "leite"] // Exemplo de array literal
lista[0] = "café" // modificar itens da matriz
lista.push("brigadeiro") // para adicionar algo ao final da matriz
lista[lista.length] = "bolo de cenoura" // outra maneira de adicionar coisas à matriz

document.getElementById("texto").innerHTML = `O primeiro item da <strong>lista</strong> é ${lista[0]}, já o último é ${lista[lista.length - 1]}` // para mostrar o ultimo item da matriz



const listinha = [] // Outra maneira de se fazer array
listinha[0] = "batata"
listinha[1] = "ovo"  
listinha[2] = "pão"
listinha[3] = "azeite"

document.getElementById("texto").innerHTML += `<p>O segundo item da <strong>listinha</strong> é ${listinha[1]} e o terceiro é ${listinha[2]} e nesta listinha existem ${listinha.length} itens` // array.length - para saber o comprimento do array



const listona = new Array("margarina", "pão de alho", "carne") // mais uma maneira de fazer um array

document.getElementById("texto").innerHTML += `<p>A <strong>listona</strong> completa é '${listona}' a conforme visto, ${listona[listona.length - 1]} é o ultimo item da matriz`



const pessoa = ["Leonardo", "Chiarelli", 18]
pessoa.push("estudante")

document.getElementById("texto").innerHTML += `Meu nome é ${pessoa[0]} e meu sobrenome é ${pessoa[1]}, eu tenho ${pessoa[2]} anos e sou ${pessoa[pessoa.length-1]}`

// Array.isArray(matriz) - para descobrir se o objeto é um array - se sim, irá retornar true
