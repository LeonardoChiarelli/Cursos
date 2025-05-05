function tabuada(){
    let numero = document.querySelector('#inumero')
    let t = document.querySelector('#selTab')
    let res = document.querySelector('#res')
    
    if(numero.value.length == 0){
        alert('Revise os dados e tente novamente')
    } else {
        let n = Number(numero.value)
        t.innerHTML = ''

        for(let c = 1; c <=10; c++){
            let item = document.createElement('option')
            item.text = `${n} x ${c} = ${n*c}`
            item.value = `t${c}`
            t.appendChild(item)
        }
    }
}