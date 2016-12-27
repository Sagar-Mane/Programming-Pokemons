import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

/**
 * Write a description of class Message here.
 * 
 * @author Nitinkumar Gove
 * @version 3.0
 */
public class Message extends Actor
{
    String msg;
    int size;
    Color color;
    
    
    public Message(String m, int size)
    {
        this.msg = m ; 
        this.size = size;
        color = Color.BLACK;
    }
     public Message(String m, int size, Color color)
    {
        this.msg = m ; 
        this.size = size;
        this.color = color; 
    }
    
    public void initialize(String m)
    {
        GreenfootImage g = new GreenfootImage(m, size, color, null);
        g.setFont(new Font(null, Font.PLAIN, 40));
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
