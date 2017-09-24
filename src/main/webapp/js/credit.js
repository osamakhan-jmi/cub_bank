/*

Author: Ruben Quadros
this will show the input fileds required to the
customer(account number and money to be credited)
and also sends the filled fields

*/

//Function To Display Popup

function div_show_credit() {
	if(document.getElementById('abc_credit').style.display == "block"){
		document.getElementById('abc_credit').style.display = "none";
	}
	else {
		document.getElementById('abc_credit').style.display = "block";
	}
}

//Function to Hide Popup
function div_hide_credit(){
	document.getElementById('abc_credit').style.display = "none";
}

//Function to send credit info
function sendCredit(){
	//$(document).ready(function () {

   // $("#test").submit(function (event) {

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