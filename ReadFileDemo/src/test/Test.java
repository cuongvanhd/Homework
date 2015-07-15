/**
 * Copyright(C) MediaBridge Company 2015
 * Test.java
 */
package test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.jdom.Element;

import until.Common;
import business.impl.FileIOImpl;

/**
 * Class Test to test application
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
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			// declare class FileIOImpl's object
			FileIOImpl fileIOImpl = new FileIOImpl();

			String pathFile = null;

			String extension = null;

			String content = null;

			/*
			 * if args.length > 0 then read file from command-line argument else
			 * read file from keyboard
			 */
			if (args.length > 0) {

				for (int i = 0; i < args.length; i++) {
					pathFile = args[i];

					// get index of character
					int index = Common.getIndexOfCharacter(pathFile, '.');

					// get extension in pathFile
					extension = Common.getExtentionFile(pathFile, index);
					try {

						System.out.println("\n-------Read file " + extension + "------------\n");

						switch (extension) {

						case "txt":
							content = fileIOImpl.readFileTxt(pathFile);
							System.out.println(content);
							Thread.sleep(1000);
							break;

						case "doc":
							String[] fileData = fileIOImpl.readDocFile(pathFile);
							fileIOImpl.printValueDocFile(fileData);
							Thread.sleep(1000);
							break;

						case "docx":
							List<XWPFParagraph> paragraphs = fileIOImpl.readDocxFile(pathFile);
							fileIOImpl.printValueDocxFile(paragraphs);
							Thread.sleep(1000);
							break;

						case "xls":
							Iterator<Row> rowIterator = fileIOImpl.readXlsFile(pathFile);
							fileIOImpl.printValueExcel(rowIterator);
							Thread.sleep(1000);
							break;

						case "xlsx":
							Iterator<Row> rowIterator1 = fileIOImpl.readXlsxFile(pathFile);
							fileIOImpl.printValueExcel(rowIterator1);
							Thread.sleep(1000);
							break;

						case "pdf":
							content = fileIOImpl.readPdfFile(pathFile);
							System.out.println(content);
							Thread.sleep(1000);
							break;

						case "xml":
							List<Element> listRoot = fileIOImpl.readXmlFile(pathFile);
							fileIOImpl.printRootXmlFile(listRoot);
							Thread.sleep(1000);
							break;

						default:
							System.out.println("extension not found");
						}

					} catch (InterruptedException e) {
						System.out.println("Exception main - InterruptedException: " + e.getMessage());
					}
				}

			} else {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Please enter the characters: ");
				content = scanner.nextLine();
				System.out.println("The first token: " + content);
			}

		} catch (Exception e) {
			System.out.println("Exception Test: " + e.getMessage());
		}
	}
}
