fetchData();
let timer = 15;
let question = 1;



const interval = setInterval(function() {
    timer--;
    document.getElementById('timer').textContent = formatTime(timer);

    if (timer <= 0) {
        clearInterval(interval);
    }
}, 1000);

function formatTime(time) {
    let minutes = 0;
    if (time > 60) {
        minutes = time % 60;
    }
    time -= minutes * 60;
    let middleString = ":";
    if (time < 10) {
        middleString = ":" + "0"
    }
    let result;
    if (minutes > 10) {
        result = minutes.toString() + middleString + time.toString();
    } else {
        result = "0" + minutes.toString() + middleString + time.toString();
    }
    return result; // Optional: return a value
}

async function fetchData() {
    const url = '/api/q';
    try {
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        timer = 15 + data.extraTime;
        document.getElementById('textoquestao').textContent = data.statement;
        if (data.type = "1") {
            setQuestionSystem();
        }
        return JSON.stringify(data);
    } catch (error) {
        console.error('Error fetching data:', error);
    }
}

async function postAnswer() {
    const url = '/api/q/answer';
    method: 'POST'
    try {
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        timer = 15 + data.extraTime;
        document.getElementById('textoquestao').textContent = data.statement;
        if (data.type = "1") {
            setQuestionSystem();
        }
        return JSON.stringify(data);
    } catch (error) {
        console.error('Error fetching data:', error);
    }
}

async function setQuestionSystem() {
    const input = document.getElementById('input');

    input.innerHTML = '<textarea id="myTextArea" name="message" rows="5" cols="40" placeholder="Type your text here..."></textarea><br><br>';
    const button = document.getElementById('submit');

    button.addEventListener("click", function() {
        alert("Button clicked!");
    });
}