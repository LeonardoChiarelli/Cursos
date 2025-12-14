function verificar(){
    let data = new Date()
    let ano = data.getFullYear()
    let fAno = document.querySelector('#iano')
    let res = document.querySelector('#res')

    if(Number(fAno.value) == 0 || Number(fAno.value) > ano){
        alert('[ERRO] Reveja os dados e tente novamente!')
    } else{
        let fSexo = document.getElementsByName('sexo')
        let idade = ano - Number(fAno.value)
        let genero = ''
        let img = document.createElement('img')
        img.setAttribute('id', 'foto')

        if(fSexo[0].checked){
            genero = 'Homem'
            if(idade >= 0 && idade < 12){
                // Criança
                img.setAttribute('src', 'imagens/bebe-M.png')
            } else if (idade >=12 && idade < 25){
                // Jovem
                img.setAttribute('src', 'imagens/jovem-M.png')
            } else if(idade >= 25 && idade < 65){
                // Adulto
                img.setAttribute('src', 'imagens/adulto-M.png')
            } else{
                // Idoso
                img.setAttribute('src', 'imagens/idoso-M.png')
            }
        } else if(fSexo[1].checked){ // 2º jeito de fazer o if
            genero = 'Mulher'
            if(idade >= 0 && idade < 12){
                // Criança
                img.setAttribute('src', 'imagens/bebe-F.png')
            } else if (idade < 25){
                // Jovem
                img.setAttribute('src', 'imagens/jovem-F.png')
            } else if(idade < 65){
                // Adulto
                img.setAttribute('src', 'imagens/adulto-F.png')
            } else{
                // Idoso
                img.setAttribute('src', 'imagens/idoso-F.png')
            }
        }

        res.style.textAlign = 'center'
        res.innerHTML = `Detectamos ${genero} de ${idade} anos<br>`
        res.appendChild(img)
    }
}