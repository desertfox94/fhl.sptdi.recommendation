package fhl.sptdi.recommendation.io.in;

import java.util.HashMap;
import java.util.Map;

public abstract class CsvEntityImporter<R extends CsvEntity> extends CsvImporter<R> {

	protected final Map<String, R> overall = new HashMap<>();

	public Map<String, R> getOverall() {
		return overall;
	}

}
