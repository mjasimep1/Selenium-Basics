package Test.Practice;

import org.testng.annotations.Test;

import java.util.Random;

public class practice {
    public static String genString;
    @Test
    public void test(){
       practice practice=new practice();
        practice.getAlphaNumericString();
        System.out.println("starting test");
        practice.getAlphaNumericString();
        System.out.println("--------------------------");
        System.out.println("1 st: "+genString);
        System.out.println("--------------------------");
        System.out.println("2 nd: "+genString);
        System.out.println("--------------------------");


    }
    public void getAlphaNumericString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        genString=generatedString;
        System.out.println(generatedString);
    }
    @Test(priority = 3)
    public void tesat(){
        System.out.println("Testing---------------");
        System.out.println(genString);
    }
    }
