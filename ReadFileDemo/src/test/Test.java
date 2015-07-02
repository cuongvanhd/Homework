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

import business.impl.FileIOImpl;

/**
 * class Test to test application
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

			String content = null;

			// declare funcion variable
			int function;
			while (true) {
				Scanner scanner = new Scanner(System.in);

				System.out.print("\n Close programer,press 0");
				System.out.print("\n Read text file, press 1");
				System.out.print("\n Read doc file, press 2");
				System.out.print("\nRead docx file press 3");
				System.out.print("\nRead pdf file, press 4");
				System.out.print("\nRead xls file, press 5");
				System.out.print("\nRead xlsx file, press 6");
				System.out.print("\nRead xml file, press 7");
				System.out.print("\n---------------*******************------------------");

				function = scanner.nextInt();

				switch (function) {
				case 0:
					System.exit(0);
					break;

				case 1:
					pathFile = "D://Bộ thủ.txt";
					content = fileIOImpl.readFileTxt(pathFile);
					System.out.println(content);
					break;

				case 2:
					pathFile = "D://kanji.doc";
					String[] fileData = fileIOImpl.readDocFile(pathFile);
					fileIOImpl.printValueDocFile(fileData);
					break;

				case 3:
					pathFile = "D://履歴書ー英語・日本語.docx";
					List<XWPFParagraph> paragraphs = fileIOImpl.readDocxFile(pathFile);
					fileIOImpl.printValueDocxFile(paragraphs);
					break;

				case 4:
					pathFile = "D://JQuery.pdf";
					content = fileIOImpl.readPdfFile(pathFile);
					System.out.println(content);
					break;

				case 5:
					pathFile = "D://Book1.xls";
					Iterator<Row> rowIterator = fileIOImpl.readXlsFile(pathFile);
					fileIOImpl.printValueExcel(rowIterator);
					break;

				case 6:
					pathFile = "D://Book1.xlsx";
					Iterator<Row> rowIterator1 = fileIOImpl.readXlsxFile(pathFile);
					fileIOImpl.printValueExcel(rowIterator1);
					break;

				case 7:
					pathFile = "D://file.xml";
					List<Element> listRoot = fileIOImpl.readXmlFile(pathFile);
					fileIOImpl.printRootXmlFile(listRoot);
					break;

				default:
					System.out.println("Please choose 1 - 7!");
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Exception Test: " + e.getMessage());
		}
	}
}
