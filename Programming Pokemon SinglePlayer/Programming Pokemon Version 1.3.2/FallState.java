import greenfoot.*;
/**
 * Write a description of class JumpState here.
 * 
 * @author Sushant Vairagade 
 * @version 2016-11-18
 */
public class FallState implements ActorState
{
    private MovableActor actor;
    //private static final Integer SPEED = 10;
    //private static Integer imageIndex = 0;
    private GreenfootImage faceForward = new GreenfootImage("forward4.png");
    private GreenfootImage faceBackward = new GreenfootImage("backward4.png");
    private static final Integer FALL_SPEED = 2;
    private static final Integer GRAVITY = 5;
    private static Integer position = 99999;

    /**
     * Constructor for objects of class FallState
     */
    public FallState(MovableActor actor)
    {
        this.actor = actor;
    }

    public void move()
    {   
        //Falling down
        
        if(!actor.onGround()) {
            Greenfoot.delay(1);
            if(Greenfoot.isKeyDown("d"))
            {
                actor.setLastAction("d");
                actor.setImage(faceForward);
                actor.setLocation(actor.getX() + FALL_SPEED, actor.getY()+ GRAVITY);
            }
            else if(Greenfoot.isKeyDown("a"))
            {
                actor.setLastAction("a");
                actor.setImage(faceBackward);
                actor.setLocation(actor.getX() - FALL_SPEED, actor.getY()+ GRAVITY);
            }
            else 
            {
                actor.setLocation(actor.getX(), actor.getY()+ GRAVITY);
            }
        } 
        else {
            actor.setActorState(actor.getGroundState());
        }
    }
}