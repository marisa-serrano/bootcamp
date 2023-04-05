/**
 * write a function that receives a number as its argument;
 *  if the number is divisible by 3, the function should return 'fizz';
 *  if the number is divisible by 5, the function should return 'buzz';
 *  if the number is divisible by 3 and 5, the function should return 'fizzbuzz';
 *
 *  otherwise the function should return the number, or false if no number
 *  was provided or if the value provided was not a number
 */
exports.fizzBuzz = function(num) {

    if (typeof num != 'number' || num === undefined) {
        return false;
    }

    let message = "";

    if (num % 3 === 0) {
        message += 'fizz';    
    
    } if (num % 5 === 0) {
        message += 'buzz';    
    }
    
    return (message ? message : num);
};
