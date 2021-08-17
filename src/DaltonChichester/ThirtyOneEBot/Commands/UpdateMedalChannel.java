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
import net.dv8tion.jda.api.entities.MessageHistory;
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
        String filePathRibbon = "31eMedals/RibbonRack/";
        String filePathMedal = "31eMedals/RibbonMedal/";
        String ribbon = "_Ribbon.png";
        String medal = "_Medal.png";
        
        for(int i = 0; i < roles.size(); i++)
        {
        	if(roles.get(i).getName().equals("CO") ||
        		roles.get(i).getName().equals("NCO"))
        	{
        		//TextChannel textChannel = event.getJDA().getGuildById("758065770927489116").getTextChannelById("763466939846230017");
        		TextChannel textChannel = event.getChannel();
        		
        		MessageHistory history = new MessageHistory(textChannel);
        		
        		event.getMessage().delete().queue();
        		
        		List<Message> messages = history.retrievePast(100).complete();
        		textChannel.deleteMessages(messages).queue();
        		
        		textChannel.sendTyping().queue();
        		//Start
        		
        		textChannel.sendMessage("═══════════════════════════════════\r\n").queue();
        		textChannel.sendMessage("https://i.gyazo.com/370bec206f12b4e9952b528937b103f7.gif\r\n").queue();
        		
        		textChannel.sendMessage("═══════════════════════════════════\n"
        				+"**《 REGIMENTAL RECORDS 》**\n"

        				+"Most kills as a regiment during 1 round:\n"
        				+"✎ 30 Kills on 1/20/21\n"

        				+"Most kills by a single person during 1 round:\n"
        				+"✎ 9 Kills by Donuts\n"

        				+"Longest kill shot by any member:\n"
        				+"✎ 192.3M by TheElGato\n").queue();
        		
        		textChannel.sendMessage("═══════════════════════════════════\r\n" + 
						"Please post medal requests in #🌟│medal-request.\r\n").queue();
        		
        		//Attendance Medals
	        		textChannel.sendMessage("═══════════════════════════════════\r\n"
	        				+ "**《 ATTENDANCE MEDALS 》**\r\n\n").queue();
	        		
	        		File file = new File(filePathRibbon + "Bro" + ribbon);
	        		textChannel.sendMessage("> **Bro** : Attend 25 events.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Homie" + ribbon);
	        		textChannel.sendMessage("> **Homie** : Attend 50 events.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Real One" + ribbon);
	        		textChannel.sendMessage("> **Real One** : Attend 100 events.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Reliable" + ribbon);
	        		textChannel.sendMessage("> **Reliable** : Attend every event hosted in a given week.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Committed" + ribbon);
	        		textChannel.sendMessage("> **Committed** : Attend every event hosted in a given month.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Novice" + ribbon);
	        		textChannel.sendMessage("> **Novice** : Attend 5 training sessions.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Apprentice" + ribbon);
	        		textChannel.sendMessage("> **Apprentice** : Attend 10 training sessions.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Master" + ribbon);
	        		textChannel.sendMessage("> **Master** : Attend 20 training sessions.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Diligent" + ribbon);
	        		textChannel.sendMessage("> **Diligent** : Attend every training hosted in a given month.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Order of the Blade" + ribbon);
	        		textChannel.sendMessage("> **Order of the Blade** : Attend 5 melee training sessions and pass the melee evaluation.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Stomper" + ribbon);
	        		textChannel.sendMessage("> **Stomper** : Attend _three_ 31e hosted Pub Stomps.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "100th Event Participant" + ribbon);
	        		textChannel.sendMessage("> **100th Event Partcipant** : Attend the regiment's 100th event.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Chinese Expedition" + ribbon);
	        		textChannel.sendMessage("> **Chinese Expedition** : Attend the Chinese Event.").addFile(file).queue();

	        		
	        	//Combat Medals
	        		textChannel.sendMessage("═══════════════════════════════════\r\n"
	        								+ "**《 COMBAT MEDALS 》**\r\n\n").queue();
	        		
	        		file = new File(filePathRibbon + "First Blood" + ribbon);
	        		textChannel.sendMessage("> **First Blood** : Get the first kill in a round.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Wounded" + ribbon);
	        		textChannel.sendMessage("> **Wounded** : Get shot and live in at least three different rounds in one event.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Conscientious Objector" + ribbon);
	        		textChannel.sendMessage("> **Conscientious Objector** : Land 5 shots in a round but don't get a kill.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Rampage" + ribbon);
	        		textChannel.sendMessage("> **Rampage** : Get 5 kills during **All Charge**.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Survivor" + ribbon);
	        		textChannel.sendMessage("> **Survivor** : Be the last person alive in our line.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "RAMBO" + ribbon);
	        		textChannel.sendMessage("> **RAMBO** : Be the last person alive on the team and get 5 kills.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Anti-Cav" + ribbon);
	        		textChannel.sendMessage("> **Anti-Cav** : Get 3 cavalry kills while performing cav circle in one event.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Assassin" + ribbon);
	        		textChannel.sendMessage("> **Assassin** : Kill **[Nr. 9] Getty**, **[TRRB] CrypticMercy**, **[45e] TheDancingPiper**, or **[Nr. 22] Fires** in an event round.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Assassinated" + ribbon);
	        		textChannel.sendMessage("> **Assassinated** : Get killed by a teammate in a different regiment.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Terracotta Medalion" + ribbon);
	        		textChannel.sendMessage("> **Terracotta Medalion** : Attend the Chinese Event and end a round in the top 5.").addFile(file).queue();

        		
	        	//Line Infantry Medals
	        		textChannel.sendMessage("═══════════════════════════════════\r\n"
	        								+ "**《 LINE INFANTRY MEDALS 》**\r\n\n").queue();
	        		
	        		file = new File(filePathRibbon + "Big Oui Oui" + ribbon);
	        		textChannel.sendMessage("> **Big Oui Oui** : Get 10 kills or more during a single event.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Running Riot" + ribbon);
	        		textChannel.sendMessage("> **Running Riot** : Get 15 kills or more during a single event.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Sharpshooter" + ribbon);
	        		textChannel.sendMessage("> **Sharpshooter** : Get a 150m+ kill with a musket.").addFile(file).queue();

	        		
		        	//Skirmisher Medals
	        		textChannel.sendMessage("═══════════════════════════════════\r\n"
	        								+ "**《 SKIRMISHER MEDALS 》**\r\n\n").queue();
	        		
	        		file = new File(filePathRibbon + "Marksman" + ribbon);
	        		textChannel.sendMessage("> **Marksman** : Get 10 kills or more during a single event.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Sniper" + ribbon);
	        		textChannel.sendMessage("> **Sniper** : Get 15 kills or more during a single event.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Chris Kyle" + ribbon);
	        		textChannel.sendMessage("> **Chris Kyle** : Get a 180m+ kill with a rifle.").addFile(file).queue();
	        		
	        		
	        	//Artillery Medals
	        		textChannel.sendMessage("═══════════════════════════════════\r\n"
	        								+ "**《 ARTILLERY MEDALS 》**\r\n\n").queue();
	        		
	        		file = new File(filePathRibbon + "Collateral" + ribbon);
	        		textChannel.sendMessage("> **Collateral** : Kill 5 people with one shot from a cannon.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Bombastic" + ribbon);
	        		textChannel.sendMessage("> **Bombastic** : Kill 10 people with one shot from a cannon.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Cannoneer" + ribbon);
	        		textChannel.sendMessage("> **Cannoneer** : Kill an enemy with a cannon from 300m+ away.").addFile(file).queue();
	        		
	        		//Auxiliary Medals
	        		textChannel.sendMessage("═══════════════════════════════════\r\n"
	        								+ "**《 AUXILIARY MEDALS 》**\r\n\n").queue();
	        		
	        		file = new File(filePathRibbon + "Gunslinger" + ribbon);
	        		textChannel.sendMessage("> **Gunslinger** : Get a 50m+ kill with a pistol *(Public Server Ok).*").addFile(file).queue();

	        	//Misc Medals
	        		textChannel.sendMessage("═══════════════════════════════════\r\n"
	        								+ "**《 MISC. MEDALS 》**\r\n\n").queue();
	        		
	        		file = new File(filePathRibbon + "Social Maggot" + ribbon);
	        		textChannel.sendMessage("> **Social Maggot** : Recruit 5 people who attend at least one event.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Social Caterpillar" + ribbon);
	        		textChannel.sendMessage("> **Social Caterpillar** : Recruit 10 people who attend at least one event.").addFile(file).queue();
        		
	        		file = new File(filePathRibbon + "Social Butterfly" + ribbon);
	        		textChannel.sendMessage("> **Social Butterfly** : Recruit 20 people who attend at least one event.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Suggester" + ribbon);
	        		textChannel.sendMessage("> **Suggester** : Submit 5 suggestions in #📮│suggestion-box and have them be accepted.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Receptionist" + ribbon);
	        		textChannel.sendMessage("> **Receptionist** : Be the first to welcome someone new to the Discord 10 times.").addFile(file).queue();
	        		
	        		
	        		//Special Medals
	        		textChannel.sendMessage("═══════════════════════════════════\r\n"
	        								+ "**《 SPECIAL MEDALS 》**\r\n\n").queue();
	        		
	        		file = new File(filePathRibbon + "MVP" + ribbon);
	        		textChannel.sendMessage("> **MVP** : Given by the Officer Corp to award those that distinguish themselves amongst their peers.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Most Improved" + ribbon);
	        		textChannel.sendMessage("> **Most Improved** : Given by the Officer Corp to award those that show the most improvement amongst their peers.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Top Recruiter" + ribbon);
	        		textChannel.sendMessage("> **Top Recruiter** : Winner of the monthly 31e Recruiting Competition.").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Cultural Scholar" + ribbon);
	        		textChannel.sendMessage("> **Cultural Scholar** : Winner of the monthly 31e Cultural Kahoot session.").addFile(file).queue();
	        		
	        		
	        		//Secret Medals
	        		textChannel.sendMessage("═══════════════════════════════════\r\n"
	        								+ "**《 SECRET MEDALS 》**\r\n\n").queue();
	        		
	        		file = new File(filePathRibbon + "Helen Keller" + ribbon);
	        		textChannel.sendMessage("> **Helen Keller** : ???").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Judas" + ribbon);
	        		textChannel.sendMessage("> **Judas** : ???").addFile(file).queue();
	        		
	        		file = new File(filePathRibbon + "Degenerate" + ribbon);
	        		textChannel.sendMessage("> **Degenerate** : ???").addFile(file).queue();
	        		
	        	//End
	        		textChannel.sendMessage("═══════════════════════════════════\r\n" + 
							"Check out your medal rack in #🤖│bot-commands by typing \r\n"
							+ " `$displaymedals`\r\n" + 
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
