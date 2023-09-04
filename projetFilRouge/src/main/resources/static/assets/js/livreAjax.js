window.onload=function(){
	afficherTousLesLivres();
	(document.getElementById("btn_livre_search"))
	   .addEventListener("click",chercherLivre);
}


function afficherTousLesLivres(){	

let wsUrl = "http://localhost:8080/projetFilRouge/api-bibliotheque/livre";

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
		(row.insertCell(4)).innerHTML = Livre.dispo? "Oui" : "Non";
		(row.insertCell(5)).innerHTML = Livre.etat;
		if(Livre.dispo){
			(row.insertCell(6)).innerHTML = 
			"<button class='btn btn-success' onclick='emprunterLivre(" + Livre.id + ")'>Emprunter</button>"
			+ "<button class='btn btn-warning' onclick='reserverLivre()'>Réserver</button>";
		} else {
			(row.insertCell(6)).innerHTML = 
			"<button class='btn btn-warning' onclick='reserverLivre()'>Réserver</button>";
		}
	};
})
}	
	
//function ajouterLivre() {
//	let titre = (document.getElementById("inputAddBookTitle")).value;
//	let auteur = (document.getElementById("inputAddBookAutor")).value;
//	let editeur = (document.getElementById("inputAddBookEditor")).value;
//	let etat = (document.getElementById("selectAddBookCondition")).value;
//	
//	let LivreJs = {
//		id: null,
//		titre : titre,
//		auteur : auteur,
//		editeur : editeur,
//		dispo: true,
//		etat : etat,
//	};
//	
//	let LivreJson = JSON.stringify(LivreJs);
//	let url = "./api-bibliotheque/livre";
//	
//	makeAjaxPostRequest(url, LivreJson, function(responseJson) {
//		afficherTousLesLivres()});
//}

//function modifierLivre() {
//	let id = (document.getElementById("inputUpdateIdBookToUpdate")).value;	
//	let titre = (document.getElementById("inputUpdateBookTitle")).value;
//	let auteur = (document.getElementById("inputUpdateBookAutor")).value;
//	let editeur = (document.getElementById("inputUpdateBookEditor")).value;
//	let dispo = (document.getElementById("selectUpdateBookAvailable")).value;
//	let etat = (document.getElementById("selectUpdateBookCondition")).value;
//	let LivreJs = {
//		id: id,
//		titre : titre,
//		auteur : auteur,
//		editeur : editeur,
//		dispo : dispo,
//		etat : etat
//	};
//	
//	let LivreJson = JSON.stringify(LivreJs);
//	let url = "./api-bibliotheque/livre";
//	makeAjaxPutRequest(url, LivreJson, function(responseJson) {
//		afficherTousLesLivres()});
//}

//function supprimerLivre() {
//	let id = document.getElementById("inputDeleteBookById").value;
//	let deleteUrl = "./api-bibliotheque/livre/" + id;
//	makeAjaxDeleteRequest(deleteUrl, function(responseJson) {
//		afficherTousLesLivres()});
//}

function chercherLivre(){
	console.log("chercherLivre")
}

function emprunterLivre(lId){
	var urlParams = new URL(window.location.href).searchParams;
	var pId = urlParams.get('id');
	
	console.log(pId, lId)
	console.log(pId, Number(lId))
	
	ajouterEmprunt(pId, Number(lId))
}

function reserverLivre(){
	console.log("reserverLivre")
}