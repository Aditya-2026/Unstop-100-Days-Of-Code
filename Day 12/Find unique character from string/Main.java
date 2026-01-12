import java.util.Scanner;

class Main {
        
    public static void determine_winner(String smit, String joy) {
        smit = smit.toLowerCase();
        joy = joy.toLowerCase();

        boolean[] seenSmit = new boolean[26];
        boolean[] seenJoy = new boolean[26];

        int smitCount = 0, joyCount = 0;

        for (int i = 0; i < smit.length(); i++) {
            int c1 = smit.charAt(i) - 'a';
            int c2 = joy.charAt(i) - 'a';

            if (!seenSmit[c1]) {
                seenSmit[c1] = true;
                smitCount++;
            }

            if (!seenJoy[c2]) {
                seenJoy[c2] = true;
                joyCount++;
            }
        }

        if (smitCount == joyCount){
            System.out.print("TIE");
        }else if (smitCount > joyCount){
            System.out.print("SMIT");
        }else{
            System.out.print("JOY");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String smit_str = scanner.nextLine();
        String joy_str = scanner.nextLine();
        
        determine_winner(smit_str, joy_str);
        scanner.close();
    }
}