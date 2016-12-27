import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bat here.
 * 
 * @author  - Nitinkumar Gove 
 * @version - V1.1
 */
public class Bat extends Actor implements Hurdle
{
   
    GifImage gifImage = new GifImage("golbat-f.gif");

    /**
     * Act - do whatever the Bat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void setAvatar()
    {
        setImage(gifImage.getCurrentImage());  
    }
    
    public void act() 
    {
        setAvatar(); 
              
        // detect left key - and act
        if(Greenfoot.isKeyDown("left"))
        {
            moveLeft();
        }
        
        // detect right key - and act
        if(Greenfoot.isKeyDown("right"))
        {
            moveRight();
        }
        
        // detect up key - and act
        if(Greenfoot.isKeyDown("up"))
        {
            moveUp();
        }
        
         // detect down key - and act
        if(Greenfoot.isKeyDown("down"))
        {
            moveDown();
        }
        
        
        
    }  
    
    // swing at a place
    public void swing()
    {
        int x = getX();
        int y = getY();
        
        int gotill;
        int start;
        
        start = x;
        gotill= x - 200;
        
        while(true)
        {
            if(x > gotill)
            {
                x = x - 10;
                setLocation(x,y);
            }
            else if(x < gotill)
            {
                x = x + 10;
                setLocation(x,y);
            }
            
        }
    }
    
    public void moveRight()
    {
        int x = (getX() + 5);
        int y = (getY());
         
        setLocation(x, y);
    }
    public void moveLeft()
    {
        int x = (getX() - 5);
        int y = (getY());
         
        setLocation(x, y);
    }
    public void moveDown()
    {
        int x = (getX());
        int y = (getY() + 5);
         
        setLocation(x, y);
    }
    public void moveUp()
    {
        int x = (getX());
        int y = (getY() - 5);
         
        setLocation(x, y);
    }
}
