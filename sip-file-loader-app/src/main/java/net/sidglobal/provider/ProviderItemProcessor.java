package net.sidglobal.provider;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.stereotype.Component;

/**
 * Created by SUNIL PC on 25-09-2017.
 */
@Component
public class ProviderItemProcessor implements ItemProcessor<Provider, Provider> {

    @Override
    public Provider process(Provider item) throws Exception {

        if(item.getNpi().equals("")||
                item.getTin().equals("")||
                item.getFirstName().equals("")||
                item.getLastName().equals("")||
                item.getNetworkName().equals("")||
                item.getNetworkStartDate().equals("")||
                item.getNetworkEndDate().equals("")||
                item.getPcpStatus().equals("")||
                item.getSpeciality1Code().equals("")||
                item.getSpecialty1Desc().equals("")||
                item.getStreet1().equals("")||
                 item.getCity().equals("")||
                item.getCountry().equals("")||
                item.getState().equals("")||
                item.getZip()<0||
                item.getPracticeName().equals("")||
                item.getPracticeTin().equals("")) {
            return null;
        }
        else
            return  item;
    }
}
