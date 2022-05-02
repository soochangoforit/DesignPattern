/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.oop2.designpattern.ch04.abstractFactoryPattern;

import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Cheese;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Clams;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Dough;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Pepperoni;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Sauce;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.ingredient.Veggies;

/**
 *
 * @author tncks
 */
public abstract class Pizza {
    
    String name;
    Dough dough;
    Sauce sauce;
    Veggies veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clam;
    
   public abstract void prepare();
    
   void bake(){
        System.out.println("Bake for 25 minutes at 350");
    }
    
    void cut(){
        System.out.println("Cutting the pizza into diagonal slices");
    }
    
    void box(){
        System.out.println("Place pizza in Official PizzaStore box");
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
}
