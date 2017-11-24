package fhl.sptdi.recommendation.io.in;

import java.util.function.Function;

public abstract class CsvImporter<R> implements Function<CsvLine, R> {

	@Override
	public final R apply(CsvLine line) {
		return importEntity(line);
	}

	protected abstract R importEntity(CsvLine line);

}
