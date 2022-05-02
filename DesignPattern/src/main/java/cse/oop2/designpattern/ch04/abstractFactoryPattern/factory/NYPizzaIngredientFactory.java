/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.oop2.designpattern.ch04.abstractFactoryPattern.factory;

import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.SlicedPepperoni;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.PizzaIngredientFactory;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Cheese;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Clams;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Dough;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.FreshClams;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Garlic;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.MarinaraSauce;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Mushroom;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Onion;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Pepperoni;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.ReggianoCheese;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Sauce;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.ThinCrustDough;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Veggies;

/**
 *
 * @author tncks
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory{

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {new Garlic() , new Onion() , new Mushroom() };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }
    
}
