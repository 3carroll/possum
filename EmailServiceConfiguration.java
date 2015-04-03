package nsl.example.dropwizard;

import javax.validation.Valid;

import com.yammer.dropwizard.config.Configuration;

public class EmailServiceConfiguration<MessagesConfiguration> extends Configuration {

    @Valid
    private MessagesConfiguration messages;

    public MessagesConfiguration getMessages() {
        return messages;
    }

    public void setMessages(MessagesConfiguration messages) {
        this.messages = messages;
    }
  
 
}
