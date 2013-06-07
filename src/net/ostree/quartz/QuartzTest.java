package net.ostree.quartz;
import java.util.Date;

import org.quartz.Scheduler; 
import org.quartz.SchedulerException; 
import org.quartz.impl.StdSchedulerFactory; 
import static org.quartz.JobBuilder.*; 
import static org.quartz.TriggerBuilder.*; 
import static org.quartz.SimpleScheduleBuilder.*; 
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 
public class QuartzTest { 
 
	//ÈÕÖ¾¼ÇÂ¼Æ÷
	private static Logger logger = LoggerFactory.getLogger(QuartzTest.class);
	   
	
    public static void main(String[] args) { 
 
    	
        try { 
            // Grab the Scheduler instance from the Factory  
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler(); 
 
            // and start it off 
            scheduler.start(); 
 
            logger.info("Scheduler " + new Date()); 
            
            scheduler.shutdown(); 
 
        } catch (SchedulerException se) { 
            se.printStackTrace(); 
        } 
    } 
} 
