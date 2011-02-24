/**
 * 
 */
// Controlla al cambiamento dei vari campi per creare un nuovo utente se sono stati settati e
// in caso affermativo abilita il pulsante per il login
function checkAbleButton() {
	var username = document.getElementById("username").value;
	var email = document.getElementById("email").value;
	var pass = document.getElementById("password").value;
	var repass = document.getElementById("repassword").value;
	var nome = document.getElementById("nome").value;
	var cognome = document.getElementById("cognome").value;
	var eta = document.getElementById("eta").value;
	var creaAccount = document.getElementById("creaAccount");
	
	if (username != "" && email != "" && pass != "" && repass != ""
			&& nome != "" && cognome != "" && eta != "") {
		creaAccount.disabled = false;
	} else {
		creaAccount.disabled = true;
	}
}

function checkInstallButton() {
	//utente
	var username = document.getElementById("user").value;
	var pass = document.getElementById("pass").value;
	var repass = document.getElementById("repass").value;
	//mysql
	var host = document.getElementById("host").value;
	var port = document.getElementById("port").value;
	var userMySql = document.getElementById("userMySql").value;
	//var passMySql = document.getElementById("passMySql").value;
	//var repassMySql = document.getElementById("repassMySql").value;
	
	var procedi = document.getElementById("procedi");
	
	if (username != "" && pass != "" && repass != ""
			&& host != "" && port != "" && userMySql != ""
		) {
		procedi.disabled = false;
	} else {
		procedi.disabled = true;
	}
}


//attiva il tasto di modifica dei valori dell'account se sono stati inseriti tutti
function checkModButton(){
	var email = document.getElementById("email").value;
	var pass = document.getElementById("password").value;
	var repass = document.getElementById("repassword").value;
	var nome = document.getElementById("nome").value;
	var cognome = document.getElementById("cognome").value;
	var eta = document.getElementById("eta").value;
	var modAccount = document.getElementById("modificaAccount");
	
	if (username != "" && email != "" && pass != "" && repass != ""
			&& nome != "" && cognome != "" && eta != "") {
		modAccount.disabled = false;
	} else {
		modAccount.disabled = true;
	}
}
//Popola il menù dell'età al carimento del body
function popolaEta() {
	sEta = document.getElementById("eta");
	sEta.innerHTML = '';
	for ( var int = 5; int < 100; int++) {
		var oOption = sEta.appendChild(document.createElement("option"));
		oOption.value = int;
		oOption.innerHTML = int;
	}
}
