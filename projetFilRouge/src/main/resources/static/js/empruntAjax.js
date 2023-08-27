window.onload=function(){
	afficherTousLesEmprunts();
	(document.getElementById("addButton")).addEventListener("click",ajouterEmprunt);
	}
	

function afficherTousLesEmprunts(){	

let wsUrl = "./api-bibliotheque/emprunt";

makeAjaxGetRequest(wsUrl,function(responseJson){
	
	let empruntJs = JSON.parse(responseJson);
	
	let bodyElt = document.getElementById("tableBody");
	bodyElt.innerHTML="";
	for(let emprunt of empruntJs){
		let row = bodyElt.insertRow(-1);
		(row.insertCell(0)).innerHTML = emprunt.id;
		(row.insertCell(1)).innerHTML = emprunt.livreId;
		(row.insertCell(2)).innerHTML = emprunt.personneLastName;
		(row.insertCell(3)).innerHTML = emprunt.personneFirstName;
		(row.insertCell(4)).innerHTML = emprunt.dateDebut;
		(row.insertCell(5)).innerHTML = emprunt.dateFin;
	};
})
}	

/*function ajouterEmprunt() {
	
	let personneId = document.getElementById("inputIdPersonne").value
	let livreId = document.getElementById("inputIdLivre").value
	
	let emprunJs = 
	{ 
		
	}
	
	
	let wsUrl = "./api-bibliotheque/emprunt";
	
	
}*/