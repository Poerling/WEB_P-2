function setzeCookie(zaehler,zaehlerWert,ablaufTage) {
    var infoBox = document.getElementById("cookieHinweis");
    infoBox.style.display = "none";
    var jetzt = new Date();
    jetzt.setTime(jetzt.getTime() + (ablaufTage*24*60*60*1000));
    var laeuftAbAm = "expires=" + jetzt.toGMTString();
    document.cookie = zaehler + "=" + zaehlerWert + ";" + laeuftAbAm + ";path=/";
}

function ladeCookie(zaehler) {
    var name = zaehler + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function istCookieGesetzt() {
    var anzahlBesucht=ladeCookie("Zaehler");
    var infoBox = document.getElementById("cookieHinweis");
    if (anzahlBesucht=="") {
        infoBox.style.display = "flex";
    }
    else {
        anzahlBesucht=parseInt(anzahlBesucht)+1;
        setzeCookie("Zaehler", anzahlBesucht, 30);
    }
}
