
const coll = document.querySelectorAll(".collapsible");
console.log(coll)

    coll.forEach(element => {
        element.addEventListener("click", () => {
            element.classList.toggle("activate");
            const content = element.nextElementSibling;
            if (content.style.maxHeight) {
                content.style.maxHeight = null;
            } else {
                content.style.maxHeight = eval(content.scrollHeight + 50) + "px";
            }
        });
    });
