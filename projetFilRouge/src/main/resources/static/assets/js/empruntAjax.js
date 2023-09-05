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
		console.log(empruntJs);
		for (let emprunt of empruntJs) {
			let row = bodyElt.insertRow(-1);
			(row.insertCell(0)).innerHTML = emprunt.id;
			(row.insertCell(1)).innerHTML = emprunt.dateDebut;
			(row.insertCell(2)).innerHTML = emprunt.dateFin;
			(row.insertCell(3)).innerHTML = emprunt.livreId;
			(row.insertCell(4)).innerHTML = emprunt.titre;
			(row.insertCell(5)).innerHTML = "<button class='btn btn-success' onclick='rendreEmprunt(" + emprunt.id + ")'>Rendre</button>" +
											"<button class='btn btn-warning' onclick='prolongerEmprunt(" + emprunt.id + ")'>Prolonger</button>" +
											"<button class='btn btn-danger' onclick='declarerIncident(" + emprunt.id + ")'>Incident</button>"
		};
	})
}

function ajouterEmpruntSauvegarde(pId, lId) {

	let personneId = pId
	let livreId = lId

	let wsUrl = "http://localhost:8080/projetFilRouge/api-bibliotheque/emprunt/emprunter?personneId=" + personneId + "&livreId=" + livreId;
	
	makeAjaxGetRequest(
		wsUrl,
		function(xhrResponseText) {
			afficherTousLesLivres()
			console.log("C'est un succès")
			console.log(xhrResponseText)
		}, function(xhrResponseTextErr) {
			alert("Nombre maximum d'emprunt simultané atteint");
		})
}

function ajouterEmprunt(pId, lId) {

	let emprunt = {
		livreId : lId,
		personneId : pId
	}

	let wsUrl = "http://localhost:8080/projetFilRouge/api-bibliotheque/emprunt/emprunter";
	
	makeAjaxPostRequest(
		wsUrl,
		JSON.stringify(emprunt),
		function(xhrResponseText) {
			afficherTousLesLivres()
			console.log("C'est un succès")
			console.log(xhrResponseText)
		}, function(xhrResponseTextErr) {
			alert("Nombre maximum d'emprunt simultané atteint");
		})
}

function prolongerEmprunt(id) {
	let wsUrl = "http://localhost:8080/projetFilRouge/api-bibliotheque/emprunt/prolonger?empruntId=" + id;

	makeAjaxPutRequestWithoutBody(
		wsUrl,
		function(xhrResponseText) {
			adminLoadLoan()
		}
	)
}

function retournerEmprunt(id) {

	let wsUrl = "http://localhost:8080/projetFilRouge/api-bibliotheque/emprunt/retourner?empruntId=" + id;

	makeAjaxDeleteRequest(
		wsUrl,
		function() {
			adminLoadLoan();
		},
		function(xhrResponseTextErr) {
			let errCallback = JSON.parse(xhrResponseTextErr);
			console.log(errCallback)
		})
}

function declarerIncident(id) {
	window.location.href = "http://localhost:8080/projetFilRouge/admin/incident.html?idEmprunt=" + id
}