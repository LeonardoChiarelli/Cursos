function num1(){
    let botao = document.getElementById("teste")

    for(let c=0; c<=9; c++){
        botao.innerHTML += `<br>${c}<br>`
    }
}