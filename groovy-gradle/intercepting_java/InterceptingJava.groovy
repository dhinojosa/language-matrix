Integer.metaClass.invokeMethod = {String name, Object args ->
   System.out.println("Intercepting $name with $args")
   def metaMethod = Integer.metaClass.getMetaMethod(name, args)
   if (metaMethod != null) {
      metaMethod.invoke(delegate, args)
   } else {
      Integer.metaClass.invokeMissingMethod(delegate, name, args)
   }
}

def x = 10.longValue()
println x
