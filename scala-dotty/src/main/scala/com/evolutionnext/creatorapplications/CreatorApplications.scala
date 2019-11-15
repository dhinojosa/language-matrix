package com.evolutionnext.creatorapplications

object CreatorApplications extends App {
  /* Use a simple function to create an object
   *  without a new. Although this is already in 
   *  place now with apply, this allows us to do so even
   *  if there is no such apply call
  **/

  enum FoodGroup {
     case Fruit
     case Vegetable
     case Meat
     case Grain
     case Dairy
     case Legumes
  }

  //Notice in the following, there is no
  //companion object, and no companion
  //object with apply
  class Food(name: String, foodGroup:FoodGroup) {
     override def toString = s"Food($name, $foodGroup)"
  }

  //Notice that there is no `new` keyword
  val food = Food("Almonds", FoodGroup.Legumes)
  println(food)
}
