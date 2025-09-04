let timer = 10;

while(timer > 1) {
    setTimeout(function() {
      timer--;
      document.getElementById('timer').textContent = timer;
    }, 1000); // 3000 milliseconds = 3 seconds
}

    document.getElementById('yourId')