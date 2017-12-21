package net.sidglobal.claims;

import org.springframework.batch.item.ItemProcessor;


public class ClaimItemProcessor implements ItemProcessor<Claim,Claim> {
    @Override
    public Claim process(Claim claim) throws Exception {

        if(claim.getClaimId().equals("")||
                claim.getClaimLineId().equals("")||
                claim.getMemberId().equals("")||
                claim.getProviderNpi().equals("")||
                claim.getProviderTypeDesc().equals("")||
                claim.getProviderBilling().equals("")||
                claim.getServiceTypeCode().equals("")||
                claim.getServiceFromDate().equals("")||
                claim.getServiceToDate().equals("")||
                claim.getDateOfPayment().equals("")||
                claim.getAllowedAmount().equals("")||
                claim.getTypeOfBill().equals(""))
            return null;
         else
        return claim ;
    }
}