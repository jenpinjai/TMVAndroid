package truecorp.core.test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import truecorp.core.model.CustomerDto;
import truecorp.core.model.JobControlDto;


public class RequestTest {
	
	public static void main(String args[]) throws JsonParseException, JsonMappingException, IOException{
		try {
		testCustomer();
		System.out.println("ภาษาไทย");
		//addJobControl();
		} finally {
		}
	}
	
	public static void testCustomer() throws JsonParseException, JsonMappingException, IOException, RestClientException {
	
		RestTemplate restTemplate = new RestTemplate();
		
		System.out.println("call getCustomer");
		ResponseEntity<CustomerDto> emp = restTemplate.getForEntity("http://localhost:8080/TMVExternalWebService/rest/customer/1", CustomerDto.class);
		//System.out.println(emp.getBody().getFirstName());
		
		System.out.println("call getAllCustomer");
		ResponseEntity<CustomerDto[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/TMVExternalWebService/rest/customer/getAll", CustomerDto[].class);
		CustomerDto[] objects = responseEntity.getBody();
		
		
		
		for (CustomerDto customerDto : objects) {
			
			//System.out.println(customerDto.getFirstName());
		}
		
		CustomerDto cus = new CustomerDto();
		//cus.setFirstName("Insert");
		System.out.println("call addCustomer");
		CustomerDto response = restTemplate.postForObject("http://localhost:8080/TMVExternalWebService/rest/customer/add", emp, CustomerDto.class);
		
		//System.out.println(response.getFirstName());
	}
	
	public static void addJobControl() throws JsonParseException, JsonMappingException, IOException{
		
		RestTemplate restTemplate = new RestTemplate();
		JobControlDto emp = new JobControlDto();
		emp.setJobname("addJob");
		emp.setErrmsg("");
		//emp.setJobstart(new Date());
		emp.setJobpid(new BigDecimal("123"));
		emp.setJobend(new Date());
		emp.setJobstatus("PD");
		emp.setRunseq(new BigDecimal("1"));
		emp.setUsername("Somchai");
		
		restTemplate.postForObject("http://172.17.158.37:8080/TMVExternalWebService/rest/jobcontrol/addJobControl", emp, JobControlDto.class);
		System.out.println("end");
	}

}
