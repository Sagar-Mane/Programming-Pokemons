public class CommandInvoker 
{
    Command command;
    public CommandInvoker(Command command)
    {
     this.command=command;
    }
    public void move()
    {
        command.execute();
    }
}
