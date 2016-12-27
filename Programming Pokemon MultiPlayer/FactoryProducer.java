import greenfoot.*;
public class FactoryProducer  
{
   public static AbstractFactory getFactory(){
   return new PokeSet1Factory();
   }
}