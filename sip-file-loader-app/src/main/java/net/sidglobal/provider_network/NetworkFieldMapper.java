package net.sidglobal.provider_network;


import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by annap on 9/28/2017.
 */

public class NetworkFieldMapper  implements FieldSetMapper<ProviderNetwork>{

    @Override
    public ProviderNetwork mapFieldSet(FieldSet fieldSet) throws BindException {

        DateFormat dateFormat =new SimpleDateFormat("MM/dd/yyyy");
        ProviderNetwork providerNetwork =new ProviderNetwork();
        providerNetwork.setNpi(fieldSet.readRawString(0));
        providerNetwork.setTin(fieldSet.readRawString(1));
        providerNetwork.setSpec(fieldSet.readRawString(2));
        providerNetwork.setNetworkName(fieldSet.readRawString(3));

        try {
            providerNetwork.setStartDate(new Date(dateFormat.parse(fieldSet.readRawString(4)).getTime()));
            providerNetwork.setEndDate(new Date(dateFormat.parse(fieldSet.readRawString(5)).getTime()));
        } catch (ParseException e) {
            throw new FlatFileParseException("Error in Date format use[MM/dd/yyyy]","");
        }



        return providerNetwork;
    }
}
