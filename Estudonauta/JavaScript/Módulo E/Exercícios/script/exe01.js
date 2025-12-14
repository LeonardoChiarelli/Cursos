function contar(){
    let inicio = document.querySelector('#iinicio')
    let fim = document.querySelector('#ifim')
    let passo = document.querySelector('#ipasso')
    let res = document.querySelector('#res')

    if(inicio.value.length == 0 || fim.value.length == 0 || passo.value.length == 0){
        res.innerHTML = 'Impossível contar!'
       // alert('[ERRO] Há valores faltando, verifique e tente novamente.')
    } else {
        res.innerHTML = 'Contando:'
        let i = Number(inicio.value)
        let f = Number(fim.value)
        let p = Number(passo.value)

        if(p <= 0){
            alert('Passo inválido! Considerando PASSO 1')
            p = 1
        }

        if(i < f){
            for(let c = i; c <= f; c += p){
                res.innerHTML += `${c} \u{1F449}`
            }
        } else{
            for(let c = i; c >= f; c -= p){
                res.innerHTML += `${c} \u{1F449}`
            }
        }
        res.innerHTML += `\u{1F3C1}`
    }
}