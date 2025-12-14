var hora = new Date().getHours()

document.getElementById("if").innerHTML = `Agora são ${hora} horas`

if(hora >= 5 && hora < 12){
    document.getElementById("if").innerHTML += `<p>BOM DIA</p>`
} else if(hora >= 12 && hora <= 18){
    document.getElementById("if").innerHTML += `<p>BOA TARDE<p>`
} else{
    document.getElementById("if").innerHTML += `<p>BOA NOITE<p>`
}

function verificaCor(){
    let cor = document.getElementById("cor").value
    cor = cor.toLowerCase()

    switch (cor){
        case 'vermelho':
            document.getElementById("conteudo").style.backgroundColor = 'red'
            break
        case 'verde':
            document.getElementById("conteudo").style.backgroundColor = 'green'
            break
        case 'azul':
            document.getElementById("conteudo").style.backgroundColor = 'blue'
            break
        default:
            alert('Cor inválida')
    }
}