const btn = document.getElementById("join");
const nameField = document.getElementById("nameField");
const idField = document.getElementById("idField");
const passwordField = document.getElementById("passwordField");

const dataToSend = {
  playerName: nameField.textContent,
  id: idField.textContent,
  password: passwordfield.textContent
};

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