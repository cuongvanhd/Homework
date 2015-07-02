/**
 * Copyright(C) MediaBridge Company 2015
 * FileIOImpl.java
 */
package business.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import business.FileIO;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

/**
 * Class FileIOImpl implements FileIO
 * 
 * @author Cuong
 *
 */
public class FileIOImpl implements FileIO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see business.FileIO#ReadFile(java.io.File)
	 */
	@Override
	public String readFileTxt(String pathFile) {

		// create a stringBuilder to take file's line by line
		StringBuilder stringBuilder = new StringBuilder();

		try {

			// connect to pathFile
			FileInputStream fileInputStream = new FileInputStream(pathFile);

			// read file with unicode
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

			// read byte
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			// read row by row
			String line = null;

			// browser file
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line + "\n");
			}

			// close reader
			inputStreamReader.close();

		} catch (IOException e) {
			System.out.println("File not found: " + pathFile);
		}

		// return
		return stringBuilder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see business.FileIO#ReadDocFile(java.lang.String)
	 */
	@SuppressWarnings("resource")
	@Override
	public String[] readDocFile(String pathFile) {

		String[] fileData = null;

		// extract the text from a Word Document
		WordExtractor extractor = null;

		try {

			FileInputStream fis = new FileInputStream(pathFile);

			// This class acts as the bucket that we throw all of the Word data
			// structures into.
			HWPFDocument document = new HWPFDocument(fis);

			extractor = new WordExtractor(document);

			// Get the text from the word file, as an array with one String per
			// paragraph
			fileData = extractor.getParagraphText();

		} catch (OfficeXmlFileException exep) {
			System.out.println("OfficeXmlFileException: " + exep.getMessage());
		} catch (IOException e) {
			System.out.println("File not found: " + pathFile);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		// return
		return fileData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see business.FileIO#ReadDocxFile(java.lang.String)
	 */
	@Override
	public List<XWPFParagraph> readDocxFile(String pathFile) {
		List<XWPFParagraph> paragraphs = new ArrayList<XWPFParagraph>();
		try {
			// File file = new File(pathFile);
			FileInputStream fis = new FileInputStream(pathFile);

			// create XWPFDocument
			XWPFDocument document = new XWPFDocument(fis);

			// get paragraphs
			paragraphs = document.getParagraphs();

			// close FileInputStream
			fis.close();
		} catch (Exception e) {
			System.out.println("ex: " + e.getMessage());
		}
		return paragraphs;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see business.FileIO#ReadPdfFile(java.lang.String)
	 */
	@Override
	public String readPdfFile(String pathFile) {

		String content = "";

		try {
			PdfReader reader = new PdfReader(pathFile);
			System.out.println("This PDF has " + reader.getNumberOfPages() + " pages.");
			content = PdfTextExtractor.getTextFromPage(reader, 1);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		// return
		return content;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see business.FileIO#readXlsFile(java.lang.String)
	 */
	@Override
	public Iterator<Row> readXlsFile(String pathFile) {

		Iterator<Row> rowIterator = null;

		try {

			// File file = new File(pathFile);
			FileInputStream fis = new FileInputStream(pathFile);

			// Create Workbook instance holding reference to .xls file
			HSSFWorkbook wb = new HSSFWorkbook(fis);

			// Get first/desired sheet from the workbook
			HSSFSheet sheet = wb.getSheetAt(0);

			// Iterate through each rows one by one
			rowIterator = sheet.iterator();

		} catch (Exception e) {
			System.out.println("Exception readxls file: " + e.getMessage());
		}

		// return
		return rowIterator;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see business.FileIO#readXlsxFile(java.lang.String)
	 */
	@Override
	public Iterator<Row> readXlsxFile(String pathFile) {

		Iterator<Row> rowIterator = null;

		try {
			FileInputStream file = new FileInputStream(new File("D://Book1.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			rowIterator = sheet.iterator();

			file.close();
		} catch (Exception e) {
			System.out.println("Exception read xlsx file: " + e.getMessage());
		}

		// return
		return rowIterator;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see business.FileIO#printValueExcel(java.util.Iterator)
	 */
	@Override
	public void printValueExcel(Iterator<Row> rowIterator) {

		// brower all row
		while (rowIterator.hasNext()) {

			Row row = rowIterator.next();

			// For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();

			// call method printCellExcel
			printCellExcel(cellIterator);
			System.out.println("");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see business.FileIO#printCellExcel(java.util.Iterator)
	 */
	@Override
	public void printCellExcel(Iterator<Cell> cellIterator) {

		// brower all cell
		while (cellIterator.hasNext()) {

			Cell cell = cellIterator.next();

			// Check the cell type and format accordingly
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				System.out.print(cell.getNumericCellValue() + "\t");
				break;
			case Cell.CELL_TYPE_STRING:
				System.out.print(cell.getStringCellValue() + "\t");
				break;
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see business.FileIO#readXmlFile(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Element> readXmlFile(String pathFile) {

		List<Element> listRoot = new ArrayList<Element>();

		// construct a document with JDOM content
		SAXBuilder builder = new SAXBuilder();

		try {

			// allow access to the root element
			Document document = builder.build(pathFile);

			Element rootNode = document.getRootElement();

			listRoot = rootNode.getChildren("staff");
		} catch (Exception e) {
			// TODO: handle exception
		}

		// return
		return listRoot;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see business.FileIO#printRoot(java.util.List)
	 */
	@Override
	public void printRootXmlFile(List<Element> listRoot) {

		for (int i = 0; i < listRoot.size(); i++) {

			Element node = listRoot.get(i);

			System.out.println("First Name : " + node.getChildText("firstname"));
			System.out.println("Last Name : " + node.getChildText("lastname"));
			System.out.println("Nick Name : " + node.getChildText("nickname"));
			System.out.println("Salary : " + node.getChildText("salary"));
			System.out.println("------------------------------------------");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see business.FileIO#printValueDocFile(java.lang.String[])
	 */
	@Override
	public void printValueDocFile(String[] fileData) {
		for (String string : fileData) {
			System.out.println(string);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see business.FileIO#printValueDocxFile(java.util.List)
	 */
	@Override
	public void printValueDocxFile(List<XWPFParagraph> paragraphs) {
		for (XWPFParagraph xwpfParagraph : paragraphs) {
			System.out.println(xwpfParagraph.getText());
		}
	}
}
