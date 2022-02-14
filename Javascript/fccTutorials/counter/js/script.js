console.log("Connected to js");

const counter = document.getElementById("counter");
const buttons = document.querySelectorAll("button");

const count = (e) => {
    // console.log(e.target.innerText)
    switch (e.target.innerText) {
        case "Increase":
        counter.innerText++;
        if (counter.innerText >= 0){
            counter.style.color = "aquamarine";
        }
        break;
        case "Decrease":
        counter.innerText--;
        if (counter.innerText < 0){
            counter.style.color = "red";
        }
        break;
        default:
        counter.innerText = 0;
        counter.style.color = "aquamarine";
    }
    console.log("counting...")
};

buttons.forEach((button) => {
    button.addEventListener("click", count, true);
});
