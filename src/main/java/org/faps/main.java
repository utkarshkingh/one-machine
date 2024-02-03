package org.faps;

import java.util.Scanner;


public class main {
    

    
    public static void main(String[] args) {

        stringer();
                      
    }

    public static char[] stringer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string of 'c' and 't': ");
        String inputString = scanner.nextLine();
        char[] sequence = new char[inputString.length()];

        for(int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            sequence[i] = c;
        }
        
        return sequence;
    }

    public char[] getArray() {
        return stringer();
    }
}
