/*

Author: Ruben Quadros
this prints all the statements required by the customer when 
he presses the print e-statement button on accounts page
this script runs on printes page

http://www.mysamplecode.com/2012/04/generate-html-table-using-javascript.html

*/
var table = document.querySelector('table');

//var section = document.querySelector('section');
//var custID = document.getElementByid("username").value;
var userID = localStorage.getItem("name");
alert(userID);
//var userID = 'cs001';
var add1= '?customerID='
var url = 'http://172.19.5.96:8090/cubbank/transaction/';
var requestURL = url+add1+userID;
var request = new XMLHttpRequest();
request.open('GET', requestURL);
request.responseType = 'text';
request.send();
request.onload = function() {
	var benInfoText = request.response;
	var benInfo = JSON.parse(benInfoText);
	//populateHeader(superHeroes);
	showInfo((benInfo));
}

function showInfo(jsonObj) {

	///////////THIS IS DYNAMIC////////////////////
	for(var i=0;i<jsonObj.length;i++){
		insertRow();

	}

}

function insertRow(){
	//////////check db/////////

	//var myArticle = document.createElement('article');
	var myRow = document.createElement('tr');
	var myData1 = document.createElement('td');
	var myData2 = document.createElement('td');
	var myData3 = document.createElement('td');
	var myData4 = document.createElement('td');
	var myData5 = document.createElement('td');
	var myData6 = document.createElement('td');
	var myData7 = document.createElement('td');


	//check the database architecture
	myData1.textContent = 'Name: '+jsonObj.customerFname+ ' '+jsonObj.customerMname+' '+jsonObj.customerLname;

	myData2.textContent = 'Cust Id: '+jsonObj.customerId+' Mobile Number:'+jsonObj.customerMobNo;

	myData3.textContent = 'Cust Id: '+jsonObj.customerId+' Mobile Number:'+jsonObj.customerMobNo;

	myData4.textContent = 'Cust Id: '+jsonObj.customerId+' Mobile Number:'+jsonObj.customerMobNo;

	myData5.textContent = 'Cust Id: '+jsonObj.customerId+' Mobile Number:'+jsonObj.customerMobNo;

	myData6.textContent = 'Cust Id: '+jsonObj.customerId+' Mobile Number:'+jsonObj.customerMobNo;

	myData7.textContent = 'Cust Id: '+jsonObj.customerId+' Mobile Number:'+jsonObj.customerMobNo;

	myRow.appendChild(myData1);
	myRow.appendChild(myData2);
	myRow.appendChild(myData3);
	myRow.appendChild(myData4);
	myRow.appendChild(myData5);
	myRow.appendChild(myData6);
	myRow.appendChild(myData7);
	table.appendChild(myRow);

}