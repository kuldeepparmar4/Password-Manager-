import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PasswordManager pm = new PasswordManager();

        while (true) {
            System.out.println("\n--- Password Manager ---");
            System.out.println("1. Add Credential");
            System.out.println("2. View All");
            System.out.println("3. Search");
            System.out.println("4. Exit");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Site: ");
                    String site = sc.nextLine();

                    System.out.print("Enter Username: ");
                    String user = sc.nextLine();

                    System.out.print("Enter Password: ");
                    String pass = sc.nextLine();

                    pm.add(site, user, pass);
                    break;

                case 2:
                    pm.viewAll();
                    break;

                case 3:
                    System.out.print("Enter Site: ");
                    pm.search(sc.nextLine());
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}