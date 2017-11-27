package fhl.sptdi.recommendation.io.in.member;

import java.util.Set;

import fhl.sptdi.recommendation.io.in.CsvEntityImporter;
import fhl.sptdi.recommendation.io.in.CsvLine;
import fhl.sptdi.recommendation.model.Member;

public class MemberImporter extends CsvEntityImporter<Member> {

	private Set<String> members;

	public MemberImporter(Set<String> members) {
		this.members = members;
	}

	@Override
	protected Member importEntity(CsvLine line) {
		MemberImpl member = new MemberImpl();
		member.msno = line.getValue(0);
		if (!members.contains(member.getMsno())) {
			return null;
		}
		member.city = line.getValue(1);
		member.age = getAge(line.getValue(2));
		member.gender = line.getValue(3);
		member.registrationMethod = line.getValue(4);
		member.registrationTime = line.getValue(5);
		member.expirationDate = line.getValue(6);
		return member;
	}

	private int getAge(String value) {
		if (value.isEmpty()) {
			return 0;
		}
		return Integer.parseInt(value);
	}

}
