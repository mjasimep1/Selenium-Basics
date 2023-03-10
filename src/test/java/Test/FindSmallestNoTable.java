package Test;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindSmallestNoTable {
    @Test(enabled = false)
    public void smallestNo() throws InterruptedException {
        //Day 28|01:00:00
//Find the smallest no
    int[] a={25,50,15,12,78};
    int b[]={78,68,45,71,21,56};
        //System.out.println(a[3]);
       // System.out.println(b[3]);
        Arrays.sort(a);
        for(int i:a){
            System.out.println(i);
        }
        for(int i=0;i<a.length;i++){
            System.out.println("Smallest number is: "+a[0]);
            break;
        }
    //Eliminating $ symbol
        String price="$200.25";
        String actPrice=price.replace("$","");
        System.out.println("without $: "+actPrice);

        String string = "004-034556";
        String[] parts = string.split("(?<=-)");
        String part1 = parts[0]; // 004-
        String part2 = parts[1];
        System.out.println(part1+"  "+part2);

    //Split the string
        String str = "geekss@for@geekss";
        String[] arrOfStr = str.split("@", 2);

        for (String aa : arrOfStr){
            System.out.println(aa);
    }

    }
}
