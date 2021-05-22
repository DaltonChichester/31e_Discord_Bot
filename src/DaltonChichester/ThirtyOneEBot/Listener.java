package DaltonChichester.ThirtyOneEBot;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.IOException;

import javax.annotation.Nonnull;

import DaltonChichester.ThirtyOneEBot.tools.AnnouncementMaker;

public class Listener extends ListenerAdapter {

    public final Manager m = new Manager();

    @Override
    public void onReady(@Nonnull ReadyEvent event)
    {
        //System.out.println(event.getJDA().getSelfUser().getName() + " is online!");
        //TextChannel textChannel = event.getJDA().getGuildById("827273975624630332").getTextChannelsByName("general", true).get(0);
    	//textChannel.sendTyping().queue();
    	//textChannel.sendMessage(event.getJDA().getSelfUser().getName() + " is online!").queue();
    	
    	//AnnouncementMaker.AnnouncementChecker(event);
    }

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) 
    {
        if(event.getMessage().getContentRaw().equalsIgnoreCase(Constants.BotPrefix+"shutdown") && event.getAuthor().getIdLong()==Constants.OWNERID) 
        {
        	TextChannel textChannel = event.getJDA().getGuildById("827273975624630332").getTextChannelsByName("general", true).get(0);
        	textChannel.sendTyping().queue();
        	textChannel.sendMessage(event.getJDA().getSelfUser().getName() + " is shutting down!").queue();
        	
            event.getJDA().shutdown();
            System.exit(0);
        }
        
        try {
			m.run(event);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Override
    public void onPrivateMessageReceived(@Nonnull PrivateMessageReceivedEvent event)
    {
    	System.out.println("Received private message from " + event.getAuthor() + ", saying: " + event.getMessage().getContentRaw());
    	m.runP(event);
    }
}