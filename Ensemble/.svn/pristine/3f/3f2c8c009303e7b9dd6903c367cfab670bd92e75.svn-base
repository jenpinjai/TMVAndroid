package truecorp.core.dataservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import truecorp.core.model.AdjustmentDto;
import truecorp.core.model.BillingAccountDto;
import truecorp.core.model.RestResponse;
import truecorp.core.model.SelectItem;

/**
 * Created by Sucha55 on 1/2/2561.
 */

public class AdjustmentService extends DataserviceManager{


    public List<SelectItem> searchAdjustReason() throws Exception{

        List<SelectItem> reasonList = new ArrayList<SelectItem>();
        try{

            System.out.println("call searchAdjustReason");
            //username = URLEncoder.encode(username,"UTF-8");
            //password = URLEncoder.encode(password,"UTF-8");
            String url = "http://"+domain+"/TMVExternalWebService/rest/listbox/adjustment-reson/";

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

    public RestResponse createAdjustment(AdjustmentDto adjustDto ) throws Exception{
        RestResponse result = null;
        try{

            System.out.println("call createAdjustment");
            String url = "http://"+domain+"/TMVExternalWebService/rest/adjustment";

            RestTemplate restTemplate = new RestTemplate();
            System.out.println(url);
            ResponseEntity<RestResponse> responseEntity =restTemplate.postForEntity(url,adjustDto, RestResponse.class);
            result = responseEntity.getBody();
        }catch(Exception ex){

            throw ex;

        }
        return result;

    }
}
