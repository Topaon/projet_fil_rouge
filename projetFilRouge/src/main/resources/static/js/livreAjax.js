window.onload=function(){
	afficherTousLesLivres();
	(document.getElementById("addButton"))
	   .addEventListener("click",ajouterLivre);
	(document.getElementById("updateButton"))
	   .addEventListener("click",modifierLivre);
	(document.getElementById("deleteButton"))
	   .addEventListener("click",supprimerLivre);
}

function afficherTousLesLivres(){	

let wsUrl = "./api-bibliotheque/livre";

makeAjaxGetRequest(wsUrl,function(responseJson){
	let LivresJs = JSON.parse(responseJson);
	
	let bodyElt = document.getElementById("tableBody");
	bodyElt.innerHTML="";
	for(let Livre of LivresJs){
		let row = bodyElt.insertRow(-1);
		(row.insertCell(0)).innerHTML = Livre.id;
		(row.insertCell(1)).innerHTML = Livre.titre;
		(row.insertCell(2)).innerHTML = Livre.auteur;
		(row.insertCell(3)).innerHTML = Livre.editeur;
		(row.insertCell(4)).innerHTML = Livre.dispo;
		(row.insertCell(5)).innerHTML = Livre.etat;
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
	console.log("Fonction modifier livre")
	let id = (document.getElementById("inputUpdateIdBookToUpdate")).value;	
	let titre = (document.getElementById("inputUpdateBookTitle")).value;
	let auteur = (document.getElementById("inputUpdateBookAutor")).value;
	let editeur = (document.getElementById("inputUpdateBookEditor")).value;
	let dispo = (document.getElementById("selectUpdateBookAvailable")).value;
	let etat = (document.getElementById("selectUpdateBookCondition")).value;
	console.log("Moisson terminée");
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
	console.log(LivreJson);
	makeAjaxPutRequest(url, LivreJson, function(responseJson) {
		afficherTousLesLivres()});
}

function supprimerLivre() {
	let id = document.getElementById("inputDeleteBookById").value;
	let deleteUrl = "./api-bibliotheque/livre/" + id;
	console.log(deleteUrl);
	makeAjaxDeleteRequest(deleteUrl, function(responseJson) {
		afficherTousLesLivres()});
}