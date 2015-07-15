/**
 * Copyright(C) MediaBridge Company 2015
 * Test.java
 */
package test;

import java.io.File;

import business.impl.ListFileImpl;

/**
 * Class Test to run application
 * 
 * @author Cuong
 *
 */
public class Test {

	/**
	 * Method using to run application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ListFileImpl listFileImpl = new ListFileImpl();

		String pathFile = "";

		/*
		 * if args's length > 0 1: read path file from command-line argument 2.
		 * read list file from that path file else 1.read current path file
		 * 2.read list file from that path file
		 */
		if (args.length > 0) {

			// Browser args array
			for (int i = 0; i < args.length; i++) {

				pathFile = args[i];
				try {

					System.out.println("\n-------List file or folder from: " + args[i] + "------------\n");

					// sleep
					Thread.sleep(500);

					// call method listFile(pathFile) to creat listFile
					File[] lsFile = listFileImpl.listFile(pathFile);

					// print list file
					listFileImpl.printListFile(lsFile);
				} catch (InterruptedException e) {
					System.out.println("Exception main: " + e.getMessage());
				}
			}
		} else {

			// call method getPathCurrentFolder()
			pathFile = listFileImpl.getPathCurrentFolder();

			System.out.println("\n-------Current pathFile:  " + pathFile);

			// call method listFile(pathFile) to create listFile
			File[] lsFile = listFileImpl.listFile(pathFile);

			// print list file
			listFileImpl.printListFile(lsFile);
		}
	}
}
