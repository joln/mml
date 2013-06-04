package net.ostree.telnetclient;

@SuppressWarnings("serial")
public class TelnetException extends Exception {

    public TelnetException() {
        super();
    }

    public TelnetException(String error) {
        super(error);
    }

    public TelnetException(Throwable t) {
        super(t);
    }

    public TelnetException(String error, Throwable t) {
        super(error, t);
    }

}
