package DaltonChichester.ThirtyOneEBot.Commands;

import DaltonChichester.ThirtyOneEBot.Command;
import DaltonChichester.ThirtyOneEBot.Constants;
import DaltonChichester.ThirtyOneEBot.tools.Tools;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.requests.restaction.MessageAction;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class MedelRack implements Command 
{
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) throws IOException 
    {
    	if(args.size() == 1) 
        {
            String id = args.get(0).replaceAll("<@", "").replaceAll("!", "").replaceAll(">", "");
            Member target = event.getGuild().getMemberById(id);
            
            List<Role> roles = target.getRoles();
            ArrayList<String> medelsNames = new ArrayList<String>();
            int numMedels = 0;
            
            ArrayList<String> medelsNames2 = new ArrayList<String>();
            int numMedels2 = 0;
            
            for(int i = 0; i < roles.size(); i++)
            {  	
            	if(roles.get(i).getName().equals("Bro") ||
            		roles.get(i).getName().equals("Homie") ||	
            		roles.get(i).getName().equals("Real One") ||
            		roles.get(i).getName().equals("Order of the Blade") ||
            		roles.get(i).getName().equals("100th Event Participant") ||
            		roles.get(i).getName().equals("Big Oui Oui") ||
            		roles.get(i).getName().equals("Running Riot") ||
            		roles.get(i).getName().equals("Rampage") ||
            		roles.get(i).getName().equals("RAMBO") ||
            		roles.get(i).getName().equals("Conscientious Objector") ||
            		roles.get(i).getName().equals("Sharpshooter") ||
            		roles.get(i).getName().equals("Gunslinger") ||
            		roles.get(i).getName().equals("First Blood") ||
            		roles.get(i).getName().equals("Assassin") ||
            		roles.get(i).getName().equals("Cannoneer") ||
            		roles.get(i).getName().equals("Collateral") ||
            		roles.get(i).getName().equals("Bombastic") ||
            		roles.get(i).getName().equals("Marksman") ||
            		roles.get(i).getName().equals("Sniper") ||
            		roles.get(i).getName().equals("Chris Kyle") ||
            		roles.get(i).getName().equals("Survivor") ||
            		roles.get(i).getName().equals("Social Maggot") ||
            		roles.get(i).getName().equals("Social Caterpillar") ||
            		roles.get(i).getName().equals("Social Butterfly") ||
            		roles.get(i).getName().equals("Suggester") ||
            		roles.get(i).getName().equals("Helen Keller") ||
            		roles.get(i).getName().equals("Degenerate") ||
            		roles.get(i).getName().equals("Judas") || 
            		roles.get(i).getName().equals("Novice") ||
            		roles.get(i).getName().equals("Apprentice") ||
            		roles.get(i).getName().equals("Master"))
            	{
            		medelsNames.add(roles.get(i).getName());
            		numMedels++;
            	}
            }
            
            for(int i = 0; i < roles.size(); i++)
            {  	
            	if(
            		roles.get(i).getName().equals("Cultural Scholar") ||
            		roles.get(i).getName().equals("MVP") ||
            		roles.get(i).getName().equals("Most Improved") ||
            		roles.get(i).getName().equals("Top Recruiter"))
            	{
            		medelsNames2.add(roles.get(i).getName());
            		numMedels2++;
            	}
            }
            
            if(numMedels == 0 && numMedels2 == 0)
			{
            	event.getChannel().sendTyping().queue();
            	event.getChannel().sendMessage("You have no medals to display!").queue();
			}
			else
			{
            
	            int cols = 3;
	            int rows;
	            
	            float temp = (float) numMedels / cols;   //we assume the no. of rows and cols are known and each chunk has equal width and height
	            
	            double temp2 = (temp - (int)temp);
	
	            int ratio = numMedels%3;
	            
	            if(temp2 > 0)
	            {
	            	rows = (int)temp + 1;
	            }
	            else
	            {
	            	rows = (int)temp;
	            }
	            
	            int chunkWidth, chunkHeight;
	            int type;
	            //fetching image files
	 
	            FileInputStream[] imgFiles;
	            
	            if(ratio == 1)
	            {
	            	numMedels = numMedels+2;
	            	imgFiles = new FileInputStream[numMedels+2];
	            	
	            	imgFiles[0] = new FileInputStream("Blank1_Medal.png");
	            	imgFiles[1] = new FileInputStream(medelsNames.get(0) + "_Medal.png");
	            	imgFiles[2] = new FileInputStream("Blank1_Medal.png");
	            	
	            	for (int i = 1; i < numMedels-2; i++) 
	                {
	                	imgFiles[i+2] = new FileInputStream(medelsNames.get(i) + "_Medal.png");
	                }
	            }
	            else if(ratio == 2)
	            {
	            	numMedels = numMedels+1;
	            	imgFiles = new FileInputStream[numMedels+1];
	            	
	            	imgFiles[0] = new FileInputStream("Blank2_Medal.png");
	            	
	            	for (int i = 0; i < numMedels-1; i++) 
	                {
	                	imgFiles[i+1] = new FileInputStream(medelsNames.get(i) + "_Medal.png");
	                }
	            }
	            else
	            {
	            	imgFiles = new FileInputStream[numMedels];
	            	
	            	for (int i = 0; i < numMedels; i++) 
	                {
	                	imgFiles[i] = new FileInputStream(medelsNames.get(i) + "_Medal.png");
	                }
	            }
	            
	            //creating a bufferd image array from image files
	            BufferedImage[] buffImages = new BufferedImage[numMedels];
	            for (int i = 0; i < numMedels; i++) 
	            {
					buffImages[i] = ImageIO.read(imgFiles[i]);
	            }
	            
	            type = buffImages[numMedels-1].getType();
	            chunkWidth = buffImages[numMedels-1].getWidth();
	            chunkHeight = buffImages[numMedels-1].getHeight();
	            
	            int chunkWidth2 = buffImages[0].getWidth();
	            int chunkHeight2 = buffImages[0].getHeight();
	
	            //Initializing the final image
	            BufferedImage finalImg = new BufferedImage(chunkWidth*cols, chunkHeight*rows, type);
	            finalImg.createGraphics().drawImage(buffImages[0], 0, 0, null);
	            finalImg.createGraphics().drawImage(buffImages[1], chunkWidth2, 0, null);
	            finalImg.createGraphics().drawImage(buffImages[2], chunkWidth2 + chunkWidth, 0, null);
	            
	            if(ratio == 2)
	            {
	            	int num = 3;
	                for (int i = 1; i < rows; i++) 
	                {
	                    for (int j = 0; j < cols; j++) 
	                    {                	
	                    	if(num == numMedels)
	                    	{
	                    		break;
	                    	}
	                    	else
	                    	{
	                    		finalImg.createGraphics().drawImage(buffImages[num], chunkWidth * j, chunkHeight * i, null);
	                            num++;
	                    	}
	                    }
	                }
	            }
	            else
	            {
	            	int num = 0;
	                for (int i = 0; i < rows; i++) 
	                {
	                    for (int j = 0; j < cols; j++) 
	                    {    	
	                    	if(num == numMedels)
	                    	{
	                    		break;
	                    	}
	                    	else
	                    	{
	                    		finalImg.createGraphics().drawImage(buffImages[num], chunkWidth * j, chunkHeight * i, null);
	                            num++;
	                    	}
	                    }
	                }
	            }
	            
	            BufferedImage finalImgWeekly = null;
	            int chunkWidthWeekly = 0, chunkHeightWeekly = 0;
	            int rowsWeekly = 0, colsWeekly = 0; 
	            
	            if(numMedels2 > 0)
	            {
		            colsWeekly = 3;
		            
		            float tempWeekly = (float) numMedels2 / colsWeekly;   //we assume the no. of rows and cols are known and each chunk has equal width and height
		            
		            double temp2Weekly = (tempWeekly - (int)tempWeekly);
		
		            int ratioWeekly = numMedels2%3;
		            
		            if(temp2Weekly > 0)
		            {
		            	rowsWeekly = (int)tempWeekly + 1;
		            }
		            else
		            {
		            	rowsWeekly = (int)tempWeekly;
		            }
		            
		            int typeWeekly;
		            //fetching image files
		 
		            FileInputStream[] imgFilesWeekly;
		            
		            if(ratioWeekly == 1)
		            {
		            	numMedels2 = numMedels2+2;
		            	imgFilesWeekly = new FileInputStream[numMedels2+2];
		            	
		            	imgFilesWeekly[0] = new FileInputStream("Blank1_Medal.png");
		            	imgFilesWeekly[1] = new FileInputStream(medelsNames2.get(0) + "_Medal.png");
		            	imgFilesWeekly[2] = new FileInputStream("Blank1_Medal.png");
		            	
		            	for (int i = 1; i < numMedels2-2; i++) 
		                {
		                	imgFilesWeekly[i+2] = new FileInputStream(medelsNames2.get(i) + "_Medal.png");
		                }
		            }
		            else if(ratioWeekly == 2)
		            {
		            	numMedels2 = numMedels2+1;
		            	imgFilesWeekly = new FileInputStream[numMedels2+1];
		            	
		            	imgFilesWeekly[0] = new FileInputStream("Blank2_Medal.png");
		            	
		            	for (int i = 0; i < numMedels2-1; i++) 
		                {
		                	imgFilesWeekly[i+1] = new FileInputStream(medelsNames2.get(i) + "_Medal.png");
		                }
		            }
		            else
		            {
		            	imgFilesWeekly = new FileInputStream[numMedels2];
		            	
		            	for (int i = 0; i < numMedels2; i++) 
		                {
		                	imgFilesWeekly[i] = new FileInputStream(medelsNames2.get(i) + "_Medal.png");
		                }
		            }
		            
		            //creating a bufferd image array from image files
		            BufferedImage[] buffImagesWeekly = new BufferedImage[numMedels2];
		            for (int i = 0; i < numMedels2; i++) 
		            {
						buffImagesWeekly[i] = ImageIO.read(imgFilesWeekly[i]);
		            }
		            
		            typeWeekly = buffImagesWeekly[numMedels2-1].getType();
		            chunkWidthWeekly = buffImagesWeekly[numMedels2-1].getWidth();
		            chunkHeightWeekly = buffImagesWeekly[numMedels2-1].getHeight();
		            
		            int chunkWidth2Weekly = buffImagesWeekly[0].getWidth();
		            int chunkHeight2Weekly = buffImagesWeekly[0].getHeight();
	            
	
		            //Initializing the final image
		            finalImgWeekly = new BufferedImage(chunkWidthWeekly*colsWeekly, chunkHeightWeekly*rowsWeekly, typeWeekly);
		            finalImgWeekly.createGraphics().drawImage(buffImagesWeekly[0], 0, 0, null);
		            finalImgWeekly.createGraphics().drawImage(buffImagesWeekly[1], chunkWidth2Weekly, 0, null);
		            finalImgWeekly.createGraphics().drawImage(buffImagesWeekly[2], chunkWidth2Weekly + chunkWidthWeekly, 0, null);
		            
		            if(ratioWeekly == 2)
		            {
		            	int numWeekly = 3;
		                for (int i = 1; i < rowsWeekly; i++) 
		                {
		                    for (int j = 0; j < colsWeekly; j++) 
		                    {                	
		                    	if(numWeekly == numMedels2)
		                    	{
		                    		break;
		                    	}
		                    	else
		                    	{
		                    		finalImgWeekly.createGraphics().drawImage(buffImagesWeekly[numWeekly], chunkWidthWeekly * j, chunkHeightWeekly * i, null);
		                            numWeekly++;
		                    	}
		                    }
		                }
		            }
		            else
		            {
		            	int numWeekly = 0;
		                for (int i = 0; i < rowsWeekly; i++) 
		                {
		                    for (int j = 0; j < colsWeekly; j++) 
		                    {    	
		                    	if(numWeekly == numMedels2)
		                    	{
		                    		break;
		                    	}
		                    	else
		                    	{
		                    		finalImgWeekly.createGraphics().drawImage(buffImagesWeekly[numWeekly], chunkWidthWeekly * j, chunkHeightWeekly * i, null);
		                            numWeekly++;
		                    	}
		                    }
		                }
		            }
	            }
	            
	            BufferedImage buffImage2 = ImageIO.read(new FileInputStream("Medal Frame2.png"));
	            BufferedImage buffImage2_1 = ImageIO.read(new FileInputStream("Medal Frame2-1.png"));
	            BufferedImage buffImage2_2 = ImageIO.read(new FileInputStream("Medal Frame2-2.png"));
	            BufferedImage buffImage2_3 = ImageIO.read(new FileInputStream("Medal Frame2-3.png"));
	           
	            int chunkWidth3_1 = buffImage2_1.getWidth();
	            int chunkHeight3_1 = buffImage2_1.getHeight();

	            int chunkHeight3_2 = buffImage2_2.getHeight();

	            int chunkHeight3_3 = buffImage2_3.getHeight();
	            
	            BufferedImage finalImg2 = new BufferedImage((chunkWidth3_1), (chunkHeight3_1 + chunkHeight3_2 + chunkHeight3_3), type);
	            
	            finalImg2.createGraphics().drawImage(buffImage2_1, 0, 0, null);
	            finalImg2.createGraphics().drawImage(buffImage2_2, 0, chunkHeight3_1, null);
	            finalImg2.createGraphics().drawImage(buffImage2_3, 0, (chunkHeight3_1 + chunkHeight3_2), null);
	            finalImg2.createGraphics().drawImage(buffImage2, 0, 0, null);
	            
	            if(numMedels2 > 0)
	            {
	            	finalImg2.createGraphics().drawImage(finalImgWeekly, ((chunkWidth3_1/2) - ((chunkWidthWeekly*3)/2)), (chunkHeight3_1 + ((chunkHeight3_2/2) - ((chunkHeightWeekly*rowsWeekly)/2))), null);
	            }
	            finalImg2.createGraphics().drawImage(finalImg, ((chunkWidth3_1/2) - ((chunkWidth*3)/2)), ((chunkHeight3_1 + chunkHeight3_2) + ((chunkHeight3_3/2) - ((chunkHeight*rows)/2))), null);
	            
	            //System.out.println("Image concatenated.....");
	
				ImageIO.write(finalImg2, "png", new File("31e_Medal_Rack.png"));
            
			
	            EmbedBuilder embed = new EmbedBuilder();
	            File file = new File("31e_Medal_Rack.png");
	            embed.setImage("attachment://31e_Medal_Rack.png")
	                 .setDescription("This is your Ribbon Rack");
	            
	            event.getChannel().sendFile(file).embed(embed.build()).queue();
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
    }

    @Override
    public String getCommand() 
    {
        return "displaymedals";
    }
    
    @Override
    public String getPCommand() 
    {
        return "displaymedals";
    }

    @Override
    public String getHelp() 
    {
        return "See a medal rack of your earned medels!\nUsage: `" + Constants.BotPrefix + getCommand() + " <@User>`";
    }
}
