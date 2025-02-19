import java.util.LinkedList;
import java.util.Locale;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't node"));
        System.out.println("***********************************");
        System.out.println(checkPalindromeFIFO("abccba"));
        System.out.println(checkPalindromeFIFO("Was it a car or a cat I saw ?"));
        System.out.println(checkPalindromeFIFO("I did, did I?"));
        System.out.println(checkPalindromeFIFO("hello"));
        System.out.println(checkPalindromeFIFO("Don't node"));
        System.out.println("***********************************");
        System.out.println(convertDecimalToBinary(13));
        System.out.println(convertDecimalToBinary(5));
        System.out.println(convertDecimalToBinary(6));
        System.out.println(convertDecimalToBinary(75));

    }

    public static boolean checkForPalindrome(String text) {

        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder noPunctionString = new StringBuilder();
        String lowerCase = text.toLowerCase(Locale.ENGLISH);

        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                noPunctionString.append(c);
                stack.push(c);

            }
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return noPunctionString.toString().equals(reversed.toString());
    }

    public static boolean checkPalindromeFIFO(String text) {

        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();
        String lowerCase = text.toLowerCase(Locale.ENGLISH);

        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                queue.addLast(c);
                stack.push(c);
            }
        }
        System.out.println("Queue" + queue);
        System.out.println("Stack" + stack);
        while(!stack.isEmpty()){
            if(!stack.pop().equals(queue.removeFirst())){
                return false;
            }
        }

return true ;
    }
    public static  String convertDecimalToBinary(int num){
        //5
        //5%2=1 2%2=0 1%2=1
        //5/2=2 2/2=1 1/2=0
    final int base=2;
        Stack digits=new Stack<>();
        while(num>0){
            digits.push(num%base);
            num=num/base;
        }
        String bits="";
        while(!digits.isEmpty()){
            bits +=digits.pop();

        }
        return bits;
    }

}