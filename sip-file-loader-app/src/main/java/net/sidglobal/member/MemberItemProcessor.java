package net.sidglobal.member;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class MemberItemProcessor implements ItemProcessor<Member, Member> {
    @Override
    public Member process(Member member) throws Exception {

        if(member.getPersonId().equals("") ||
                member.getPlanTypeCode().equals("") ||
                member.getPlanTypeDesc().equals("") ||
                member.getMedEffDate().equals("") ||
                member.getMedTermDate().equals("") ||
                member.getPrvPcpNPI().equals("") ||
                member.getMbrRiskscore().equals(""))
        return null;
        else
            return  member;
    }
}
