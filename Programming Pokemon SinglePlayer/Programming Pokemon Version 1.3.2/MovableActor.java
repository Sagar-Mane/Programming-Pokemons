import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class MovableActor here.
 * 
 * @author Sushant Vairagade 
 * @version 2016-11-18
 */
public class MovableActor extends Actor
{
    // instance variables - replace the example below with your own
    private ActorState actorState;
    private GroundState groundState;
    private JumpState jumpState;
    private FallState fallState;
    private String lastAction;
    private int lives=3;
    private ArrayList<ScoreObserver> obs = new ArrayList<ScoreObserver>();    
    public Score score = Score.getInstance(); 
    
    public int getScore(){
        return score.getScore();
    }
    
    public void setScore(int s){
        score.setScore(score.getScore()+s);
        
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
    
    /**
     * Constructor for objects of class MovableActor
     */
    public MovableActor()
    {
        groundState = new GroundState(this);
        jumpState = new JumpState(this);
        fallState = new FallState(this);
        actorState = fallState;
        setImage(new GreenfootImage("standingforward.png"));
        lastAction = "d";
        score.setScore(score.getScore());
    }
    
    
    
    public void setActorState(ActorState actorState) 
    {
        this.actorState = actorState;
    }
    
    public ActorState getGroundState() {
        return groundState;
    }
    
    public ActorState getJumpState() {
        return jumpState;
    }
    
    public ActorState getFallState() {
        return fallState;
    }
    
    public void setLastAction(String lastAction)
    {
        this.lastAction= lastAction;
    }
    
    public String getLastAction() 
    {
        return lastAction;
    }
    
    public boolean onGround()
    {   
        Actor platform = getOneObjectAtOffset(0, getImage().getHeight()/2, Platform.class);
        return platform != null;
    }
    
    public boolean touchingPlatform()
    {   
        Actor platform = getOneIntersectingObject(Platform2.class);
        return platform != null;
    }
    
    public boolean onThePlatform()
    {   
        Actor platform = getOneIntersectingObject(Platform2.class);
        if (platform != null)
        {
            if(platform.getY() < getY()) {
                return true;
            }
        }
        return false;
    }
    
    public void act() {
        actorState.move();
        checkNext();
        checkHurdle();
        capturePokemons();
    }
    
    public void checkNext(){
      Actor door=getOneObjectAtOffset(0, 0, Door.class);
      
      if(door!=null){
          
        ((Level)getWorld()).nextLevel();
       }
      
    }
    
    public void checkHurdle(){
       if(this.getOneIntersectingObject(StillFire.class)!=null){
         getWorld().removeObject(this);
         Greenfoot.setWorld(new GameOver());
        }
       if(this.getOneIntersectingObject(Hurdle.class)!=null){
         getWorld().removeObject(this);
         Greenfoot.setWorld(new GameOver());
        }
        if(this.getOneIntersectingObject(Fire.class)!=null){
         getWorld().removeObject(this);
         Greenfoot.setWorld(new GameOver());
        }
    }
    
    public void capturePokemons(){
       if(this.getOneIntersectingObject(Pikachu.class)!=null){
           getWorld().removeObjects(getWorld().getObjects(Pikachu.class));
           setScore(50);
           
      }
      if(this.getOneIntersectingObject(Pidgeotto.class)!=null){
           getWorld().removeObjects(getWorld().getObjects(Pidgeotto.class));
           setScore(50);
           
      }
      if(this.getOneIntersectingObject(Ponyta.class)!=null){
           getWorld().removeObjects(getWorld().getObjects(Ponyta.class));
           setScore(50);    
           
      }
      if(this.getOneIntersectingObject(Wailord.class)!=null){
           getWorld().removeObjects(getWorld().getObjects(Wailord.class));
           setScore(50);
           
      }
       if(this.getOneIntersectingObject(Kingler.class)!=null){
           getWorld().removeObjects(getWorld().getObjects(Kingler.class));
           setScore(50);
           
      }
       if(this.getOneIntersectingObject(Machamp.class)!=null){
           getWorld().removeObjects(getWorld().getObjects(Machamp.class));
           setScore(50);
           
      }
      if(this.getOneIntersectingObject(Bulbasaur.class)!=null){
           getWorld().removeObjects(getWorld().getObjects(Bulbasaur.class));
           setScore(50);
           
      }
      if(this.getOneIntersectingObject(Chansey.class)!=null){
           getWorld().removeObjects(getWorld().getObjects(Chansey.class));
           setScore(50);
           
      }
      if(this.getOneIntersectingObject(Mrmime.class)!=null){
           getWorld().removeObjects(getWorld().getObjects(Mrmime.class));
           setScore(50);
           
      }
      
    }
    public void checkDoor(){
        if(this.getOneIntersectingObject(Door.class)!=null){
        int score=getScore();
        
        }
    }
}
