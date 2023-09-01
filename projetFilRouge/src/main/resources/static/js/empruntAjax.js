window.onload = function() {
	afficherTousLesEmprunts();
}


function afficherTousLesEmprunts() {

	let wsUrl = "./api-bibliotheque/emprunt";

	makeAjaxGetRequest(wsUrl, function(xhrResponseText) {

		let empruntJs = JSON.parse(xhrResponseText);

		let bodyElt = document.getElementById("tableBody");
		bodyElt.innerHTML = "";
		for (let emprunt of empruntJs) {
			let row = bodyElt.insertRow(-1);
			(row.insertCell(0)).innerHTML = emprunt.id;
			(row.insertCell(1)).innerHTML = emprunt.livreId;
			(row.insertCell(2)).innerHTML = emprunt.personneLastName;
			(row.insertCell(3)).innerHTML = emprunt.personneFirstName;
			(row.insertCell(4)).innerHTML = emprunt.dateDebut;
			(row.insertCell(5)).innerHTML = emprunt.dateFin;
			(row.insertCell(6)).innerHTML = emprunt.enCours;
		};
	})
}

function ajouterEmprunt() {

	let personneId = document.getElementById("inputIdPersonne").value
	let livreId = document.getElementById("inputIdLivre").value

	let wsUrl = "./api-bibliotheque/emprunt/emprunter?personneId=" + personneId + "&livreId=" + livreId;

	makeAjaxGetRequest(wsUrl, function() {
		afficherTousLesEmprunts()
	})
}

function prolongerEmprunt() {

	let empruntId = document.getElementById("inputIdEmpruntProlonger").value

	let wsUrl = "./api-bibliotheque/emprunt/prolonger?empruntId=" + empruntId;

	makeAjaxGetRequest(wsUrl, function() {
		afficherTousLesEmprunts()
	})
}

function retournerEmprunt() {

	let empruntId = document.getElementById("inputIdEmpruntRetourner").value

	let wsUrl = "./api-bibliotheque/emprunt/retourner?empruntId=" + empruntId;

	makeAjaxGetRequest(wsUrl, function() {
		afficherTousLesEmprunts()
	})
}