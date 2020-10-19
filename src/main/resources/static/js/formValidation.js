let isSpeaker = document.querySelector("#isSpeaker");

isSpeaker.addEventListener('change', () => {
    let speakerGroup = document.querySelector('.speaker-group');
    if (isSpeaker.checked) {
        speakerGroup.classList.remove('not-visible');
    } else {
        speakerGroup.classList.add('not-visible');
    }
});

function getJsonData(){
    return {
        name: document.getElementById('name').value,
        lastName: document.getElementById('lastName').value,
        email: document.getElementById('email').value,
        phone: document.getElementById('phone').value,
        subdivision: document.getElementById('subdivision').value,
        speaker: document.getElementById('isSpeaker').checked,
        topicLecture: document.getElementById('topicLecture').value,
        descriptionLecture: document.getElementById('descriptionLecture').value,
    };
}

function validateEmail(email) {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

function validatePhone(phone) {
    const re = /\+7\(\d{3}\)\d{3}-\d{2}-\d{2}/;
    return re.test(String(phone).toLowerCase());
}

function validateJsonData(data){
    let errors = [];
    if('' === data.name){
        errors.push('Поле имя - обязательное');
    }
    if('' === data.email){
        errors.push('Поле email - обязательное');
    }
    if(!validateEmail(data.email)){
        errors.push('Поле email не соответствует содержимого типу email');
    }
    if('' === data.phone){
        errors.push('Поле телефон  - обязательное');
    }
    if(!validatePhone(data.phone)){
        errors.push('Поле телефон не соответствует содержимого типу телефон');
    }
    if('' === data.subdivision){
        errors.push('Поле подразделение  - обязательное');
    }
    if(data.speaker){
        if('' === data.topicLecture){
            errors.push('Поле тема доклада - обязательное');
        }
        if('' === data.topicLecture){
            errors.push('Поле краткое описание доклада - обязательное');
        }
    }

    return errors;
}

document.querySelector('#submit').addEventListener('click', () => {
    let jsonData = getJsonData();
    let errors = validateJsonData(jsonData);
    if(errors.length !== 0){
        alert(errors.join());
        return;
    }
    const url = "/clientapi/user/registration";
    fetch(url, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonData)
    }).then(
        response => response.text()
    ).then(
        response => {
            if(false === JSON.parse(response)){
                alert('Ошибка!!!');
            } else {
                alert('Спасибо, вы зарегистрированы на конференцию');
                setTimeout(() =>  window.location.href = "/", 1000);
            }
        }
    );
});