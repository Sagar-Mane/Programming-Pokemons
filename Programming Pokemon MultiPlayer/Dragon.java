import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Dragon here.
 * 
 * @author Nitinkumar Gove 
 * @version V1.1
 */
public class Dragon extends Actor implements Hurdle
{
    GifImage gifImage = new GifImage("aerodactyl.gif");
    int flag = 0;
    int counter=0;
    // for actor purpose - temp in dragon
    
    private ArrayList<ScoreObserver> obs = new ArrayList<ScoreObserver>();    
    public int score = 0 ; 
    
    public int getScore(){
        return score;
    }
    
    public void setScore(int s){
        this.score += s; 
        //System.out.println("Score " + score ); 
        notifyObservers();
    }
    
    public void attach(ScoreObserver sc)
    {
        obs.add(sc);
    }
    
    public void notifyObservers()
    {
       for(ScoreObserver sc : obs )
             sc.updateScoreBoard();
    }
    
    // -----------------------------------------------
    
     public void setAvatar()
    {
        setImage(gifImage.getCurrentImage());  
    }
    
    /**
     * Act - do whatever the Dragon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setAvatar();
        spitFire();
        move();
        
    }    
    
    public void move()
    {
        counter++;
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
    
    public void spitFire()
    {
        if(counter%100==0) 
        {
            try{
            getWorld().addObject(new Fire(), getX()-20, getY());
        }
        catch(Exception e){}
        }
    }
}
