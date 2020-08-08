package shop.tools;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import shop.constants.FilePaths;

@EnableAsync
@Component
public class Schedule {
	
	private FileTools fileTools;
	
	@Autowired
	public Schedule(FileTools fileTools) {
		this.fileTools = fileTools;
	}
	
	@Async
	@Scheduled(fixedDelay = 120000, initialDelay = 1800000) //every 30 minutes after start 
	public void showDateAndTime() {
		
		this.fileTools.deleteContentOfFile(FilePaths.FILE_LOG_PATH);
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));
		System.out.println("Log is deleted");
		
		
		/*
		 * long now = System.currentTimeMillis() / 1000; System.out.println(
		 * "Fixed rate task with one second initial delay - " + now);
		 */
    }

}
