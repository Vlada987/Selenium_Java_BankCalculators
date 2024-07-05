package utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.annotations.Test;

import utility.Excel;

public class GetData {

	public LinkedHashMap<Integer, List<String>> getMapData(String path) throws IOException {

		Excel excel = new Excel(path);
		int rows = excel.getRowCount("Sheet1");
		int coll = excel.getCellCount("Sheet1", 1);

		LinkedHashMap<Integer, List<String>> data = new LinkedHashMap<>();

		for (int a = 1; a <= rows; a++) {
			List<String> dataList = new ArrayList<>();
			for (int b = 0; b < coll; b++) {
				String dat = excel.getCelldata("Sheet1", a, b);

				dataList.add(dat);
				data.put(a, dataList);
			}
		}
		return data;
	}

	public String[][] get2DarrayData(String path) throws IOException {

		Excel excel = new Excel(path);
		int rows = excel.getRowCount("Sheet1");
		int coll = excel.getCellCount("Sheet1", 1);
		String[][] data = new String[rows][coll];

		for (int a = 1; a <= rows; a++) {
			for (int b = 0; b < coll; b++) {
				data[a - 1][b] = excel.getCelldata("Sheet1", a, b);
			}
		}
		return data;
	}

}
