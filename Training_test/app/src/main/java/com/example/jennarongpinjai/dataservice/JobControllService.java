package com.example.jennarongpinjai.dataservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jennarongpinjai.model.JobControlDto;
import com.example.jennarongpinjai.training_test.R;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class JobControllService {


    public List<JobControlDto> getAllJobList(){


        try{

            System.out.println("call getAllJobControl");
            //username = URLEncoder.encode(username,"UTF-8");
            //password = URLEncoder.encode(password,"UTF-8");
            String url = "http://172.16.46.34:8080/TMVExternalWebService/rest/jobcontrol/getAllJobControl";

            RestTemplate restTemplate = new RestTemplate();
            System.out.println(url);
            ResponseEntity<JobControlDto[]> responseEntity =restTemplate.getForEntity(url, JobControlDto[].class);

            List<JobControlDto> jobs = new ArrayList<JobControlDto>();

            for(JobControlDto job : responseEntity.getBody()){

                jobs.add(job);

            }

            return jobs;

        }catch(Exception ex){

            throw ex;

        }


    }



}
