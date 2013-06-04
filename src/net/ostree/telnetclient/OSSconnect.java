package net.ostree.telnetclient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.apache.commons.net.telnet.*;

public class OSSconnect {

	private static String ip;
	private static String port;
	// private static String prompt = "END";
	private static InputStream in;
	private static PrintStream out;
	private static TelnetClient telnet = new TelnetClient();
	private static StringBuffer sb;

	public static void ossconnect(String ip, int port) {

		try {
			telnet.connect(ip, port);
			in = telnet.getInputStream();
			out = new PrintStream(telnet.getOutputStream());
			System.out.println(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String readUntil(String pattern) {
		try {
			char lastChar = pattern.charAt(pattern.length() - 1);
			sb = new StringBuffer();
			InputStreamReader isr = new InputStreamReader(in, "GBK");

			char ch = (char) isr.read();
			while (true) {
				sb.append(ch);
				if (ch == lastChar) {
					if (sb.toString().endsWith(pattern)) {
						byte[] temp = sb.toString().getBytes("iso8859-1");
						return new String(temp, "GBK");
					}
				}
				ch = (char) in.read();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static String readUntil2(String pattern) {
		try {
			// char lastChar = pattern.charAt(pattern.length() - 1);
			sb = new StringBuffer();
			InputStreamReader isr = new InputStreamReader(in, "GBK");
			BufferedReader brd = new BufferedReader(isr);
			String str = null;
			while (true) {
				str = brd.readLine();
				sb.append(str);
				System.out.println(str);
				// mmlchuli.mmlcmdchuli(str, 12);
				if (!str.endsWith(pattern)) {
					// System.out.println(str);
					str = null;
				} else {
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static void write(String value)

	{
		try {
			out.println(value);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String sendCommand(String command, String prompt) {
		try {
			write(command);
			return readUntil(prompt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String sendCommand2(String command, String prompt) {
		try {
			write(command);
			return readUntil2(prompt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void disconnect() {
		try {
			telnet.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
