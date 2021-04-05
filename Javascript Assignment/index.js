
var Employee = {};
var Vehicle = {};
var error_msg = document.querySelector('#error-info');


var password = document.querySelector("input[name=password]");
password.addEventListener('input', () =>{
    var length = password.value.length;
    if(length<8){
        password.parentElement.style="border: 2px solid red";
    }else if(length>=8 && length<10){
        password.parentElement.style="border: 2px solid orange";
    }else{
        password.parentElement.style="border: 2px solid green";
    }
});


function error(input){
    input.classList.add('error');
}

function checkName(input) {
    if (input.value.length < 3) {
        error_msg.innerHTML = "Name should be greater than 3 letters."
        return false;
    } else {
        return true;
    }
}

function checkEmail(mail) {
    if (/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(mail.value)) {
        return true;
    }
    error_msg.innerHTML = "Email should be in correct form"
    return false;
}

function checkPassword(password) {
    var passw = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
    if (password.value.match(passw)) {
        return true;
    }
    else {
        error_msg.innerHTML = "Password must have Minimum eight characters, at least one letter, one number and one special character."
        return false;
    }
}

function confirmPassword(input){
    if(input.value == Employee['password']){
        return true;
    }else{
        error_msg.innerHTML = "Password didn't match"
        return false;
    }
}

function checkContact(contact){
    var phone = /[0-9]{8,}/;
    if(phone.test(contact.value)){
        return true;
    }else{
        error_msg.innerHTML = "Contact Number must have 10 digits"
        return false;
    }
}

function nextField(parent, nextInput){
    parent.classList.add('inactive');
    parent.classList.remove('active');
    nextInput.classList.add('active');
}


function displayPlan() {
    var selectedCurrency = document.querySelector('#currency');
    var currencySymbols = document.querySelectorAll('.currency-symbol');
    currencySymbols.forEach(symbol => {
        if(selectedCurrency.value == 'usd'){
            symbol.innerHTML = "$"
        }
        if(selectedCurrency.value == 'yen'){
            symbol.innerHTML = "¥"
        }
    });

}


function animatedForm(){

    var arrows = document.querySelectorAll(".fa-arrow-right");
    arrows.forEach(arrow => {
        arrow.addEventListener('click', () =>{
            error_msg.innerHTML = "";
            var input = arrow.previousElementSibling;
            var parent = arrow.parentElement;
            var nextInput = parent.nextElementSibling;
            console.log(input.tagName)
            var user_info = document.querySelector('#user-info');
            if(input.tagName == 'P'){
                parent.classList.add('inactive');
                parent.classList.remove('active');
                // var content = document.querySelector('.content');
                // content.style = "";
                // document.getElementById("empForm").submit();
                Employee['id'] = Employee["name"] + Math.floor(Math.random() * 10);
                user_info.innerText = `Your Registration Id is ${Employee['id']}`;
                
                return;
            }else if(input.name == "name" && checkName(input)){
                Employee[input.name] = input.value;
                user_info.innerHTML = `Hey ${Employee['name']}, Can I get your Gender.`;
                nextField(parent, nextInput);
            }else if(input.name == "gender"){
                user_info.innerHTML = `Hey ${Employee['name']}, Can I get your Email.`;
                Employee[input.name] = input.value;
                nextField(parent, nextInput);   
            }else if(input.name == "email" && checkEmail(input)){
                user_info.innerHTML = `Hey ${Employee['name']}, Please set your password.`;
                Employee[input.name] = input.value;
                nextField(parent, nextInput);
            }else if(input.name == "password" && checkPassword(input)){
                user_info.innerHTML = `Hey ${Employee['name']}, Confirm your password.`;
                Employee[input.name] = input.value;
                nextField(parent, nextInput);
            }else if(input.name == "confirm" && confirmPassword(input)){
                user_info.innerHTML = `Hey ${Employee['name']}, Can I get your Number.`;
                Employee[input.name] = input.value;
                nextField(parent, nextInput);
            }else if(input.name == "contact" && checkContact(input)){
                nextField(parent, nextInput);
            }else if(input.name == 'user_id' ){
                if(input.value != Employee['id']){
                    document.querySelector('#error-info2').innerHTML = "Registration Id is Invalid."
                }else{
                    Vehicle[input.name] = input.value;
                    nextField(parent, nextInput);
                }
            }else if(input.tagName == 'SELECT'){
                Vehicle[input.name] = input.value;
                var cycle = document.querySelector('.Cycle');
                var motor = document.querySelector('.Motorcycle');
                var car = document.querySelector('.Car')
                switch(input.value){
                    case "Cycle":
                        motor.style = "display: none;";
                        car.style = "display:none;";
                        break;
                    case "Motor Cycle":
                        cycle.style = "display:none;";
                        car.style = "display: none;";
                        break;
                    case "Four Wheeler":
                        cycle.style = "display: none;";
                        motor.style = "display: none;";
                }
                nextField(parent, nextInput);
            }else if((input.name == "vehicleName" || input.name == "vehicleNumber" || input.tagName == 'TEXTAREA') && input.value.length>0){
                Vehicle[input.name] = input.value;    
                nextField(parent, nextInput);
            }
            else{
                error(parent);
            }
            console.log(Vehicle);
        });
    });

}


animatedForm();