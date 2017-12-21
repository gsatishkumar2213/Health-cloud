package net.sidglobal.claims;

import java.util.Date;

/**
 * Created by rohit on 9/24/2017.
 */
public class Claim {

    private  String  claimId;
    private  String  claimLineId;
    private  String  memberId;
    private  String  providerNpi;
    private  String  providerTypeDesc;
    private  String  providerBilling;
    private  String  providerNetworkStatus;
    private  String  servicePostalCode;
    private  String  serviceIcdProc1;
    private  String  serviceIcdProc2;
    private  String  serviceIcdProc3;
    private  String  serviceIcdProc4;
    private  String  serviceIcdProc5;
    private  String  serviceIcdProc6;
    private  String  serviceIcdProc7;
    private  String  serviceProcedureType;
    private  String  serviceProcedureCode;
    private  String  serviceRevenueCode;
    private  String  serviceCptCode;
    private String   serviceIcdProcCode1;
    private String   serviceIcdProcCode2;
    private String   serviceIcdProcCode3;
    private String   serviceIcdProcCode4;
    private String   serviceIcdProcCode5;
//    private String   serviceIcdProcCode6;
//    private String   serviceIcdProcCode7;
    private String   serviceModifierCpt4Code;
    private String   serviceTypeCode;
    private String      serviceIpDays;
    private String   serviceAdmitType;
    private String     serviceFromDate;
    private String     serviceToDate;
//    private String   dischargeCode;
//    private String     dischargeDate;
    private String     dateOfPayment;
    private String   allowedAmount;
    private String   paidAmount;
    private String   payType;
    private String   typeOfBill;

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public String getClaimLineId() {
        return claimLineId;
    }

    public void setClaimLineId(String claimLineId) {
        this.claimLineId = claimLineId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getProviderNpi() {
        return providerNpi;
    }

    public void setProviderNpi(String providerNpi) {
        this.providerNpi = providerNpi;
    }

    public String getProviderTypeDesc() {
        return providerTypeDesc;
    }

    public void setProviderTypeDesc(String providerTypeDesc) {
        this.providerTypeDesc = providerTypeDesc;
    }

    public String getProviderBilling() {
        return providerBilling;
    }

    public void setProviderBilling(String providerBilling) {
        this.providerBilling = providerBilling;
    }

    public String getProviderNetworkStatus() {
        return providerNetworkStatus;
    }

    public void setProviderNetworkStatus(String providerNetworkStatus) {
        this.providerNetworkStatus = providerNetworkStatus;
    }

    public String getServicePostalCode() {
        return servicePostalCode;
    }

    public void setServicePostalCode(String servicePostalCode) {
        this.servicePostalCode = servicePostalCode;
    }

    public String getServiceIcdProc1() {
        return serviceIcdProc1;
    }

    public void setServiceIcdProc1(String serviceIcdProc1) {
        this.serviceIcdProc1 = serviceIcdProc1;
    }

    public String getServiceIcdProc2() {
        return serviceIcdProc2;
    }

    public void setServiceIcdProc2(String serviceIcdProc2) {
        this.serviceIcdProc2 = serviceIcdProc2;
    }

    public String getServiceIcdProc3() {
        return serviceIcdProc3;
    }

    public void setServiceIcdProc3(String serviceIcdProc3) {
        this.serviceIcdProc3 = serviceIcdProc3;
    }

    public String getServiceIcdProc4() {
        return serviceIcdProc4;
    }

    public void setServiceIcdProc4(String serviceIcdProc4) {
        this.serviceIcdProc4 = serviceIcdProc4;
    }

    public String getServiceIcdProc5() {
        return serviceIcdProc5;
    }

    public void setServiceIcdProc5(String serviceIcdProc5) {
        this.serviceIcdProc5 = serviceIcdProc5;
    }

    public String getServiceIcdProc6() {
        return serviceIcdProc6;
    }

    public void setServiceIcdProc6(String serviceIcdProc6) {
        this.serviceIcdProc6 = serviceIcdProc6;
    }

    public String getServiceIcdProc7() {
        return serviceIcdProc7;
    }

    public void setServiceIcdProc7(String serviceIcdProc7) {
        this.serviceIcdProc7 = serviceIcdProc7;
    }

    public String getServiceProcedureType() {
        return serviceProcedureType;
    }

    public void setServiceProcedureType(String serviceProcedureType) {
        this.serviceProcedureType = serviceProcedureType;
    }

    public String getServiceProcedureCode() {
        return serviceProcedureCode;
    }

    public void setServiceProcedureCode(String serviceProcedureCode) {
        this.serviceProcedureCode = serviceProcedureCode;
    }

    public String getServiceRevenueCode() {
        return serviceRevenueCode;
    }

    public void setServiceRevenueCode(String serviceRevenueCode) {
        this.serviceRevenueCode = serviceRevenueCode;
    }

    public String getServiceCptCode() {
        return serviceCptCode;
    }

    public void setServiceCptCode(String serviceCptCode) {
        this.serviceCptCode = serviceCptCode;
    }

    public String getServiceIcdProcCode1() {
        return serviceIcdProcCode1;
    }

    public void setServiceIcdProcCode1(String serviceIcdProcCode1) {
        this.serviceIcdProcCode1 = serviceIcdProcCode1;
    }

    public String getServiceIcdProcCode2() {
        return serviceIcdProcCode2;
    }

    public void setServiceIcdProcCode2(String serviceIcdProcCode2) {
        this.serviceIcdProcCode2 = serviceIcdProcCode2;
    }

    public String getServiceIcdProcCode3() {
        return serviceIcdProcCode3;
    }

    public void setServiceIcdProcCode3(String serviceIcdProcCode3) {
        this.serviceIcdProcCode3 = serviceIcdProcCode3;
    }

    public String getServiceIcdProcCode4() {
        return serviceIcdProcCode4;
    }

    public void setServiceIcdProcCode4(String serviceIcdProcCode4) {
        this.serviceIcdProcCode4 = serviceIcdProcCode4;
    }

    public String getServiceIcdProcCode5() {
        return serviceIcdProcCode5;
    }

    public void setServiceIcdProcCode5(String serviceIcdProcCode5) {
        this.serviceIcdProcCode5 = serviceIcdProcCode5;
    }

//    public String getServiceIcdProcCode6() {
//        return serviceIcdProcCode6;
//    }
//
//    public void setServiceIcdProcCode6(String serviceIcdProcCode6) {
//        this.serviceIcdProcCode6 = serviceIcdProcCode6;
//    }
//
//    public String getServiceIcdProcCode7() {
//        return serviceIcdProcCode7;
//    }
//
//    public void setServiceIcdProcCode7(String serviceIcdProcCode7) {
//        this.serviceIcdProcCode7 = serviceIcdProcCode7;
//    }

    public String getServiceModifierCpt4Code() {
        return serviceModifierCpt4Code;
    }

    public void setServiceModifierCpt4Code(String serviceModifierCpt4Code) {
        this.serviceModifierCpt4Code = serviceModifierCpt4Code;
    }

    public String getServiceTypeCode() {
        return serviceTypeCode;
    }

    public void setServiceTypeCode(String serviceTypeCode) {
        this.serviceTypeCode = serviceTypeCode;
    }

    public String getServiceIpDays() {
        return serviceIpDays;
    }

    public void setServiceIpDays(String serviceIpDays) {
        this.serviceIpDays = serviceIpDays;
    }

    public String getServiceAdmitType() {
        return serviceAdmitType;
    }

    public void setServiceAdmitType(String serviceAdmitType) {
        this.serviceAdmitType = serviceAdmitType;
    }

    public String getServiceFromDate() {
        return serviceFromDate;
    }

    public void setServiceFromDate(String serviceFromDate) {
        this.serviceFromDate = serviceFromDate;
    }

    public String getServiceToDate() {
        return serviceToDate;
    }

    public void setServiceToDate(String serviceToDate) {
        this.serviceToDate = serviceToDate;
    }

//    public String getDischargeCode() {
//        return dischargeCode;
//    }
//
//    public void setDischargeCode(String dischargeCode) {
//        this.dischargeCode = dischargeCode;
//    }
//
//    public String getDischargeDate() {
//        return dischargeDate;
//    }
//
//    public void setDischargeDate(String dischargeDate) {
//        this.dischargeDate = dischargeDate;
//    }

    public String getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(String dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getAllowedAmount() {
        return allowedAmount;
    }

    public void setAllowedAmount(String allowedAmount) {
        this.allowedAmount = allowedAmount;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getTypeOfBill() {
        return typeOfBill;
    }

    public void setTypeOfBill(String typeOfBill) {
        this.typeOfBill = typeOfBill;
    }
}
