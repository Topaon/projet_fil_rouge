window.onload=function(){
	afficherProfile();
	// (document.getElementById("btn_modifier"))
	//    .addEventListener("click",modifierPersonne)
}

function afficherProfile(){

	var urlParams = new URL(window.location.href).searchParams;
	var pId = urlParams.get('id');

	let wsUrl = "http://localhost:8080/projetFilRouge/api-bibliotheque/personne/" + pId;

	makeAjaxGetRequest(wsUrl,function(responseJson){
	let PersonnesJs = JSON.parse(responseJson)
	
	$("#profil_nom").html(PersonnesJs.nom);
	$("#profil_prenom").html(PersonnesJs.prenom);
	$("#profil_email").html(PersonnesJs.email);
	$("#profil_adresse").html(PersonnesJs.adresse);
	
	$("#input_nom").val(PersonnesJs.nom);
	$("#input_prenom").val(PersonnesJs.prenom);
	$("#input_email").val(PersonnesJs.email);
	$("#input_adresse").val(PersonnesJs.adresse);
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