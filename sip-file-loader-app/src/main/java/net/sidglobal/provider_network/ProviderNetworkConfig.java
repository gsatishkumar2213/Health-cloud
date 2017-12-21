package net.sidglobal.provider_network;

/**
 * Created by Bhargav on 9/28/2017.
 */
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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.FileSystemResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class ProviderNetworkConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Qualifier("dataSource")
    @Autowired
    public DataSource dataSource;

    @Bean
    @Scope("prototype")
    public FlatFileItemReader<ProviderNetwork> readerProviderNetwork() {
        FlatFileItemReader<ProviderNetwork> reader = new FlatFileItemReader<>();
        reader.setLinesToSkip(1);

        reader.setResource(new FileSystemResource(System.getProperty(ResourceInfo.FILE_PATH)));

        reader.setLineMapper(new DefaultLineMapper<ProviderNetwork>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] {"npi", "tin", "spec", "networkName", "startDate", "endDate"});
            }});
            setFieldSetMapper(new NetworkFieldMapper());
        }});
        return reader;
    }

    @Bean
    public NetworkItemProcessor processorProviderNetwork() {
        return new NetworkItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<ProviderNetwork> writerProviderNetwork() {
        JdbcBatchItemWriter<ProviderNetwork> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<ProviderNetwork>());
        writer.setSql("INSERT INTO provider_network (prv_npi,prv_tin,prov_spec,prv_network_name,network_start_date,network_end_date) VALUES (:npi, :tin, :spec, :networkName, :startDate, :endDate)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    @Scope("prototype")
    public Job importProviderNetwork() {
        return jobBuilderFactory.get("importProviderNetwork")
                .incrementer(new RunIdIncrementer())
                .flow(stepProviderNetwork())
                .end()
                .build();
    }

    @Bean
    @Scope("prototype")
    public Step stepProviderNetwork() {
        return stepBuilderFactory.get("step1")
                .<ProviderNetwork, ProviderNetwork> chunk(30)
                .faultTolerant()
                .skip(FlatFileParseException.class)
                .skipLimit(10000)
                .reader(readerProviderNetwork())
                .processor(processorProviderNetwork())
                .writer(writerProviderNetwork())
                .build();

    }

}