import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gastly here.
 * 
 * @author Nitinkumar Gove
 * @version V1.1
 */
public class Gastly extends Actor implements Hurdle
{
    GifImage gifImage = new GifImage("gastly.gif");
    int flag = 0;
    
    public void setAvatar()
    {
        setImage(gifImage.getCurrentImage());  
    }
    
    /**
     * Act - do whatever the Gastly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setAvatar();
        move();
    }   
    
     public void move()
    {
        if(getX()>100 && flag == 0)
        {
            setLocation(getX()-5, getY());
            flag = 0;
        }
        else if(getX() < getWorld().getWidth()-100 ) 
        {
            setLocation(getX()+5, getY());
            flag = 1;
        }
        else
            flag = 0;       
    }
}
