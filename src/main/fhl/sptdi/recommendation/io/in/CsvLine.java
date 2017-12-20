package main.fhl.sptdi.recommendation.io.in;

public class CsvLine {

	private final String[] data;

	private int row;

	CsvLine(String data, int row) {
		this.data = data.split(",");
		this.row = row;
	}

	public String getValue(int column) {
		if (column < 0 || column > data.length) {
			System.err.println("No valid data column!");
			return null;
		}
		return data[column].trim();
	}

	public int getRow() {
		return row;
	}

}
