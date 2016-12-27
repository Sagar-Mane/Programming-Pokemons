import greenfoot.*;

public class MoveLeftCommand implements Command
{
    MovableActor actor;
    private static final Integer SPEED =5;
    private GreenfootImage runBackward[] = new GreenfootImage[]{new GreenfootImage("backward1.png"), new GreenfootImage("backward2.png"), new GreenfootImage("backward3.png"),
                                                                new GreenfootImage("backward4.png"),new GreenfootImage("backward5.png"),new GreenfootImage("backward6.png")};
    private static Integer imageIndex = 0;
    
    public MoveLeftCommand(MovableActor actor)
    {
     this.actor=actor;
    }
    public void execute()
    {
        actor.setLocation(actor.getX() - SPEED, actor.getY());
            actor.setImage(runBackward[imageIndex]);
            imageIndex = (imageIndex+1)%runBackward.length;
            actor.setLastAction("a");              
    }
}