import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        // Task for generating random number
        Random random = new Random();
        System.out.println(random.nextInt(6));

        // Task 1: Check for palindrome
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = input.nextLine();
        int strlen = str.length();
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(strlen - i - 1)) {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "is palindrome" : "not palindrome");

        // Task 2: Email validation
        System.out.println("Enter a input string:");
        str = input.nextLine();
        Pattern pattern = Pattern.compile("([a-zA-Z]+\\d+|[a-zA-Z]+|[a-zA-Z]+\\.[a-zA-Z]+)@gmail.com");
        Matcher matcher = pattern.matcher(str);
        boolean b = matcher.matches();
        if (b) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }

        // Task 3: Current date in a specific format
        LocalDate today = LocalDate.now();
        String newDate = today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("before " + today);
        System.out.println("after " + newDate);

        // Task 4: Add 30 days to a date
        System.out.println("Enter a date (yyyy-MM-dd):");
        str = input.nextLine();
        LocalDate date = LocalDate.parse(str);
        date = date.plusDays(30);
        System.out.println(date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        // Task 5: Convert number to Roman numeral
        System.out.println("Enter a number:");
        str = input.nextLine();
        int mInt = Integer.parseInt(str);
        String[] rnChars = {"M", "CM", "D", "C", "XC", "L", "X", "IX", "V", "I"};
        int[] rnVals = {1000, 900, 500, 100, 90, 50, 10, 9, 5, 1};
        String retVal = "";
        for (int i = 0; i < rnVals.length; i++) {
            int num = mInt / rnVals[i];
            if (num == 0) continue;
            retVal += (num == 4 && i > 0) ? rnChars[i] + rnChars[i - 1] : rnChars[i];
            mInt = mInt % rnVals[i];
        }
        System.out.println("roman number = " + retVal);

        // Task 6: Validate brackets
        System.out.println("Enter brackets:");
        str = input.nextLine();
        if (Pattern.compile("\\(\\)|\\(\\)\\{\\}\\[\\]|\\[\\{\\(\\)\\}\\]").matcher(str).matches())
            System.out.println("valid");
        else
            System.out.println("Invalid");

        // Task 7: Find the longest common prefix
        String[] strArr = {"dog", "racecar", "car"};
        if (strArr.length == 0)
            System.out.println("string is empty");
        else if (strArr.length == 1)
            System.out.println(strArr[0]);
        else {
            String firstStr = strArr[0];
            for (int i = 1; i < strArr.length; i++) {
                String currstr = strArr[i];
                int j = 0;
                while (j < currstr.length() && j < firstStr.length() && currstr.charAt(j) == firstStr.charAt(j)) {
                    j++;
                }
                if (j == 0) {
                    System.out.println("this is not matched");
                    break;
                }
                firstStr = currstr.substring(0, j);
            }
            System.out.println(firstStr);
        }

        // Task 8: Remove duplicates and sort characters
        System.out.println("Enter a string:");
        str = input.nextLine();
        newStr = "";
        arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int j;
            for (j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    break;
                }
            }
            if (i == j) {
                newStr += arr[i];
            }
        }
        System.out.println(newStr);
        char[] arr1 = newStr.toCharArray();
        Arrays.sort(arr1);
        newStr = String.valueOf(arr1);
        System.out.println(newStr);
    }
}
