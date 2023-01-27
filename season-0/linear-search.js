let linSearch = function (list, target) {
	let i = 0;
	let wasFound;

	while (i < list.length && !wasFound) {
		if (list[i] === target) {
			wasFound = true;
			console.log("I found it!");
		}
		i++;
	}

	if (!wasFound) {
		console.log("Sorry, it's not here");
	}
}

linSearch([1, 2, 3, 4], 3);
