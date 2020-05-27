package Task_4;

import java.util.Scanner;

public class DescribeNumb {
    static  int numb;
    public static void main(String[] args) {
        analyzeNumb(getNumb());
    }

    static int getNumb() {
        Scanner scan = new Scanner(System.in);
        String input = "";
        boolean flag=true;
        while (true) {
            System.out.println("Введите одно число");
            input = scan.next();
            try {
                numb = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели недопустимый символ. Повторите ввод");
            }
        }
        return numb;
    }

    static void analyzeNumb(int numb) {
        if (numb>0) System.out.println("Число положительное");
        else if (numb<0) System.out.println("Число отрицательное");
        else System.out.println("Число равно нулю");
        System.out.println(numb%2==0? "Число четное":"Число нечетное");
    }
}
