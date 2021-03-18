public class Node2 {
    private static int key = 2;
    public static String Node2Encrypt (String input){
        char[] chars = input.toCharArray();
        int i = 0;
        for (char c: chars) {
            c +=  key;
            chars[i] = c;
            i++;
        }
        String encryptedOutput = new String(chars);
        return encryptedOutput;
    }

    public static String Node2Decrypt (String input) {
        char[] chars = input.toCharArray();
        int i = 0;
        for (char c : chars) {
            c -= key;
            chars[i] = c;
            i++;
        }
        String decryptedOutput = new String(chars);
        return decryptedOutput;
    }
}
