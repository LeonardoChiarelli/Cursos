function num1(){
    let botao = document.getElementById("teste")
    document.getElementById("but").style.display = 'none'
    for(let c=0; c<=10; c++){
        botao.innerHTML += `${c}, `
    }
}
var ano = new Date().getFullYear() // terminação desses códigos sempre com () no final

for(let c = ano; c >= 1900; c--){
    document.getElementById("ano").innerHTML += `<option value='${c}'>${c}</option>`
}

function car(){
const carros = ["Corvette", "720lt", "SF90", "AMG GT Black Series", "Huracan STO", "Mustang", "M4 Competition"]
var tamanho = carros.length
document.getElementById("button").style.display = 'none'

for(let i = 0; i<tamanho; i++){
    document.getElementById("carro").innerHTML += `${carros[i]} - `
} 
}