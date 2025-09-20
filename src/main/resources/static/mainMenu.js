const jogarBtn = document.getElementById('jogar');
const criarBtn = document.getElementById('criar');


jogarBtn.addEventListener('click', function() {clickPlay("http://localhost:8080/joinMatchMenu")});
criarBtn.addEventListener('click', function() {clickPlay("http://localhost:8080/createMatch")});


function clickPlay(url) {
    window.location.href = url;
}

