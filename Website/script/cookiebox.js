function setzeCookie(MinziroZaehler,zaehlerWert,ablaufTage) {
    var infoBox = document.getElementById("cookieHinweis");
    infoBox.style.display = "none";

    var jetzt = new Date();
    jetzt.setTime(jetzt.getTime() + (ablaufTage*24*60*60*1000));
    var laeuftAbAm = "expires=" + jetzt.toGMTString();
    document.cookie = MinziroZaehler + "=" + zaehlerWert + ";" + laeuftAbAm + ";path=/";
}

function ladeCookie(zaehler) {
    var name = zaehler + "=";
    var decodedCookies = decodeURIComponent(document.cookie);
    var cookies = decodedCookies.split(';');
    for(var i = 0; i < cookies.length; i++) {
        var temp = cookies[i];
        if (temp.indexOf(name) == 0) {
            return temp.substring(name.length, temp.length);
        }
    }
    return "";
}

function istCookieGesetzt() {
    var anzahlBesucht=ladeCookie("Minziro-Zaehler");
    var infoBox = document.getElementById("cookieHinweis");
    if (anzahlBesucht=="") {
        infoBox.style.display = "block";
    }
    else {
        anzahlBesucht=parseInt(anzahlBesucht)+1;
        setzeCookie("Minziro-Zaehler", anzahlBesucht, 30);
    }
}
