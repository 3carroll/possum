package nsl.example.dropwizard;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;


public class ModifyEmail extends Service <EmailServiceConfiguration> {
	 private static JSONObject jsonObj = new JSONObject();
	  public static void main(String[] args) throws Exception {
	    	try {
	    		initialEmailObject();
	    	} catch (JSONException je) {
	    		System.out.println("Exception Initializing JSON Object. Exiting Application");
	    		System.exit(0);
	    	}
	        new ModifyEmail().run(args);
	    }

	    @Override
	    public void initialize(Bootstrap <EmailServiceConfiguration> bootstrap) {
	        bootstrap.setName("dropwizard");
	    }

	    @Override
	    public void run(EmailServiceConfiguration conf, Environment env) throws Exception {	     	    	
	    	env.addResource(new MaintainEmailResource(jsonObj));
	    }

		
	    public static void initialEmailObject() throws JSONException {
	    	   List<String> startLlist = new ArrayList<String>();
	           startLlist.add("test1@test.com");
	           startLlist.add("test2@test.com");	         
	            
	           jsonObj.accumulate("start", startLlist);
	 
	           List<String> endList = new ArrayList<String>();
	           endList.add("test1@test.com");
	           endList.add("test3@test.com");	         
	            
	           jsonObj.accumulate("end", endList);	        	          
	    	
	    }

	}
