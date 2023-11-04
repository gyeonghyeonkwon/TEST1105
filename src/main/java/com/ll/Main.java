package com.ll;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("명령 : ");
            String sc = scanner.nextLine();
            if(sc.equals("종료")){
                break;
            }
        }
    }
}