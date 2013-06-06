package net.ostree.quartz;
import java.io.File;       
import java.io.FileFilter;
import java.util.Date;       
      
import org.quartz.Job;       
import org.quartz.JobDataMap;       
import org.quartz.JobDetail;       
import org.quartz.JobExecutionContext;       
import org.quartz.JobExecutionException;  

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ɨ��һ��Ŀ¼�е��Ĳ���ʾ�ļ�����ϸ��Ϣ
 * @author Administrator
 *
 */

public class ScanDirectoryJob implements Job 
{
	private Logger logger = LoggerFactory.getLogger(ScanDirectoryJob.class);
	   
    //static Log logger = LogFactory.getLog(ScanDirectoryJob.class);//��־��¼��
	
	@Override
    public void execute(JobExecutionContext context) throws JobExecutionException 
    {
        //Every job has its own job detail       
        JobDetail jobDetail = context.getJobDetail();       
        // The name is defined in the job definition       
        String jobName = ((File) jobDetail).getName();//��������       
        // Log the time the job started       
        logger.info(jobName + " fired at " + new Date());//��¼����ʼִ�е�ʱ��       
        // The directory to scan is stored in the job map       
        JobDataMap dataMap = jobDetail.getJobDataMap();//���������õ�����ӳ���       
        String dirName = dataMap.getString("SCAN_DIR");//��ȡҪɨ���Ŀ¼       
        // Validate the required input       
        if (dirName == null) 
        {//����Ҫ��ɨ��Ŀ¼û���ṩ       
             throw new JobExecutionException( "Directory not configured" );       
        }       
        // Make sure the directory exists       
        File dir = new File(dirName);       
        if (!dir.exists()) 
        {//�ṩ���Ǵ���Ŀ¼       
            throw new JobExecutionException( "Invalid Dir "+ dirName);       
        }       
        // Use FileFilter to get only XML files       
        FileFilter filter = new FileExtensionFileFilter(".xml");       
        //ֻͳ��xml�ļ�
        File[] files = dir.listFiles(filter);       
        if (files == null || files.length <= 0) 
        {//Ŀ¼��û��xml�ļ�       
            logger.info("No XML files found in " + dir);       
            // Return since there were no files       
            return;
        }       
        // The number of XML files       
        int size = files.length;          
        // Iterate through the files found       
        for (int i = 0; i < size; i++) 
        {
            File file = files[i];       
            // Log something interesting about each file.       
            File aFile = file.getAbsoluteFile();       
            long fileSize = file.length();       
            String msg = aFile + " - Size: " + fileSize;       
            logger.info(msg);//��¼���ļ���·���ʹ�С
        } 
    }
}