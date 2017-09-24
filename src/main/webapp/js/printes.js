/*

Author: Ruben Quadros
this will show the input fields required for the
customer(account number and how many last transactions)
when he presses the print e-statement button on
accounts page and it sends the info for validation

*/

//Function To Display Popup
function div_show_printes() {
	if(document.getElementById('abc_printes').style.display == "block"){
		document.getElementById('abc_printes').style.display = "none";
	}
	else {
		document.getElementById('abc_printes').style.display = "block";
	}
}
//Function to Hide Popup
function div_hide_printes(){
	document.getElementById('abc_printes').style.display = "none";
}

//Function to send filled data
function sendPrintes(){
	//$(document).ready(function () {

    //$("#test").submit(function (event) {

        //event.preventDefault();

        //var creditInfo = {}

        //creditInfo[""] = document.getElementById('acNo').value;

		//creditInfo[""] = document.getElementById('amount').value;

		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "http://172.19.5.96:8090/cubbank/customer/account/credit",
			data: JSON.stringify(creditInfo), // convert array to JSON
			dataType: 'json',
			cache: false,
			timeout: 100000,
			});
}

//Function to tell that customer wants to see 
//last month transaction details
function sendMonthly(){
	$(document).ready(function () {

    $("#test").submit(function (event) {

        event.preventDefault();

        //var creditInfo = {}

        //creditInfo[""] = document.getElementById('acNo').value;

		//creditInfo[""] = document.getElementById('amount').value;

		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "http://172.19.5.96:8090/cubbank/customer/account/credit",
			data: JSON.stringify(creditInfo), // convert array to JSON
			dataType: 'json',
			cache: false,
			timeout: 100000,
			});

    });

});
}