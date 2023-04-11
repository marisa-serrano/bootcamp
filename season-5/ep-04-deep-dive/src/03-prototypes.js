/**
 * Create a developer person object with a code method
 * that delegates to the provided person object
 */
exports.createDelegate = function(person) {
    const developer = Object.create(person);

    developer.code = function() {
        console.log('coding');
    }

    return developer;
};

/**
 * Borrow and invoke the person say method on top of the company object
 */
exports.borrowSayMethod = function(person, company) {
    return person.say.call(company);
};

/**
 * Iterate over all of the provided object own properties,
 * returning an array of key: value strings
 */
exports.iterate = function(obj) {
    const properties = [];

    Object.entries(obj).forEach(pair => {
        properties.push(pair[0] + ': ' + pair[1]);
    });

    return properties;
};

/**
 * Add a repeatify method to all JavaScript Strings
 * 'string'.repeatify(3) should equal 'stringstringstring'
 * NOTE: This exercise exists for a pedagogic purpose only,
 * do not think doing stuff like this is a good idea...
 *
 * String already contains a repeat method, let's NOT use that one.
 */
exports.extendString = function() {

    if (String.prototype.repeatify) {
        return;
    }

    String.prototype.repeatify = function(num) {
        let str = '';

        while (num > 0) {
            str += this;
            num--;
        }

        return str;
    } 
};
