package nbn.entities;

import java.time.LocalDateTime;

public class APICall{
    public String method;
    public LocalDateTime dateTime;
    public String httpStatus;
    public String request;
    public String response;

    public APICall(){

    }

    public APICall(String method, LocalDateTime dateTime, String httpStatus, String request, String response){
        this.method = method;
        this.dateTime = dateTime;
        this.httpStatus = httpStatus;
        this.request = request;
        this.response = response;
    }

    @Override
    public String toString(){
        return String.format("The %s was called on %s with a %s response. Detailed request: %s, detailed response: %s", method, dateTime, httpStatus, request, response);
    }
}