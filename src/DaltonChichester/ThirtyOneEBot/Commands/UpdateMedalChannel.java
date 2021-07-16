package DaltonChichester.ThirtyOneEBot.Commands;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DaltonChichester.ThirtyOneEBot.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.utils.AttachmentOption;

public class UpdateMedalChannel implements Command 
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
        		//TextChannel textChannel = event.getJDA().getGuildById("758065770927489116").getTextChannelById("763466939846230017");
        		TextChannel textChannel = event.getChannel();
        		
        		event.getMessage().delete().queue();
        		
        		textChannel.sendTyping().queue();
        		//Start
        		
        		textChannel.sendMessage("═══════════════════════════════════\r\n" + 
						"Please post medal requests in #🌟│medal-request.\r\n").queue();
        		
        		//Attendance Medals
	        		textChannel.sendMessage("═══════════════════════════════════\r\n"
	        				+ "**《 ATTENDANCE MEDALS 》**\r\n\n").queue();
	        		
	        		File file = new File("Medals/Bro_Medal.png");
	        		textChannel.sendMessage("> **Bro** : Attend 25 events.").addFile(file).queue();
	        		
	        		file = new File("Medals/Homie_Medal.png");
	        		textChannel.sendMessage("> **Homie** : Attend 50 events.").addFile(file).queue();
	        		
	        		file = new File("Medals/Real One_Medal.png");
	        		textChannel.sendMessage("> **Real One** : Attend 100 events.").addFile(file).queue();
	        		
	        		file = new File("Medals/Committed_Medal.png");
	        		textChannel.sendMessage("> **Committed** : Attend every event hosted in a given month..").addFile(file).queue();
	        		
	        		file = new File("Medals/Novice_Medal.png");
	        		textChannel.sendMessage("> **Novice** : Attend 5 training sessions.").addFile(file).queue();
	        		
	        		file = new File("Medals/Apprentice_Medal.png");
	        		textChannel.sendMessage("> **Apprentice** : Attend 10 training sessions.").addFile(file).queue();
	        		
	        		file = new File("Medals/Master_Medal.png");
	        		textChannel.sendMessage("> **Master** : Attend 20 training sessions.").addFile(file).queue();
	        		
	        		file = new File("Medals/Diligent_Medal.png");
	        		textChannel.sendMessage("> **Diligent** : Attend every training hosted in a given month.").addFile(file).queue();
	        		
	        		file = new File("Medals/Order of the Blade_Medal.png");
	        		textChannel.sendMessage("> **Order of the Blade** : Attend 5 melee training sessions and pass the melee evaluation.").addFile(file).queue();
	        		
	        		file = new File("Medals/100th Event Participant_Medal.png");
	        		textChannel.sendMessage("> **100th Event Partcipant** : Attend the regiment's 100th event.").addFile(file).queue();
	        		
	        	//Combat Medals
	        		textChannel.sendMessage("═══════════════════════════════════\r\n"
	        								+ "> **《 COMBAT MEDALS 》**\r\n\n").queue();
	        		
	        		file = new File("Medals/Big Oui Oui_Medal.png");
	        		textChannel.sendMessage("> **Big Oui Oui** : Get 10 kills or more during a single event.").addFile(file).queue();
	        		
	        		file = new File("Medals/Running Riot_Medal.png");
	        		textChannel.sendMessage("> **Running Riot** : Get 15 kills or more during a single event.").addFile(file).queue();
	        		
	        		file = new File("Medals/Rampage_Medal.png");
	        		textChannel.sendMessage("> **Rampage** : Get 5 kills during **All Charge**.").addFile(file).queue();
	        		
	        		file = new File("Medals/RAMBO_Medal.png");
	        		textChannel.sendMessage("> **RAMBO** : Be the last person alive on the team and get 5 kills.").addFile(file).queue();
	        		
	        		file = new File("Medals/Conscientious Objector_Medal.png");
	        		textChannel.sendMessage("> **Conscientious Objector** : Land 5 shots in a round but don't get a kill.").addFile(file).queue();
	        		
	        		file = new File("Medals/Sharpshooter_Medal.png");
	        		textChannel.sendMessage("> **Sharpshooter** : Get a 150m+ kill with a musket.").addFile(file).queue();

	        		file = new File("Medals/Gunslinger_Medal.png");
	        		textChannel.sendMessage("> **Gunslinger** : Get a 50m+ kill with a pistol *(Public Server Ok).*").addFile(file).queue();
	        		
	        		file = new File("Medals/First Blood_Medal.png");
	        		textChannel.sendMessage("> **First Blood** : Get the first kill in a round.").addFile(file).queue();
	        		
	        		file = new File("Medals/Assassin_Medal.png");
	        		textChannel.sendMessage("> **Assassin** : Kill **[Nr. 9] Getty**, **[TRRB] CrypticMercy**, **[45e] TheDancingPiper**, or **[Nr. 22] Fires** in an event round.").addFile(file).queue();
	        		
	        		file = new File("Medals/Assassinated_Medal.png");
	        		textChannel.sendMessage("> **Assassinated** : Get killed by a teammate in a different regiment.").addFile(file).queue();
	        		
	        		file = new File("Medals/Wounded_Medal.png");
	        		textChannel.sendMessage("> **Wounded** : Get shot and live in at least three different rounds in one event.").addFile(file).queue();
        		
	        	//Artillery Medals
	        		textChannel.sendMessage("═══════════════════════════════════\r\n"
	        								+ "**《 ARTILLERY MEDALS 》**\r\n\n").queue();
	        		
	        		file = new File("Medals/Cannoneer_Medal.png");
	        		textChannel.sendMessage("> **Cannoneer** : Kill an enemy with a cannon from 300m+ away.").addFile(file).queue();
	        		
	        		file = new File("Medals/Collateral_Medal.png");
	        		textChannel.sendMessage("> **Collateral** : Kill 5 people with one shot from a cannon.").addFile(file).queue();
	        		
	        		file = new File("Medals/Bombastic_Medal.png");
	        		textChannel.sendMessage("> **Bombastic** : Kill 10 people with one shot from a cannon.").addFile(file).queue();
        		
	        	//Skirmisher Medals
	        		textChannel.sendMessage("═══════════════════════════════════\r\n"
	        								+ "**《 SKIRMISHER MEDALS 》**\r\n\n").queue();
	        		
	        		file = new File("Medals/Marksman_Medal.png");
	        		textChannel.sendMessage("> **Marksman** : Get 10 kills or more during a single event.").addFile(file).queue();
	        		
	        		file = new File("Medals/Sniper_Medal.png");
	        		textChannel.sendMessage("> **Sniper** : Get 15 kills or more during a single event.").addFile(file).queue();
	        		
	        		file = new File("Medals/Chris Kyle_Medal.png");
	        		textChannel.sendMessage("> **Chris Kyle** : Get a 180m+ kill with a rifle.").addFile(file).queue();
	        		
	        	//Misc Medals
	        		textChannel.sendMessage("═══════════════════════════════════\r\n"
	        								+ "**《 MISC. MEDALS 》**\r\n\n").queue();
	        		
	        		file = new File("Medals/Survivor_Medal.png");
	        		textChannel.sendMessage("> **Survivor** : Be the last person alive in our line.").addFile(file).queue();
	        		
	        		file = new File("Medals/Social Maggot_Medal.png");
	        		textChannel.sendMessage("> **Social Maggot** : Recruit 5 people who attend at least one event.").addFile(file).queue();
	        		
	        		file = new File("Medals/Social Caterpillar_Medal.png");
	        		textChannel.sendMessage("> **Social Caterpillar** : Recruit 10 people who attend at least one event.").addFile(file).queue();
        		
	        		file = new File("Medals/Social Butterfly_Medal.png");
	        		textChannel.sendMessage("> **Social Butterfly** : Recruit 20 people who attend at least one event.").addFile(file).queue();
	        		
	        		file = new File("Medals/Suggester_Medal.png");
	        		textChannel.sendMessage("> **Suggester** : Submit 5 suggestions in #📮│suggestion-box and have them be accepted.").addFile(file).queue();

	        		file = new File("Medals/Cultural Scholar_Medal.png");
	        		textChannel.sendMessage("> **Cultural Scholar** : Winner of the monthly 31e cultural Kahoot session.").addFile(file).queue();
	        		
	        		file = new File("Medals/Receptionist_Medal.png");
	        		textChannel.sendMessage("> **Receptionist** : Be the first to welcome someone new to the discord 10 times").addFile(file).queue();
	        	//End
	        		textChannel.sendMessage("═══════════════════════════════════\r\n" + 
							"Check out your medal rack in #🤖│bot-commands by typing \r\n `$displaymedals`\r\n" + 
							"═══════════════════════════════════\r\n").queue();
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
		return "updatemedalchannel";
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
		// TODO Auto-generated method stub
		return null;
	}

}
