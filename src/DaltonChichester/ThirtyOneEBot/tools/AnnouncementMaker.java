package DaltonChichester.ThirtyOneEBot.tools;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AnnouncementMaker
{	
	public static void AnnouncementChecker(ReadyEvent event)
    {
		LocalDateTime now = LocalDateTime.now();
		
		DayOfWeek dayOfWeek = DayOfWeek.from(now);
		
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
            
            for(int i = 0; i < List.size(); i++)
            {     	
            	String[] line = List.get(i).split("\\|");
	
            	String[] days = line[0].split("\\s");
            	int hour = Integer.parseInt(line[1]);
            	int minute = Integer.parseInt(line[2]);         	
            	int reactions = Integer.parseInt(line[3]);
            	String message = line[4];
            	
            	String[] unicodeEmoji = {"✅", "💣", "🎯"};

            	
            	for(int ii = 0; ii < days.length; ii++)
                {
            		if(dayOfWeek == DayOfWeek.valueOf(days[ii]))
            		{
            			System.out.println("Announcement Day Match");
            			now = LocalDateTime.now();
            	        LocalDateTime nextAnnouncement = now.withHour(hour).withMinute(minute).withSecond(0);
            	        
            	        // if it's already past the time the Announcement will be scheduled for the next day
            	        if (now.compareTo(nextAnnouncement) > 0) 
            	        {
            	        	break;
            	        	//nextAnnouncement = nextAnnouncement.plusDays(1);
            	        }
            	        
            	        // duration between now and the beginning of the next Announcement
            	        Duration durationUntilAnnouncement = Duration.between(now, nextAnnouncement);
            	        // in seconds
            	        long initialDelayAnnouncement = durationUntilAnnouncement.getSeconds();
            	        System.out.println("Time till posting: " + durationUntilAnnouncement);
            	        
            	        // schedules the reminder at a fixed rate of one day
            	        ScheduledExecutorService schedulerAnnouncement = Executors.newScheduledThreadPool(1);
            	        schedulerAnnouncement.scheduleAtFixedRate(() -> 
            	        {  
            	            JDA jda = event.getJDA();
            	            for (Guild guild : jda.getGuilds()) 
            	            {
            	                guild.getDefaultChannel().sendMessage(message).queue(reactMesage -> 
            	                {
            	                    for(int iii = 0; iii < reactions; iii++) 
            	                    {
            	                    	reactMesage.addReaction(unicodeEmoji[iii]).queue();
            	                    }
            	                });
            	                
            	                System.out.println("Posted Announcement");
            	            }
            	         }, initialDelayAnnouncement, TimeUnit.DAYS.toSeconds(1), TimeUnit.SECONDS);
            		}
        		}
            }  
        } 
        catch (FileNotFoundException e) 
        {
        }
    }
	
	public static void AnnouncementChecker(GuildMessageReceivedEvent event)
    {
		LocalDateTime now = LocalDateTime.now();
		
		DayOfWeek dayOfWeek = DayOfWeek.from(now);
		
		File file = new File("AnnouncementList.txt");
        Scanner scnr;
        try 
        {
        	ScheduledExecutorService schedulerAnnouncement = Executors.newScheduledThreadPool(1);
        	schedulerAnnouncement.shutdownNow();
        	System.out.println("Resetting Announcements");
        	
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
            
            for(int i = 0; i < List.size(); i++)
            {
            	String[] line = List.get(i).split("\\|");
            	
            	String[] days = line[0].split("\\s");
            	int hour = Integer.parseInt(line[1]);
            	int minute = Integer.parseInt(line[2]);
            	int reactions = Integer.parseInt(line[3]);
            	String message = line[4];
            	
            	String[] unicodeEmoji = {"✅", "💣", "🎯"};

            	for(int ii = 0; ii < days.length; ii++)
                {
            		if(dayOfWeek == DayOfWeek.valueOf(days[ii]))
            		{
            			System.out.println("Announcement Day Match");
            			now = LocalDateTime.now();
            	        LocalDateTime nextAnnouncement = now.withHour(hour).withMinute(minute).withSecond(0);
            	        
            	        // if it's already past the time the Announcement will be scheduled for the next day
            	        if (now.compareTo(nextAnnouncement) > 0) 
            	        {
            	        	break;
            	        	//nextAnnouncement = nextAnnouncement.plusDays(1);
            	        }
            	        
            	        // duration between now and the beginning of the next Announcement
            	        Duration durationUntilAnnouncement = Duration.between(now, nextAnnouncement);
            	        // in seconds
            	        long initialDelayAnnouncement = durationUntilAnnouncement.getSeconds();
            	        System.out.println("Time till posting: " + durationUntilAnnouncement);
            	        
            	        // schedules the reminder at a fixed rate of one day
            	        ScheduledExecutorService schedulerAnnouncement2 = Executors.newScheduledThreadPool(1);
            	        schedulerAnnouncement2.scheduleAtFixedRate(() -> 
            	        {  
            	            JDA jda = event.getJDA();
            	            for (Guild guild : jda.getGuilds()) 
            	            {
            	                guild.getDefaultChannel().sendMessage(message).queue(reactMesage -> 
            	                {
            	                    for(int iii = 0; iii < reactions; iii++) 
            	                    {
            	                    	reactMesage.addReaction(unicodeEmoji[iii]).queue();
            	                    }
            	                });
            	                
            	                System.out.println("Posted Announcement");
            	            }
            	         }, initialDelayAnnouncement, TimeUnit.DAYS.toSeconds(1), TimeUnit.SECONDS);
            		}
        		}
            }  
        } 
        catch (FileNotFoundException e) 
        {
        }
    }
}
