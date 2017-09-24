/*
Author: Ruben Quadros

input field to input transaction password when clicked on
TRANSFER FUNDS in accounts page

PUT SEND FUNCTION IN THIS ONLY
function check_empty_tpass() {
	if (document.getElementById('tpass').value == "") {
		alert("Fill All Fields !");
	} 
	else {
		//document.getElementById('chg_addr').submit();
		onSubmit.alert("Form Submitted Successfully");	
	}
}*/
//Function To Display Popup
function div_show_tpass() {
	if(document.getElementById('abc_tpass').style.display == "block"){
		document.getElementById('abc_tpass').style.display = "none";
	}
	else {
		document.getElementById('abc_tpass').style.display = "block";
	}
}
//Function to Hide Popup
function div_hide_tpass(){
	document.getElementById('abc_tpass').style.display = "none";
}

function sendTpass(){
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