package nbn.scheduled;

import nbn.entities.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
 
@Component
public class PollUsers{

    private static final Logger log = LoggerFactory.getLogger(PollUsers.class);

    private String id;
    private User user;
    private boolean isPollEnabled = false;
    @Value("${users.remote.host}")
    private String remoteHost;
    @Value("${users.remote.port}")
    private String remotePort;
    private String request;

    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(fixedDelayString = "${schedule.interval.seconds:300}000")
    public void pollUsers(){
        if(isPollEnabled){
            this.request = "http://"+remoteHost+":"+remotePort+"/user?id="+this.id;
            this.user = restTemplate.getForObject(request, User.class);
            log.info(user.toString());
        }
    }

    @Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
    }

    public void setId(String id){
        this.id = id;
    }

    public void setIsPollEnabled(boolean isPollEnabled){
        this.isPollEnabled = isPollEnabled;
    }

    public String getRequest(){
        this.request = "http://"+remoteHost+":"+remotePort+"/user?id="+this.id;
        return this.request;
    }

    public User getUser(){
        return this.user;
    }
}