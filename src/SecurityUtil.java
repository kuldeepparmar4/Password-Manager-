public class SecurityUtil {

    public static String encrypt(String text) {
        String result = "";
        for (char c : text.toCharArray()) {
            result += (char)(c + 3);
        }
        return result;
    }

    public static String decrypt(String text) {
        String result = "";
        for (char c : text.toCharArray()) {
            result += (char)(c - 3);
        }
        return result;
    }
}