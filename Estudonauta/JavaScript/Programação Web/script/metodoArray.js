const pessoa = ["Leonardo", "Chiarelli", 18, "macaco"]
const pessoa2 = ["Gabriela" , "Lettieri", 18, "macaca"]
const jogadores = ["Pelé", "Maradona", "CR7", "Cássio", "Fagner", "Garro"]
const numeros = [8, 1, -91, 5, 75, 34]
const maior20 = numeros.filter(filtragem)

document.getElementById("texto").innerHTML = pessoa

function Join(){
    document.getElementById("texto").innerHTML = `${pessoa.join(" ** ")}`
}

function remove(){
    pessoa.pop();
    document.getElementById("texto").innerHTML = pessoa
}

function add(){
    pessoa.push("estudante")
    document.getElementById("texto").innerHTML = pessoa
}

function removeP(){
    pessoa.shift()
    document.getElementById("texto").innerHTML = pessoa
}

function addP(){
    pessoa.unshift("lindo");
    document.getElementById("texto").innerHTML = pessoa
}

function Splice(){
    pessoa.splice(1, 0, "Ribeiro")
    document.getElementById("texto").innerHTML = pessoa
}

function verGabi(){
    document.getElementById("texto").innerHTML = pessoa2
} function concatenar(){
   const pessoa3 = pessoa.concat(pessoa2)
   document.getElementById("texto").innerHTML = pessoa3
}

function mostrarJ(){
    document.getElementById("texto").innerHTML = jogadores
} function cortarJ(){
   const craques = jogadores.slice(3)
    document.getElementById("texto").innerHTML = craques
}

function ordem(){
    pessoa.sort()
    document.getElementById("texto").innerHTML = pessoa
} function desordem(){
    pessoa.sort()
    pessoa.reverse()
    document.getElementById("texto").innerHTML = pessoa
}

function mostrarNum(){
    document.getElementById("texto").innerHTML = numeros
} function ordemNum(){
    numeros.sort(function(a,b){return a - b})
    document.getElementById("texto").innerHTML = numeros.join(", ")
} function desordemNum(){
    numeros.sort(function(a,b){return b - a})
    document.getElementById("texto").innerHTML = numeros.join(", ")
}

function maiorNum(numeros){
    return Math.max.apply(null, numeros);
} function mostrarMN(){
    document.getElementById("texto").innerHTML = maiorNum(numeros)
}

function menorNum(numeros){
    return Math.min.apply(null, numeros);
} function mostrarMenorNum(){
    document.getElementById("texto").innerHTML = menorNum(numeros)
}

function filtragem(value, index, numeros){
    return value > 20
} function mostrar20(){
    document.getElementById("texto").innerHTML = maior20
}