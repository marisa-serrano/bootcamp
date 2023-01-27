let binarySearch = function (list, target) {
	let middle = list.length / 2;
	let wasFound;
	let numOfElements = list.length;
	
	while (numOfElements > 0 && !wasFound) {
		if (list[middle] === target) {
			console.log("I found it!");
			wasFound = true;

		} else if (list[middle] < target) {
			list = list.slice(middle + 1);
			numOfElements = list.length;

		} else {
			list = list.slice(0, middle);
			numOfElements = list.length;
		}

	if (!wasFound) {
		console.log("Sorry, it's not here");
	}
}

let cards = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13];

binarySearch(cards, 7);
binarySearch(cards, 15);
