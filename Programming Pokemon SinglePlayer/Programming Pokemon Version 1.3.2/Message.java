import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

/**
 * Write a description of class Message here.
 * 
 * @author Nitinkumar Gove
 * @version 1.0
 */
public class Message extends Actor
{
    String msg;
    int size;
    
    public Message(String m, int size)
    {
        this.msg = m ; 
        this.size = size;
    }
    
    public void initialize(String m)
    {
        GreenfootImage g = new GreenfootImage(m, size, null, null);
        g.setFont(new Font("calibri", Font.PLAIN, 40));
        setImage(g);
    }
    
    public String getMessage(){
        return msg;
    }
    
    public void act() 
    {
        // Add your action code here.
        initialize(getMessage());
    }    
}
