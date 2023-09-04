function afficherTousLesEmprunts() {

	let wsUrl = "http://localhost:8080/projetFilRouge/api-bibliotheque/emprunt";

	makeAjaxGetRequest(wsUrl, function(xhrResponseText) {

		let empruntJs = JSON.parse(xhrResponseText);

		let bodyElt = document.getElementById("tableBody");
		bodyElt.innerHTML = "";
		for (let emprunt of empruntJs) {
			let row = bodyElt.insertRow(-1);
			(row.insertCell(0)).innerHTML = emprunt.id;
			(row.insertCell(1)).innerHTML = emprunt.dateDebut;
			(row.insertCell(2)).innerHTML = emprunt.dateFin;
			(row.insertCell(3)).innerHTML = emprunt.livreId;
			(row.insertCell(4)).innerHTML = emprunt.titre;
		};
	})
}

function afficherTousLesEmpruntsParPersonId(id) {
	let wsUrl = "http://localhost:8080/projetFilRouge/api-bibliotheque/emprunt/personne?personneId=" + id;

	makeAjaxGetRequest(wsUrl, function(xhrResponseText) {

		let empruntJs = JSON.parse(xhrResponseText);

		let bodyElt = document.getElementById("tableBody");
		bodyElt.innerHTML = "";
		for (let emprunt of empruntJs) {
			console.log(emprunt)
			let row = bodyElt.insertRow(-1);
			(row.insertCell(0)).innerHTML = emprunt.id;
			(row.insertCell(1)).innerHTML = emprunt.dateDebut;
			(row.insertCell(2)).innerHTML = emprunt.dateFin;
			(row.insertCell(3)).innerHTML = emprunt.livreId;
			(row.insertCell(4)).innerHTML = emprunt.titre;
			(row.insertCell(5)).innerHTML = emprunt.type;
		};
	})
}

function adminAfficherTousLesEmpruntsParPersonId(id) {

	let wsUrl = "http://localhost:8080/projetFilRouge/api-bibliotheque/emprunt/personne?personneId=" + id;

	makeAjaxGetRequest(wsUrl, function(xhrResponseText) {

		let empruntJs = JSON.parse(xhrResponseText);

		let bodyElt = document.getElementById("tableBody");
		bodyElt.innerHTML = "";
		for (let emprunt of empruntJs) {
			let row = bodyElt.insertRow(-1);
			(row.insertCell(0)).innerHTML = emprunt.id;
			(row.insertCell(1)).innerHTML = emprunt.dateDebut;
			(row.insertCell(2)).innerHTML = emprunt.dateFin;
			(row.insertCell(3)).innerHTML = emprunt.livreId;
			(row.insertCell(4)).innerHTML = emprunt.titre;
			(row.insertCell(5)).innerHTML = "<button class='btn btn-success' onclick='rendreEmprunt(" + emprunt.id + ")'>Rendre</button>" +
											"<button class='btn btn-warning' onclick='prolongerEmprunt(" + emprunt.id + ")'>Prolonger</button>"
		};
	})
}

function ajouterEmprunt(pId, lId) {

	let personneId = pId
	let livreId = lId

	let wsUrl = "http://localhost:8080/projetFilRouge/api-bibliotheque/emprunt/emprunter?personneId=" + personneId + "&livreId=" + livreId;
	
	console.log("emprunt")
	
	makeAjaxGetRequest(
		wsUrl,
		function(xhrResponseText) {
			afficherTousLesLivres()
			let xhrResponseTextJs = JSON.parse(xhrResponseText);
			console.log("C'est un succès")
			console.log(xhrResponseTextJs)
		}, function(xhrResponseTextErr) {
			let errCallback = JSON.parse(xhrResponseTextErr);
			console.log("C'est une erreur")
			console.log(errCallback)
		})
}

function prolongerEmprunt(id) {
	let wsUrl = "http://localhost:8080/projetFilRouge/api-bibliotheque/emprunt/prolonger?empruntId=" + id;

	makeAjaxGetRequest(
		wsUrl,
		function(xhrResponseText) {
			adminLoadLoan()
		}
	)
}

function retournerEmprunt(id) {

	let wsUrl = "http://localhost:8080/projetFilRouge/api-bibliotheque/emprunt/retourner?empruntId=" + id;

	makeAjaxGetRequest(
		wsUrl,
		function() {
			adminLoadLoan();
		},
		function(xhrResponseTextErr) {
			let errCallback = JSON.parse(xhrResponseTextErr);
			console.log(errCallback)
		})
}