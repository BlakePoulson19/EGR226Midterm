public class Node1 {
    private static int key = 4;
    public static String Node1Encrypt(String userInput){
        char[] chars = userInput.toCharArray();
        int i = 0;
        for (char c: chars) {
            c += key;
            chars[i] = c;
            i++;
        }
        String encryptedOutput = new String(chars);
        return encryptedOutput;
    }

    public static String Node1Decrypt (String input) {
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