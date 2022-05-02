
package cse.oop2.designpattern.ch04.abstractFactoryPattern;

import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Cheese;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Clams;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Dough;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Pepperoni;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Sauce;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Veggies;

public interface PizzaIngredientFactory {
    
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClam();
    
}
