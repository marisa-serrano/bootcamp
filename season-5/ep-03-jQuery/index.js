$(document).ready(function () {
	getCustomers();
	waitForClicks();
	deleteCustomer();
});

function getCustomers() {
	let customerData;

	$.ajax({
		url: "http://localhost:8080/javabank5/api/customer",
		dataType: "json",
		data: customerData,
		async: true,
		success: insertCustomerData,
	});
}

function insertCustomerData(customerData) {
	const usersTable = $("#users-table");
	$("td").remove();

	customerData.forEach((customer) => {
		const row = $("<tr>");

		insertPropertyData(customer.id, row);
		insertPropertyData(customer.firstName, row);
		insertPropertyData(customer.lastName, row);
		insertPropertyData(customer.email, row);
		insertPropertyData(customer.phone, row);
		addButton(row, customer.id, "Edit", "success");
		addDeleteButton(row, customer.id);

		row.appendTo(usersTable);
	});
	editCustomer();
}

function insertPropertyData(property, row) {
	const data = $('<td class="align-middle">');
	data.text(property);
	data.appendTo(row);
}

function addButton(row, id, message, color) {
	const cell = $("<td>");
	cell.addClass("m-1");

	const button = $(`<button type="button">${message}</button>`);
	button.addClass(
		`btn btn-${color} bg-${color} ${id} ${message.toLowerCase()}-customer`
	);

	console.log(id);

	button.attr("id", "edit_" + `${id}`);

	button.appendTo(cell);
	cell.appendTo(row);
}

function addDeleteButton(row, id) {
	const cell = $("<td>");
	cell.addClass("m-1");

	const button = $(`<button type="button">Delete</button>`);
	button.addClass(`btn btn-danger bg-danger delete-customer ${id}`);

	button.appendTo(cell);
	cell.appendTo(row);
}

function waitForClicks() {
	$("#add-button").click(function () {
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/javabank5/api/customer/",
			async: true,
			contentType: "application/json",
			data: JSON.stringify(getFormData()),
			success: function () {
				alert("Success!");
				getCustomers();
			},
		});
	});

	function getFormData() {
		const customer = {
			firstName: $("#firstNameInput").val(),
			lastName: $("#lastNameInput").val(),
			email: $("#emailInput").val(),
			phone: $("#phoneInput").val(),
		};
		return customer;
	}
}

function editCustomer() {

	$(".edit-customer").click(function () {
		const id = $(this).attr("class").split(" ")[3];
		console.log(id);

		let jsonCustomer;


		$.ajax({
			url: `http://localhost:8080/javabank5/api/customer/${id}`,
			async: true,
			dataType: 'text',
			data: jsonCustomer,
			success: function (jsonData) {
				const customer = JSON.parse(jsonData);

				$("#firstNameInput").val(customer.firstName);
				$("#lastNameInput").val(customer.lastName);
				$("#emailInput").val(customer.email);
				$("#phoneInput").val(customer.phone);
			},
		});
	});
}

function deleteCustomer() {
	$(".delete-customer").click(function () {
		console.log("delete");
	});
}
