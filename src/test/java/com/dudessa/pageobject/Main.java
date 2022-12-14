package com.dudessa.pageobject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        WebDriver webDriver = new ChromeDriver();
//        WebDriverManager.chromedriver().setup();
//        webDriver.get("https://www.valentino.com/en-ca");
//        HomePage homePage = new HomePage(webDriver);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        System.out.println(merge(list, list2));

        System.out.println("---------------------------------");
        int[] arrrr = {2,3,10,5,7,8,9};
        System.out.println(maxArea(arrrr));

    }

    public static List<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
        int secondListPointer = 0;
        int resultPointer = 0;

        while(resultPointer!=b.size()*2){
            if(resultPointer < a.size() && secondListPointer< b.size() && a.get(resultPointer) >= b.get(secondListPointer)) {
                a.add(resultPointer, b.get(secondListPointer));
                secondListPointer++;
            } else if(resultPointer == a.size()){
                a.add(resultPointer, b.get(secondListPointer));
                secondListPointer++;
            }
            resultPointer++;
        }
        return a;
    }

    public static int maxArea(int[] height) {
        int maxAmountOfWater = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                maxAmountOfWater = Math.max(maxAmountOfWater, Math.min(height[i], height[j]) * (j-i));
            }
        }
        return maxAmountOfWater;
    }
}
