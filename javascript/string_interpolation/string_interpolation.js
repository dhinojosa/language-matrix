/* A String can be interpolated with a double quoted string 
 * Given a couple variable assignments...*/

const name = "Albert Einstein";
const age = 76;

/* To do an interpolation, surround the string with a backtick.
 * It can be interpolated in the string with a dollar sign 
 * and possibly a bracket Anything after the dollar
 * sign replaces the values in the context */

console.log(`His name was ${name} and he lived until he was ${age}`)

/* A bracket is mandatory in order to do string interpolation, the
 * following will not work properly and will only print $name and $age */

console.log(`His name was $name and he lived until he was $age`)

/* If there is a method that needs to be called or some kind of
 * You can place that inside the braces.
 */

console.log(`His name was ${name.split('').reverse().join('')} and he lived until he was ${age + 1}`)
