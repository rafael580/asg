const url = window.location.href;

function loginRequest(username,password) {

	let url_api = `${url}/usurious/${username}/${password}`;

	$.ajax({
		type: "GET",
		url: url_api,
	}).done(function(data) {
		if (data) {

			var objeto = JSON.stringify(data);
			localStorage.setItem('UserDetails', objeto);
			window.location.href = "Dashboard/Index";
		} else {
			showErr()
		}
	})
}

function login() {

	var inputUsername = document.getElementById("emailId").value.trim();
	var inputPassword = document.getElementById("password").value.trim();

	if (inputUsername.length <= 0 || inputPassword.length <= 0) {
		showErr();
	}
	else{
		loginRequest(inputUsername,inputPassword);
	}
}

function showErr() {
	var divErr =  document.querySelector("#errorMessage")
	divErr.style.display = 'block'
}
