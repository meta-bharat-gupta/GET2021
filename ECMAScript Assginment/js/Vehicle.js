
let Vehicle = {};
const errormsg = document.querySelector('#error-info2');


let animatedForm = () => {

    const arrows = document.querySelectorAll(".fa-arrow-right");
    arrows.forEach(arrow => {
        arrow.addEventListener('click', () =>{
            errormsg.innerHTML = "";
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
            }else if(input.name == 'user_id' ){
                if(input.value != Employee['id']){
                    errormsg.innerHTML = "Registration Id is Invalid."
                }else{
                    Vehicle[input.name] = input.value;
                    nextField(parent, nextInput);
                }
            }else if(input.tagName == 'SELECT'){
                Vehicle[input.name] = input.value;
                const cycle = document.querySelector('.Cycle');
                const motor = document.querySelector('.Motorcycle');
                const car = document.querySelector('.Car')
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