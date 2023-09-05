function nouvelIncident() {

	let wsUrl = "http://localhost:8080/projetFilRouge/api-bibliotheque/incident";

	var urlParams = new URL(window.location.href).searchParams;
	var idEmprunt = urlParams.get('idEmprunt');

	var incident = {
		"id" : idEmprunt, 
		"typeIncident" : $("#input_type_incident").val(),
		"nouvelEtat" : $("#input_nouvel_etat").val(),
		"description" : $("#input_description").val(),
	};

	makeAjaxPostRequest(wsUrl, JSON.stringify(incident), function(xhrResponseText) {

		console.log(xhrResponseText);

	})
}