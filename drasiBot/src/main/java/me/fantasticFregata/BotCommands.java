package me.fantasticFregata;

import java.util.ArrayList;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class BotCommands extends ListenerAdapter {

	static ArrayList<Player> players = new ArrayList<Player>();

	/*
	 * DONE: Test NewPlayer AddCharacter AddMVPs RemovePlayer RemoveCharacter SetPR
	 * SetTag RemovePR SetRegion
	 * 
	 * TO-DO: Roster SetPosition
	 */

	@Override
	public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
		
		String name = event.getName();
		TextChannel channel = event.getGuild().getTextChannelsByName("crew-roster", true).get(0);
		
			if (name.equalsIgnoreCase("test")) {

				// delays reply for up to 15 minutes while bot processes
				event.deferReply().queue();

				// Roster.updateRoster(players, channel, true);

				// retrieves the option variable that I added to the commandData in the
				// onGuildReady method
				// String option = event.getOption("testoption").getAsString();

				// .getHook().sendMessage(String str) is used instead of .reply(String str) when
				// deferring reply
				event.getChannel().asTextChannel().getManager().setPosition(2).queue();
				event.getHook().sendMessage("test successful").queue();
			}

			if (name.equalsIgnoreCase("char")) {
				event.deferReply().queue();

				String character = event.getOption("character").getAsString();
				String msg = "";
				boolean flag = false;

				if (CharacterEmojis.characterEmojis.containsKey(character.toLowerCase())) {
					for (String s : CharacterEmojis.characterEmojis.get(character)) {
						msg += s;
					}
					flag = true;
					event.getHook().sendMessage(msg).queue();
				}

				if (!flag) {
					event.getHook().sendMessage("**ERROR:** character not found").queue();
				}
			}

			if (name.equalsIgnoreCase("player")) {
				event.deferReply().queue();
				boolean flag = false;

				for (Player p : players) {
					if (p.getTag().equalsIgnoreCase(event.getOption("tag").getAsString())) {
						event.getHook().sendMessage(p.toString() + " | " + p.getPosition()).queue();
						flag = true;
						break;
					}
				}

				if (!flag) {
					event.getHook().sendMessage("**ERROR:** player not found").queue();
				}
			}

			if (name.equalsIgnoreCase("roster")) {

				// defers reply, sets up blank string to be sent as a message, creates temporary
				// arraylist so that original doesn't get messed with
				event.deferReply().queue();

				// temp array of players to edit and pass to the updateRoster method
				ArrayList<Player> temp = new ArrayList<Player>(players);
				// creates an arraylist of players to delete from the temp array
				ArrayList<Player> playersToDelete = new ArrayList<Player>();

				// if the position option isn't null, it removes all elements that are not of
				// the specified position
				if (event.getOption("position") != null) {
					// adds players that are not the specified position to the arraylist of players
					// to delete
					for (Player p : temp) {
						if (!p.getPosition().equalsIgnoreCase(event.getOption("position").getAsString())) {
							playersToDelete.add(p);
						}
					}
				}

				// if the mvps option isn't null, it removes all players with less than the
				// specified number of mvps
				if (event.getOption("mvps") != null) {
					// adds players below the specified number of mvps to the arraylist of players
					// to delete
					for (Player p : temp) {
						if (p.getMvps() < event.getOption("mvps").getAsInt()) {
							playersToDelete.add(p);
						}
					}
				}

				// if the ispr method is true, it removes players that are not pr'd
				if (event.getOption("ispr") != null) {
					// removes players that are not prd if pr is specified
					if (event.getOption("ispr").getAsBoolean()) {
						for (Player p : temp) {
							if (p.getPR() == null) {
								playersToDelete.add(p);
							}
						}
					}
					// removes players that are prd if not pr is specified
					if (!event.getOption("ispr").getAsBoolean()) {
						for (Player p : temp) {
							if (p.getPR() != null || p.getPR().equals("")) {
								playersToDelete.add(p);
							}
						}
					}
				}

				// removes the playerstodelete arraylist from the temp arraylist
				temp.removeAll(playersToDelete);

				event.getHook().sendMessage("Here you go:").queue();

				Roster.updateRoster(temp, event.getChannel().asTextChannel(), false);
			}
		
		if (name.equalsIgnoreCase("newplayer")) {

			event.deferReply().queue();

			String tag = event.getOption("tag").getAsString();
			String character = CharacterEmojis.charToEmoji(event.getOption("character").getAsString());
			String character2 = (event.getOption("character2") == null) ? ""
					: CharacterEmojis.charToEmoji(event.getOption("character2").getAsString());
			String character3 = (event.getOption("character3") == null) ? ""
					: CharacterEmojis.charToEmoji(event.getOption("character3").getAsString());
			String position = event.getOption("position").getAsString();
			String region = event.getOption("region").getAsString();
			// Integer mvps = 0;
			Integer mvps = (event.getOption("mvps") == null) ? 0 : event.getOption("mvps").getAsInt();
			String pr = (event.getOption("pr") == null) ? "" : event.getOption("pr").getAsString();

			boolean playerFound = true;
			boolean validChar = !character.equals("CHARNOTFOUND") && !character2.equals("CHARNOTFOUND")
					&& !character3.equals("CHARNOTFOUND");

			for (Player p : players) {
				if (p.getTag().equalsIgnoreCase(tag)) {
					playerFound = false;
					break;
				}
			}

			if (playerFound && validChar) {
				players.add(new Player(tag, character, position, region, mvps, pr));
				players.get(players.size() - 1).addCharacter(character2, character3, "");
				event.getHook().sendMessage("Player added!\n" + players.get(players.size() - 1)).queue();
			} else {
				if (!playerFound) {
					event.getHook().sendMessage("**ERROR:** a player already exists with this tag").queue();
				}
				if (!validChar) {
					event.getHook().sendMessage("**ERROR:** invalid character name").queue();
				}
			}

			Roster.updateRoster(players, channel, true);
		}

		if (name.equalsIgnoreCase("addcharacter")) {

			event.deferReply().queue();

			// sets the tag and character
			String tag = event.getOption("tag").getAsString();
			String character = CharacterEmojis.charToEmoji(event.getOption("character").getAsString());

			// this flag checks if there is a Player object with the name inputted
			boolean playerFound = false;
			boolean charAlreadyListed = false;
			boolean validChar = !character.equals("CHARNOTFOUND");

			for (Player p : players) {
				// checks to see if there is a player with the name inputted
				if (p.getTag().equalsIgnoreCase(tag)) {
					playerFound = true;
					// adds the character, if it is not already there
					// sends a success message
					// sets flag to true to signify that the player has been found and changes have
					// been made
					if (!p.getChars().contains(character) && validChar) {
						p.addCharacter(character);
						event.getHook().sendMessage("Done! \n" + p.toString()).queue();
						charAlreadyListed = true;
					}
				}
			}
			// error message if there is no player with the name inputted
			if (!playerFound) {
				event.getHook().sendMessage("**ERROR:** player not found").queue();
			} else if (!charAlreadyListed) {
				event.getHook().sendMessage("**ERROR:** character is already listed").queue();
			} else if (!validChar) {
				event.getHook().sendMessage("**ERROR:** invalid character name").queue();
			}

			Roster.updateRoster(players, channel, true);
		}

		if (name.equalsIgnoreCase("addmvps")) {

			event.deferReply().queue();

			// retrieves tag
			String tag = event.getOption("tag").getAsString();

			boolean flag = false;

			// searches through the player array for a player with the same tag
			for (Player p : players) {
				if (p.getTag().equalsIgnoreCase(tag)) {
					// adds 1 mvp if no parameter is given
					if (event.getOption("number") == null) {
						p.addMvps(1);
						event.getHook().sendMessage("Added 1 mvp to " + tag + "!\n" + p.toString()).queue();
						flag = true;
					} else {
						// retrieves the mvp parameter and adds it to the total
						p.addMvps(event.getOption("number").getAsInt());
						event.getHook().sendMessage("Added " + event.getOption("number").getAsInt() + " mvps to " + tag
								+ "!\n" + p.toString()).queue();
						flag = true;
					}
				}
			}

			// if no player matching the tag parameter is found, sends error message
			if (!flag) {
				event.getHook().sendMessage("**ERROR:** player not found").queue();
			}
			Roster.updateRoster(players, channel, true);
		}

		if (name.equalsIgnoreCase("removeplayer")) {

			event.deferReply().queue();

			boolean flag = false;
			// searches array for a player with the tag, removes them if found
			for (int i = 0; i < players.size(); i++) {
				if (event.getOption("tag").getAsString().equalsIgnoreCase(players.get(i).getTag())) {
					players.remove(i);
					event.getHook().sendMessage("Player removed!").queue();
					flag = true;
				}
			}

			// sends error message if player not found in the array
			if (!flag) {
				event.getHook().sendMessage("**ERROR:** player not found").queue();
			}
			Roster.updateRoster(players, channel, true);
		}

		if (name.equalsIgnoreCase("removecharacter")) {

			event.deferReply().queue();

			boolean flag = false;
			String tag = event.getOption("tag").getAsString();
			String character = CharacterEmojis.charToEmoji(event.getOption("character").getAsString());

			// if a player has a matching tag and character, the character is removed
			for (Player p : players) {
				if (p.getTag().equalsIgnoreCase(tag) && p.getChars().contains(character)) {
					flag = true;
					p.getChars().remove(character);
					event.getHook().sendMessage("Character removed!").queue();
				}
			}

			// sends error message if player not found
			if (!flag) {
				event.getHook().sendMessage("**ERROR:** player or character not found").queue();
			}
			Roster.updateRoster(players, channel, true);
		}

		if (name.equalsIgnoreCase("setpr")) {

			event.deferReply().queue();

			boolean flag = false;

			// if a player has a matching tag, sets PR
			for (Player p : players) {
				if (p.getTag().equalsIgnoreCase(event.getOption("tag").getAsString())) {
					flag = true;
					p.setPR(event.getOption("pr").getAsString());
					event.getHook().sendMessage("PR set! " + p.toString()).queue();
				}
			}

			// if no player is found, sends error message
			if (!flag) {
				event.getHook().sendMessage("**ERROR**: player not found").queue();
			}
			Roster.updateRoster(players, channel, true);
		}

		if (name.equalsIgnoreCase("settag")) {

			event.deferReply().queue();

			boolean flag = false;

			// if the player has a matching old tag, changes to new tag
			for (Player p : players) {
				if (p.getTag().equalsIgnoreCase(event.getOption("oldtag").getAsString())) {
					flag = true;
					p.setTag(event.getOption("newtag").getAsString());
					event.getHook().sendMessage("Tag set! " + p.toString()).queue();
				}
			}

			// if no player is found, sends error message
			if (!flag) {
				event.getHook().sendMessage("**ERROR**: player not found").queue();
			}
			Roster.updateRoster(players, channel, true);
		}

		if (name.equalsIgnoreCase("setposition")) {

			event.deferReply().queue();

			boolean flag = false;

			for (Player p : players) {
				if (p.getTag().equalsIgnoreCase(event.getOption("tag").getAsString())) {
					flag = true;
					p.setPosition(event.getOption("newposition").getAsString());
					event.getHook().sendMessage("Position set! " + p.toString()).queue();
				}
			}

			if (!flag) {
				event.getHook().sendMessage("**ERROR:** player not found").queue();
			}
			Roster.updateRoster(players, channel, true);
		}

		if (name.equalsIgnoreCase("removepr")) {

			event.deferReply().queue();

			boolean flag = false;

			// sets pr to null if the player is found
			for (Player p : players) {
				if (p.getTag().equalsIgnoreCase(event.getOption("tag").getAsString())) {
					flag = true;
					p.setPR(null);
					event.getHook().sendMessage("PR removed! " + p.toString()).queue();
				}
			}

			// if no player is found, sends error message
			if (!flag) {
				event.getHook().sendMessage("**ERROR**: player not found").queue();
			}
			Roster.updateRoster(players, channel, true);
		}

		if (name.equalsIgnoreCase("setregion")) {

			event.deferReply().queue();

			boolean flag = false;

			for (Player p : players) {
				if (p.getTag().equalsIgnoreCase(event.getOption("tag").getAsString())) {
					flag = true;
					p.setRegion(event.getOption("region").getAsString());
					event.getHook().sendMessage("Region set! " + p.toString()).queue();
				}
			}

			if (!flag) {
				event.getHook().sendMessage("**ERROR**: player not found").queue();
			}
			Roster.updateRoster(players, channel, true);
		}

		if (name.equalsIgnoreCase("dogy")) {
			event.deferReply().queue();

			event.getHook().sendMessage("<:dogy:1046896295593398352>").queue();
		}

	}

	@Override
	public void onGuildReady(GuildReadyEvent event) {

		// loads the server token from the .env file and stores it in serverToken
		Dotenv dotenv = Dotenv.load();
		String serverToken = dotenv.get("SERVER_TOKEN");
		String serverToken2 = dotenv.get("SERVER_TOKEN_2");

		// creates an arraylist of commanddata objects, which can be added to
		// Commands.slash(String name, String description) creates a new CommandData
		// object to be added to the arraylist
		// Using .addOption to create more fields that I can use (names must be all
		// lowercase)
		ArrayList<CommandData> commandData = new ArrayList<CommandData>();
		commandData.add(Commands.slash("test", "Test Command").addOption(OptionType.STRING, "testoption",
				"Test required String", false));
		commandData.add(
				Commands.slash("newplayer", "Adds a player").addOption(OptionType.STRING, "tag", "Player's Tag", true)
						.addOption(OptionType.STRING, "character", "Player's Character", true)
						.addOption(OptionType.STRING, "position", "Player's Rank", true)
						.addOption(OptionType.STRING, "region", "Player's Region", true)
						.addOption(OptionType.INTEGER, "mvps", "Player's number of MVPs", false)
						.addOption(OptionType.STRING, "pr", "Player's pr", false)
						.addOption(OptionType.STRING, "character2", "Player's second character", false)
						.addOption(OptionType.STRING, "character3", "Player's third character", false));
		commandData.add(Commands.slash("addcharacter", "Adds a character to the player's profile")
				.addOption(OptionType.STRING, "tag", "Tag of the player to add characters to", true)
				.addOption(OptionType.STRING, "character", "Character to add", true));
		commandData.add(Commands.slash("addmvps", "Adds mvps")
				.addOption(OptionType.STRING, "tag", "Tag of the player to add mvps to", true)
				.addOption(OptionType.INTEGER, "number", "Number of mvps to add; Adds 1 if this field isn't filled out",
						false));
		commandData.add(Commands.slash("removeplayer", "Removes a player").addOption(OptionType.STRING, "tag",
				"Tag of the player to remove", true));
		commandData.add(Commands.slash("removecharacter", "Removes a character from a player's profile")
				.addOption(OptionType.STRING, "tag", "The player's tag", true)
				.addOption(OptionType.STRING, "character", "Name of the character to remove", true));
		commandData.add(Commands.slash("setpr", "Sets the player's PR status")
				.addOption(OptionType.STRING, "tag", "The player's tag", true)
				.addOption(OptionType.STRING, "pr", "What place and in what region?", true));
		commandData.add(Commands.slash("settag", "Changes a player's tag")
				.addOption(OptionType.STRING, "oldtag", "What is the player's old tag?", true)
				.addOption(OptionType.STRING, "newtag", "What's the player's new tag?", true));
		commandData.add(Commands.slash("roster", "Prints out the roster")
				.addOption(OptionType.STRING, "position", "Use this to search for players with a certain position",
						false)
				.addOption(OptionType.INTEGER, "mvps",
						"Use this to search for players with a certain mvp count, >= number provided", false)
				.addOption(OptionType.BOOLEAN, "ispr", "True or false, looks for PR players", false));
		commandData.add(Commands.slash("setposition", "Sets the player's position")
				.addOption(OptionType.STRING, "tag", "The player's tag", true)
				.addOption(OptionType.STRING, "newposition", "The new position of the player", true));
		commandData.add(Commands.slash("removepr", "Removes a player's pr status").addOption(OptionType.STRING, "tag",
				"The player's tag", true));
		commandData.add(Commands.slash("setregion", "Changes a player's region")
				.addOption(OptionType.STRING, "tag", "The player's tag", true)
				.addOption(OptionType.STRING, "region", "The new region", true));
		commandData.add(Commands.slash("dogy", ":)"));
		commandData.add(Commands.slash("player", "Returns information about a player").addOption(OptionType.STRING,
				"tag", "The player's tag", true));
		commandData.add(Commands.slash("char", "Returns a character's alts").addOption(OptionType.STRING, "character",
				"The character you're looking for", true));
		// allows commands only in specific server
		if (event.getGuild().getId().equals(serverToken) || event.getGuild().getId().equals(serverToken2)) { // Server
																												// token
			event.getGuild().updateCommands().addCommands(commandData).queue();
		}
	}

}
