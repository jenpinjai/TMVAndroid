package truecorp.core.dataservice;

/**
 * Created by Jennarong Pinjai on 16/12/2560.
 */


import android.content.AsyncTaskLoader;
import android.os.AsyncTask;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import truecorp.core.model.CustomerDto;

public class CustomerService extends DataserviceManager {



    public List<CustomerDto> testCustomer() throws JsonParseException, JsonMappingException, IOException, RestClientException, ExecutionException, InterruptedException, TimeoutException {

        List<CustomerDto> customerList = new ArrayList<CustomerDto>();

        System.out.println("call getCustomer");
        String url = "http://"+domain+"/TMVExternalWebService/rest/customer/1";

        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity<CustomerDto> emp =restTemplate.getForEntity(url, CustomerDto.class);

        //System.out.println(emp.getBody().getFirstName());
        System.out.println("call getAllCustomer");
        String url2 = "http://"+domain+"/TMVExternalWebService/rest/customer/getAll";


        ResponseEntity<CustomerDto[]> responseEntity =restTemplate.getForEntity(url2, CustomerDto[].class);

        customerList.add(emp.getBody());

        for(CustomerDto cus : responseEntity.getBody()){
            customerList.add(cus);
        }

        return customerList;
    }


}
