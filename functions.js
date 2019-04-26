function onload() {
    var neu = "<ul>\n" +
        "    <li class=\"burger\">\n" +
        "        <a href=\"#\" onclick=\"responsiveMenu()\">\n" +
        "            <div class=\"burgericon\"></div>\n" +
        "            <div class=\"burgericon\"></div>\n" +
        "            <div class=\"burgericon\"></div>\n" +
        "        </a>\n" +
        "    </li>\n" +
        "\n" +
        "    <li><a href=\"main.html\">Home</a></li>\n" +
        "    <!-- Navigationsmenü - Dropdown -->\n" +
        "    <!-- javascript:void(0) -->\n" +
        "    <li class=\"dropdown\">\n" +
        "        <a href=\"ueberUns.html\" class=\"dropbtn\">Über uns</a>\n" +
        "        <div class=\"dropdown-inhalt\">\n" +
        "            <a href=\"satzung.html\">Satzung</a>\n" +
        "            <a href=\"unserVorstand.html\">Unser Vorstand</a>\n" +
        "        </div>\n" +
        "    </li>\n" +
        "    <li class=\"dropdown\">\n" +
        "        <a href=\"wirHelfen.html\" class=\"dropbtn\">Wir helfen</a>\n" +
        "        <div class=\"dropdown-inhalt\">\n" +
        "            <a href=\"spenden.html\">Spenden</a>\n" +
        "        </div>\n" +
        "    </li>\n" +
        "    <li><a href=\"ueberMinziro.html\">Über Minziro</a></li>\n" +
        "    <li><a href=\"aktuelles.html\">Aktuelles</a></li>\n" +
        "    <li class=\"dropdown\">\n" +
        "        <a href=\"projekte.html\" class=\"dropbtn\">Projekte</a>\n" +
        "        <div class=\"dropdown-inhalt\">\n" +
        "            <a href=\"ProjektSchulbibliothek.html\">Projekt Schulbibliothek</a>\n" +
        "        </div>\n" +
        "    </li>\n" +
        "    <li class=\"dropdown\">\n" +
        "        <a href=\"kontakt.html\" class=\"dropbtn\">Kontakt</a>\n" +
        "        <div class=\"dropdown-inhalt\">\n" +
        "            <a href=\"socialmedia.html\">Social Media</a>\n" +
        "            <a href=\"impressum.html\">Impressum</a>\n" +
        "            <a href=\"datenschutz.html\">Datenschutz</a>\n" +
        "        </div>\n" +
        "    </li>\n" +
        "    <li><a href=\"bildergalerie.html\">Bildergalerie</a></li>\n" +
        "    <li><a href=\"MitgliedWerden.html\">Mitglied werden</a></li>\n" +
        "</ul>"
    document.getElementById("navigation").innerHTML = neu;
    istCookieGesetzt()
}
function responsiveMenu() {
    var a = document.getElementById("navigation");
    if (a.className === "menu") {
        a.className += " responsive";
    } else {
        a.className = "menu";
    }
}