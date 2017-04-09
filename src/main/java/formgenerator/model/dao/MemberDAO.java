package formgenerator.model.dao;
import java.util.List;

import formgenerator.model.Member;

public interface MemberDAO {
	
		Member getMember(Integer id);
		Member saveMember(Member member);
		boolean delete(Member member);
		List<Member> getMembers();
		
}
