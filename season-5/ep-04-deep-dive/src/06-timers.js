/**
 * Return a stop watch object with the following API:
 * getTime - return number of seconds elapsed
 * start - start counting time
 * stop - stop counting time
 * reset - sets seconds elapsed to zero
 */
exports.createStopWatch = function () {
	let init;
	let elapsed;

	return {
		start: function () {
			init = Date.now();
		},

		stop: function () {
			elapsed = Math.floor(Date.now() - init / 1000);
		},

		getTime: function () {
			this.stop();
			return elapsed;
		},

		reset: function () {
			elapsed = 0;
		},
	};
};
