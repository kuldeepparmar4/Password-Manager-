public class Credential {
    private String site;
    private String username;
    private String password;

    public Credential(String site, String username, String password) {
        this.site = site;
        this.username = username;
        this.password = password;
    }

    public String getSite() { return site; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public String toString() {
        return site + "," + username + "," + password;
    }

    public static Credential fromString(String data) {
        String[] parts = data.split(",");
        return new Credential(parts[0], parts[1], parts[2]);
    }
}