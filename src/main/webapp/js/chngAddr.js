/*

Author: Ruben Quadros
this will show the input fileds required to the
customer to change his address and also send the
new info back

*/

//Function To Display Popup
function div_show_addr() {
	if(document.getElementById('abc_addr').style.display == "block"){
		document.getElementById('abc_addr').style.display = "none";
	}
	else {
		document.getElementById('abc_addr').style.display = "block";
	}
}

//Function to Hide Popup
function div_hide_addr(){
	document.getElementById('abc_addr').style.display = "none";
}

//Function to send changed data
function sendAddr(){

	//$(document).ready(function () {

    //$("#test").submit(function (event) {

        //event.preventDefault();

        var creditInfo = {}

        addrInfo[""] = document.getElementById('street').value;

		addrInfo[""] = document.getElementById('city').value;

		addrInfo[""] = document.getElementById('state').value;

		addrInfo[""] = document.getElementById('country').value;

		addrInfo[""] = document.getElementById('pin').value;

		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "http://172.19.5.96:8090/cubbank/customer/account/credit",
			data: JSON.stringify(addrInfo), // convert array to JSON
			dataType: 'json',
			cache: false,
			timeout: 100000,
			});

}