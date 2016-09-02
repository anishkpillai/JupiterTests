package com.jupiter.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Table {
	
	protected WebElement table;
	
	public Table(WebElement table) {
		this.table = table;
	}

	public WebElement getCellElement(String findColumn, String findText, String returnColumn) throws Exception {
		List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));
		int findColumnIndex = getColumnIndex(findColumn);
		int findReturnColumnIndex = getColumnIndex(returnColumn);
		for (int row=0;row<rows.size();row++) 
		{
			List<WebElement> columns = rows.get(row).findElements(By.tagName("td"));
			if (columns.get(findColumnIndex).getText().equals(findText))
			{
				return columns.get(findReturnColumnIndex);
			}
		}
		throw new Exception("Unable to find cell with text: "+findText);
	}
	
	protected int getColumnIndex(String heading) throws Exception {
		List<WebElement> tableHeadings = table.findElements(By.tagName("th"));
		for(int index=0; index<tableHeadings.size();index++) {
			if(tableHeadings.get(index).getText().equals(heading)) {
				return index;
			}
		}
		throw new Exception("Unable to find column with header text: "+heading);
	}
}
