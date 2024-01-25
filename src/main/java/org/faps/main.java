package org.faps;

import java.time.Duration;
import java.util.Scanner;

public class main {


    public char[] main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a string of 'c' and 't': ");
    String inputString = scanner.nextLine();
    char[] Sequence = new char[inputString.length()];

    for(int i = 0; i < inputString.length(); i++) {
        char c = inputString.charAt(i);
        Sequence[i] = c;
    }
}
            
    public static char[] getSequence() {
        return Sequence[];
    
    
}


