window.onload=function(){
	loadLoan();
	(document.getElementById("btn_loan_page"))
	   .addEventListener("click",nouvelEmprunt);
}

var id = new URL(window.location.href).searchParams.get('id');

function nouvelEmprunt(){
	window.location.href = "http://localhost:8080/projetFilRouge/livre.html?id=" + id;
}

function loadLoan(){
	afficherTousLesEmpruntsParPersonId(id);
}