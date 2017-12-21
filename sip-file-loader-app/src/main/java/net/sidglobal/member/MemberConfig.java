package net.sidglobal.member;

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
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.FileSystemResource;

import javax.sql.DataSource;
@Configuration
@EnableBatchProcessing
@ComponentScan
public class MemberConfig {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Qualifier("dataSource")
    @Autowired
    public DataSource dataSource;

    // tag::readerwriterprocessor[]
    @Bean
    @Scope("prototype")
    public FlatFileItemReader<Member> readerMember() {
        FlatFileItemReader<Member> reader = new FlatFileItemReader<Member>();
        reader.setResource(new FileSystemResource(System.getProperty(ResourceInfo.FILE_PATH)));
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper<Member>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] { "personId","mbrGender","mbrBirthyear","mbrCounty","mbrZip","mbrState","planTypeCode","planTypeDesc","medEffDate","medTermDate","prvPcpNPI","mbrRiskscore" });
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Member>() {{
                setTargetType(Member.class);
            }});
        }});
        return reader;
    }

    @Bean
    public MemberItemProcessor processorMember() {
        return new MemberItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Member> writerMember() {
        JdbcBatchItemWriter<Member> writer = new JdbcBatchItemWriter<Member>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Member>());
        writer.setSql("INSERT INTO member (person_id,mbr_gender,mbr_birthyear,mbr_county,mbr_zip,mbr_state,plan_type_code,plan_type_desc,med_eff_date ,med_term_date,prv_pcp_npi,mbr_Riskscore) VALUES (:personId,:mbrGender, :mbrBirthyear,:mbrCounty,:mbrZip,:mbrState,:planTypeCode,:planTypeDesc,:medEffDate,:medTermDate,:prvPcpNPI,:mbrRiskscore)");
        writer.setDataSource(dataSource);
        return writer;
    }
    // end::readerwriterprocessor[]

    // tag::jobstep[]
    @Bean
    @Scope("prototype")
    public Job importMember() {
        return jobBuilderFactory.get("importMember")
                .incrementer(new RunIdIncrementer())
                .flow(stepMember())
                .end()
                .build();
    }

    @Bean
    @Scope("prototype")
    public Step stepMember() {
        return stepBuilderFactory.get("step1")
                .<Member, Member> chunk(10)
                .reader(readerMember())
                .processor(processorMember())
                .writer(writerMember())
                .build();
    }}
