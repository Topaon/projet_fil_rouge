window.onload=function(){
	afficherToutesLesPersonnes();
}

function afficherToutesLesPersonnes(){	

let wsUrl = "./api-bibliotheque/personne"

makeAjaxGetRequest(wsUrl,function(responseJson){
	let PersonnesJs = JSON.parse(responseJson);
	
	let bodyElt = document.getElementById("tableBody");
	bodyElt.innerHTML="";
	for(let Personne of PersonnesJs){
		var row = document.createElement("tr");
		row.id = Personne.id
		row.innerHTML = 
			"<td>" + Personne.id + "</td>" +
			"<td>" + Personne.nom + "</td>" +
			"<td>" + Personne.prenom + "</td>" +
			"<td>" + Personne.email + "</td>" +
			"<td>" + Personne.adresse + "</td>";
		row.setAttribute("onclick", "detailPersonne('" + Personne.id + "')")
		bodyElt.appendChild(row);
	};
})
}

function ajouterLivre() {
	let titre = (document.getElementById("inputAddBookTitle")).value;
	let auteur = (document.getElementById("inputAddBookAutor")).value;
	let editeur = (document.getElementById("inputAddBookEditor")).value;
	let etat = (document.getElementById("selectAddBookCondition")).value;
	
	let LivreJs = {
		id: null,
		titre : titre,
		auteur : auteur,
		editeur : editeur,
		dispo: true,
		etat : etat,
	};
	
	let LivreJson = JSON.stringify(LivreJs);
	let url = "./api-bibliotheque/livre";
	
	makeAjaxPostRequest(url, LivreJson, function(responseJson) {
		afficherTousLesLivres()});
}

function modifierLivre() {
	let id = (document.getElementById("inputUpdateIdBookToUpdate")).value;	
	let titre = (document.getElementById("inputUpdateBookTitle")).value;
	let auteur = (document.getElementById("inputUpdateBookAutor")).value;
	let editeur = (document.getElementById("inputUpdateBookEditor")).value;
	let dispo = (document.getElementById("selectUpdateBookAvailable")).value;
	let etat = (document.getElementById("selectUpdateBookCondition")).value;
	let LivreJs = {
		id: id,
		titre : titre,
		auteur : auteur,
		editeur : editeur,
		dispo : dispo,
		etat : etat
	};
	
	let LivreJson = JSON.stringify(LivreJs);
	let url = "./api-bibliotheque/livre";
	makeAjaxPutRequest(url, LivreJson, function(responseJson) {
		afficherTousLesLivres()});
}

function supprimerLivre() {
	let id = document.getElementById("inputDeleteBookById").value;
	let deleteUrl = "./api-bibliotheque/livre/" + id;
	makeAjaxDeleteRequest(deleteUrl, function(responseJson) {
		afficherTousLesLivres()});
}

function detailPersonne(text){
	window.location.href = "http://localhost:8080/projetFilRouge/detailPersonne.html?id=" + text
}