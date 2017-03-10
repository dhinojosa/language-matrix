import groovy.transform.Canonical

@Canonical
class Fahrenheit {
   int temperature

   def asType(Class target) {
      if (target in Celcius) {
         new Celcius(temperature : (this.temperature - 32) * 0.5556)
      }
   }
}

@Canonical
class Celcius {
   int temperature

   def asType(Class target) {
      if (target in Fahrenheit) {
         new Fahrenheit(temperature : (this.temperature * 1.8 + 32))
      }
   }
}

assert new Fahrenheit(temperature:100) as Celcius == new Celcius(37)
