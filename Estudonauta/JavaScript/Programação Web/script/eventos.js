function clicar(){
    alert("Parabéns você clicou")
}

function clicar2(){
    document.body.style.backgroundColor = 'yellow'
}

function mouseOver(){
    document.getElementById("div").style.backgroundColor = 'green'
    document.getElementById("div").innerHTML = "mouse entrou!"
}

function mouseOut(){
    document.getElementById("div").style.backgroundColor = 'yellow'
    document.getElementById("div").innerHTML = "mouse saiu!"
}

function mouseMove(){
    let p = document.getElementById("texto");
    p.append('Mouse moveu')
    document.getElementById("div2").style.backgroundColor = 'purple'
}

function mouseDown(){
    document.getElementById("div3").style.backgroundColor = 'pink'
    document.getElementById("div3").innerHTML = "Agora solta"
}

function mouseUp(){
    let div = document.getElementById("div3");
    div.style.backgroundColor = 'white' // Outra maneira
    div.innerHTML = "Aperta de novo"
}

function limparTexto(){
    let campo = document.getElementById("campoTexto");
    campo.value = ''
    campo.style.backgroundColor = 'blue'
}

function voltarTexto(){
    let campo = document.querySelector("#campoTexto");
    campo.value = 'Texto voltou'
    campo.style.color = 'white'
    campo.style.backgroundColor = 'black'
}

function keyDown(){
    let campo = document.querySelector("#campoTexto").value
    console.log(campo)

}

function mudou(){
    console.log("mudou")
    document.getElementById("campoTexto").style.backgroundColor = 'white'
}