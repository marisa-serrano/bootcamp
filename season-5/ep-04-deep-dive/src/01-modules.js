/**
 * Creates a counter module with an initial value, zero if not provided
 */
exports.createCounter = function (counter) {
	let value = counter ? counter : 0;

	return {
		get: function () {
			return value;
		},
		increment: function () {
			return ++value;
		},
		reset: function (num) {
			value = num ? num : 0;
			return value;
		},
	};
};

/**
 * Creates a person module with name and age
 * An initial name value should be provided and
 * an exception thrown if not
 */
exports.createPerson = function (name) {

	if (!name) {
		throw new Error("Please provide a name");
	}

	let age = 0;

	const person = {
		getName: function () {
			return name;
		},
		setName: function (string) {
			name = string;
		},
		getAge: function () {
			return age;
		},
		setAge: function (num) {
			age = num;
		},
	};

	return person;
};
