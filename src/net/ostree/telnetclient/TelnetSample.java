package net.ostree.telnetclient;
import org.apache.commons.net.telnet.*;
import java.io.*;
/**
* ʹ��apache��commons-net��ģ��telnet ��¼
* @author Administrator
*
*/
public class TelnetSample {
private TelnetClient telnet = null;
private InputStream in;
private PrintStream out;
private char prompt = '#';//linux��ʾ��

/**
* ��¼linux
* @param server
* @param user
* @param password
*/
public TelnetSample(String server, String user, String password) {
   try {
    // Connect to the specified server
    telnet = new TelnetClient();
    // network virtual terminal (NVT) ʹ�� VT100
    TerminalTypeOptionHandler ttopt = new TerminalTypeOptionHandler(
      "VT100", false, false, true, false);
    EchoOptionHandler echoopt = new EchoOptionHandler(true, false,
      true, false);
    SuppressGAOptionHandler gaopt = new SuppressGAOptionHandler(true,
      true, true, true);

    //Registers a new TelnetOptionHandler for this telnet client to use.
    telnet.addOptionHandler(ttopt);
    telnet.addOptionHandler(echoopt);
    telnet.addOptionHandler(gaopt);

    telnet.connect(server, 23);

    // Get input and output stream references
    in = telnet.getInputStream();
   
    out = new PrintStream(telnet.getOutputStream());

    // Log the user on
    readUntil("login: ");
    write(user);

    readUntil("Password: ");
    write(password);

    // Advance to a prompt
    readUntil("$" + " ");
   
//    readUntil("$" + "su = root");
    //write("su - root");

   } catch (Exception e) {
    e.printStackTrace();
   }
}
/**
* �ı䵱ǰ��¼�û�
* @param user �û���
* @param password ����
* @param serTile linux�û���ʾ��
* @return
*/
public String suUser(String user,String password,String userTitle){
   //System.out.println("�ı䵱ǰ�û���");  
   write("su - "+user);
// System.out.println("׼����ȡ���ص��������ǲ��ǿ��Լ���¼�������ˣ�");
   readUntil("���룺");//�п��ܲ������ģ�����telnet���������
   //System.out.println("������Ϣ��ʾ����¼�����룬�ſ�ʼ¼���룺");
   write(password);
   return readUntil(userTitle + " ");
}
/**
* ��ȡ����Ϣ
* @param pattern ����ȡʱ�Ľ����ַ�
* @return
*/
public String readUntil(String pattern) {
   try {
    char lastChar = pattern.charAt(pattern.length() - 1);
    //System.out.println("��ǰ�����ַ�����"+new InputStreamReader(in).getEncoding());
    StringBuffer sb = new StringBuffer( );
    byte[] buff = new byte[1024];      
            int ret_read = 0;
            String str="";
            do {      
                ret_read = in.read(buff);      
                if (ret_read > 0) {
                //�Ѷ�ȡ�����ַ�ת�룬������linux��������echo $LANG�鿴ϵͳ��ʲô����
                String v=new String(buff, 0, ret_read,"UTF-8");
                str=str+v;
                //System.out.println("debug:"+str+"========"+pattern);
                    if(str.endsWith(pattern)){
                    //System.out.println("�˳�:"+str+"========"+pattern);
                    break;
                    }
                }      
     
            } while (ret_read >= 0);                       
            return str; 
   } catch (Exception e) {
    e.printStackTrace();
   }
   return null;
}
/**
* �����з�����Ϣ
* @param value
*/
public void write(String value) {
   try {
    out.println(value);
    out.flush();
    System.out.println("¼������:"+value);
   } catch (Exception e) {
    e.printStackTrace();
   }
}
/**
* �������Ĭ��linux��ʾ����'$'
* @param command ����
* @return
*/
public String sendCommand(String command) {
   try {
    prompt = '$';
    write(command);
    return readUntil(prompt + " ");
   } catch (Exception e) {
    e.printStackTrace();
   }
   return null;
}
/**
* �������Ĭ��linux��ʾ����'$'
* @param command ����
* @param userTitle linux��ʾ��
* @return
*/
public String sendCommand(String command,char userTitle) {
   try {
    prompt = userTitle;
    write(command);
    return readUntil(prompt + " ");
   } catch (Exception e) {
    e.printStackTrace();
   }
   return null;
}
/**
* �ͷ�����
*/
public void disconnect() {
   try {
    telnet.disconnect();
   } catch (Exception e) {
    e.printStackTrace();
   }
}

public static void main(String[] args) {
   try {
    TelnetSample telnet = new TelnetSample("10.196.150.52", "administrator",
      "12345678");
    //ʹ��--color=no����ls�������ɫ��Ҫ����������
    String reStr=telnet.sendCommand("ls --color=no");
    System.out.println(reStr.replaceFirst("ls --color=no",""));
    telnet.suUser("root","rootroot","#");
    String reStr2=telnet.sendCommand("ls --color=no",'#');
    System.out.println(reStr2.replaceFirst("ls --color=no",""));
    telnet.disconnect();
   } catch (Exception e) {
    e.printStackTrace();
   }
}
}
