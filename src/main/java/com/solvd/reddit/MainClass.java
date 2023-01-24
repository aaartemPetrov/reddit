package com.solvd.reddit;

import com.google.gson.Gson;
import com.solvd.reddit.task1.company.Company;
import com.solvd.reddit.task1.company.Employee;
import com.solvd.reddit.task2.image_matrix.Image;
import com.solvd.reddit.task3.string_pattern.StringPattern;
import com.solvd.reddit.task4.palindrome.Palindrome;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Map;

import static java.util.Map.entry;

public class MainClass {

    public static void main(String args[]) throws FileNotFoundException {
        System.out.println("\nFirst\n");
        FileReader fileReader = new FileReader("/Users/apetrov/Documents/java/projects/reddit/src/main/resources/company.json");
        Gson gson = new Gson();
        Company company = gson.fromJson(fileReader, Company.class);
        int sumSalary = 0;
        for (Employee employee : company.getEmployees()) {
            sumSalary += employee.getSalary();
        }
        int avgSalary = sumSalary / company.getEmployees().size();
        System.out.println(avgSalary);


        System.out.println("\nSECOND\n");
        int[][] imageMatrix = {
                {1, 0, 0, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };
        Image.getRectanglesInfo(imageMatrix);


        System.out.println("\nTHIRD\n");
        String a = "[asdf][qwerty]3[z]";
        String b = "3[a]4[b]";
        String c = "3[a2[b]]";
        String d = "x2[a3[b]2[c]]y4[d]";

        System.out.println(StringPattern.asdf(a));
        System.out.println(StringPattern.asdf(b));
        System.out.println(StringPattern.asdf(c));
        System.out.println(StringPattern.asdf(d));


        System.out.println("\nFOURTH\n");
        System.out.println(Palindrome.isPalindrome("asd", "dsa", false));
        System.out.println(Palindrome.isPalindrome("asDsa", "asdsa", false));


        System.out.println("\nFIfTH\n");
        Map<String, Map<String, Map<String, Integer>>> test1 = Map.ofEntries(
                entry("2022-06-24", Map.ofEntries(entry("new reddit", Map.ofEntries(entry("uniques", 111902), entry("pageviews", 221081))), entry("android", Map.ofEntries(entry("uniques", 298063), entry("pageviews", 1153728))), entry("old reddit", Map.ofEntries(entry("uniques", 132801), entry("pageviews", 723509))), entry("ios", Map.ofEntries(entry("uniques", 311642), entry("pageviews", 755030))), entry("mobile web", Map.ofEntries(entry("uniques", 130288), entry("pageviews", 219457))))),
                entry("2022-06-23", Map.ofEntries(entry("new reddit", Map.ofEntries(entry("uniques", 118371), entry("pageviews", 225093))), entry("android", Map.ofEntries(entry("uniques", 280199), entry("pageviews", 1291546))), entry("old reddit", Map.ofEntries(entry("uniques", 145437), entry("pageviews", 760191))), entry("ios", Map.ofEntries(entry("uniques", 257443), entry("pageviews", 575184))), entry("mobile web", Map.ofEntries(entry("uniques", 116411), entry("pageviews", 191464))))),
                entry("2022-06-22", Map.ofEntries(entry("new reddit", Map.ofEntries(entry("uniques", 175446), entry("pageviews", 300378))), entry("android", Map.ofEntries(entry("uniques", 331628), entry("pageviews", 1613490))), entry("old reddit", Map.ofEntries(entry("uniques", 164052), entry("pageviews", 830788))), entry("ios", Map.ofEntries(entry("uniques", 288464), entry("pageviews", 626490))), entry("mobile web", Map.ofEntries(entry("uniques", 111844), entry("pageviews", 193197))))),
                entry("2022-06-21", Map.ofEntries(entry("new reddit", Map.ofEntries(entry("uniques", 140548), entry("pageviews", 267522))), entry("android", Map.ofEntries(entry("uniques", 375491), entry("pageviews", 1336061))), entry("old reddit", Map.ofEntries(entry("uniques", 189477), entry("pageviews", 957462))), entry("ios", Map.ofEntries(entry("uniques", 418290), entry("pageviews", 985014))), entry("mobile web", Map.ofEntries(entry("uniques", 198403), entry("pageviews", 336195)))))
        );

        int sum = test1.entrySet().stream()
                .filter(firstEntry -> {
                    String key = firstEntry.getKey();
                    return (LocalDate.now().getDayOfMonth() - Integer.parseInt(key.substring(key.lastIndexOf('-') + 1))) < 2;
                })
                .flatMap(firstEntry -> firstEntry.getValue().entrySet().stream()
                        .flatMap(secondEntry -> secondEntry.getValue().entrySet().stream()
                                .filter(thirdEntry -> "pageviews".equals(thirdEntry.getKey()))
                                .map(thirdEntry -> thirdEntry.getValue())))
                .reduce((x,y) -> x + y).get();

        System.out.println(sum);


        System.out.println("\nNINTH\n");
        int number = 15853443;
        char[] chars = Integer.toString(15853443).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                System.out.print(chars[i] + "+");
            } else {
                System.out.print(chars[i]);
            }
        }
        System.out.println();


        System.out.println("\nTENTH\n");
        String str = "asdfGGkjcl";
        char[] chars1 = str.toCharArray();
        String substr = "";
        for (int i = 0; i < chars1.length; i++) {
            if (i != chars.length - 1) {
                if (chars1[i] == chars1[i + 1]) {
                    substr = str.substring(i + 1);
                    break;
                }
            }
        }
        System.out.println(substr);
        System.out.println(substr.length());

    }

}


