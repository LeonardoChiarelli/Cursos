let num = document.querySelector('#inum')
let tab = document.querySelector('#tab')
let res = document.querySelector('#res')
let dados = []

// verifica se número n é >= 1 e <= 100
function isNum(n) {
  if (Number(n) >= 1 && Number(n) <= 100) {
    return true
  } else {
    return false
  }
}

// verifica se lista l[] contém número n
function inList(n, l) {
  if (l.indexOf(Number(n)) != -1) {
    return true
  } else {
    return false
  }
}

// Adiciona num à dados[] se isNum retornar true & inList retornar false
function adicionar() {
  console.log("num.value = ", num.value);
  if (isNum(num.value) && !inList(num.value, dados)) {
    dados.push(Number(num.value))
    let item = document.createElement('option')
    item.text = `Valor ${num.value} adicionado a lista`
    tab.appendChild(item)
    // Chama função para atualizar o conteúdo da div res
    atualizarLista()
  } else {
    alert('Valor inválido ou já encontrado na lista, revise os dados e tente novamnete')
  }
  num.value = ''
  num.focus()
  console.log("vetor dados[] final = ", dados);
}

// Função para atualizar a lista na interface
function atualizarLista() {
  // Limpa a lista atual
  tab.innerHTML = ''
  // Adiciona cada item da lista dados como um novo elemento option
  dados.forEach(function(valor) {
    let item = document.createElement('option')
    item.text = `Valor ${valor} adicionado a lista`
    tab.appendChild(item)
  })
}

// valores -> dados
function finalizar() {
  if (dados.length == 0) {
    alert('Adicione valores antes de finalizar');
  } else {
    let total = dados.length;
    let maior = dados[0];
    let menor = dados[0];
    let soma = 0;
    let media = 0;

    for (let pos in dados) {
      soma += dados[pos];
      if (dados[pos] > maior) {
        maior = dados[pos];
      }
      if (dados[pos] < menor) {
        menor = dados[pos];
      }
    }
    media = soma / total;

    res.innerHTML = '';
    res.innerHTML += `<p>Ao todo temos ${total} números cadastrados</p>`;
    res.innerHTML += `<p>O maior valor informado é o ${maior} e o menor é o ${menor}</p>`;
    res.innerHTML += `<p>A soma dos valores informados é ${soma}</p>`;
    res.innerHTML += `<p>A média dos valores informados é ${media}</p>`;
  }
}