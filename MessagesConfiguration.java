package nsl.example.dropwizard;

import javax.validation.constraints.NotNull;

public class MessagesConfiguration {

    @NotNull
  
    private String email;

   
    public String getEmails() {
            return email;
        }

        public void setEmails(String email) {
            this.email = email;
        }
        
}
