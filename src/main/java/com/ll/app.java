package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class app {
    Scanner scanner = new Scanner(System.in);
    int wiseSayingNumber = 0;
    List<Inventory> inventoryList = new ArrayList<>();

    public void run() {

        while (true) {
            System.out.print("명령 : ");
            String sc = scanner.nextLine();

            Rq rq = new Rq(sc);

            System.out.println(rq.getAction());
            System.out.println(rq.getParamAsInt("id",0));
            if (sc.equals("종료")) {
                break;
            } else if (sc.equals("등록")) {
                registration();
            } else if (sc.equals("목록")) {
                todoList();
            } else if (sc.startsWith("삭제?")) {
                todoListRemove(sc);
            }
        }
    }

    void registration() {
        System.out.print("명언 : ");
        String wiseSaying = scanner.nextLine();
        System.out.print("작가 : ");
        String another = scanner.nextLine();
        wiseSayingNumber++;
        int id = wiseSayingNumber;
        System.out.printf("%d번 명언이 등록되었습니다%n", id);
        Inventory inventory = new Inventory(wiseSaying, another, id);
        inventoryList.add(inventory);
    }

    void todoList() {
        System.out.println("번호 / 작가 /명언");
        System.out.println("-".repeat(18));
        for (int i = inventoryList.size() - 1; i >= 0; i--) {
            Inventory inventory = inventoryList.get(i);
            System.out.printf("%d %s %s %n", inventory.id, inventory.another, inventory.wiseSaying);
        }
    }

    void todoListRemove(String sc) { //삭제?id=1
        int id= getparamAsInt(sc, "id", 0);
        if (id == 0) {
            System.out.println("id 를 입력하세요.");
            return;
        }

        System.out.printf("%d번 명언을 삭제합니다 %n", id);
    }

    int getparamAsInt(String sc, String paramName, int defalutValue) {
        String[] scBit = sc.split("\\?", 2);
        String action = scBit[0]; // "삭제?"
        String queryString = scBit[1]; // "id=2"
        String[] queryStringBit = queryString.split("&");
        for (int i = 0; i < queryStringBit.length; i++) { // id=1
            String queryStringStrBit = queryStringBit[i];
            String[] queryStringStrBits = queryStringStrBit.split("=", 2); //"id" , "2"
            String _paramName = queryStringStrBits[0]; //"id"
            String paramValue = queryStringStrBits[1]; //"2"
            if (_paramName.equals("id")) {
                try {
                    return Integer.parseInt(paramValue);
                } catch (NumberFormatException e) {
                    return defalutValue;
                }
            }

        }
       return defalutValue;
    }
}



