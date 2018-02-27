package truecorp.core.dataservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;

import truecorp.core.model.M203UserDto;

/**
 * Created by Jennarong Pinjai on 16/12/2560.
 */

public class LoginService extends DataserviceManager{


    public M203UserDto sendLogin(String username, String password){

        try{

            System.out.println("call validateLogin");
            //username = URLEncoder.encode(username,"UTF-8");
            //password = URLEncoder.encode(password,"UTF-8");
            String url = "http://"+domain+"/TMVExternalWebService/rest/user/login/"+username+"/"+password;

            RestTemplate restTemplate = new RestTemplate();
            System.out.println(url);
            ResponseEntity<M203UserDto> user =restTemplate.getForEntity(url, M203UserDto.class);

            return  user.getBody();
        }catch(Exception ex){
            ex.printStackTrace();
            return null;

        }



    }


}
