package net.sidglobal.provider;

import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.FlatFileFormatException;
import org.springframework.validation.BindException;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by SUNIL PC on 28-09-2017.
 */
public class ProviderFieldSetMapper implements FieldSetMapper<Provider> {

    @Override
    public Provider mapFieldSet(FieldSet fieldSet) throws BindException {

        DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
        Provider provider=new Provider();
        provider.setNpi(fieldSet.readRawString("NPI"));
        provider.setTin(fieldSet.readRawString("TIN"));
        provider.setTitleDegree(fieldSet.readRawString("DEGREE"));
        provider.setFirstName(fieldSet.readRawString("FNAME"));

        provider.setMiddleName(fieldSet.readRawString("MNAME"));
        provider.setLastName(fieldSet.readRawString("LNAME"));
        provider.setNetworkName(fieldSet.readRawString("GROUP_NAME"));
        try {
            provider.setNetworkStartDate(new Date(dateFormat.parse(fieldSet.readRawString("START_DATE")).getTime()));
            provider.setNetworkEndDate(new Date(dateFormat.parse(fieldSet.readRawString("END_DATE")).getTime()));
        } catch (ParseException e) {
            throw new FlatFileParseException("Error in Date format use[MM/dd/yyyy]","");
        }

        provider.setPhone(fieldSet.readRawString("PHONE"));
        provider.setPcpStatus("N/A");
        provider.setSpeciality1Code(fieldSet.readRawString("SPECIALTY"));
        provider.setSpecialty1Desc(fieldSet.readRawString("SPECIALTY"));
        provider.setStreet1(fieldSet.readRawString("ADDR1"));
        provider.setStreet2(fieldSet.readRawString("ADDR2"));
        provider.setCity(fieldSet.readRawString("CITY"));
        provider.setCountry(fieldSet.readRawString("COUNTY"));
        provider.setState(fieldSet.readRawString("STATE"));
        provider.setZip(fieldSet.readInt("ZIP"));
        provider.setNewPatients("N/A");
        provider.setPracticeName("N/A");
        provider.setPracticeTin("N/A");
        return provider;
    }
}
