import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Conditions here.
 * 
 * @author Nitinkumar Gove
 * @version 1.0
 */
public class Conditions extends World
{

    Message m;
    Message m2;
    String variable = " Awesome, You are a winner  !!! \n";
    String message = " For all this time, all the jumping arond walls and skipping \n the fire you did, the thing which made it possible was conditions. \n Conditions allow programs to behave in different way based on different conditions. "; 
       
    public Conditions()
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
       if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new GameOver());
        }
        if(Greenfoot.mouseClicked(m2)){
        Greenfoot.setWorld(new Level03());
        }
    } 
}
