const valores = [1 , 5, 9, 10, 32, 29]

for(let pos in valores){
    console.log(`A posição ${pos} tem o valor ${valores[pos]}`)
}

console.log(`O valor 9 está na posição ${valores.indexOf(9)}`)
console.log(`O valor 12 não existe portando o software irá retornar ${valores.indexOf(12)} ao procurar dentro do array: valores`)


const values = [0, 1, 2, 3, 4 ,5]
let position = values.indexOf(6)

if(position == -1){
    console.log(`O valor desejado não foi encontrado`)
} else{
    console.log(`O valor está na posição ${position}`)
}
// sintaxe válida apenas para vetores

// valores.indexOf('valor dentro do array') - para buscar valores; caso retorne -1 siginifica que o valor procurado não existe