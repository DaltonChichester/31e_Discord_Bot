package DaltonChichester.ThirtyOneEBot;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;

import java.io.IOException;
import java.util.List;

public interface Command 
{
    void run(List<String> args, GuildMessageReceivedEvent event) throws IOException;
    void runP(List<String> args, PrivateMessageReceivedEvent event);
    String getCommand();
	String getPCommand();
    String getHelp();
}