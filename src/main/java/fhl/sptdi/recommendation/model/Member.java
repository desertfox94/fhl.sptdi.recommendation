package fhl.sptdi.recommendation.model;

import fhl.sptdi.recommendation.io.in.CsvEntity;

public interface Member extends CsvEntity {

	public static final String DATE_FORMAT = "yyyyMMdd";

	String getExpirationDate();

	String getRegistrationTime();

	String getRegistrationMethod();

	String getGender();

	/**
	 * Note: this column has outlier values, please use your judgement.
	 * 
	 * @return
	 */
	int getAge();

	String getCity();

	String getMsno();

	default @Override String getId() {
		return getMsno();
	}

}
