/*

Author: Ruben Quadros
this will give the input fields required to the 
customer(account number and money) and sends the
filled data 

*/

//Function To Display Popup
function div_show_debit() {
	if(document.getElementById('abc_debit').style.display == "block"){
		document.getElementById('abc_debit').style.display = "none";
	}
	else {
		document.getElementById('abc_debit').style.display = "block";
	}
}

//Function to Hide Popup
function div_hide_debit(){
	document.getElementById('abc_debit').style.display = "none";
}

//Function to send the data
function sendDebit(){
	//$(document).ready(function () {

    //$("#test").submit(function (event) {

       // event.preventDefault();

        var creditInfo = {}

        debitInfo[""] = document.getElementById('acNo').value;

		debitInfo[""] = document.getElementById('amount').value;

		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "http://172.19.5.96:8090/cubbank/customer/account/debit",
			data: JSON.stringify(debitInfo), // convert array to JSON
			dataType: 'json',
			cache: false,
			timeout: 100000,
			});
}