window.onload=function(){
	afficherTousLesPersonnes();
	(document.getElementById("addButton"))
	   .addEventListener("click",ajouterPersonne);
	(document.getElementById("deleteButton"))
	   .addEventListener("click",supprimerPersonne);
	(document.getElementById("updateButton"))
	   .addEventListener("click",modifierPersonne);
}

function afficherTousLesPersonnes(){	

let wsUrl = "./api-bibliotheque/personne";

makeAjaxGetRequest(wsUrl,function(responseJson){
	let PersonnesJs = JSON.parse(responseJson);
	
	let bodyElt = document.getElementById("tableBody");
	bodyElt.innerHTML="";
	for(let Personne of PersonnesJs){
		let row = bodyElt.insertRow(-1);
		(row.insertCell(0)).innerHTML = Personne.id;
		(row.insertCell(1)).innerHTML = Personne.nom;
		(row.insertCell(2)).innerHTML = Personne.prenom;
		(row.insertCell(3)).innerHTML = Personne.email;
		(row.insertCell(4)).innerHTML = Personne.adresse;
	};
})
}

function ajouterPersonne() {
	let nom = (document.getElementById("inputAddPersonName")).value;
	let prenom = (document.getElementById("inputAddPersonSurname")).value;
	let email = (document.getElementById("inputAddPersonEmail")).value;
	let adresse = (document.getElementById("inputAddPersonAdresse")).value;
	
	let PersonneJs = {
		id: null,
		nom : nom,
		prenom : prenom,
		email : email,
		adresse : adresse
	};
	
	let PersonneJson = JSON.stringify(PersonneJs);
	let url = "./api-bibliotheque/personne";
	
	makeAjaxPostRequest(url, PersonneJson, function(responseJson) {
		afficherTousLesPersonnes()});
}

function modifierPersonne() {
	let id = (document.getElementById("inputUpdateIdPersonToUpdate")).value;	
	let nom = (document.getElementById("inputUpdatePersonName")).value;
	let prenom = (document.getElementById("inputUpdatePersonSurname")).value;
	let email = (document.getElementById("inputUpdatePersonEmail")).value;
	let adresse = (document.getElementById("inputUpdatePersonAdresse")).value;
	
	let PersonneJs = {
		id: id,
		nom : nom,
		prenom : prenom,
		email : email,
		adresse : adresse
	};
	
	let PersonneJson = JSON.stringify(PersonneJs);
	let url = "./api-bibliotheque/personne";
	
	makeAjaxPutRequest(url, PersonneJson, function(responseJson) {
		afficherTousLesPersonnes()});
}

function supprimerPersonne() {
	let id = document.getElementById("inputDeletePersonById").value;
	let deleteUrl = "./api-bibliotheque/personne/" + id;
	makeAjaxDeleteRequest(deleteUrl, function(responseJson) {
		afficherTousLesPersonnes()});
}