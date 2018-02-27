package truecorp.core.dataservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import truecorp.core.model.FileUploadResponse;
import truecorp.core.model.ManualPaymentDto;

/**
 * Created by Jennarong Pinjai on 19/2/2561.
 */

public class PaymentService extends  DataserviceManager {

    public FileUploadResponse createManualPayment(ManualPaymentDto payment) {

        try{

            System.out.println("call proccessRefund");
            //username = URLEncoder.encode(username,"UTF-8");
            //password = URLEncoder.encode(password,"UTF-8");
            String url = "http://"+domain+"/TMVExternalWebService/rest/manual-payment/payment";

            RestTemplate restTemplate = new RestTemplate();
            System.out.println(url);
            ResponseEntity<FileUploadResponse> responseEntity =restTemplate.postForEntity(url,payment,FileUploadResponse.class);


            FileUploadResponse response =responseEntity.getBody();

            return  response;

        }catch (Exception ex){
            ex.printStackTrace();
            return null;

        }


    }
}
