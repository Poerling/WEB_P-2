function burgerMenu() {
    var x = document.getElementById("navigation");
    if (x.className === "menu") {
        x.className += " responsive";
    } else {
        x.className = "menu";
    }
}
