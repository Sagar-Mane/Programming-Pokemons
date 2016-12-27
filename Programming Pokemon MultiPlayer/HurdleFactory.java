import greenfoot.*;
/**
 * Write a description of class HurdleFactory here.
 * 
 * @author Nitinkumar Gove
 * @version 1.0
 */

public class HurdleFactory  
{
    
    public static Actor getHurdle(String hurdleType){
        
        if(hurdleType.equalsIgnoreCase("bat"))
            return new Bat();
        else if(hurdleType.equalsIgnoreCase("haunter"))
            return new Haunter();
        else if(hurdleType.equalsIgnoreCase("gastly"))
            return new Gastly();
        else if(hurdleType.equalsIgnoreCase("dragon"))
            return new Dragon();
        else if(hurdleType.equalsIgnoreCase("stillfire"))
            return new StillFire();
        
            
        return null;
    }
}
