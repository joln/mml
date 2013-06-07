package net.ostree.quartz;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
import java.util.Date;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
public class Console {
    public static void main(String[] args) {
        try {
            testJob();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // ����ʹ��quartzʵ�ֵĵ�������
    public static void testJob() throws SchedulerException, InterruptedException {
        // ���������߹���
        SchedulerFactory sfc = new StdSchedulerFactory();
        // ͨ����������һ��������
        Scheduler scheduler = sfc.getScheduler();
         /*//----------Quartz1.8.4��д��---------------//

         // ����һ������������myjob����������group1������Ӧ�����ࡰExampleJob��
         JobDetail myJob = new JobDetail("myjob", "group1", ExampleJob.class);
         // ʹ�ô����������ഴ��һ��ÿ��15��ִ��һ�εĴ�����
         Trigger trigger = TriggerUtils.makeSecondlyTrigger(15);
         trigger.setName("mytrigger");
         trigger.setStartTime(new Date());
         */
        //----------Quartz 2.0.2��д��---------------//
        JobDetail myJob = newJob(ExampleJob.class).withIdentity("myJob", "job-group").build();
        Trigger trigger = newTrigger().withIdentity("mytrigger", "trigger-group").startAt(new Date())
                .withSchedule(simpleSchedule().withIntervalInSeconds(15).repeatForever()).build();
        // ��������
        Date startDate = scheduler.scheduleJob(myJob, trigger);
        System.out.println(myJob.getKey() + " will start at:" + startDate.toLocaleString());
        // ��ʼ���е��ȳ���
        scheduler.start();        
        Thread.sleep(20000);// �ȴ�20��
        scheduler.shutdown();// �رյ��ȳ���        SchedulerMetaData metaData = scheduler.getMetaData();
        System.out.println("Test end------>");    }}
