package phonebook;

import java.util.*;
import java.io.*;

public class PhoneBookApp {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        ArrayList<Person> pList = new ArrayList<>();

        Reader fr = new FileReader("./PhoneDB.txt");
        BufferedReader br = new BufferedReader(fr);

        while (true) {
            String info = br.readLine();

            if (info == null) {
                break;
            }

            String[] person = info.split(",");
            pList.add(new Person(person[0], person[1], person[2]));
        }

        System.out.println("********************************************");
        System.out.println("*             전화번호 관리 프로그램              *");
        System.out.println("********************************************");

        boolean flag = true;

        while (flag) {
            System.out.println();
            System.out.println("1. 리스트    2.등록    3.삭제    4.검색    5.종료");
            System.out.println("--------------------------------------------");
            System.out.print("> 메뉴번호: ");

            String ipt = sc.next();
            int num = 0;

            try {
                num = Integer.parseInt(ipt);
            } catch (NumberFormatException e) {

            }

            switch(num) {
                case 1:
                    System.out.println("<1. 리스트>");
                    printAll(pList);
                    break;

                case 2:
                    System.out.println("<2. 등록>");

                    System.out.print("> 이름: ");
                    String name = sc.next();
                    System.out.print("> 휴대전화: ");
                    String hp = sc.next();
                    System.out.print("> 회사전화: ");
                    String company = sc.next();

                    pList.add(new Person(name, hp, company));
                    update(pList);
                    System.out.println("[등록되었습니다.]");
                    break;

                case 3:
                    System.out.println("<3. 삭제>");
                    System.out.print("> 번호: ");
                    int no = sc.nextInt();

                    if (pList.size() == 0) {
                        System.out.println("[DB에 데이터가 없습니다.]");
                    } else if (no <= pList.size() && no >= 0) {
                        pList.remove(no-1);
                        update(pList);
                        System.out.println("[삭제되었습니다.]");
                    } else {
                        System.out.println("[1부터 " + pList.size() + "까지의 숫자만 입력 가능합니다.]");
                    }
                    break;

                case 4:
                    System.out.println("<4. 검색>");
                    System.out.print("> 이름: ");
                    String search = sc.next();

                    int cnt = 0;
                    for (int i = 0; i < pList.size(); i++) {
                        Person curr = pList.get(i);

                        if (curr.getName().contains(search)) {
                            print(pList, i);
                            cnt++;
                        }
                    }

                    if (cnt == 0) {
                        System.out.println("[\"" + search + "\"(이)가 포함된 검색 결과가 없습니다." + "]");
                    }
                    break;

                case 5:
                    flag = false;
                    break;

                default:
                    System.out.println("[다시 입력해 주세요.]");
            }
        }

        System.out.println();
        System.out.println("********************************************");
        System.out.println("*                 감사합니다                  *");
        System.out.println("********************************************");

        br.close();
        sc.close();
    }


    public static void printAll(ArrayList<Person> p) {
        for (int i = 0; i < p.size(); i++) {
            Person curr = p.get(i);
            System.out.println(i+1 + ".    " + curr.getName() + "    " + curr.getHp() + "    " + curr.getCompany());
        }
    }


    public static void print(ArrayList<Person> p, int i) {
        Person curr = p.get(i);
        System.out.println(i+1 + ".    " + curr.getName() + "    " + curr.getHp() + "    " + curr.getCompany());

    }


    public static void update(ArrayList<Person> person) throws IOException {
        Writer fw = new FileWriter("./PhoneDB.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        for (Person p: person) {
            String info = p.getName() + "," + p.getHp() + "," + p.getCompany();
            bw.write(info);
            bw.newLine();
        }

        bw.close();
    }
}
