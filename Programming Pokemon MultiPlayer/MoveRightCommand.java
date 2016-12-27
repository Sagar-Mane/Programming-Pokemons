import greenfoot.*;
public class MoveRightCommand implements Command
{
    MovableActor actor;
    private static final Integer SPEED = 5;
    private GreenfootImage  runForward[] = new GreenfootImage[]{new GreenfootImage("forward1.png"), new GreenfootImage("forward2.png"), new GreenfootImage("forward3.png"), 
                                                                new GreenfootImage("forward4.png"),new GreenfootImage("forward5.png"),new GreenfootImage("forward6.png")};
                                                                
    private static Integer imageIndex = 0;
        
    public MoveRightCommand(MovableActor actor)
    {
     this.actor=actor;
    }
    
    public void execute()
    {
            //Greenfoot.delay(10);
            actor.setLocation(actor.getX() + SPEED, actor.getY()); 
            actor.setImage(runForward[imageIndex]);
            imageIndex = (imageIndex+1)%runForward.length;
            actor.setLastAction("d");        
    }
}