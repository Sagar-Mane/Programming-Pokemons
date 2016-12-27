import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Haunter here.
 * 
 * @author Nitinkumar Gove
 * @version V1.1
 */
public class Haunter extends Actor implements Hurdle
{
    
    GifImage gifImage = new GifImage("haunter.gif");
     int flag = 0;
     
    public void setAvatar()
    {
        setImage(gifImage.getCurrentImage());  
    }
    /**
     * Act - do whatever the Haunter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setAvatar();
        move();
        // movement
        
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
