const num = [4, 3, 8, 9, 10, 6763]
num[6] = 9812 // desenvolvedor tem que informar a posição
num.push(32) // adiciona sempre à ultima posição
// num.length - para saber o comprimento do array
// num.sort() - o software vai colocar os números dentro do array em ordem crescente

console.log(`Nosso vetor é o ${num}`)
console.log(`O vetor tem ${num.length} posições`)
console.log(`O primeiro valor do vetor é ${num[0]} e o último é ${num[7]}`)
console.log(`O vetor em ordem crescente é ${num.sort()}`)

for(let pos = 0; pos < num.length; pos++){
    console.log(`A posição ${pos} tem o valor ${num[pos]}`)
}