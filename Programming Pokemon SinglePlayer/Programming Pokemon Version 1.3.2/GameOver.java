import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    Message m1,m2;
    private Score score = Score.getInstance();
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
       
        //m2=new Message("Your Score-",40);
        //addObject(m2,380,300);
        //String scr=""+score.getScore();
        //m1=new Message(scr,40);
        //addObject(m1,490,300);
        
        
        
    }
}
