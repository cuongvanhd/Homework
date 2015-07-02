/**
 * Copyright(C) MediaBridge Company 2015
 * Test.java
 */
package test;

import java.io.File;
import java.lang.reflect.Array;
import java.text.Collator;
import java.util.*;

import business.impl.ListFileImpl;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.directory.shared.ldap.codec.compare.CompareRequestCodec;

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

            // list file revert of ls command
            ArrayList<File> fileRevertLs = new ArrayList<File>();

			// call method getPathCurrentFolder()
			pathFile = listFileImpl.getPathCurrentFolder();

                 System.out.println("\n-------Current pathFile:  " + pathFile);

                 // call method listFile(pathFile) to create listFile
                 File[] lsFile = listFileImpl.listFile(pathFile);

            System.out.println(" ------ls command-----------");
            for (int i = 0; i < lsFile.length; i++) {
                if(!listFileImpl.checkHiddenFile(lsFile[i])){
                    System.out.println(lsFile[i].getName());

                    // add file revert into arrayList
                    fileRevertLs.add(lsFile[i]);
                }
            }



            System.out.println("ls-----");
            for (File fs : fileRevertLs){
                System.out.println(fs.getName());
            } 

            /**
             * ls -r start
             */
            System.out.println("------ls -r:---------");
             Collections.reverse(fileRevertLs);
            for(File file: fileRevertLs){
                System.out.println(file.getName());
            }
            // ls -r end

            /**
             * ls -a start
             */
            System.out.println(" ------ls -a command----------");
            listFileImpl.printListFile(lsFile);
            // ls -a command end


            /**
             * ls -t start
             */
            System.out.println(" ls -t ----------");
            Arrays.sort(lsFile, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {

                    if(o1.lastModified() > o2.lastModified()){
                        return 1;
                    }

                    return 0;
                }
            });

            // print arrays
            for (int i = 0; i <lsFile.length ; i++) {
                if(!listFileImpl.checkHiddenFile(lsFile[i])){
                    System.out.println("File:  "+ lsFile[i].getName());
                }

            }
            // ls - t end


            /**
             * revert file: ls -t of revert
             */
            System.out.println("ls -t revert-----------");

            ArrayList<File> listFileLsT = new ArrayList<File>();

            // add list list into arrayList
            for (int i = 0; i < lsFile.length ; i++) {
                if(!listFileImpl.checkHiddenFile(lsFile[i])){
                    listFileLsT.add(lsFile[i]);
                }
            }

            // revert
            Collections.reverse(listFileLsT);

            // print
            for (File ls : listFileLsT){
                System.out.println(ls.getName());
            }
        }
	}
}
