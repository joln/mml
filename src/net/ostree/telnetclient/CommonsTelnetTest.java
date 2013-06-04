package net.ostree.telnetclient;
import java.io.IOException;  

import java.io.InputStream;  
 
import java.io.PrintStream;  
  
import org.apache.commons.net.telnet.TelnetClient;  

public class CommonsTelnetTest {  
  
       private final String ip = ""; // Ҫtelnet��IP��ַ  
 
       private final String port = "23"; //�˿ںţ�Ĭ��23  
       
       private final String user = "";//�û���  
  
       private final String pwd = ""; //�û�����  
  
       private final String osTag = "$";// ϵͳ��ʾ����  
  
       private final TelnetClient tc = new TelnetClient(); //�½�һ�� TelnetClient���󣬴˶����� commons-net-2.0.jar���ṩ  
  
       private InputStream in; // �����������շ�����Ϣ  
  
       private PrintStream out; //�� ������д�� ����  
  
   
  
       public void connect() {  
  
              try {  
  
                     tc.connect(ip, Integer.parseInt(port));  
  
                     in = tc.getInputStream();  
  
                     out = new PrintStream(tc.getOutputStream());  
  
              } catch (Exception e) {  
  
                     System.out.println("connect error !");  
  
              }  
  
       }  
  
   
  
       public String execute(String command) {  
  
              connect();  
  
              out.println(command);  
  
              out.flush();  
  
   
  
              StringBuffer sb = new StringBuffer();  
  
   
  
              try {  
  
                     char ch = (char) in.read();  
  
                     while (true) {  
  
                            sb.append(ch);  
  
                            if (ch == osTag.charAt(osTag.length() - 1)) {  
  
                                   if (sb.toString().endsWith(osTag))  
  
                                          return sb.toString();  
  
                            }  
  
                            ch = (char) in.read();  
  
                     }  
  
   
  
              } catch (IOException e) {  
  
                     e.printStackTrace();  
  
              }  
  
              return "error! when the program execute";  
  
       }  
  
         
   
        public static void main(String [] args){  
   
               System.out.println(new CommonsTelnetTest().execute("ls"));  
   
        }  
   
    
   
 }  
