package net.ostree.telnetclient;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.apache.commons.net.telnet.TelnetClient;


public class TelnetBrowser {
    
    
    private TelnetClient client;
    private String host;
    private int port;
    private PrintStream out;
    private BufferedReader in;
    
    
    public TelnetBrowser(String host, int port) {
        client = new TelnetClient();
        this.host = host;
        this.port = port;
    }
    
    public void connect() throws TelnetException {
        try {
            client.connect(host, port);
        } catch (Exception e) {
            throw new TelnetException(e);
        }
    }
    
    public void disconnect() throws TelnetException {
        try {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
            client.disconnect();
        } catch (IOException e) {
            throw new TelnetException(e);
        }
    }
    
    public void sendCommand(String cmd) throws TelnetException {
        if (!client.isConnected()) {
            throw new IllegalStateException();
        }
        if (out == null) {
            out = new PrintStream(client.getOutputStream());
        }
        if (in == null) {
            InputStreamReader isr = new InputStreamReader(client.getInputStream());
            in = new BufferedReader(isr);
        }
        try {
            out.print(cmd);
            out.flush();
            String str = null;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            throw new TelnetException(e);
        }
    }
    
}
