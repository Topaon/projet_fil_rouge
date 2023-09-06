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
		(row.insertCell(4)).innerHTML = Livre.domaine;
		(row.insertCell(5)).innerHTML = Livre.dispo? "Oui" : "Non";
		(row.insertCell(6)).innerHTML = Livre.etat;
		if(Livre.dispo){
			(row.insertCell(7)).innerHTML = 
			"<button class='btn btn-success' onclick='emprunterLivre(" + Livre.id + ")'>Emprunter</button>"
			+ "<button class='btn btn-warning' onclick='reserverLivre()'>Réserver</button>";
		} else {
			(row.insertCell(7)).innerHTML = 
			"<button class='btn btn-warning' onclick='reserverLivre()'>Réserver</button>";
		}
	};
})
}

function chercherLivre(){
	var titre = $("#input_livre_search").val();
	
	let wsUrl = "http://localhost:8080/projetFilRouge/api-bibliotheque/livre/?titre=" + titre;

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
		(row.insertCell(4)).innerHTML = Livre.domaine;
		(row.insertCell(5)).innerHTML = Livre.dispo? "Oui" : "Non";
		(row.insertCell(6)).innerHTML = Livre.etat;
		if(Livre.dispo){
			(row.insertCell(7)).innerHTML = 
			"<button class='btn btn-success' onclick='emprunterLivre(" + Livre.id + ")'>Emprunter</button>"
			+ "<button class='btn btn-warning' onclick='reserverLivre()'>Réserver</button>";
		} else {
			(row.insertCell(7)).innerHTML = 
			"<button class='btn btn-warning' onclick='reserverLivre()'>Réserver</button>";
		}
	};
})
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