package canaryprism.electronconfig;

import java.util.*;

class Main {
    static final String[] subshell_labels = { "s", "p", "d", "f", "g", "j", "y", "e", "r", "m", "b", "z", "w" };
    
    record Subshell(String label, int capacity) {}
    
    static final ArrayList<Subshell> subshells = new ArrayList<>();
    static {
        try {
            int n = 1;
            while (true) {
                for (int i = Math.ceilDiv(n, 2) - 1; i >= 0; i--) {
                    subshells.add(new Subshell((n - i) + subshell_labels[i], ((i * 2) + 1) * 2));
                }
                n++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {}
    }
    
    static String superscript(Number i) {
        return String.valueOf(i)
                .replace('0', '⁰')
                .replace('1', '¹')
                .replace('2', '²')
                .replace('3', '³')
                .replace('4', '⁴')
                .replace('5', '⁵')
                .replace('6', '⁶')
                .replace('7', '⁷')
                .replace('8', '⁸')
                .replace('9', '⁹');
    }
    
    static String electronConfiguration(int z) {
        var electrons = z;
        var sb = new StringBuilder();
        for (var subshell : subshells) {
            sb.append(subshell.label);
            if (subshell.capacity < electrons)
                sb.append(superscript(subshell.capacity));
            else
                sb.append(superscript(electrons));
            
            electrons -= subshell.capacity;
            
            if (electrons <= 0)
                break;
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        
        System.out.print("enter an atomic number: ");
        while (sc.hasNext()) {
            try {
                var z = sc.nextInt();
                System.out.println(electronConfiguration(z));
            } catch (InputMismatchException e) {
                System.out.println("not an integer");
            }
            System.out.print("enter an atomic number: ");
        }
    }
}