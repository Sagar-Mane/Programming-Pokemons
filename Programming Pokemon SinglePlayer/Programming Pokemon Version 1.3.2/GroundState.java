import greenfoot.*;

/**
 * Write a description of class GroundState here.
 * 
 * @author Sushant Vairagade 
 * @version 2016-11-18
 */
public class GroundState implements ActorState
{
    private MovableActor actor;
    private GreenfootImage  runForward[] = new GreenfootImage[]{new GreenfootImage("forward1.png"), new GreenfootImage("forward2.png"), new GreenfootImage("forward3.png"), 
                                                                new GreenfootImage("forward4.png"),new GreenfootImage("forward5.png"),new GreenfootImage("forward6.png")};
                                                                
    private GreenfootImage faceForward = new GreenfootImage("standingforward.png");
     
    private GreenfootImage runBackward[] = new GreenfootImage[]{new GreenfootImage("backward1.png"), new GreenfootImage("backward2.png"), new GreenfootImage("backward3.png"),
                                                                new GreenfootImage("backward4.png"),new GreenfootImage("backward5.png"),new GreenfootImage("backward6.png")};
                                                                
    private GreenfootImage faceBackward = new GreenfootImage("standingbackward.png");
    private static final Integer SPEED = 5;
    private static Integer imageIndex = 0;

    /**
     * Constructor for objects of class GroundState
     */
    public GroundState(MovableActor actor)
    {
        this.actor = actor;
    }
    
    public void move()
    {
        if(!actor.onGround()) 
        {
            actor.setActorState(actor.getFallState());
        }
        else if(Greenfoot.isKeyDown("d")) 
        {
            //Greenfoot.delay(10);
            actor.setLocation(actor.getX() + SPEED, actor.getY());
            actor.setImage(runForward[imageIndex]);
            imageIndex = (imageIndex+1)%runForward.length;
            actor.setLastAction("d");
        }
        else if(Greenfoot.isKeyDown("a")) 
        {
           // Greenfoot.delay(10);
            actor.setLocation(actor.getX() - SPEED, actor.getY());
            actor.setImage(runBackward[imageIndex]);
            imageIndex = (imageIndex+1)%runBackward.length;
            actor.setLastAction("a");
        }
        else if(Greenfoot.isKeyDown("w")) {
            actor.setActorState(actor.getJumpState());
        }
        else {
            if("d".equals(actor.getLastAction())) 
            {
                actor.setImage(faceForward);
            }
            else if("a".equals(actor.getLastAction())) 
            {
                actor.setImage(faceBackward);
            }
        }
    }
}
