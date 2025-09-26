const passwordfield = document.getElementById("passwordField");
const btn = document.getElementById("createBtn")

const dataToSend = {
  password: passwordfield.textContent
};

const url = '/api/match/createMatch'

let newMatchId;

btn.addEventListener('click', function () {
  fetch(url,
    {
      method: 'POST', headers:
        { "Content-Type": "application/json" },
      body: JSON.stringify(dataToSend)
    })
    .then(
      response => response.json()
    )
    .then(data => {
      newMatchId = data.matchId,
      window.location.href = "http://localhost:8080/match/"+newMatchId
    })
    .catch(
      error => console.error('Error:', error)
    );
});

