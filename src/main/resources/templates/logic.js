let timer = 1;
let question = 0;
let pontuation = 1;
let storedId = 0;
let answeredTimes = 0;


fetchQuestion();
addButtonListener();



const interval = setInterval(function () {
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
    return result;
}

async function fetchQuestion() {
    console.log("Fetched")
    question++;
    const url = window.location.origin + '/api/q';
    try {
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        storedId = data.id;
        timer = 15 + data.extraTime;
    document.getElementById('questao').textContent = "Questão: " + question;
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
    answeredTimes++;
    const url = window.location.origin + '/api/q/answer';
    const input = document.getElementById('aInput');
    const data = {
        id: storedId,
        answer: input.value,
        remainingTime: timer,
        triedTimes: answeredTimes
    };

    try {
        const response = await fetch(
            url, 
            { method: 'POST', headers: 
                { "Content-Type": "application/json" }, 
            body: JSON.stringify(data) });
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const result = await response.json();
        pontuation += result.points;
        document.getElementById('point').textContent = "Pontuação: " + pontuation;
        if (result.won) {
            triedTimes = 0;
            fetchQuestion();
        }

    } catch (error) {
        console.error('Error fetching data:', error);
    }
}

async function setQuestionSystem() {
    const input = document.getElementById('input');

    input.innerHTML = '<textarea id="aInput" name="message" rows="5" cols="40" placeholder="Type your text here..."></textarea><br><br>';
}

function addButtonListener() {
    const button = document.getElementById('submit');

button.addEventListener("click", async function () {
    await postAnswer();
});
}