package truecorp.core.dataservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import truecorp.core.model.JobControlDto;
import truecorp.core.model.M203UserDto;
import truecorp.core.model.ParameterShellDto;
import truecorp.core.session.Session;

/**
 * Created by Jennarong Pinjai on 16/12/2560.
 */

public class JobcontrolService extends DataserviceManager {


    public List<JobControlDto> getAllJobControl() throws Exception {

        try {

            System.out.println("call getAllJobControl");
            //username = URLEncoder.encode(username,"UTF-8");
            //password = URLEncoder.encode(password,"UTF-8");
            String url = "http://" + domain + "/TMVExternalWebService/rest/jobcontrol/getAllJobControl";

            RestTemplate restTemplate = new RestTemplate();
            System.out.println(url);
            ResponseEntity<JobControlDto[]> responseEntity = restTemplate.getForEntity(url, JobControlDto[].class);

            List<JobControlDto> jobs = new ArrayList<JobControlDto>();

            for (JobControlDto job : responseEntity.getBody()) {

                jobs.add(job);

            }

            return jobs;

        } catch (Exception ex) {

            throw ex;

        }

    }

    public String[] getLogFilename(String jobName) {

        try {
            System.out.println("call getLogFileName");
            //username = URLEncoder.encode(username,"UTF-8");
            //password = URLEncoder.encode(password,"UTF-8");
            String url = "http://" + domain + "/TMVExternalWebService/rest/jobcontrol/getAllLog/" + jobName;

            RestTemplate restTemplate = new RestTemplate();
            System.out.println(url);
            ResponseEntity<String[]> responseEntity = restTemplate.getForEntity(url, String[].class);

            String[] logs = responseEntity.getBody();


            return logs;

        } catch (Exception ex) {

            throw ex;

        }


    }

    public String[] getLogText(String fileName, String types) {

        try {
            System.out.println("call getLogFileName");
            //username = URLEncoder.encode(username,"UTF-8");
            //password = URLEncoder.encode(password,"UTF-8");
            String url = "http://" + domain + "/TMVExternalWebService/rest/jobcontrol/getLog/" + fileName + "/" + types;

            RestTemplate restTemplate = new RestTemplate();
            System.out.println(url);
            ResponseEntity<String[]> responseEntity = restTemplate.getForEntity(url, String[].class);

            String[] logs = responseEntity.getBody();


            return logs;

        } catch (Exception ex) {

            throw ex;

        }


    }

    public String jobProcess(String condition, String jobName) {

        try {
            System.out.println("call jobProcess");
            //RequestTest.main(null);
            RestTemplate restTemplate = new RestTemplate();
            ParameterShellDto params = new ParameterShellDto();
            String url = "http://" + domain + "/TMVExternalWebService/rest/jobcontrol/jobProcess/" + condition;
            System.out.println(url);
            List<String> lst = new ArrayList<String>();
            M203UserDto user = null;
            if (Session.getAttribute("user") != null) {
                user = (M203UserDto) Session.getAttribute("user");
            } else {
                throw new Exception("Can't find user!");
            }

            lst.add(user.getUserId()); // user name
            lst.add(jobName); // job name
            params.setParams(lst);

            //http://172.16.46.34:8080/TMVExternalWebService/rest/jobcontrol/jobProcess/(start , rerun , stop)
            ResponseEntity<String> emp = restTemplate.postForEntity(url, params, String.class);

            return emp.getBody();

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

        }


    }

    public JobControlDto updateJobStatus(JobControlDto job, String status) {
        try {
            System.out.println("starting update job");
            RestTemplate restTemplate = new RestTemplate();
            ParameterShellDto params = new ParameterShellDto();
            String url = "http://" + domain + "TMVExternalWebService/rest/jobcontrol/updateJobControl";
            System.out.println(url);

            List<String> lst = new ArrayList<String>();
            M203UserDto user = null;
            if (Session.getAttribute("user") != null) {
                user = (M203UserDto) Session.getAttribute("user");
            } else {
                throw new Exception("Can't find user!");
            }

            lst.add(user.getUserId()); // user name
            lst.add(job.getJobname()); // job name
            params.setParams(lst);

            job.setJobstatus(status);
            JobControlDto emp = restTemplate.postForObject(url, job, JobControlDto.class, params);
            return emp;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }


}
