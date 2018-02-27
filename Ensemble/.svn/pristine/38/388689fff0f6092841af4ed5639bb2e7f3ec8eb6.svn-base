package truecorp.core.dataservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import truecorp.core.model.FileControlDto;
import truecorp.core.model.JobControlDto;

/**
 * Created by Anukoon on 2/5/2018.
 */

public class FileControlService extends DataserviceManager {
    public void getAllJobs(List<FileControlDto> jobs){
        try{

            System.out.println("call getAllJobs in FileControlService");
            String url = "http://" + domain + "/TMVExternalWebService/rest/file-control";

            RestTemplate restTemplate = new RestTemplate();
            System.out.println(url);
            ResponseEntity<FileControlDto[]> responseEntity = restTemplate.getForEntity(url, FileControlDto[].class);

            //List<FileControlDto> jobs = new ArrayList<FileControlDto>();

            for (FileControlDto job : responseEntity.getBody()) {

                jobs.add(job);

            }
            System.out.println("Finished getAllJobs in FileControlService");

        }catch(Exception e){
            System.out.println("error : "+e.getMessage());
        }
    }

}
