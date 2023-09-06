window.onload=function(){
	afficherTousLesPersonnes();
	(document.getElementById("btn_lecteur_search"))
	   .addEventListener("click",chercherLecteur);
}

function afficherTousLesPersonnes(){	

	let wsUrl = "http://localhost:8080/projetFilRouge/api-bibliotheque/personne"
	
	makeAjaxGetRequest(wsUrl,function(responseJson){
		let PersonnesJs = JSON.parse(responseJson)
		
		let bodyElt = document.getElementById("tableBody")
		bodyElt.innerHTML=""
		for(let Personne of PersonnesJs){
		var row = document.createElement("tr");
		row.id = Personne.id
		row.innerHTML = 
			"<td>" + Personne.id + "</td>" +
			"<td>" + Personne.nom + "</td>" +
			"<td>" + Personne.prenom + "</td>" +
			"<td>" + Personne.email + "</td>";
		row.setAttribute("onclick", "detailPersonne('" + Personne.id + "')")
		bodyElt.appendChild(row);
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

function detailPersonne(text){
	window.location.href = "http://localhost:8080/projetFilRouge/admin/profil-detail.html?id=" + text
}

function chercherLecteur(){
	var nom = $("#input_lecteur_nom").val();
	
	console.log(nom);
	
	let wsUrl = "http://localhost:8080/projetFilRouge/api-bibliotheque/personne/?name=" + nom;
	
	console.log(wsUrl);
	
	makeAjaxGetRequest(wsUrl,function(responseJson){
		let PersonnesJs = JSON.parse(responseJson)
		
		let bodyElt = document.getElementById("tableBody")
		bodyElt.innerHTML=""
		for(let Personne of PersonnesJs){
		var row = document.createElement("tr");
		row.id = Personne.id
		row.innerHTML = 
			"<td>" + Personne.id + "</td>" +
			"<td>" + Personne.nom + "</td>" +
			"<td>" + Personne.prenom + "</td>" +
			"<td>" + Personne.email + "</td>";
		row.setAttribute("onclick", "detailPersonne('" + Personne.id + "')")
		bodyElt.appendChild(row);
	};
	})
}