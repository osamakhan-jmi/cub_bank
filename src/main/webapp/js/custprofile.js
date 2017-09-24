/*

Author: Ruben Quadros
this will display all the customer 
personal details on accounts page

*/

var header = document.querySelector('header');
localStorage.removeItem("name");
var userID = sessionStorage.getItem("name");
alert(userID);
//var userID = 'cs001';
var url = 'http://172.19.5.96:8090/cubbank/customer/';
var requestURL = url+userID;
var request = new XMLHttpRequest();
request.open('GET', requestURL);
request.responseType = 'text';
request.send();
request.onload = function() {
	var custInfoText = request.response;
	var custInfo = JSON.parse(custInfoText);
	//populateHeader(superHeroes);
	showInfo((custInfo));
}
			
function showInfo(jsonObj) {
	//alert(jsonObj[0].customerMobNo);
	var myArticle = document.createElement('article');
	//var myH2 = document.createElement('h2');
	var myPara1 = document.createElement('p');
	var myPara2 = document.createElement('p');
	var myPara3 = document.createElement('p');
	var myPara4 = document.createElement('p');
	//var myPara5 = document.createElement('p');
	//var myList = document.createElement('ul');
	//myH2.textContent = heroes[i].name;
				
	//for ( var i = 0; i<jsonObj.length ; i++) {
	myPara1.textContent = 'Name: '+jsonObj.customerFname+ ' '+jsonObj.customerMname+' '+jsonObj.customerLname;
						
	myPara2.textContent = 'Cust Id: '+jsonObj.customerId+' Mobile Number:'+jsonObj.customerMobNo;
		
	myPara3.textContent = 'DOB: '+jsonObj.customerDob+' Email: '+jsonObj.customerEmail;
				
	myPara4.textContent = 'Address: '+jsonObj.customerStreet+' '+jsonObj.customerCity+' '+jsonObj.customerState+' '+jsonObj.customerCountry+' '+jsonObj.customerPostalPin;
				

	//myPara1.textContent = 'Cust Id: '+jsonObj[0].customerId;
	//break;
	//myPara5.textContent = jsonObj['accountActivationDate'];
			
	//myArticle.appendChild(myH2);
	myArticle.appendChild(myPara1);
	myArticle.appendChild(myPara2);
	myArticle.appendChild(myPara3);
	myArticle.appendChild(myPara4);
	//myArticle.appendChild(myList);
	header.appendChild(myArticle);
 }
   