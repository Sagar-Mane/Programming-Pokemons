import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

/**
 * Write a description of class Name here.
 * @author Nitinkumar Gove
 * @version 1.0
 */
public class Name extends World
{
    NameButton john, lucy, bruce, milly;
    Message m;
    
    String variable = " Awesome ! Just the way you picked a name for you, in computer world you \n use variables to a particular memory location.";
    Message m2;
    public Name()
    {   
        
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        john = new NameButton("john");
        milly = new NameButton("milly");
        bruce = new NameButton("bruce");
        lucy = new NameButton("lucy");
        
        m = new Message(" Select a name for your player ", 40);
        
        addObject(john, 400, 250);
        addObject(milly, 400, 300);
        addObject(bruce, 400, 350);
        addObject(lucy, 400, 400);
        
        addObject(m, 400, 150);
        m2=new Message("Continue",30);
        addObject(m2,700,550);
    }
    
    
   
    public void act() 
    {       
        if (Greenfoot.mouseClicked(john) || Greenfoot.mouseClicked(milly) || Greenfoot.mouseClicked(bruce) || Greenfoot.mouseClicked(lucy) ) {
           System.out.println("button clicked");
           m = new Message(variable, 22);
           addObject(m, 400, 500);
        }
        if(Greenfoot.mouseClicked(m2)){
        Greenfoot.setWorld(new Level01());
        }
    } 
 
    
    
}
