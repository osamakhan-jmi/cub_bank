/*

Author: Ruben Quadros
this will give the input fields to add beneficiaries
(beneficiary account number and beneficiary name)
also it will send the filled data

*/

//Function To Display Popup

function div_show_ben() {
	if(document.getElementById('abc_ben').style.display == "block"){
		document.getElementById('abc_ben').style.display = "none";
	}
	else {
		document.getElementById('abc_ben').style.display = "block";
	}
}

//Function to Hide Popup

function div_hide_ben(){
	document.getElementById('abc_ben').style.display = "none";
}

//Function to send data

function sendBen(){
	//$(document).ready(function () {

    //$("#test").submit(function (event) {

        //event.preventDefault();

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