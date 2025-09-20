const jogarBtn = document.getElementById('jogar');
const criarBtn = document.getElementById('criar');


jogarBtn.addEventListener('click', clickPlay("https://www.example.com/new-page.html"));
criarBtn.addEventListener('click', clickPlay("https://www.example.com/new-page.html"));


function clickPlay(url) {
    window.location.href = url;
}

