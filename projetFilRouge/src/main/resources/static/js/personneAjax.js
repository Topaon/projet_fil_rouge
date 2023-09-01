window.onload=function(){
	afficherTousLesPersonnes();
	(document.getElementById("btn_modifier"))
	   .addEventListener("click",modifierPersonne)
}

function afficherTousLesPersonnes(){	

let wsUrl = "./api-bibliotheque/personne"

makeAjaxGetRequest(wsUrl,function(responseJson){
	let PersonnesJs = JSON.parse(responseJson)
	
	let bodyElt = document.getElementById("tableBody")
	bodyElt.innerHTML=""
	for(let Personne of PersonnesJs){
		let row = bodyElt.insertRow(-1)
		(row.insertCell(0)).innerHTML = Personne.id
		(row.insertCell(1)).innerHTML = Personne.nom
		(row.insertCell(2)).innerHTML = Personne.prenom
		(row.insertCell(3)).innerHTML = Personne.email
		(row.insertCell(4)).innerHTML = Personne.adresse
	};
})
}

function ajouterPersonne() {
	let nom = (document.getElementById("inputAddPersonName")).value
	let prenom = (document.getElementById("inputAddPersonSurname")).value
	let email = (document.getElementById("inputAddPersonEmail")).value
	let adresse = (document.getElementById("inputAddPersonAdresse")).value
	
	let PersonneJs = {
		id: null,
		nom : nom,
		prenom : prenom,
		email : email,
		adresse : adresse
	};
	
	let PersonneJson = JSON.stringify(PersonneJs)
	let url = "./api-bibliotheque/personne"
	
	makeAjaxPostRequest(url, PersonneJson, function(responseJson) {
		afficherTousLesPersonnes()})
}

function modifierPersonne() {
//	let id = id
//	let nom = (document.getElementById("input_nom")).value
//	let prenom = (document.getElementById("input_prenom")).value
//	let email = (document.getElementById("input_email")).value
//	let adresse = (document.getElementById("input_adresse")).value
//	
//	let PersonneJs = {
//		id: id,
//		nom : nom,
//		prenom : prenom,
//		email : email,
//		adresse : adresse
//	};
//	
//	let PersonneJson = JSON.stringify(PersonneJs)
//	let url = "./api-bibliotheque/personne"
//	
//	makeAjaxPutRequest(url, PersonneJson, function(responseJson) {
//		majPage()})
}

function supprimerPersonne() {
	let id = document.getElementById("inputDeletePersonById").value
	let deleteUrl = "./api-bibliotheque/personne/" + id
	makeAjaxDeleteRequest(deleteUrl, function(responseJson) {
		afficherTousLesPersonnes()})
}

function majPage(){
	console.log("majPage")
}