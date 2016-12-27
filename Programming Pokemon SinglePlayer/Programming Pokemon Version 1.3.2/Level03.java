import greenfoot.Greenfoot;

public class Level03 extends Level
{
    /** ********************      MAP LEGEND     *********************** */
    //      b = block        m = monster         f = floating platform q = wrong door
    //      p = platform     k = key             w = wall   
    //      c = character    d = door            s = score
    public void setFields()
    {
        
        map = new String[] { 
            "                         ",
            "                         ",
            "                      hm ",
            "                  ppppp  ",
            "             z           ",
            "            ppp          ",
            "                         ",
            "                  ppp  d",
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

    public void nextLevel()
    {
        Greenfoot.setWorld(new Winner()); 
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        System.out.println("inside prepare level 1");
       // Platform2 platform2 = new Platform2();
       // addObject(platform2, 100, 158);
    }
}