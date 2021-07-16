package DaltonChichester.ThirtyOneEBot.Commands;

import DaltonChichester.ThirtyOneEBot.Command;
import DaltonChichester.ThirtyOneEBot.Constants;
import DaltonChichester.ThirtyOneEBot.tools.AnnouncementMaker;
import DaltonChichester.ThirtyOneEBot.tools.Tools;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;

import java.io.FileWriter;
import java.util.List;

public class AddAnnouncement implements Command 
{
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) 
    {	   
    	String msg = event.getMessage().getContentRaw();
    	String[] line = msg.split("\\|");
	    	
		if(!args.isEmpty()) 
		{				
		    FileWriter fWriter;
			try 
			{
				fWriter = new FileWriter("AnnouncementList.txt", true);
								
				fWriter.write("\n" + args.get(0));
				fWriter.write(line[line.length -1] + "\n");
				
				fWriter.write("###");
				
				fWriter.close();
								
				AnnouncementMaker.AnnouncementChecker(event);
				event.getChannel().sendTyping().queue();
				event.getChannel().sendMessage("Successfully added announcement").queue();
			} 
			catch (Exception e) 
			{
				event.getChannel().sendTyping().queue();
				Tools.error(event.getChannel());
			}
		}
		else
		{
			event.getChannel().sendTyping().queue();
			Tools.wrongUsage(event.getChannel(), this);
		}
    }
    
    @Override
	public void runS(SlashCommandEvent event) 
    {
	}
    
    @Override
    public void runP(List<String> args, PrivateMessageReceivedEvent event) 
    {
    	String msg = event.getMessage().getContentRaw();
    	String[] line = msg.split("\\|");
    	
		if(!args.isEmpty()) 
		{				
		    FileWriter fWriter;
			try 
			{
				fWriter = new FileWriter("AnnouncementList.txt", true);
								
				fWriter.write("\n" + args.get(0) + "\n");
				fWriter.write(line[line.length -1] + "\n");
				fWriter.write("###\n");
				
				fWriter.close();
								
				event.getChannel().sendTyping().queue();
				event.getChannel().sendMessage("Successfully added announcement").queue();
			} 
			catch (Exception e) 
			{
				event.getChannel().sendTyping().queue();
				Tools.error(event.getChannel());
			}
		}
		else
		{
			event.getChannel().sendTyping().queue();
			Tools.wrongUsage(event.getChannel(), this);
		}
    }


    @Override
    public String getCommand() 
    {
        return "add_announcement";
    }
    
    @Override
    public String getPCommand() {
        return "add_announcement";
    }

    @Override
    public String getHelp() 
    {
        return "Allows the adding of announcements at specified times!\n" +
                "Usage: `" + Constants.BotPrefix + getCommand() + " <Day You want it Posted>|<Hour You want it Posted>|<Minute You want it Posted>|<Reaction value you want added to message>|"
                		+ "\n<Message You want Posted>`";
    }

	
}
