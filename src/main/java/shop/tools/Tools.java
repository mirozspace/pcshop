package shop.tools;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class Tools {

    public String getLoggedUser() {
    	String username = null;
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	if (principal instanceof UserDetails) {
    		username = ((UserDetails) principal).getUsername();
    	} else {
    		username = principal.toString();
    	}
    	return new String(username);
    }
    
    @PostConstruct
    @Async("threadPoolTaskExecutor")
    public void asyncMethodWithConfiguredExecutor() {
    	System.out.println("System is startet!");
		/*
		 * System.out.println("Execute method with configured executor - " +
		 * Thread.currentThread().getName());
		 */
    }
}
