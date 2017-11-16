package fhl.sptdi.recommendation.io.in.member;

import fhl.sptdi.recommendation.model.Member;

public class MemberImpl implements Member {

	String msno;
	String city;
	int age;
	String gender;
	String registrationMethod;
	String registrationTime;
	String expirationDate;

	@Override
	public String getMsno() {
		return msno;
	}

	@Override
	public String getCity() {
		return city;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public String getRegistrationMethod() {
		return registrationMethod;
	}

	@Override
	public String getRegistrationTime() {
		return registrationTime;
	}

	@Override
	public String getExpirationDate() {
		return expirationDate;
	}

}
