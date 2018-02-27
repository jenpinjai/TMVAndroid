package truecorp.ensemble;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import truecorp.core.model.ParameterShellDto;
import truecorp.core.test.RequestTest;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {

        //RequestTest.main(null);
        RestTemplate restTemplate = new RestTemplate();
        ParameterShellDto params = new ParameterShellDto();
        List<String> lst = new ArrayList<String>();
        lst.add("webadmin"); // user name
        lst.add("TEST3"); // job name
        params.setParams(lst);

        //http://172.16.46.34:8080/TMVExternalWebService/rest/jobcontrol/jobProcess/(start , rerun , stop)
        ResponseEntity<String> emp = restTemplate.postForEntity("http://172.16.46.34:8080/TMVExternalWebService/rest/jobcontrol/jobProcess/start",params, String.class);
    }
}