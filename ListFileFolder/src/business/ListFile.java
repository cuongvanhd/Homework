/**
 * Copyright(C) MediaBridge Company 2015
 * ListFile.java
 */
package business;

import com.sun.xml.internal.xsom.impl.ListSimpleTypeImpl;

import java.io.File;
import java.util.ArrayList;

/**
 * Class ListFile include method to list file and folder
 * 
 * @author Cuong
 *
 */
public interface ListFile {

	/**
	 * Method using to get list file in directory
	 * 
	 * @param pathFile
	 * @return listFile
	 */
	public File[] listFile(String pathFile);

	/**
	 * Method using to print list file
	 * 
	 * @param listFile
	 */
	public void printListFile(File[] listFile);

	/**
	 * Method using to get Path Current Folder
	 * 
	 * @return String path
	 */
	public String getPathCurrentFolder();

    /**
     * Method using to check hidden file
     * @param file
     * @return true if file is hidden, false if file is hidden
     */
    public boolean checkHiddenFile(File file);


}
