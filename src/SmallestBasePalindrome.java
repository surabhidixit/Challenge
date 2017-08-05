import java.util.HashMap;
import java.util.Map;

/**
 * Created by surabhi on 8/3/17.
 */
public class SmallestBasePalindrome {

    /*
    * Method to create a hashmap that maps numbers 0-1000 to their smallest bases in which
    * they are palindromes
    * */
    public Map<Integer,Integer> getBase(){
        Map<Integer,Integer>baseindex=new HashMap<>();
        for(int i=0;i<=1000;i++){
            baseindex.put(i,converttoBase(i));
        }
        return baseindex;
    }


    //starting from 11 base if the number if >=10 and <base it is A,B..
    //starting the base it becomes 10,11,12..


    /*Method to convert given number to a base between 2-999
    *
    *
    * */
    public int converttoBase(int num) {
        int quotient,rem=0;
        StringBuilder sb = null;
        for (int base = 2; base < 1000; base++) {
            quotient=num;
            if(quotient==0)
                return base;
            /*We know that a number that is divisible by its base or if the base is equal to the number
             is not a palindrome
            */
            sb = new StringBuilder();
            if (num % base == 0 || num == base)
                continue;
            else {

                while (quotient >= 1) {
                    rem = quotient % base;
                    sb.append(checkValue(rem, base));
                    quotient = quotient / base;
                }
                if (isPalindrome(sb.toString()))
                    return base;
            }
        }
        //not palindrome in any base
        return -1;
    }

    /*
    * Method to check if a String is palindrome
    *
    * */
    public boolean isPalindrome(String str){
        if(str.length()<=1)
            return true;
        else{
            int len=str.length()-1;
            for(int i=0;i<str.length()/2;i++){
                if(str.charAt(i)!=str.charAt(len-i))
                    return false;
            }
            return true;
        }

    }


    /*
    * Method to check the remainder (for alphabet representation)
    *
    *
    * */
    public String checkValue(int rem,int base){
        //if number is single digit
        if(rem>=0&&rem<=9){
            return String.valueOf(rem);
        }
        else {
            //if number is A-Z and less than base
            if(rem>=10&&rem<base){
                return String.valueOf((char)(rem-10+'A'));
            }
            else return "";
        }
    }

/*main method calls getBase method that returns a Hashmap of numbers and corresponding smallest
bases
*/
    public static void main(String[] args) {
        SmallestBasePalindrome palindromeCheck=new SmallestBasePalindrome();
        Map<Integer,Integer>map=palindromeCheck.getBase();
        map.forEach((k,v)->System.out.println("Number : " + k + " Smallest base : " + v));
    }

}
