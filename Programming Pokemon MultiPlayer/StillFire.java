import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StillFire here.
 * 
 * @author Nitinkumar Gove 
 * @version 1.0
 */
public class StillFire extends Fire implements Hurdle
{
    GifImage gifImage = new GifImage("still_fire.gif");
    
    public void setAvatar()
    {
        setImage(gifImage.getCurrentImage());  
    }
    
    /**
     * Act - do whatever the StillFire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setAvatar();
    }    
}
