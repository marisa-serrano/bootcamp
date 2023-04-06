let ajax;

if (window.XMLHttpRequest) {
	// Mozilla, Safari, IE7+ ...
	ajax = new XMLHttpRequest();

} else if (window.ActiveXObject) {
	// IE 6 and older
	ajax = new ActiveXObject("Microsoft.XMLHTTP");
}

// run this when the ajax request completes
ajax.onreadystatechange = function () {
	if (ajax.readyState === 4 && ajax.status === 200) {
		const customerJson = JSON.parse(ajax.responseText);
		console.log(customerJson);
		insertCustomerData(customerJson);
	}
};

ajax.open("GET", "http://localhost:8080/javabank5/api/customer", true);
ajax.send();

const usersTable = document.getElementById("users-table");

function insertCustomerData (customerData) {
	customerData.forEach((customer) => {
		const row = usersTable.insertRow(-1);

		insertPropertyData(customer.id, row);
		insertPropertyData(customer.firstName, row);
		insertPropertyData(customer.lastName, row);
		insertPropertyData(customer.email, row);
		insertPropertyData(customer.phone, row);
	});
};

function insertPropertyData (property, row) {
	const newData = document.createElement("td");
	const newContent = document.createTextNode(property);
	newData.appendChild(newContent);
	row.appendChild(newData);
};
