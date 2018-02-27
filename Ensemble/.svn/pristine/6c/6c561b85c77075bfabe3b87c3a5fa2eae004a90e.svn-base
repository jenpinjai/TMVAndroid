package truecorp.core.dataservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import truecorp.core.model.BackoutRequestDto;
import truecorp.core.model.RestResponse;
import truecorp.core.model.SelectItem;

/**
 * Created by Jennarong Pinjai on 9/2/2561.
 */

public class BackoutService extends DataserviceManager{

    public List<SelectItem> searchBackoutReason() throws Exception{

        List<SelectItem> reasonList = new ArrayList<SelectItem>();
        try{

            System.out.println("call searchAdjustReason");
            //username = URLEncoder.encode(username,"UTF-8");
            //password = URLEncoder.encode(password,"UTF-8");
            String url = "http://"+domain+"/TMVExternalWebService/rest/listbox/backout-reson/";

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

    public RestResponse proccessBackout(BackoutRequestDto requestDto) throws Exception{


        try{

            System.out.println("call proccessBackout");
            //username = URLEncoder.encode(username,"UTF-8");
            //password = URLEncoder.encode(password,"UTF-8");
            String url = "http://"+domain+"/TMVExternalWebService/rest/backout-process/backout";

            RestTemplate restTemplate = new RestTemplate();
            System.out.println(url);
            ResponseEntity<RestResponse> responseEntity =restTemplate.postForEntity(url,requestDto,RestResponse.class);


            RestResponse response =responseEntity.getBody();

            return  response;

        }catch(Exception ex){

            throw ex;

        }


    }

}
