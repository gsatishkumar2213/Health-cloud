package net.sidglobal.claims;

import net.sidglobal.util.ResourceInfo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.FileSystemResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class ClaimConfig {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Qualifier("dataSource")
    @Autowired
    public DataSource dataSource;

    @Bean
    @Scope("prototype")
    public FlatFileItemReader<Claim> readerClaim() {
        FlatFileItemReader<Claim> reader = new FlatFileItemReader<>();
        reader.setLinesToSkip(1);


        reader.setResource(new FileSystemResource(System.getProperty(ResourceInfo.FILE_PATH)));

        reader.setLineMapper(new DefaultLineMapper<Claim>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                if ( System.getProperty(ResourceInfo.FILE_HEADER, null) != null ) {
                    setNames(System.getProperty(ResourceInfo.FILE_HEADER).split(","));
                } else {
                    setNames(new String[]{"claimId", "claimLineId", "memberId", "providerNpi", "providerTypeDesc", "providerBilling", "providerNetworkStatus", "servicePostalCode", "serviceIcdProc1", "serviceIcdProc2", "serviceIcdProc3", "serviceIcdProc4", "serviceIcdProc5", "serviceIcdProc6", "serviceIcdProc7", "serviceProcedureType",
                            "serviceProcedureCode", "serviceRevenueCode", "serviceCptCode", "serviceIcdProcCode1", "serviceIcdProcCode2", "serviceIcdProcCode3", "serviceIcdProcCode4", "serviceIcdProcCode5", "serviceModifierCpt4Code", "serviceTypeCode", "serviceIpDays", "serviceAdmitType", "serviceFromDate", "serviceToDate",
                             "dateOfPayment", "allowedAmount", "paidAmount", "payType", "typeOfBill"});
                }}});
            setFieldSetMapper( new ClaimFieldSetMapper() );
        }});
        return reader;
    }

    @Bean
    public ClaimItemProcessor processorClaim() {
        return new ClaimItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Claim> writerClaim() {
        JdbcBatchItemWriter<Claim> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Claim>());
        writer.setSql("INSERT INTO claims (claim_id,claim_line_id,mbr_id,prv_npi,prv_type_desc,prv_tin,prv_in_network_flag, svc_pos_code,svc_diag_1_code,svc_diag_2_code,svc_diag_3_code,svc_diag_4_code,svc_diag_5_code,svc_procedure_type, svc_procedure_code,svc_rev_code,svc_cpt_code,svc_icd_proc_1_code,svc_icd_proc_2_code,svc_icd_proc_3_code,svc_icd_proc_4_code,svc_icd_proc_5_code,svc_modifier_code,svc_tos_code,svc_ip_days,svc_admit_type,svc_service_frm_date,svc_service_to_date,Paid_date ,Allowed_amt, Paid_amt,Pay_type,bill_type_code) VALUES (:claimId, :claimLineId, :memberId, :providerNpi, :providerTypeDesc, :providerBilling, :providerNetworkStatus, :servicePostalCode, :serviceIcdProc1,:serviceIcdProc2,:serviceIcdProc3,:serviceIcdProc4,:serviceIcdProc5, :serviceProcedureType, :serviceProcedureCode, :serviceRevenueCode, :serviceCptCode, :serviceIcdProcCode1,:serviceIcdProcCode2,:serviceIcdProcCode3,:serviceIcdProcCode4,:serviceIcdProcCode5, :serviceModifierCpt4Code, :serviceTypeCode, :serviceIpDays, :serviceAdmitType, :serviceFromDate, :serviceToDate, :dateOfPayment, :allowedAmount, :paidAmount, :payType, :typeOfBill)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    @Scope("prototype")
    public Job importClaim() {
        return jobBuilderFactory.get("importClaim")
                .incrementer(new RunIdIncrementer())
                .flow(stepClaim())
                .end()
                .build();
    }

    @Bean
    @Scope("prototype")
    public Step stepClaim() {
        return stepBuilderFactory.get("step1")
                .<Claim, Claim> chunk(30)
                .reader(readerClaim())
                .processor(processorClaim())
                .writer(writerClaim())
                .build();

    }

}