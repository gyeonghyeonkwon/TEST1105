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


            switch (rq.getAction()) {
                case "종료":
                    return;
                case "등록":
                    registration();
                    break;
                case "목록":
                    todoList();
                    break;
                case "삭제?":
                    todoListRemove(rq);
                    break;
                case "수정?":
                    todoListModify(rq);
                    break;
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

    void todoListRemove(Rq rq) { //삭제?id=1
        int id= rq.getParamAsInt( "id", 0);
        if (id == 0) {
            System.out.println("id 를 입력하세요.");
            return;
        }

        System.out.printf("%d번 명언을 삭제합니다 %n", id);
    }

    void todoListModify(Rq rq){
        int id= rq.getParamAsInt( "id", 0);
        if (id == 0) {
            System.out.println("id 를 입력하세요.");
            return;
        }
        System.out.printf("%d번 명언을 수정합니다 %n", id);
    }


}



