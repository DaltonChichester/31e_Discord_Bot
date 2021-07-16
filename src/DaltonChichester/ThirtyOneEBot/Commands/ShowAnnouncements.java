package DaltonChichester.ThirtyOneEBot.Commands;

import DaltonChichester.ThirtyOneEBot.Command;
import DaltonChichester.ThirtyOneEBot.Constants;
import DaltonChichester.ThirtyOneEBot.tools.Tools;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShowAnnouncements implements Command 
{
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) 
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
            
            EmbedBuilder e = new EmbedBuilder()
                    .setTitle("A list of all announcements:");

            for(int i = 0; i < List.size(); i++)
            {
                e.addField("ID: " + String.valueOf(i+1) + ": ", List.get(i), false);
            }       
            
            event.getChannel().sendMessage(e.build()).queue();
        } 
        catch (FileNotFoundException e) 
        {
            event.getChannel().sendTyping().queue();
            Tools.error(event.getChannel());
        }
    }
    
    @Override
    public void runP(List<String> args, PrivateMessageReceivedEvent event) 
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
            
            EmbedBuilder e = new EmbedBuilder()
                    .setTitle("A list of all announcements:");

            for(int i = 0; i < List.size(); i++)
            {
                e.addField("ID: " + String.valueOf(i+1) + ": ", List.get(i), false);
            }       

            event.getChannel().sendMessage(e.build()).queue();
        } 
        catch (FileNotFoundException e) 
        {
            event.getChannel().sendTyping().queue();
            Tools.error(event.getChannel());
        }
    }

    @Override
    public String getCommand() 
    {
        return "show_announcements";
    }
    
    @Override
    public String getPCommand() 
    {
        return "show_announcements";
    }

    @Override
    public String getHelp() 
    {
        return "blarg!\n"
        		+ "Usage: `" + Constants.BotPrefix + getCommand() + "`";
    }

	@Override
	public void runS(SlashCommandEvent event) {
		// TODO Auto-generated method stub
		
	}
}
