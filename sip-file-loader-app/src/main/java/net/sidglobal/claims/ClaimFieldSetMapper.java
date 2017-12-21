package net.sidglobal.claims;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * Created by rohit on 10/1/2017.
 */
public class ClaimFieldSetMapper implements FieldSetMapper<Claim> {
    @Override
    public Claim mapFieldSet(FieldSet fieldSet) throws BindException {

        Claim claim =new Claim();
        claim.setClaimId(fieldSet.readRawString("claim_id"));
        claim.setClaimLineId(fieldSet.readRawString("claim_line_id"));
        claim.setMemberId(fieldSet.readRawString("person_id"));
        claim.setProviderNpi(fieldSet.readRawString("prv_npi"));
        claim.setProviderTypeDesc(fieldSet.readRawString("prv_type_desc"));
        claim.setProviderBilling(fieldSet.readRawString("prv_tin"));
        claim.setProviderNetworkStatus(fieldSet.readRawString("prv_in_network_flag"));
        claim.setServicePostalCode(fieldSet.readRawString("svc_pos_code"));
        claim.setServiceIcdProc1(fieldSet.readRawString("svc_diag_1_code"));
        claim.setServiceIcdProc2(fieldSet.readRawString("svc_diag_2_code"));
        claim.setServiceIcdProc3(fieldSet.readRawString("svc_diag_3_code"));
        claim.setServiceIcdProc4(fieldSet.readRawString("svc_diag_4_code"));
        claim.setServiceIcdProc5(fieldSet.readRawString("svc_diag_5_code"));
        claim.setServiceIcdProc6(fieldSet.readRawString("svc_diag_6_code"));
        claim.setServiceIcdProc7(fieldSet.readRawString("svc_diag_7_code"));
        claim.setServiceProcedureType(fieldSet.readRawString("svc_procedure_type"));
        claim.setServiceProcedureCode(fieldSet.readRawString("svc_procedure_code"));
        claim.setServiceRevenueCode(fieldSet.readRawString("svc_rev_code"));
        claim.setServiceCptCode(fieldSet.readRawString("svc_cpt_code"));
        claim.setServiceIcdProc1(fieldSet.readRawString("svc_icd_proc_1_code"));
        claim.setServiceIcdProc2(fieldSet.readRawString("svc_icd_proc_2_code"));
        claim.setServiceIcdProc3(fieldSet.readRawString("svc_icd_proc_3_code"));
        claim.setServiceIcdProc4(fieldSet.readRawString("svc_icd_proc_4_code"));
        claim.setServiceIcdProc5(fieldSet.readRawString("svc_icd_proc_5_code"));
//        claim.setServiceIcdProc6(fieldSet.readRawString("svc_icd_proc_6_code"));
//        claim.setServiceIcdProc7(fieldSet.readRawString("svc_icd_proc_7_code"));
        claim.setServiceModifierCpt4Code(fieldSet.readRawString("svc_modifier_code"));
        claim.setServiceTypeCode(fieldSet.readRawString("svc_tos_code"));
        claim.setServiceIpDays(fieldSet.readRawString("svc_ip_days"));
        claim.setServiceAdmitType(fieldSet.readRawString("svc_admit_type"));
        claim.setServiceFromDate(fieldSet.readRawString("svc_service_frm_date"));
        claim.setServiceToDate(fieldSet.readRawString("svc_service_to_date"));
//        claim.setDischargeCode(fieldSet.readRawString(""));
        claim.setDateOfPayment(fieldSet.readRawString("paid_date"));
//        claim.setDischargeDate(fieldSet.readRawString(""));
        claim.setAllowedAmount(fieldSet.readRawString("allowed_amt"));
        claim.setPaidAmount(fieldSet.readRawString("paid_amt"));
        claim.setPayType(fieldSet.readRawString("pay_type"));
        claim.setTypeOfBill(fieldSet.readRawString("pay_type"));







        return claim;
    }
}
