/**
 * Copyright(C) MediaBridge Company 2015
 * Common.java
 */
package until;

/**
 * Class Common includes Common Method
 * 
 * @author Cuong
 *
 */
public class Common {

	/**
	 * Method using to get extention of file
	 * 
	 * @param pathFile
	 * @return String extention file
	 */
	public static String getExtentionFile(String pathFile, int index) {

		String extention = pathFile.substring(index + 1, pathFile.length());

		// return
		return extention;

	}

	/**
	 * Method using to get index character to substring a String
	 * 
	 * @param pathFile
	 * @param character
	 * @return
	 */
	public static int getIndexOfCharacter(String pathFile, char character) {

		int index = 0;

		for (int i = 0; i < pathFile.length(); i++) {
			if (pathFile.charAt(i) == character) {
				index = i;
			}
		}

		// return
		return index;
	}
}
