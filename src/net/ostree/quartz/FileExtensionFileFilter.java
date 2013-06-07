package net.ostree.quartz;
import  java.io.File;       
import  java.io.FileFilter;   

public class FileExtensionFileFilter implements  FileFilter 
{
     private  String extension;//�ļ���׺     
     
     public  FileExtensionFileFilter(String extension)
     {       
         this.extension = extension;
     }             
     public   boolean  accept(File file)
     {//ֻ����ָ����׺���ļ�       
         // Lowercase the filename for easier comparison       
         String lCaseFilename = file.getName().toLowerCase();//Сд��
         return  (file.isFile() &&(lCaseFilename.indexOf(extension) >  0 )) ?  true : false ;       
     }       
}