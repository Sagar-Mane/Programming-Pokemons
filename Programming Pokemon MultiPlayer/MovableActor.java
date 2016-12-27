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
    GreenfootSound doorMusic = new GreenfootSound("door.mp3");
    // instance variables - replace the example below with your own
    private ActorState actorState;
    private GroundState groundState;
    private JumpState jumpState;
    private FallState fallState;
    private String lastAction;
    private int lives=3;
    private boolean canComplete;
    private ArrayList<ScoreObserver> obs = new ArrayList<ScoreObserver>();    
    public Score score = Score.getInstance(); 
   
    //Level01 lv1 = new Level01();
    public int getScore(){
        return score.getScore();
    }
    
    public void setScore(int s){
        if(s>0) {
            canComplete = true;
        }
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
        capturePokemons();
        checkHurdle();       
        
    }
    
    public void checkNext(){
      Actor door=getOneObjectAtOffset(0, 0, Door.class);
      
      int scr=score.getScore();
      if(door!=null && canComplete)
      {
         canComplete = false;
        ((Level)getWorld()).nextLevel();
       }
      
    }
    
    public void checkHurdle(){
       if(this.getOneIntersectingObject(StillFire.class)!=null){
         getWorld().removeObject(this);
         Greenfoot.setWorld(new ScoresList());
         Level.level1Music.stop();
        }
       else if(this.getOneIntersectingObject(Hurdle.class)!=null){
         getWorld().removeObject(this);
         Greenfoot.setWorld(new ScoresList());
         Level.level1Music.stop();
        }
       else if(this.getOneIntersectingObject(Fire.class)!=null){
         getWorld().removeObject(this);
         Greenfoot.setWorld(new ScoresList());     
         Level.level1Music.stop();
        }
    }
    
    public void capturePokemons(){
       if(getOneIntersectingObject(Pikachu.class)!=null){
           getWorld().removeObjects(getWorld().getObjects(Pikachu.class));
           setScore(50);
           
      }
      else if(getOneIntersectingObject(Pidgeotto.class)!=null){
           getWorld().removeObjects(getWorld().getObjects(Pidgeotto.class));
           setScore(50);
           
      }
      else if(getOneIntersectingObject(Ponyta.class)!=null){
           getWorld().removeObjects(getWorld().getObjects(Ponyta.class));
           setScore(50);    
           
      }
      else if(getOneIntersectingObject(Wailord.class)!=null){
           getWorld().removeObjects(getWorld().getObjects(Wailord.class));
           setScore(50);
           
      }
      else if(getOneIntersectingObject(Kingler.class)!=null){
           getWorld().removeObjects(getWorld().getObjects(Kingler.class));
           setScore(50);
           
      }
      else if(getOneIntersectingObject(Machamp.class)!=null){
           getWorld().removeObjects(getWorld().getObjects(Machamp.class));
           setScore(50);
           
      }
      else if(getOneIntersectingObject(Bulbasaur.class)!=null){
           getWorld().removeObjects(getWorld().getObjects(Bulbasaur.class));
           setScore(50);
           
      }
      else if(getOneIntersectingObject(Chansey.class)!=null){
           getWorld().removeObjects(getWorld().getObjects(Chansey.class));
           setScore(50);
           
      }
      else if(getOneIntersectingObject(Mrmime.class)!=null){
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