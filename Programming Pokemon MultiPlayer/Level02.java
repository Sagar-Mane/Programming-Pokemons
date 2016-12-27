import greenfoot.*;

public class Level02 extends Level
{
    GreenfootSound doorMusic = new GreenfootSound("doorchange.mp3");
   
    boolean doorFlag=true;
    
    /** ********************      MAP LEGEND     *********************** */
    //      b = block        m = monster         f = floating platform q = wrong door
    //      p = platform     k = key             w = wall   
    //      c = character    d = door            s = score
    public void setFields()
    {
        
        boolean doorFlag= true;
        map = new String[] { 
            "                         ",
            "                         ",
            "                       m ",
            "  c                      ",
            "                        n",
            " ppp              ppppppp",
            "            z            ",
            "           ppppp        ",
            "     a            z      ",
            "         p      pppppp   ",
            "                         ",
            "       z            s    ",
            "      pppp         pppp  ",
            " h z                      ",
            " ppp        p            ",
            "               v         ",
            "              ppp        ",
            " ss       sss     ss     ",
            "bbbbbbbbbbbbbbbbbbbbbbbbbb" };
            
    }

    public void nextLevel()
    {
       
        level1Music.stop();
         doorMusic.play();
        Greenfoot.setWorld(new Conditions()); 
    }
    public void act()
    {
        level1Music.playLoop();
     if (doorFlag==true)
     {         
     doorMusic.play();   
      doorFlag=false;
    }
    }
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        //System.out.println("inside prepare level 1");
       // Platform2 platform2 = new Platform2();
       // addObject(platform2, 100, 158);
    }
}