const pessoa = ["Leonardo", "Chiarelli", 18, "macaco"]
const pessoa2 = ["Gabriela" , "Lettieri", 18, "macaca"]
const jogadores = ["Pelé", "Maradona", "CR7", "Cássio", "Fagner", "Garro"]

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