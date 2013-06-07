package net.ostree.quartz;
import java.util.Date;       


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.quartz.JobDetail;
import org.quartz.Scheduler;       
import org.quartz.SchedulerException;       
import org.quartz.Trigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleScheduler 
{
	//日志记录器
	private static Logger logger = LoggerFactory.getLogger(ExampleJob.class);
   
	public static void main(String[] args) 
    {       
         SimpleScheduler simple = new SimpleScheduler();       
         try
         {       
             // Create a Scheduler and schedule the Job       
             Scheduler scheduler = simple.createScheduler();       
             simple.scheduleJob(scheduler);       
    
             // Start the Scheduler running       
             scheduler.start();       
    
             logger.info( "Scheduler started at " + new Date());       
    
        } catch (SchedulerException ex) {       
             //logger.error(ex);       
        }   
        
    }       
    public Scheduler createScheduler() throws SchedulerException 
    {//创建调度器       
        return StdSchedulerFactory.getDefaultScheduler();
    }   
    
    //Create and Schedule a ScanDirectoryJob with the Scheduler       
    private void scheduleJob(Scheduler scheduler) throws SchedulerException 
    {       
  
    }       
}