import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Loops here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Loops extends World
{
   GreenfootSound clickSound = new GreenfootSound("click.mp3"); 
    Message m;
     Message m2;
    String variable = " Way to go buddy !!! \n";
    String message = " Remember how you killed some of those monsters ? \n Well all those furious bullets were fire through a loop. \n Loops provide us with a special way to things repeatedly."; 
       
    public Loops()
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
           clickSound.play();
       Greenfoot.setWorld(new Level03());
    }
    } 
}
