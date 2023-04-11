/**
 * Return a Rectangle constructor function
 * Rectangle instances should contain x and y properites
 * and they should know how to calculate their area and perimeter
 */
exports.createRectangleConstructor = function () {
	function Rectangle(x, y) {
        this.x = x;
        this.y = y;
    };

	Rectangle.prototype.area = function () {
		return this.x * this.y;
	};

	Rectangle.prototype.perimeter = function () {
		return this.x * 2 + this.y * 2;
	};

    return Rectangle;
};

/**
 * Return a constructor function that
 * subclasses the provided constructor
 */
exports.createSubClass = function (fn) {
    return function SubClass() {
        fn.call(this);
    }
};
