import getDados from "./getDados.js";

const btnSortear = document.querySelector('.btn-sortear');
const fichaDescricao = document.getElementById('ficha-descricao');

function carregarInfoSerie() {
  getDados(`/series/frases`)
      .then(data => {
        fichaDescricao.innerHTML = `
              <img src="${data.poster}" alt="${data.title}" />
              <div>
                  <h2>${data.title}</h2>
                  <div class="descricao-texto">
                      <p><i>"${data.phrase}"</i></p>
                      <p><b>Citado por:</b> ${data.character}</p>
                  </div>
              </div>
          `;
      })
      .catch(error => {
          console.error('Erro ao obter informações da série:', error);
      });
}


window.onload = carregarInfoSerie();
btnSortear.addEventListener('click', carregarInfoSerie);