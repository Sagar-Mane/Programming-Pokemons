import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HowToPlay here.
 * 
 * @author Nitinkumar Gove
 * @version 1.0
 */
public class HowToPlay extends StartScreen
{
    Button cont;

     /**
     * Constructor for objects of class HowToPlay.
     */
   public HowToPlay()
   {
        this.setBackground(new GreenfootImage("front.jpg"));
        this.removeObjects(getObjects(Button.class));
        cont = new Button("continue");
        this.addObject(cont, 400, 550) ;
   }
   
   public void act()
   {
       if(Greenfoot.mouseClicked(cont))
            Greenfoot.setWorld(new Name());
    }
}
