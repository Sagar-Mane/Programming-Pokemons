 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**d
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     int speed = 10;
     int superspeed=70;
     int acceleration =10;
     boolean jumping = false;
     int gravity=5;
     int i = 0; 
     int jumpHeight = 0;
     int deltaY = -1;
     int jumpSpeed = 2;
     
     String key = "d";
     public GreenfootImage  runForward[] = new GreenfootImage[]{new GreenfootImage("walkforward1.png"), new GreenfootImage("walkforward2.png"), new GreenfootImage("walkforward3.png"), 
                                                                new GreenfootImage("walkforward4.png"),new GreenfootImage("walkforward5.png"),new GreenfootImage("walkforward6.png")};
                                                                
     public GreenfootImage faceForward = new GreenfootImage("standingforward.png");
     
     public GreenfootImage runBackward[] = new GreenfootImage[]{new GreenfootImage("walkingbackward1.png"), new GreenfootImage("walkingbackward2.png"), new GreenfootImage("walkingbackward3.png"),
                                                                new GreenfootImage("walkingbackward4.png"),new GreenfootImage("walkingbackward5.png"),new GreenfootImage("walkingbackward6.png")};
                                                                
     public GreenfootImage faceBackward = new GreenfootImage("standingbackward.png");
public void act() 
        {
            movement();
            //checkNext();
            Actor door=getOneObjectAtOffset(0, 0, Door.class);
            System.out.println("Check door"+door);
            if(door!=null){
            System.out.println("Check door");
            ((Level)getWorld()).nextLevel();
            }
        }   
public boolean onGround()
{   
    Actor below = getOneObjectAtOffset( 0, getImage().getHeight()/2, Platform.class);
    return below != null ;
}
private void movement() {
    
        if(Greenfoot.isKeyDown("d") && !jumping)
        {                
            updateActorMovement("d", speed, runForward, 5);
        }
        if(Greenfoot.isKeyDown("d") && jumping)
        {                
            updateActorMovement("d", speed, runForward, 5);
            //checkFall();
        }
        if(Greenfoot.isKeyDown("a") && jumping)
        {                
            updateActorMovement("a", speed, runForward, 5);
            //checkFall();
        }
        if(Greenfoot.isKeyDown("a")&& !jumping)
        {                
            updateActorMovement("a", -speed, runBackward, 5);
        }
        if(Greenfoot.isKeyDown("a") && jumping)
        {                
            updateActorMovement("a", -speed, runBackward, 5);
            //checkFall();
        }
       if(Greenfoot.isKeyDown("w") && !jumping)
        { 
           jump();     
        } 
       checkFall();
       setLastPosition();
}
private void updateActorMovement(String keyPressed, int speed, GreenfootImage[] images, int delay) {

            if(jumping) {
                setLocation(getX()+jumpSpeed,getY());
                setImage(faceForward);
            }
            else {
            setLocation(getX()+speed,getY());
            setImage(images[i]);
            }
            Greenfoot.delay(10);
            i= (i+1)%images.length;
            key = keyPressed;
   }
private void setLastPosition() {
        if( key =="d")
        {
            setImage(faceForward);  
        }
        else if ( key =="a")
        {
            setImage(faceBackward);
        }    
    }
public void checkFall()
{
    if(onGround())
    {
     jumping= false;
     //gravity = 0;
    }
    else
    {
        jumping= true;
        fall();
    }
}    
public void jump()
{    
    jumping=true;
    int y = getY();
    while(getY() > y -150) {
        Greenfoot.delay(1);
         if(Greenfoot.isKeyDown("d"))
        {                
            setLocation(getX()+jumpSpeed, getY()- gravity);
        }
        else if(Greenfoot.isKeyDown("a"))
        {                
            setLocation(getX()-jumpSpeed, getY()- gravity);
        }
        else {
            setLocation(getX(), getY()- gravity);
        }
    }
    
    while(!onGround()) {
        System.out.println("In whiuke");
      Greenfoot.delay(1);
      if(Greenfoot.isKeyDown("d"))
        {                
            setLocation(getX()+jumpSpeed, getY()+ gravity);
        }
        else if(Greenfoot.isKeyDown("a"))
        {                
            setLocation(getX()-jumpSpeed, getY()+ gravity);
        }
        else {
            setLocation(getX(), getY()+ gravity);
        }
    }
     jumping=false;
}

public void fall()
  { 
     setLocation(getX(),getY()+ gravity);
     if(Greenfoot.isKeyDown("d"))
      {                
         setLocation(getX()+1,getY()+gravity);
      }
  }
  public void checkNext(){
      System.out.println("Check door method");
      Actor door=getOneObjectAtOffset(0, 0, Door.class);
      if(door!=null){
          System.out.println("Check door");
        ((Level)getWorld()).nextLevel();
       }
      
    }
}