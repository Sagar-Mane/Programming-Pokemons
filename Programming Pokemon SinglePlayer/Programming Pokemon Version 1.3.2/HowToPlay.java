import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HowToPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HowToPlay extends StartScreen
{
    Message m2;
    /**
     * Constructor for objects of class HowToPlay.
     * 
     */
   public HowToPlay()
   {
        this.setBackground(new GreenfootImage("instructions.png"));
        this.removeObject(getObjects(Button.class).get(0));
        m2=new Message("Continue",30);
        addObject(m2,700,550);
        
   }
   
   public void act()
   {
       if(Greenfoot.mouseClicked(m2)){
        Greenfoot.setWorld(new Name());
    }
            
    }
}
