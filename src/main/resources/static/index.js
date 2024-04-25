function kjopBillett() {
    const film = $("#film").val();
    const antallBilletter = $("#antallBilletter").val();
    const navn = $("#navn").val();
    const telefonnr = $("#telefonnr").val();
    const epost = $("#epost").val();

    //Inputvalidering for hvert valg.
    if (film === ("Velg film her")) {
        alert("Velg en film!")
        return;
    }

    if (isNaN(antallBilletter) || antallBilletter === ("")) {
        alert("Oppgi antall billetter du ønsker å kjøpe!")
        return;
    }

    if (navn === ("")) {
        alert("Oppgi navnet ditt!")
        return;
    }

    // 8 siffer for telefonnr
    let telefonnrReq = /^\d{8}$/;
    if (telefonnr === "" || !telefonnrReq.test(telefonnr)) {
        alert("Oppgi et gyldig telefonnummer!")
        return;
    }

    let epostReq = /^\w+@([\w-]+\.)+[\w-]+$/;
    if (epost === "" || !epostReq.test(epost)) {
        alert("Oppgi en gyldig e-postadresse!")
        return;
    }

    const etKjop = {
        film : film,
        antallBilletter : antallBilletter,
        navn : navn,
        telefonnr : telefonnr,
        epost : epost
    };
    $.post("/lagre", etKjop, function () {
        hentBilletter();
    });
    $("#film").val("");
    $("#antallBilletter").val("");
    $("#navn").val("");
    $("#telefonnr").val("");
    $("#epost").val("");
}

function hentBilletter() {
    $.get("/hentBilletter", function (data) {
        formaterData(data);
    });
}

function slettBilletter() {
    $.get("/slettBilletter", function () {
        hentBilletter()
    })
}

function slettBillett(id) {
    const url = "slettBillett?id=" + id;
    $.ajax({
        url: url,
        type: 'DELETE',
        success: function(result) {
            hentBilletter();
        }
    });
}

function formaterData(billetter) {
    let ut = "<table><tr>" +
        "<th>Film</th><th>Billetter</th><th>Navn</th>" +
        "<th>Telefonnr</th><th>Epost</th><th>Valg</th></tr>";
    for (const i of billetter) {
        ut += "<tr><td>" + i.film + "</td><td>" + i.antallBilletter + "</td><td>" + i.navn + "</td>" +
            "<td>" + i.telefonnr + "</td><td>" + i.epost + "</td><td> <a class='btn btn-primary'\n" +
            "href='endre.html?id=" + i.id + " '>Endre</a> <br> <button class='btn btn-danger' " +
            "onclick='slettBillett(" + i.id + ")'>Slett</button></td></tr>";
    }
    ut+="</table>";
    $("#billettArray").html(ut);
}

$(function() {
    const id = window.location.search.substring(1);
    const url = "/hentBillett"+id;
    $.get(url, function(billett) {
        $("#billettId").val(billett.id);
        $("#film").val(billett.film);
        $("#antallBilletter").val(billett.antallBilletter);
        $("#navn").val(billett.navn);
        $("#telefonnr").val(billett.telefonnr);
        $("#epost").val(billett.epost);
        $("#name-tag").text(billett.navn);
        $("#billet-id").text(billett.id);
    });
});

function endreBillett() {
    const billett = {
        id: $("#billettId").val(),
        film: $("#film").val(),
        antallBilletter: $("#antallBilletter").val(),
        navn: $("#navn").val(),
        telefonnr: $("#telefonnr").val(),
        epost: $("#epost").val()
    }
    $.ajax({
        url: "/endreBillett",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(billett),
        success: function () {
            window.location.href = "/index.html";
        }
    });
}

window.addEventListener("load", hentBilletter);




