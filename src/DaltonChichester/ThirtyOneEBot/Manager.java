package DaltonChichester.ThirtyOneEBot;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import DaltonChichester.ThirtyOneEBot.Commands.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;

public class Manager 
{
    private final Map<String, Command> commands = new HashMap<>();
    private final Map<String, Command> commandsP = new HashMap<>();
    
    Manager() 
    {
    	//public commands
    	addCommand(new Help(this));
    	//addCommand(new AddAnnouncement());
    	//addCommand(new ShowAnnouncements());
    	//addCommand(new DeleteAnnouncement());
    	addCommand(new EightBall());
    	addCommand(new Poll());
    	addCommand(new Ping());
    	addCommand(new Meme());
    	addCommand(new MedelRack());
    	addCommand(new UserInfo());
        
        //private commands
        addPCommand(new Help(this));
        //addPCommand(new AddAnnouncement());
        //addPCommand(new ShowAnnouncements());
        //addPCommand(new DeleteAnnouncement());
    	addPCommand(new EightBall());
    	addPCommand(new Ping());
    	addPCommand(new Meme());
    }

    private void addCommand(Command c) 
    {
        if(!commands.containsKey(c.getCommand())) 
        {
            commands.put(c.getCommand(), c);
        }
    }
    
    private void addPCommand(Command c) 
    {
        if(!commandsP.containsKey(c.getPCommand())) 
        {
            commandsP.put(c.getPCommand(), c);
        }
    }

    public Collection<Command> getCommands() 
    {
        return commands.values();
    }
    
    public Collection<Command> getPCommands() 
    {
        return commandsP.values();
    }

    public Command getCommand(String commandName) 
    {
        if(commandName == null) 
        {
            return null;
        }
        return commands.get(commandName);
    }
    
    public Command getPCommand(String commandName) 
    {
        if(commandName == null) 
        {
            return null;
        }
        return commandsP.get(commandName);
    }

    void run(GuildMessageReceivedEvent event) throws IOException
    {
        final String msg = event.getMessage().getContentRaw();
        
        if(!msg.startsWith(Constants.BotPrefix)) 
        {
        	nonCommand(event);
            return;
        }
        
        final String[] split = msg.replaceFirst("(?i)" + Pattern.quote(Constants.BotPrefix), "").split("\\s+");
        final String command = split[0].toLowerCase();
        
        if(commands.containsKey(command)) 
        {
            final List<String> args = Arrays.asList(split).subList(1, split.length);
            commands.get(command).run(args, event);
        }
    }
    
    void runP(PrivateMessageReceivedEvent event)
    {
        final String msg = event.getMessage().getContentRaw();
        
        if(!msg.startsWith(Constants.BotPrefix)) 
        {
            return;
        }
        
        final String[] split = msg.replaceFirst("(?i)" + Pattern.quote(Constants.BotPrefix), "").split("\\s+");
        final String command = split[0].toLowerCase();
        
        if(commandsP.containsKey(command)) 
        {
            final List<String> args = Arrays.asList(split).subList(1, split.length);
            commandsP.get(command).runP(args, event);
        }
    }
    
    public void nonCommand(GuildMessageReceivedEvent event)
    {
    	String[] args = event.getMessage().getContentRaw().split("\\s");
    	
    	if(event.getAuthor().isBot())
        {
            return;
        }
    	
    }
}
