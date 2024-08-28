function calculateFlames() {
    const name1 = document.getElementById('name1').value.trim();
    const name2 = document.getElementById('name2').value.trim();

    if (!name1 || !name2) {
        document.getElementById('result-message').innerText = "Please enter both names!";
        return;
    }

    // Convert names to arrays
    let sbName1 = [...name1.toLowerCase()];
    let sbName2 = [...name2.toLowerCase()];

    let len = sbName1.length + sbName2.length;

    for (let i = 0; i < sbName1.length; i++) {
        for (let j = 0; j < sbName2.length; j++) {
            if (sbName1[i] === sbName2[j]) {
                sbName1[i] = '*'; // mark as matched
                sbName2[j] = '*'; // mark as matched
                len -= 2;
                break;
            }
        }
    }

    let flames = "FLAMES";
    let sbFlames = [...flames];
    let index = 0;

    while (sbFlames.length > 1) {
        index = (index + len - 1) % sbFlames.length;
        sbFlames.splice(index, 1);
    }

    let result = sbFlames[0];
    displayResult(result);
}

function displayResult(result) {
    const resultMessage = document.getElementById('result-message');
    const name1 = document.getElementById('name1').value.trim();
    const name2 = document.getElementById('name2').value.trim();

    let message = "";
    switch(result) {
        case 'F':
            message = `${name1} and ${name2} are friends`;
            break;
        case 'L':
            message = `${name1} and ${name2} are lovers`;
            break;
        case 'A':
            message = `${name1} has affection on ${name2}`;
            break;
        case 'M':
            message = `${name1} and ${name2} will marry`;
            break;
        case 'E':
            message = `${name1} and ${name2} are enemies`;
            break;
        case 'S':
            message = `${name1} and ${name2} are sister/brother`;
            break;
    }

    resultMessage.innerText = message;
}
