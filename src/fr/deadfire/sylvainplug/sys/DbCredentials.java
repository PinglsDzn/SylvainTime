package fr.deadfire.sylvainplug.sys;

public class DbCredentials {
    private String host;
    private int port;
    private String user;
    private String pass;
    private String dbname;

    public DbCredentials(String host, int port, String user, String pass, String dbname) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
        this.dbname = dbname;
    }

    public String toURI() {
        final StringBuilder sb = new StringBuilder();

        sb.append("jdbc:mysql://")
	        .append(host)
	        .append(":")
	        .append(port)
	        .append("/")
	        .append(dbname)
	        .append("?characterEncoding=utf8");

        return sb.toString();
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}
