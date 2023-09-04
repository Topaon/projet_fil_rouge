window.onload=function(){
	adminLoadLoan();
	afficherProfile();
	(document.getElementById("btn_loan_page"))
	   .addEventListener("click",nouvelEmprunt);
}

var id = new URL(window.location.href).searchParams.get('id');

function nouvelEmprunt(){
	window.location.href = "http://localhost:8080/projetFilRouge/admin/livre.html?id=" + id;
}

function adminLoadLoan(){
	adminAfficherTousLesEmpruntsParPersonId(id);
}

function rendreEmprunt(id){
	retournerEmprunt(id);
}