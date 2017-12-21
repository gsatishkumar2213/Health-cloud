package net.sidglobal;

import net.sidglobal.claims.ClaimConfig;
import net.sidglobal.member.MemberConfig;
import net.sidglobal.provider.ProviderConfig;
import net.sidglobal.provider_network.ProviderNetworkConfig;
import net.sidglobal.util.ResourceInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
@Configuration
//@Import({MemberConfig.class, ProviderConfig.class, ClaimConfig.class, ProviderNetworkConfig.class})
public class Application {



    public static void main(String[] args) throws Exception {
        Log log = LogFactory.getLog(Application.class);
        ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
        JobLauncher jobLauncher=context.getBean(JobLauncher.class);
        JobParametersBuilder jobParametersBuilder=new JobParametersBuilder();
        JobParameters jobParameters=jobParametersBuilder.addLong("run.id",System.currentTimeMillis()).toJobParameters();

//        System.out.println(jobParameters.getLong("run.id"));

        //--------OPTIONS TO SELECT FILE TO LOAD--------
        log.info("OPTIONS TO SELECT FILE TO LOAD");
        log.info("1---------->Provider File");
        log.info("2---------->Claim File");
        log.info("3---------->Member File");
        log.info("4---------->Provider Network File");

        int option ;
        if ( System.getProperty(ResourceInfo.FILE_TYPE, null ) == null ) {
            log.info("Enter your file type [1|2|3|4]: ");
            Scanner console = new Scanner(System.in);
            option = console.nextInt();

        } else {
            String optionValue = System.getProperty(ResourceInfo.FILE_TYPE);
            // Check for a valid option before continuing to use the provided option
            option = Integer.parseInt(optionValue);
        }

        if ( System.getProperty(ResourceInfo.FILE_PATH, null ) == null ) {
            System.out.println("Enter File LOCATION(File Path)");
            Scanner console = new Scanner(System.in);
            String path = console.next();
            // Check to Validate that the below is a valid file location
            System.setProperty(ResourceInfo.FILE_PATH,path);
        }

        String header = getHeader(System.getProperty(ResourceInfo.FILE_PATH));
        System.setProperty(ResourceInfo.FILE_HEADER, header);


        if(option==1)
            jobLauncher.run((Job)context.getBean("importProvider"),jobParameters);
        else if(option==2)
            jobLauncher.run((Job)context.getBean("importClaim"),jobParameters);
        else if(option==3)
            jobLauncher.run((Job)context.getBean("importMember"),jobParameters);
        else if(option==4)
            jobLauncher.run((Job)context.getBean("importProviderNetwork"),jobParameters);
        else
            log.error("wrong selection");

    }

    public static String getHeader(String filename) throws IOException {
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(filename));
        String header = reader.readLine();
        return header ;
    }
}
