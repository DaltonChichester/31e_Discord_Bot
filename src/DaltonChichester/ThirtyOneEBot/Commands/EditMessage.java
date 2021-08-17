package DaltonChichester.ThirtyOneEBot.Commands;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DaltonChichester.ThirtyOneEBot.Command;
import DaltonChichester.ThirtyOneEBot.Constants;
import DaltonChichester.ThirtyOneEBot.tools.Tools;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.utils.AttachmentOption;

public class EditMessage implements Command 
{

	@Override
	public void run(List<String> args, GuildMessageReceivedEvent event) throws IOException 
	{
		Member target = event.getMember();
        
        List<Role> roles = target.getRoles();
		for(int i = 0; i < roles.size(); i++)
        {
        	if(roles.get(i).getName().equals("CO") ||
        		roles.get(i).getName().equals("NCO"))
        	{
				if(!args.isEmpty()) 
		        {
					RestAction<Message> messageToEdit = event.getChannel().retrieveMessageById(args.get(0));
					String content = event.getMessage().getContentRaw();
					content = content.replace("$editmessage", "");
					content = content.replace(args.get(0), "");
					
					event.getMessage().delete().queue();
					event.getChannel().editMessageById(args.get(0), content).queue();
		        }
		    	else
		    	{
		    		Tools.wrongUsage(event.getChannel(), this);
		    	}
        	}
        }
	}

	@Override
	public void runS(SlashCommandEvent event) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runP(List<String> args, PrivateMessageReceivedEvent event) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCommand() 
	{
		return "editmessage";
	}

	@Override
	public String getPCommand() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHelp() 
	{
		return "Edit a message: \n"
        		+ "Usage: `" + Constants.BotPrefix + getCommand() + " <Message ID> <New Message>`";
	}

}
