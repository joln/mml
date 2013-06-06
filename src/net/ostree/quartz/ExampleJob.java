package net.ostree.quartz;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ExampleJob implements Job {
    private Logger logger = LoggerFactory.getLogger(ExampleJob.class);
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.print("I can count to 10 ->");
        // ���1-10
        for (int i = 1; i <= 10; i++) {
            System.out.print(" | " + i + " ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
            }
        }
        System.out.println("<- See I did it.");
        JobDataMap properties = context.getJobDetail().getJobDataMap();
        System.out.println("Previous Fire Time: " + context.getPreviousFireTime());// �ϴ�ִ��ʱ��
        System.out.println("Current Fire Time: " + context.getFireTime());// ����ִ��ʱ��
        System.out.println("Next Fire Time: " + context.getNextFireTime());// ��һ��ִ��ʱ��
    }
}
