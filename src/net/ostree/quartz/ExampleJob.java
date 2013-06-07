package net.ostree.quartz;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试Job，功能，从1到10，每秒1次。
 * 
 * @author Administrator
 *
 */
public class ExampleJob implements Job {
    private Logger logger = LoggerFactory.getLogger(ExampleJob.class);
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.print("I can count to 10 ->");
        // 输出1-10
        for (int i = 1; i <= 10; i++) {
            System.out.print(" | " + i + " ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
            }
        }
        logger.info("<- See I did it.");
        JobDataMap properties = context.getJobDetail().getJobDataMap();
        logger.info("Previous Fire Time: " + context.getPreviousFireTime());// 上次执行时间
        logger.info("Current Fire Time: " + context.getFireTime());// 本次执行时间
        logger.info("Next Fire Time: " + context.getNextFireTime());// 下一次执行时间
    }
}
