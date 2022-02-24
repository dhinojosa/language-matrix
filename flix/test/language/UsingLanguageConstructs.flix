
/**
 * For a list of keywords, you can get an 
 * idea at the syntax highlighting for VSCode's
 * Flix Server. https://github.com/flix/vscode-flix/blob/master/syntaxes/flix.tmLanguage.json
 */
@test
def onlyKeywordsCanBeInfixedWithoutBacktick():Bool & Pure = 
   (4 mod 2) == 0

/**
 * Notice that custom functions require backticks
 */
@test
def usingCustomInfixFunctions():Bool & Pure = 
   def op(x:Int32, y:Int32) = x * y;
   (3 `op` 5) == 15

/**
 * Importing a module and using a custom function
 * That still follows the same rules with custom
 * functions. Use a backtick
 */
@test
def usingInfixFunctionWithUse(): Bool & Pure =
   use MyFunctions.multiply;
   (3 `multiply` 5) == 15