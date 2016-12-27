import greenfoot.*;

public class Level03 extends Level
{
    GreenfootSound level3Music = new GreenfootSound("level1.mp3");
    GreenfootSound doorMusic = new GreenfootSound("victory.mp3");
    /** ********************      MAP LEGEND     *********************** */
    //      b = block        m = monster         f = floating platform q = wrong door
    //      p = platform     k = key             w = wall   
    //      c = character    d = door            s = score
    public void setFields()
    {
        
        map = new String[] { 
            "                         ",
            "                         ",
            "                       dm",
            "                  ppppp  ",
            "             z           ",
            "            ppp          ",
            "                         ",
            "                  ppp   ",
            "                         ",
            "          pppppp         ",
            " v   z             z  n   ",
            " ppppppp            ppp  ",
            "                         ",
            "  c                    k ",
            "       pppp      ppppppp ",
            "              z          ",
            "             ppppp       ",
            "                         ",
            "bbbbbbbbbbbbbbbbbbbbbbbbbb" };
    }

    private Score score = Score.getInstance();
    Service service; 
    
    public void nextLevel()
    {  
        doorMusic.play();
        level3Music.stop();
        
        service = Service.getInstance();
        service.updateScore(score.getScore());
        
        Greenfoot.setWorld(new ScoresList()); 
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
    public void act()
    {
        level3Music.playLoop();
    }
}