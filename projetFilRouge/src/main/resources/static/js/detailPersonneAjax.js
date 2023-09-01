window.onload=function(){
	getPersonne();
}

function getPersonne(){
	var urlParams = new URL(window.location.href).searchParams;
	var id = urlParams.get('id');
	console.log(id)
}