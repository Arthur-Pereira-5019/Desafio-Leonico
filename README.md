# Desafio Leônico

### Status: In the works

This is an web game I started to develop for practicing my web related skills: HTML, CSS, Js and Spring Boot, but also biology that is one of my weak spots in school.

The main idea it is being an kahoot-like biology multiplayer game that could be used in schools for biology tests.

# How it will work

### Explaining from the Back to the Front.

It works by reading from the DB a list of random questions sorted and choosed by hardness and biology study field (Zoology, genetics, ) at the time, which the Backend makes it even more random by replacing possible "wildcards" in the question statements, those questions are then associated with a Match object, that contains data about the players, their scores and the questions, these Match data is then retrieved by the front end of the players logged in that match, that will use it to assemble the scoreboard and the question display.
