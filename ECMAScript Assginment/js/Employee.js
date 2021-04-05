
let Employee = {};

const error_msg = document.querySelector('#error-info');


const password = document.querySelector("input[name=password]");
password.addEventListener('input', () =>{
    const length = password.value.length;
    if(length<8){
        password.parentElement.style="border: 2px solid red";
    }else if(length>=8 && length<10){
        password.parentElement.style="border: 2px solid orange";
    }else{
        password.parentElement.style="border: 2px solid green";
    }
});

let error = input  => {
    input.classList.add('error');
}

let checkName = input => {
    if (input.value.length < 3) {
        error_msg.innerHTML = "Name should be greater than 2 letters."
        return false;
    } else {
        return true;
    }
}

let checkEmail = mail => {
    if (/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(mail.value)) {
        return true;
    }
    error_msg.innerHTML = "Email should be in correct form"
    return false;
}

let checkPassword = password => {
    const passw = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
    if (password.value.match(passw)) {
        return true;
    }
    else {
        error_msg.innerHTML = "Password must have Minimum eight characters, at least one letter, one number and one special character."
        return false;
    }
}

let confirmPassword = input => {
    if(input.value == Employee['password']){
        return true;
    }else{
        error_msg.innerHTML = "Password didn't match"
        return false;
    }
}

let checkContact = contact => {
    const phone = /[0-9]{8,}/;
    if(phone.test(contact.value)){
        return true;
    }else{
        error_msg.innerHTML = "Contact Number must have 10 digits"
        return false;
    }
}

let nextField = (parent, nextInput) => {
    parent.classList.add('inactive');
    parent.classList.remove('active');
    nextInput.classList.add('active');
}


let employeeForm = () => {

    const arrows = document.querySelectorAll(".fa-arrow-right");
    arrows.forEach(arrow => {
        arrow.addEventListener('click', () =>{
            error_msg.innerHTML = "";
            const input = arrow.previousElementSibling;
            const parent = arrow.parentElement;
            const nextInput = parent.nextElementSibling;
            const user_info = document.querySelector('#user-info');
            if(input.tagName == 'P'){
                parent.classList.add('inactive');
                parent.classList.remove('active');
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
            }else{
                error(parent);
            }
        });
    });

}

employeeForm();