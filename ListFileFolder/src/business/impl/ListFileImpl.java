/**
 * Copyright(C) MediaBridge Company 2015
 * ListFileImpl.java
 */
package business.impl;

import java.io.File;
import business.ListFile;

/**
 * Class ListFileImpl implements ListFile
 * 
 * @author Cuong
 *
 */
public class ListFileImpl implements ListFile {

	/*
	 * (non-Javadoc)
	 * 
	 * @see business.ListFile#listFile(java.lang.String)
	 */
	@Override
	public File[] listFile(String pathFile) {

		// create file
		File folder = new File(pathFile);

		// create list file
		File[] lsFile = null;

		try {

			// get list file from directory
			lsFile = folder.listFiles();

		} catch (Exception e) {
			System.out.println("Exception in listFile: " + e.getMessage());
		}

		// return
		return lsFile;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see business.ListFile#printListFile(java.io.File[])
	 */
	@Override
	public void printListFile(File[] listFile) {
		try {
			for (int i = 0; i < listFile.length; i++) {
				if (listFile[i].isFile()) {
					System.out.println("File:  " + listFile[i].getName());
				} else if (listFile[i].isDirectory()) {
					System.out.println("Directory: " + listFile[i].getName());
				}
			}
		} catch (Exception e) {
			System.out.println("Exception in printFile: " + e.getMessage());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see business.ListFile#getPathCurrentFolder()
	 */
	@Override
	public String getPathCurrentFolder() {
		String path = new File(".").getAbsoluteFile().getParent();
		return path;
	}
}
