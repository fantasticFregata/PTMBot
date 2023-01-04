package me.fantasticFregata;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class DrasiBot {
	public static void main(String[] args) throws Exception {

		// Token is in .env file for privacy reasons
		// This code uses Dotenv to retrieve it and stores it in the String token
		Dotenv dotenv = Dotenv.load();
		String botToken = dotenv.get("BOT_TOKEN");

		// stores the values in the csv file in the arraylist of players
		CSVReadAndWrite.readDataLineByLine();

		JDA api = JDABuilder
				.createDefault(botToken, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT,
						GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_EMOJIS_AND_STICKERS)
				.addEventListeners(new BotCommands()).build();
		
		//method blocks the code underneath until a connection is established, only need if there is code below
		//api.awaitReady();		
		//Use the code below to change the name of the bot on startup
		//api.getSelfUser().getManager().setName("drasiBot").queue();
	}
}
