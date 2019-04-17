function responsiveMenu() {
    var a = document.getElementById("navigation");
    if (a.className === "menu") {
        a.className += " responsive";
    } else {
        a.className = "menu";
    }
}