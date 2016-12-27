import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Array here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Array extends World
{

    Message m;
   Message m2;
   String variable = " Congrats for catching a bunch of Pokemons !!! \n";
   String message = " A collection of things, in computer world, is called as an array. \n It is as similar as storing a bunch of pokemon's  on your desk, all together."; 
      
   public Array()
   {   
       
       // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
       super(800, 600, 1);            
       m = new Message(variable, 40);             
       addObject(m, 400, 150);
       
        m = new Message(message, 25);             
       addObject(m, 400, 250);
       m2=new Message("Continue",30);
        addObject(m2,700,550);
   }
   public void act()
   {
       if(Greenfoot.mouseClicked(m2)){
       Greenfoot.setWorld(new Level02());
    }
    
    }
}
