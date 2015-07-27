/* A String can be interpolated with a double quoted string 
 * Given a couple variable assignments...*/

val name = "Albert Einstein"
val age = 76

/* It can be interpolated in the string with a dollar sign 
 * and possibly a bracket Anything after the dollar
 * sign replaces the values in the context */

println(s"His name was ${name} and he lived until he was ${age}")

/* If it is one single variable without any method call or
 * mathematic operations you can omit the braces */

println(s"His name was $name and he lived until he was $age")

/* If there is a method that needs to be called or some kind of
 * arithmetic operation you need the braces */

println(s"His name was ${name.reverse} and he lived until he was ${age + 1}")

