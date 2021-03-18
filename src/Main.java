import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Type something");
        Scanner s = new Scanner(System.in);
        String userInput = s.nextLine();
        System.out.println("Type something else");
        String userInput2 = s.nextLine();
        ArrayList<String> RAM = new ArrayList<String>(); // the clients RAM object
        RAM.add(userInput);
        RAM.add(userInput2);
        String decrypted1 = encryptDecrypt(RAM.get(0));
        String decrypted2 = encryptDecrypt(RAM.get(1)); // send userInput to the nodes
        RAM.remove(0);
        RAM.remove(0); // clear memory
        RAM.add(decrypted1);
        RAM.add(decrypted2); // add new strings to RAM after they've been encrypted/decrypted
        // CPU Functions simulation
        String finalString = RAM.get(0) + " " + RAM.get(1);
        RAM.remove(0);
        RAM.remove(0); // clear memory
        RAM.add(finalString);
        System.out.println(RAM.get(0));
    }
    public static String encryptDecrypt(String input) throws Exception {
            ArrayList<String> RAM = new ArrayList<String>(); // creating the "RAM" object
            RAM.add(input); // add the userInput to the ram.
            String encrypt1 = Node1.Node1Encrypt(RAM.get(0)); // input gets sent from RAM to the node
            System.out.println(encrypt1);
            RAM.remove(0); // cleared from memory
            RAM.add(encrypt1); // encrypted string gets added to memory
            String encrypt2 = Node2.Node2Encrypt(RAM.get(0)); // Encrypted String sent to the nextNode
            RAM.remove(0); // previous string cleared from memory
            System.out.println(encrypt2);
            RAM.add(encrypt2); // new, twice-encrypted string is added to memory
            byte[] node3Encrypted = Node3.Initialize(RAM.get(0)); // String is sent to the third and final node
            System.out.println(node3Encrypted);
            RAM.remove(0); // memory cleared
            String node3Decrypted = Node3.Node3Decrypt(node3Encrypted); // 1st Decryption in 3rd node
            System.out.println(node3Decrypted);
            RAM.add(node3Decrypted); // added to memory
            String node2Decrypted = Node2.Node2Decrypt(RAM.get(0)); // 2nd decryption in 2nd node
            System.out.println(node2Decrypted);
            RAM.remove(0); // memory cleared
            RAM.add(node2Decrypted);  // added to memory
            String node1Decrypted = Node1.Node1Decrypt(RAM.get(0)); // final decryption on 1st node
            System.out.println(node1Decrypted);
            RAM.remove(0); // memory cleared
            RAM.add(node1Decrypted); // final decrypted String is added to memory
            return RAM.get(0);
    }
}