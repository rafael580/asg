const url = window.location.href;

let userDetails;

$(function() {
	$("#customerForm").submit(function(event) {
		event.preventDefault();

		userDetails = {
			"firstName": $("#firstName").val().trim(),
			"lastName": $("#lastName").val().trim(),
			"emailId": $("#emailId").val().trim(),
			"passcode": $("#passcode").val().trim(),
			"contactNumber": $("#contactNumber").val().trim(),
		}

		const url_api = `${url}/novo`;

		$.ajax({
			type: "POST",
			url: url_api,
			data: JSON.stringify(userDetails),
			contentType: "application/json",

		}).done(function(result) {

			if (result) {
				window.location.href = "../Dashboard/Index";
			} else {
				console.log("Deu errado, objeto veio nulo");
			}
		});
		return false
	});

});