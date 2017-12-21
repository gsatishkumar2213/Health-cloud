package net.sidglobal.provider;

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
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.FileSystemResource;

import javax.sql.DataSource;

/**
 * Created by SUNIL PC on 25-09-2017.
 */
@Configuration
@EnableBatchProcessing
public class ProviderConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    // tag::readerwriterprocessor[]
    @Bean
    @Scope("prototype")
    public FlatFileItemReader<Provider> readerProvider() {
        FlatFileItemReader<Provider> reader = new FlatFileItemReader<Provider>();
        reader.setResource(new FileSystemResource(System.getProperty(ResourceInfo.FILE_PATH)));
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper<Provider>() {{
                setLineTokenizer(new DelimitedLineTokenizer() {{
                    if ( System.getProperty(ResourceInfo.FILE_HEADER, null) != null ) {
                        setNames(System.getProperty(ResourceInfo.FILE_HEADER).split(","));
                    }
//                    else {
//                        setNames(new String[]{"npi", "tin", "titleDegree", "firstName", "middleName", "lastName", "networkName", "networkStartDate", "networkEndDate",
//                                "phone", "pcpStatus", "speciality1Code", "specialty1Desc", "street1", "street2", "city", "country", "state", "zip", "newPatients", "practiceName", "practiceTin"});
//                    }
                }});
                setFieldSetMapper(new ProviderFieldSetMapper()
//                 {{setTargetType(Provider.class);}}
                );
            }});

        return reader;

    }

    @Bean
    public ProviderItemProcessor processorProvider() {
        return new ProviderItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Provider> writerProvider() {
        JdbcBatchItemWriter<Provider> writer = new JdbcBatchItemWriter<Provider>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Provider>());
        writer.setSql("INSERT INTO provider (prv_npi, prv_tin, prv_title_degree, prv_first_name, prv_middle_name, prv_last_name, prv_network_name, Network_start_date, Network_end_date, prv_phone, prv_PCP_status, prv_speciality_1_code, prv_specialty_1_desc, prv_street_1, prv_street_2, prv_city, prv_county, prv_state, prv_zip, prv_new_patients, prv_practice_Name, prv_practice_Tin) VALUES (    :npi, :tin, :titleDegree, :firstName, :middleName, :lastName, :networkName, :networkStartDate, :networkEndDate, :phone, :pcpStatus, :speciality1Code, :specialty1Desc, :street1, :street2, :city, :country, :state, :zip, :newPatients, :practiceName, :practiceTin)");
        writer.setDataSource(dataSource);
        return writer;
    }
    // end::readerwriterprocessor[]

    // tag::jobstep[]
    @Bean
    @Scope("prototype")
    public Job importProvider() {
        return jobBuilderFactory.get("importProvider")
                .incrementer(new RunIdIncrementer())
                .flow(stepProvider())
                .end()
                .build();
    }

    @Bean
    @Scope("prototype")
    public Step stepProvider() {
        return stepBuilderFactory.get("step1")
                .<Provider, Provider> chunk(10)
                .faultTolerant()
                .skip(FlatFileParseException.class)
                .skipLimit(10000)
                .reader(readerProvider())
                .processor(processorProvider())
                .writer(writerProvider())
                .build();
    }
    // end::jobstep[]
}
