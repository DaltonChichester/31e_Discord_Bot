package DaltonChichester.ThirtyOneEBot.Commands;

import DaltonChichester.ThirtyOneEBot.Command;
import DaltonChichester.ThirtyOneEBot.Constants;
import DaltonChichester.ThirtyOneEBot.tools.Tools;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteAnnouncement implements Command 
{
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) 
    {	 
    	if(!args.isEmpty()) 
        {
	    	File file = new File("AnnouncementList.txt");
	        Scanner scnr;
	        try 
	        {
	            scnr = new Scanner(file);
	            
	            ArrayList<String> List = new ArrayList<String>();
	            
	            String temp;
	            String temp2 = "";
	            while (scnr.hasNextLine())
	            {
	            	temp = scnr.nextLine();
	            	if(!temp.equals("###"))
	            	{
	            		temp2 = temp2 + temp + "\n";
	            	}
	            	else
	            	{
	            		List.add(temp2);
	            		temp2 = "";
	            	}
	            }
	            
	            List.remove(Integer.parseInt(args.get(0)) - 1);
	            
	            FileWriter fWriter;
				try 
				{
					fWriter = new FileWriter("AnnouncementList.txt");
							
					for(int i = 0; i < List.size(); i++)
					{
						fWriter.write(List.get(i) + "\n");
						fWriter.write("###\n");
					}
			
					fWriter.close();
									
					event.getChannel().sendTyping().queue();
					event.getChannel().sendMessage("Successfully removed announcement").queue();
				} 
				catch (Exception e) 
				{
					event.getChannel().sendTyping().queue();
					Tools.error(event.getChannel());
				}
	            
	        } 
	        catch (FileNotFoundException e) 
	        {
	            event.getChannel().sendTyping().queue();
	            Tools.error(event.getChannel());
	        }
        }
    	else
    	{
    		Tools.wrongUsage(event.getChannel(), this);
    	}
    }
    
    @Override
    public void runP(List<String> args, PrivateMessageReceivedEvent event) 
    {
    	if(!args.isEmpty()) 
        {
	    	File file = new File("AnnouncementList.txt");
	        Scanner scnr;
	        try 
	        {
	            scnr = new Scanner(file);
	            
	            ArrayList<String> List = new ArrayList<String>();
	            
	            while (scnr.hasNextLine())
	            {
	                List.add(scnr.nextLine());
	            }
	            
	            List.remove(Integer.parseInt(args.get(0)) - 1);
	            
	            FileWriter fWriter;
				try 
				{
					fWriter = new FileWriter("AnnouncementList.txt", true);
							
					for(int i = 0; i < List.size(); i++)
					{
						fWriter.write(List.get(i) + "\n");
					}
			
					fWriter.close();
									
					event.getChannel().sendTyping().queue();
					event.getChannel().sendMessage("Successfully removed announcement").queue();
				} 
				catch (Exception e) 
				{
					event.getChannel().sendTyping().queue();
					Tools.error(event.getChannel());
				}
	            
	        } 
	        catch (FileNotFoundException e) 
	        {
	            event.getChannel().sendTyping().queue();
	            Tools.error(event.getChannel());
	        }
        }
    	else
    	{
    		Tools.wrongUsage(event.getChannel(), this);
    	}
    }


    @Override
    public String getCommand() 
    {
        return "delete_announcement";
    }
    
    @Override
    public String getPCommand() {
        return "delete_announcement";
    }

    @Override
    public String getHelp() 
    {
        return "Allows the removing of announcements!\n" +
                "Usage: `" + Constants.BotPrefix + getCommand() + " <ID of announcement you want to remove>`";
    }
}
