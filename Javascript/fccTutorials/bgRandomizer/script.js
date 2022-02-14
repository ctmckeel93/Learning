console.log("Connected!!!")

let red,
    blue,
    green

const body = document.querySelector("body")
const bg = document.getElementById("bg")

const rng = Math.random
const floor = Math.floor

const changeBg = () => {
    setRandomRGB();
    color = `rgba(${red},${blue},${green})`
    bg.innerText=color
    body.style.backgroundColor = color
}

const setRandomRGB = () => {
    red = floor(rng() * 255)
    blue = floor(rng() * 255)
    green = floor(rng() * 255)
}