import greenfoot.*;
import java.util.*;

public abstract class Level extends World
{
    public static GreenfootSound level1Music = new GreenfootSound("level1.mp3");
    String[] map;
    int randomPoke;
    AbstractFactory pokemon= FactoryProducer.getFactory();
    ArrayList<Actor> obj = new ArrayList<Actor>();
    Actor bat, haunter, gastly, stillfire, dragon;
    Score score = Score.getInstance();
    
    public Level()
    {
        super(800, 600, 1);
        //setBackground(new GreenfootImage("StartScreen.png")); // Splash Screen
        setFields();
        bat = HurdleFactory.getHurdle("bat");
        haunter = HurdleFactory.getHurdle("haunter");
        gastly = HurdleFactory.getHurdle("gastly");
        stillfire = HurdleFactory.getHurdle("stillfire");
        dragon = HurdleFactory.getHurdle("dragon");
        MovableActor p=new MovableActor();
        

        obj.add(pokemon.getActor("Pikachu"));
        obj.add(pokemon.getActor("Pidgeotto"));
        obj.add(pokemon.getActor("Ponyta"));
        obj.add(pokemon.getActor("Wailord"));
       // obj.add(pokemon.getActor("Onix"));
        obj.add(pokemon.getActor("Kingler"));
        obj.add(pokemon.getActor("Machamp"));
        obj.add(pokemon.getActor("Mrmime"));
        obj.add(pokemon.getActor("Chansey"));
        obj.add(pokemon.getActor("Bulbasaur"));
        randomPoke = Greenfoot.getRandomNumber(obj.size());
        
        for (int i=0; i<map.length; i++) for (int j=0; j<map[i].length(); j++) // Example of Iteration
        {
                int kind = "cbpwmdasnzhv".indexOf(""+map[i].charAt(j));
                if (kind < 0) continue;
                Actor actor = null;
                if (kind == 0) actor=p;
                if (kind == 1) actor = new Block();
                if (kind == 2) actor = new Platform2();
                if (kind == 3) actor = new Wall();
                if (kind == 4) actor=  new Counter("Score: ",p);
                if (kind == 5) actor=  HurdleFactory.getHurdle("dragon");
                if (kind == 6) actor=  HurdleFactory.getHurdle("Gastly");
                if (kind == 7) actor=  new StillFire();
                if (kind == 8) actor=  new Door();
                if (kind == 9) actor=  obj.get(i%obj.size());
                if (kind == 10) actor=  HurdleFactory.getHurdle("haunter");
                if (kind == 11) actor=  HurdleFactory.getHurdle("bat");
                addObject(actor, 16+j*32, 16+i*32);
        }
    }

    public void setFields() {
        
    }
   
    public void nextLevel() {}
}