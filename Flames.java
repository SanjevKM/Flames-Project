

import java.util.*;

public class Flames {
  
    public static void main(String[] args) {

        System.out.println("**FLames Game**");
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the first name:");
        String name1 = sc.nextLine();
        System.out.println("Enter the second name:");
        String name2 = sc.nextLine();
    
        // Convert strings to StringBuilder to allow modification
        StringBuilder sbName1 = new StringBuilder(name1);
        StringBuilder sbName2 = new StringBuilder(name2);
    
        int len = name1.length() + name2.length();
    
        for (int i = 0; i < sbName1.length(); i++) {
            for (int j = 0; j < sbName2.length(); j++) {
                // Case-insensitive comparison of characters
                if (Character.toLowerCase(sbName1.charAt(i)) == Character.toLowerCase(sbName2.charAt(j))) {
                    // Replace matched characters with '*'
                    sbName1.setCharAt(i, '*');
                    sbName2.setCharAt(j, '*');
                    len -= 2;
                    break;
                }
            }
        }
    
        // Elimination Process using LinkedList
        LinkedList<Character> flamesList = new LinkedList<>(Arrays.asList('F', 'L', 'A', 'M', 'E', 'S'));
        int index = 0;
        while (flamesList.size() > 1) {
            index = (index + len - 1) % flamesList.size();
            flamesList.remove(index);
        }
        char result = flamesList.get(0);
    
        switch(result) {
            case 'F':
                System.out.println(name1 + " and " + name2 + " are friends");
                break;
            case 'L':
                System.out.println(name1 + " and " + name2 + " are lovers");
                break;
            case 'A':
                System.out.println(name1 + " have affection on " + name2);
                break;
            case 'M':
                System.out.println(name1 + " and " + name2 + " are going to marry");
                break;
            case 'E':
                System.out.println(name1 + " and " + name2 + " are enemies");
                break;
            case 'S':
                System.out.println(name1 + " and " + name2 + " are brothers/sisters");
                break;
        }
    }
}
