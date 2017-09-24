/*

Author: Ruben Quadros
shows the transactions required by the admin in tables
when he presses report in employee page

http://www.mysamplecode.com/2012/04/generate-html-table-using-javascript.html



*/

var header = document.querySelector('header');

//var section = document.querySelector('section');
//var custID = document.getElementByid("username").value;

var userID = 'cs001';
vvar add1= '?customerID='
var url = 'http://172.19.5.96:8090/cubbank/customer/accounts/';
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
	for(){
		insertRow();

	}



}

function insertRow(){
	//////////check db/////////

	var myArticle = document.createElement('article');
	var myRow1 = document.createElement('td');
	var myRow2 = document.createElement('td');

	/* check the database architecture
	myRow1.textContent = 'Name: '+jsonObj.customerFname+ ' '+jsonObj.customerMname+' '+jsonObj.customerLname;

	myRow2.textContent = 'Cust Id: '+jsonObj.customerId+' Mobile Number:'+jsonObj.customerMobNo;*/

	myArticle.appendChild(myRow1);
	myArticle.appendChild(myRow2);
	header.appendChild(myArticle);

}
			