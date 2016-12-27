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
    private GreenfootImage faceForward = new GreenfootImage("standingforward.png");
     
                                                                
    private GreenfootImage faceBackward = new GreenfootImage("standingbackward.png");
    private static final Integer SPEED = 5;

    CommandInvoker commandInvoker;  
    MoveRightCommand moveRightCommand;
    MoveLeftCommand moveLeftCommand;
    /**
     * Constructor for objects of class GroundState
     */
    public GroundState(MovableActor actor)
    {
        this.actor = actor;    
        moveRightCommand = new MoveRightCommand(actor);
        moveLeftCommand = new MoveLeftCommand(actor);
    }
    public void move()
    {
        if(!actor.onGround()) 
        {
            actor.setActorState(actor.getFallState());
        }
        else if(Greenfoot.isKeyDown("d")) 
        {
            commandInvoker=new CommandInvoker(moveRightCommand);            
        }
        else if(Greenfoot.isKeyDown("a")) 
        {
            commandInvoker=new CommandInvoker(moveLeftCommand);   
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
        if(commandInvoker!= null)
        {
            commandInvoker.move();
            commandInvoker = null;
        }
   }
}