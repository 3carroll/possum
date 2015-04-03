package nsl.example.dropwizard;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.fasterxml.jackson.core.JsonProcessingException;

@Path(value = "/emails")

@Produces("application/json")

public class MaintainEmailResource {

    private JSONObject jsonObj;

    public MaintainEmailResource(JSONObject obj) {
    	this.jsonObj = obj;
    	
	}
	
    @GET
    @Produces("application/json")
    public String getEmails() throws JSONException, JsonProcessingException {
   
    	
    	// show original email
    	String emails = "Original Emails:\n\t" + jsonObj;
    	
    	// Update with new values
    	jsonObj = new JSONObject();
        List<String> newlist = new ArrayList<String>();
        newlist.add("test@test.com");    
         
        jsonObj.accumulate("start", newlist);
     
        List<String> stayList = new ArrayList<String>();
        stayList.add("test1@test.com");
            
        jsonObj.accumulate("stayed", stayList);
       
      
        List<String> leaveList = new ArrayList<String>();
        leaveList.add("test2@test.com");
        jsonObj.accumulate("unsubscribed", leaveList);
        emails = emails + "\nUpdated Emails:\n\t" + jsonObj.toString();
    	return emails; 
    	
     
    }
    

    
}
