package fhl.sptdi.recommendation.io.in;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CSVImport {

	private static int row;

	public static <R extends CsvEntity> Map<String, R> importFromFile(File file, CsvEntityImporter<R> importer) throws IOException {
		importFromFile(file, (CsvImporter<R>) importer);
		return importer.getOverall();
	}

	public static <R> List<R> importFromFile(File file, CsvImporter<R> importer) throws IOException {
		List<R> result = new LinkedList<>();
		row = 0;
		BufferedReader reader = new BufferedReader(new FileReader(file));
		reader.lines().forEach(s -> {
			if (row++ != 0) {
				result.add(importer.apply(new CsvLine(s, row)));
			}
		});
		reader.close();
		return result;
	}

}
