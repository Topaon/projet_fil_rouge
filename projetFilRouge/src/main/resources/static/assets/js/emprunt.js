window.onload=function(){
	loadLoan();
}

var id = new URL(window.location.href).searchParams.get('id');

function loadLoan(){
	afficherTousLesEmpruntsParPersonId(id);
}