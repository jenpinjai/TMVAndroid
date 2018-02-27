package truecorp.core.dataservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import truecorp.core.model.BillingAccountDto;
import truecorp.core.model.JobControlDto;
import truecorp.core.model.SelectItem;

/**
 * Created by Jennarong Pinjai on 16/12/2560.
 */

public class BillingAccountService extends DataserviceManager{


    public List<BillingAccountDto> searchBillingAccount(String crytiria,String value) throws Exception{

        try{

            System.out.println("call searchBillingAccount");
            //username = URLEncoder.encode(username,"UTF-8");
            //password = URLEncoder.encode(password,"UTF-8");
            String url = "http://"+domain+"/TMVExternalWebService/rest/billingAccount/searchByCriteria/"+crytiria+"/"+value;

            RestTemplate restTemplate = new RestTemplate();
            System.out.println(url);
            ResponseEntity<BillingAccountDto[]> responseEntity =restTemplate.getForEntity(url, BillingAccountDto[].class);

            List<BillingAccountDto> billList = new ArrayList<BillingAccountDto>();

            for(BillingAccountDto bill : responseEntity.getBody()){

                billList.add(bill);

            }

            return billList;

        }catch(Exception ex){

            throw ex;

        }

    }

    public List<SelectItem> getCertificateType() throws Exception{

        List<SelectItem> reasonList = new ArrayList<SelectItem>();
        try{

            System.out.println("call searchAdjustReason");
            //username = URLEncoder.encode(username,"UTF-8");
            //password = URLEncoder.encode(password,"UTF-8");
            String url = "http://"+domain+"/TMVExternalWebService/rest/listbox/certificate/";

            RestTemplate restTemplate = new RestTemplate();
            System.out.println(url);
            ResponseEntity<SelectItem[]> responseEntity =restTemplate.getForEntity(url, SelectItem[].class);


            for(SelectItem list : responseEntity.getBody()){

                reasonList.add(list);

            }


        }catch(Exception ex){

            throw ex;

        }
        return reasonList;

    }


}
