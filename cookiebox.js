function setzeCookie() {
    var datum = new Date();
    var jetzigeZeit = datum.getTime();
    var gueltigBis = jetzigeZeit + 86400;
    datum.setTime(gueltigBis);
    var EnddatumString = datum.toUTCString();
    document.cookie = "Minziro = set;expires=" + EnddatumString;
    document.getElementById("cookieHinweis").style.display = "none";
}