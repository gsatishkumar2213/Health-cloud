package net.sidglobal.provider_network;

/**
 * Created by Bhargav on 9/28/2017.
 */

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class NetworkItemProcessor implements ItemProcessor<ProviderNetwork, ProviderNetwork> {

    @Override
    public ProviderNetwork process(ProviderNetwork item) throws Exception {
        if(item.getNpi().equals("")||
                item.getTin().equals("")||
                item.getSpec().equals("")||
                item.getNetworkName().equals("")||
                item.getStartDate().equals("")||
                item.getEndDate().equals(""))
            return null;
        else
        return item;
    }

}




