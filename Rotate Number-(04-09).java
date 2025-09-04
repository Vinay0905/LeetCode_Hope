// write a program to print the all n digit number which is same after rotate 180 degree .

// image
// For Example: If N = 2, all the strobogrammatic numbers of length = 2 are “11”, “88”, “69”, “96”.

// Input Format

// input consist of a single integer 2

// Output Format

// 11 69 88 96

// Sample Input 0

// 2
// Sample Output 0

// 11 69 88 96


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            sc.close();
            char[] rotate = new char[10];
            rotate[0] ='0';
            rotate[1] ='1';
            rotate[6] ='9';
            rotate[8] ='8';
            rotate[9] ='6';

            List<String> result = new ArrayList<>();


            int start =(int) Math.pow(10, n-1); 
            int end =(int) Math.pow(10, n)-1;   

            if (n == 1) {
                start = 0;
                end = 9;
            }

            for (int num = start; num <= end; num++) {
                String str = String.valueOf(num);


                if (str.length()!=n) continue;

                boolean valid = true;
                StringBuilder rotated = new StringBuilder();


                for (int i =str.length()-1;i>=0;i--) {
                    char c =str.charAt(i);
                    if (c !='0' && c!='1' && c!='6' && c!='8' && c!='9') {
                        valid=false;
                        break;
                    }
                    int digit = c-'0';
                    rotated.append(rotate[digit]);
                }

                if (valid && rotated.toString().equals(str)) {
                    result.add(str);
                }
            }


            for (int i=0;i<result.size();i++) {
                System.out.print(result.get(i));
                if (i<result.size()-1) System.out.print(" ");
            }
            System.out.println();
    }
}
