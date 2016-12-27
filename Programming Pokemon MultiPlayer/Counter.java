import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
 
/**
 * Counter that displays a text and number.
 * 
 * @author Nitinkumar Gove
 * @version 1.0.1
 */
public class Counter extends Actor implements ScoreObserver
{
    private static final Color textColor = new Color(0, 0, 0);
     
    private int value = 0;
    private int target = 0;
    private String text;
    private int stringLength;
    
    MovableActor p = null ; 
    private Score score = Score.getInstance();
 
    public Counter()
    {
        this("",null);
    }
    
   
 
    public Counter(String prefix, MovableActor p)
    {
        
        this.p = p;
        p.attach(this);
        text = prefix;
        stringLength = (text.length() + 2) * 12; 
        setImage(new GreenfootImage(stringLength, 145));
        GreenfootImage image = getImage();
        image.setFont(new java.awt.Font("Helvetica", Font.PLAIN, 18));
        image.setColor(textColor); 
        updateImage();
    }
    
    public  void updateScoreBoard()
    {
        this.add(score.getScore());
    }
     
    public void act() {
        if(value < target) {
            value++;
            updateImage();
        }
        else if(value > target) {
            value--;
            updateImage();
        }
    }
 
    public void add(int score)
    {
        target += score;
    }
 
    public int getValue()
    {
        return value;
    }
 
    /**
     * Make the image
     */
    private void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.setFont(new java.awt.Font("Helvetica", Font.PLAIN,18));
        image.drawString(text + score.getScore(), 5,12);
        
    }
}