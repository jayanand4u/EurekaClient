package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}

@RestController
class ServiceInstanceRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancer;
    @RequestMapping(value= "/login", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @LoadBalanced
    public  LogInResponseType serviceInstancesByApplicationName()  {
//    	
    	LogInResponseType LogInResponseType = new LogInResponseType();
    	LogInResponseType.setSessionId("custSessionId");
    	LogInResponseType.setConfirmationCode("custConfirmCode");
    	LogInResponseType.setTransactionId("transId");
    	return LogInResponseType;
    }
}
