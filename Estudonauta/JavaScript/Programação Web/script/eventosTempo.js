function startTimeout(){
    document.getElementById("teste1").innerHTML = "Começou a contar!"
    tempo = setTimeout(function(){
        document.getElementById("teste1").innerHTML = "Executou o setTimeout"
        document.body.style.backgroundColor = 'green'
    }, 5000) // cada 1000 milessegundos = 1 segundo
}

function stopTimeout(){
    clearTimeout(tempo) // parâmetro para parar a contagem
    document.getElementById("teste1").innerHTML = "Contagem parada!"
}

function startInterval(){
    intervalo = setInterval(function(){
        var cronometro = document.getElementById("teste2").innerHTML
        var soma = Number(cronometro) +1 // transformar a string em número
        document.getElementById("teste2").innerHTML = soma
    }, 1000)
}

function stopInterval(){
    clearInterval(intervalo)
}