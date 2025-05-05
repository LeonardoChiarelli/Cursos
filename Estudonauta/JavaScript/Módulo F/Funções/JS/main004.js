function fatorial(n){
    let fat = 1

    for(let c = n; c > 1; c--){
        fat *= c 
    }
    return `${n}! é = ${fat}`
}

console.log(fatorial(10))