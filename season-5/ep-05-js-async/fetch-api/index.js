$(document).ready(function () {
	searchUsers();
});

function searchUsers() {
	$("#search-btn").click(function getUsers() {
		console.log("xdd");
		const username = $("#username").val();
		console.log(username);
		const url = "https://api.github.com/search/users?type=Users&q=" + username;

		console.log(url);

		fetch(url)
			.then((data) => data.json())
			.then((data) => data.items.forEach(insertUser));
	});
}

function insertUser(user) {
	const list = $("ol");
	const listItem = $("<li>");
    const link = $("<a>");

    link.attr('href', user.html_url);
	link.text(user.login);

    link.appendTo(listItem);
	listItem.appendTo(list);
}
