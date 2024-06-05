let agora = new Date()
let hora = agora.getHours()

console.log(`São exatamente ${hora} horas`)
if(hora >= 0 && hora < 6){
    console.log('Boa Madrugada!')
} else if(hora >=6 && hora < 12){
    console.log('Bom dia!')
} else if(hora >= 12 && hora < 19){
    console.log('Boa tarde!')
} else{
    console.log('Boa noite!')
}