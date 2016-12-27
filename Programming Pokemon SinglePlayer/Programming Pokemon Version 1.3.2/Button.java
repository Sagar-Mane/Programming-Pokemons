import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
   String tag = "";
        
    public Button(String t)
    {
        this.tag = t;
    }
   
    public void act() 
    {       
        createButton();
        if (Greenfoot.mouseClicked(this)) {
            HowToPlay h = new HowToPlay();
            Greenfoot.setWorld(h);
        }
    } 
 
    public void createButton()
    {       
               GreenfootImage drawedImage = new GreenfootImage("playnowsmall.png");
               setImage(drawedImage);     
    }
}
