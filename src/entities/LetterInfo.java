package entities;

import java.io.IOException;
import java.util.HashMap;

public class LetterInfo {
	
	static HashMap<String, Integer> letterValues;
	
	public static void initializeLetterInfo() {
		letterValues = new HashMap<String, Integer>();
		letterValues.put("E", 1);
        letterValues.put("T", 1);
        letterValues.put("A", 2);
        letterValues.put("O", 2);
        letterValues.put("I", 2);
        letterValues.put("N", 2);
        letterValues.put("S", 2);
        letterValues.put("H", 2);
        letterValues.put("R", 2);
        letterValues.put("D", 3);
        letterValues.put("L", 3);
        letterValues.put("C", 3);
        letterValues.put("U", 3);
        letterValues.put("M", 3);
        letterValues.put("W", 3);
        letterValues.put("F", 4);
        letterValues.put("G", 4);
        letterValues.put("Y", 4);
        letterValues.put("P", 4);
        letterValues.put("B", 4);
        letterValues.put("V", 5);
        letterValues.put("K", 5);
        letterValues.put("J", 7);
        letterValues.put("X", 7);
        letterValues.put("QU", 8);
        letterValues.put("Z", 8);
        letterValues.put("", 0); // need this for a hack
	}
	
	/**
	 * calculates value of given letter
	 * @param letter the letter
	 * @return the point value of letter
	 */
	public static int getLetterValue(String letter) {
		if (letterValues == null) {
			initializeLetterInfo();
		}
		return letterValues.get(letter).intValue();
	}

}


