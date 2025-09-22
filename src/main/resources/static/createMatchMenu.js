const passwordfield = document.getElementById("passwordField");
const btn = document.getElementById("createBtn")

const dataToSend = {
  password: passwordfield.textContent;
};

const url = '/api/match/createMatch'

btn.addEventListener('click', function() {
    fetch( url,
                      { method: 'POST', headers:
                          { "Content-Type": "application/json" },
                      body: JSON.stringify(dataToSend) })
      .then(
        response => response.json()
    )
      .then(
        data => alert(data)
    )
      .catch(
        error => console.error('Error:', error)
    );
});

