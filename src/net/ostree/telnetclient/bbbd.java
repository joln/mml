package net.ostree.telnetclient;

public class bbbd {

	static String BSCNAME="GYBSC0129302";
	public static void main(String[] args) {
		OSSconnect.ossconnect("10.195.145.18", 23);
		//String res0 = OSSconnect.sendCommand2("LGI:OP=WGZX,PWD=wg123456;","END");
		//String res = OSSconnect.sendCommand2("LST NE:;","END");
		//System.out.println(res);
//		String result2 = OSSconnect.sendCommand2("REG NE:NAME="+BSCNAME+";","END");
//		System.out.println(result2);
//		String result3 = OSSconnect.sendCommand2("LST GCELLCHMGAD:;","±¨¸æ");
		OSSconnect.disconnect();
	}

}
