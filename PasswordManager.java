import java.io.*;
import java.util.*;

public class PasswordManager {
    private List<Credential> list = new ArrayList<>();
    private final String FILE = "data.txt";

    public PasswordManager() {
        load();
    }

    public void add(String site, String user, String pass) {
        String encPass = SecurityUtil.encrypt(pass);
        list.add(new Credential(site, user, encPass));
        save();
    }

    public void viewAll() {
        for (Credential c : list) {
            System.out.println("Site: " + c.getSite());
            System.out.println("Username: " + c.getUsername());
            System.out.println("Password: " + SecurityUtil.decrypt(c.getPassword()));
            System.out.println("---------------------");
        }
    }

    public void search(String site) {
        for (Credential c : list) {
            if (c.getSite().equalsIgnoreCase(site)) {
                System.out.println("Username: " + c.getUsername());
                System.out.println("Password: " + SecurityUtil.decrypt(c.getPassword()));
                return;
            }
        }
        System.out.println("Not found!");
    }

    private void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {
            for (Credential c : list) {
                bw.write(c.toString());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error saving!");
        }
    }

    private void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Credential.fromString(line));
            }
        } catch (Exception e) {
        }
    }
}