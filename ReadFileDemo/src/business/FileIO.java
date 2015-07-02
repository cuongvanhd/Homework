/**
 * Copyright(C) MediaBridge Company 2015
 * FileIO.java
 */
package business;

import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.jdom.Element;

/**
 * Class FileIO includes File's basic method
 * 
 * @author Cuong
 *
 */
public interface FileIO {

	/**
	 * Method using to read file
	 * 
	 * @param pathFile
	 * @return String
	 */
	public String readFileTxt(String pathFile);

	/**
	 * 
	 * Method using to read file.doc
	 * 
	 * @param pathFile
	 * @return String[] fileData
	 */
	public String[] readDocFile(String pathFile);

	/**
	 * Method using to read file.docx
	 * 
	 * @param pathFile
	 * @return List<XWPFParagraph> paragraphs
	 */
	public List<XWPFParagraph> readDocxFile(String pathFile);

	/**
	 * Method using to read file Pdf
	 * 
	 * @param pathFile
	 * @return String
	 */
	public String readPdfFile(String pathFile);

	/**
	 * Method using to read file.xls
	 * 
	 * @param String
	 *            pathFile
	 * @return Iterator<Row>
	 */
	public Iterator<Row> readXlsFile(String pathFile);

	/**
	 * 
	 * Method using to read file.xlsx
	 * 
	 * @param String
	 *            pathFile
	 */
	public Iterator<Row> readXlsxFile(String pathFile);

	/**
	 * 
	 * Method using to print value excel file
	 * 
	 * @param Iterator
	 *            <Row> rows
	 */
	public void printValueExcel(Iterator<Row> rows);

	/**
	 * 
	 * Method using to print cell in excel file
	 * 
	 * @param Iterator
	 *            <Cell> cellIterator
	 */
	public void printCellExcel(Iterator<Cell> cellIterator);

	/**
	 * Method using to read file xml
	 * 
	 * @param pathFile
	 * @return List Element
	 */
	public List<Element> readXmlFile(String pathFile);

	/**
	 * Method using to print root
	 * 
	 * @param List
	 *            <Element> listRoot
	 */
	public void printRootXmlFile(List<Element> listRoot);

	/**
	 * Method using to print value doc file
	 * 
	 * @param String
	 *            [] fileData
	 */
	public void printValueDocFile(String[] fileData);

	/**
	 * Method using to print value docx file
	 * 
	 * @param (List<XWPFParagraph> paragraphs
	 */
	public void printValueDocxFile(List<XWPFParagraph> paragraphs);
}
