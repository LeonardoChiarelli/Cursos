function carregar(){
    let msg = document.querySelector('#msg')
    let img = document.querySelector('#img')
    let data = new Date()
    let hora = data.getHours()
    msg.innerHTML = `Agora são ${hora} horas<br>`

    if(hora >= 0 && hora < 12){
        msg.innerHTML += `<br>BOM DIA!`
        img.src = 'imagens/manha.png'
        document.body.style.background = '#C7AD68'
    } else if(hora >= 12 && hora < 19){
        msg.innerHTML += `<br>BOA TARDE!`
        img.src = 'imagens/tarde.png'
        document.body.style.background = '#CC9860'
    } else {
        msg.innerHTML += `<br>BOA NOITE!`
        img.src = 'imagens/noite.png'
        document.body.style.background = '#4C5747'
    }
}
