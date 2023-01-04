package me.fantasticFregata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;

import net.dv8tion.jda.api.entities.TextChannel;

public class Roster {

	//players is an ArrayList of players in the roster being considered
	//channel is the channel to send the message to
	//newChannel is whether or not to delete and remake the channel being considered
	public static void updateRoster(ArrayList<Player> players, TextChannel channel, boolean newChannel) {

		//ArrayList<Player> objects so that the players ArrayList can be broken up by position and ordered alphabetically by tag
		ArrayList<Player> leaders = new ArrayList<Player>();
		ArrayList<Player> advisors = new ArrayList<Player>();
		ArrayList<Player> members = new ArrayList<Player>();
		ArrayList<Player> unflaired = new ArrayList<Player>();
		ArrayList<String> messageToSend = new ArrayList<String>();
		//Compares the player tags, used when sorting players alphabetically
		Comparator<Player> comparator = new Comparator<Player>() {
			public int compare(Player p1, Player p2) {
				return p1.getTag().toLowerCase().compareTo(p2.getTag().toLowerCase());
			}
		};

		// splits arraylist based on position
		for (Player p : players) {
			if (p.getPosition().equalsIgnoreCase("leader")) {
				leaders.add(p);
			} else if (p.getPosition().equalsIgnoreCase("advisor")) {
				advisors.add(p);
			} else if (p.getPosition().equalsIgnoreCase("member")) {
				members.add(p);
			} else if (p.getPosition().equalsIgnoreCase("unflaired")) {
				unflaired.add(p);
			}
		}

		// Sort different arraylists of players
		Collections.sort(leaders, comparator);
		Collections.sort(advisors, comparator);
		Collections.sort(members, comparator);
		Collections.sort(unflaired, comparator);

		// cleans up data in the players arraylist and in the csv file after it's sorted
		players.clear();
		for (Player p : leaders) {
			players.add(p);
		}

		for (Player p : advisors) {
			players.add(p);
		}

		for (Player p : members) {
			players.add(p);
		}

		for (Player p : unflaired) {
			players.add(p);
		}

		//updates CSV file using the players ArrayList
		CSVReadAndWrite.writeDataLineByLine();

		// header for the roster
		messageToSend.add("<:ptm2:827575603695845429> Phantasm Current Roster <:ptm2:827575603695845429>\n\n");

		// if the leaders list has players, then add them with proper formatting
		if (!leaders.isEmpty()) {
			messageToSend.add("**LEADERS**\n");
			for (Player p : leaders) {
				messageToSend.add(p + "\n");
			}
			if (!advisors.isEmpty() || !members.isEmpty() || !unflaired.isEmpty()) {
				messageToSend.add("-\n");
			}
		}

		// if the advisors list has players, then add them with proper formatting
		if (!advisors.isEmpty()) {
			messageToSend.add("**ADVISORS**\n");
			for (Player p : advisors) {
				messageToSend.add(p + "\n");
			}
			if (!members.isEmpty() || !unflaired.isEmpty()) {
				messageToSend.add("-\n");
			}
		}

		// if the members list has players, then add them with proper formatting
		if (!members.isEmpty()) {
			messageToSend.add("**MEMBERS**\n");
			for (Player p : members) {
				messageToSend.add(p + "\n");
			}
			if (!unflaired.isEmpty()) {
				messageToSend.add("-\n");
			}
		}

		// if the unflaired list has players, then add them with proper formatting
		if (!unflaired.isEmpty()) {
			messageToSend.add("**UNFLAIRED**\n");
			for (Player p : unflaired) {
				messageToSend.add(p + "\n");
			}
		}

		if (newChannel) {
			//uses RestAction success consumer to get the new text channel being cloned
			channel.createCopy().setPosition(channel.getPosition()).queue(new Consumer<TextChannel>() {
				@Override
				public void accept(TextChannel t) {
					String msg = "";
					boolean isFirstMessage = true;
					// messageToSend is an ArrayList<String> with each line of the message that I'm
					// trying to send
					for (String s : messageToSend) {
						// msg is the message that I'm sending, this code checks to see if it's within
						// character limits
						if ((msg.length() + s.length()) < 2000) {
							// if it's within limits, add it to the message
							msg += s;
						} else {
							// prints off all text and sets the msg variable to the new string if the length
							// is too long
							// uses gethook if it's the first message, otherwise uses getchannel (for
							// aesthetic purposes)
							if (isFirstMessage) {
								t.sendMessage(msg).queue();
							} else
								t.sendMessage(msg).queue();
							// sets message
							msg = s;
							// updates to change from using gethook to getchannel
							isFirstMessage = false;
						}
					}

					// sends the remaining part of the message
					if (isFirstMessage) {
						t.sendMessage(msg).queue();
					} else
						t.sendMessage(msg).queue();
				}
			});
			
			//deletes the old version of the TextChannel that was cloned
			channel.delete().queue();
		} else {
			String msg = "";
			boolean isFirstMessage = true;
			// messageToSend is an ArrayList<String> with each line of the message that I'm
			// trying to send
			for (String s : messageToSend) {
				// msg is the message that I'm sending, this code checks to see if it's within
				// character limits
				if ((msg.length() + s.length()) < 2000) {
					// if it's within limits, add it to the message
					msg += s;
				} else {
					// prints off all text and sets the msg variable to the new string if the length
					// is too long
					// uses gethook if it's the first message, otherwise uses getchannel (for
					// aesthetic purposes)
					if (isFirstMessage) {
						channel.sendMessage(msg).queue();
					} else
						channel.sendMessage(msg).queue();
					// sets message
					msg = s;
					// updates to change from using gethook to getchannel
					isFirstMessage = false;
				}
			}

			// sends the remaining part of the message
			if (isFirstMessage) {
				channel.sendMessage(msg).queue();
			} else
				channel.sendMessage(msg).queue();
		}
	}

}
