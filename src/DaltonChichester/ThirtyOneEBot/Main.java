package DaltonChichester.ThirtyOneEBot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

import DaltonChichester.ThirtyOneEBot.Constants;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class Main 
{
	private static final OptionType COMMAND = null;
	private static final OptionType USER = null;
	public static JDA jda;
	public static String prefix = "~";
	
	//Main Method
	public static void main(String[] args) throws LoginException, FileNotFoundException, InterruptedException
	{
		Scanner scanner = new Scanner(new File("Token.txt"));
		
		String data = null;
        String token = null;
		
		while (scanner.hasNextLine()) 
		{
	    	data = scanner.nextLine();
	        token = data.replace(" ", "");
	    }

		JDABuilder builder = JDABuilder.createDefault(token);
		
		builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
		builder.enableIntents(GatewayIntent.GUILD_PRESENCES);
		builder.enableIntents(GatewayIntent.GUILD_VOICE_STATES);
		builder.setChunkingFilter(ChunkingFilter.ALL);
		builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.enableCache(CacheFlag.ACTIVITY);
        builder.enableCache(CacheFlag.VOICE_STATE);
		
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.playing("type " + Constants.BotPrefix + "help for help"));
        
        // Register listeners
        builder.addEventListeners(new Listener());
        
        builder.build();
        
       jda.updateCommands().addCommands(
                new CommandData("help", "Gives you a list of existing commands on this bot!")
                	.addOptions(new OptionData(COMMAND, "command", "The command you would like more information on")),
                new CommandData("displaymedals", "See a medal rack of your earned medels!")
                	.addOptions(new OptionData(USER, "user", "The user you would to view the medal rack of."))
    				);
                
        jda.updateCommands().queue();
	}
}
