let timer = 10;

const interval = setInterval(function() {
  timer--;
  document.getElementById('timer').textContent = timer.toString();

  if (timer <= 0) {
    clearInterval(interval);
  }
}, 1000);