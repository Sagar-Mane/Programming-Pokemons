import greenfoot.*;
public class PokeSet1Factory extends AbstractFactory
{
    public Actor getActor(String name)
    {
        if(name==null)
        {return null;}
        else if(name.equalsIgnoreCase("Ponyta"))
        {return new Ponyta();}
        else if(name.equalsIgnoreCase("Machamp"))
        {return new Machamp();}
        else if(name.equalsIgnoreCase("Mrmime"))
        {return new Mrmime();}
        else if(name.equalsIgnoreCase("Wailord"))
        {return new Wailord();}
        else if(name.equalsIgnoreCase("Onix"))
        {return new Onix();}
        else if(name.equalsIgnoreCase("Chansey"))
        {return new Chansey();}
        else if(name.equalsIgnoreCase("Pikachu"))
        {return new Pikachu();}
        else if(name.equalsIgnoreCase("Bulbasaur"))
        {return new Bulbasaur();}
        else if(name.equalsIgnoreCase("Pidgeotto"))
        {return new Pidgeotto();}
        else if(name.equalsIgnoreCase("Kingler"))
        {return new Kingler();}
        return null;
    }
}
    