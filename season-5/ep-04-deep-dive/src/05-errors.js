/**
 * Return the result of invoking the provided function
 * If an exception is thrown, return the enclosed error message
 */
exports.callIt = function (fn) {
	try {
		return fn();
	} catch (error) {
		return error.message;
	}
};

/**
 * Return true if the provided arguments are equal,
 * throw an error with an enclosed message otherwise
 */
exports.assertEqual = function (a, b) {
	if (a === b) {
		return true;
	}

	throw new Error(error.message);
};

/**
 * Return a custom error constructor with a timestamp property
 * indicating when the error occurred
 */
exports.createCustomError = function () {
    return function CustomError() {
        Error.call(this);
        this.timestamp = Date.now();
    }
};
