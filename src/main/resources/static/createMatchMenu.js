const passwordfield = document.getElementById("passwordField");
const btn = document.getElementById("createBtn")

const dataToSend = {
  password: passwordfield.textContent
};

btn.addEventListener('click', function() {
    fetch('url')
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

