/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score  
{
    // instance variables - replace the example below with your own
    private static int totalscore=0;
    private static Score scoreInstance = null;
    private Score() {}

    public static Score getInstance() {
        if(scoreInstance == null) {
            scoreInstance = new Score();
        }
        return scoreInstance;
    }
    
    public static void setScore(int s){
        totalscore=s;
    }
    
    public static int getScore()
    {
        return totalscore;
    }
    
}
