package me.fantasticFregata;

import java.util.ArrayList;

public class Player {

	private String tag;
	private ArrayList<String> chars = new ArrayList<String>();
	private String region;
	private String position;
	private Integer mvps;
	private String pr;

	public Player(String tag, String charName, String position, String region, Integer mvps, String pr) {
		this.tag = tag;
		this.chars.add(charName);
		setPosition(position);
		this.region = region;
		this.mvps = mvps;
		this.pr = pr;
	}

	// for creating players from string[] in csv
	public Player(String[] parameters) {
		tag = parameters[0];
		region = parameters[1];
		position = parameters[2];
		pr = parameters[3];
		mvps = Integer.parseInt(parameters[4]);
		for (int i = 5; i < parameters.length; i++) {
			chars.add(parameters[i]);
		}

	}

	// Mvp methods

	// Adds input number of mvps
	public void addMvps(int num) {
		mvps += num;
	}

	// Makes sure mvp wont go negative and then subtracts the input number
	public void subtractMvps(int num) {
		if (mvps >= num) {
			mvps--;
		}
	}

	// returns number of mvps
	public int getMvps() {
		return mvps;
	}

	// Character methods

	// Checks to make sure the character isn't already in the arraylist and then
	// adds them
	public void addCharacter(String a, String b, String c) {
		if (chars.indexOf(a) == -1 && !a.equals("")) {
			chars.add(a);
		}
		if (chars.indexOf(b) == -1 && !b.equals("")) {
			chars.add(b);
		}
		if (chars.indexOf(c) == -1 && !c.equals("")) {
			chars.add(c);
		}
	}

	public void addCharacter(String a) {
		addCharacter(a, "", "");
	}

	// finds the position of the target string and then deletes it (may have an
	// issue with capitalization)
	public void removeCharacter(String target) {
		int position = chars.indexOf(target);
		if (position != -1) {
			chars.remove(position);
		}
	}

	// returns arraylist of characters
	public ArrayList<String> getChars() {
		return chars;
	}

	// Tag methods

	// changes tag to inputted string
	public void setTag(String a) {
		tag = a;
	}

	// return tag
	public String getTag() {
		return tag;
	}

	// position methods

	// sets position to leader, advisor, member, or unflaired
	public void setPosition(String pos) {
		if (pos.equalsIgnoreCase("leader")) {
			position = "leader";
		} else if (pos.equalsIgnoreCase("advisor")) {
			position = "advisor";
		} else if (pos.equalsIgnoreCase("member")) {
			position = "member";
		} else if (pos.equalsIgnoreCase("unflaired")) {
			position = "unflaired";
		} else
			position = "member";
	}

	// returns position
	public String getPosition() {
		return position;
	}

	// region methods

	// sets region
	public void setRegion(String reg) {
		region = reg;
	}

	// returns region
	public String getRegion() {
		return region;
	}

	// pr methods

	// sets pr
	public void setPR(String power) {
		pr = power;
	}

	// returns pr
	public String getPR() {
		return pr;
	}

	// for writing back to the csv file
	public String[] toStringArray() {
		// creates new string array of size 5 plus the number of characters the player
		// plays
		String[] arr = new String[5 + chars.size()];

		// sets indexes according to the csv format
		arr[0] = tag;
		arr[1] = region;
		arr[2] = position;
		arr[3] = pr;
		if (mvps != null) {
			arr[4] = mvps.toString();
		} else
			arr[4] = null;
		// adds the characters in the order they are in chars
		for (int i = 0; i < chars.size(); i++) {
			arr[i + 5] = chars.get(i);
		}

		// returns array
		return arr;
	}

	// toString method
	// returns a string in the form of "[region] [tag] [characters] | x[mvps]" need
	// to work on implementing emojis
	public String toString() {
		String msg = region + " " + tag;
		for (String s : chars) {
			msg += " " + s;
		}
		if ((mvps != null && mvps != 0) || (pr != null && !pr.equals(""))) {
			msg += " |";
		}
		if (mvps != null && mvps != 0) {
			msg += " <:ptm2:827575603695845429> x" + mvps;
		}
		if (pr != null && !pr.equals("")) {
			msg += " [" + pr + "]";
		}
		return msg;
	}
}
