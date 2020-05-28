package Task_4;

import java.util.Scanner;


public class ArithmeticProgression {
    static int COUNT_OF_DATA=3;
    public static void main(String[] args) {
        boolean flag=true;
        do {
            try {
                arithmeticProgression(strParsing(getData()));
                flag=false;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (flag);

    }
    /* Метод считывает количество пар чисел (выявляя не введен ли ноль или нечисловое значение),
    записывает все числа в строку (проверяя разделены ли цифры пробелом и нет ли лишних пробелов).
    **/
    static String getData () {
        Scanner scan=new Scanner(System.in);
        int count=0;
        do {
            System.out.println("Введите количество арифметических прогрессий");
            String input=scan.nextLine();
            try {
                count=Integer.parseInt(input);
                if (count==0) System.out.println("Вы ввели пустое значение. Повторите ввод");
            } catch (NumberFormatException e) {
                System.out.println("Недопустимый ввод. Повторите.");
            }
        } while (count<=0);
        String member="";
        String inputMember="";
        for (int i = 0; i <count ; i++) {
            boolean err=true;
            do {
                System.out.printf("Введите три числа по тестовым данным №%d через пробел, " +
                        "первое число - начальный символ, второе число - шаг прогрессии, " +
                        "третье число - количество членов прогрессии", i + 1);
                System.out.println();
                String input=scan.nextLine();
                inputMember=input.trim();
                if (!inputMember.contains(" ")) {
                    System.out.println("Необходимо числа разделить пробелом");
                } else if (inputMember.split(" ").length % COUNT_OF_DATA!=0) {
                    System.out.println("Введено мнее трех чисел. Повторите ввод.");
                } else {
                    err=false;
                    member+=inputMember+" ";
                }
            } while (inputMember.isEmpty() || !inputMember.contains(" ") || err);
        }
        return member;
    }

    /* Метод преобразовывает строку в массив целых чисел.
    Если было введено нечисловое значение (за исключением '-') вместо числа пробрасывается в точку входа
    исключение.
    **/
    static int [] strParsing (String member) {
        String [] massStr=member.split(" ");
        int [] massMember=new int[massStr.length];
        for (int i = COUNT_OF_DATA-1; i <massStr.length ; i=i+COUNT_OF_DATA) {
            if (massStr[i].contains("-") && massStr[i].charAt(0)!='0'){
                throw new NumberFormatException("Значение "+massStr[i]+" должно быть " +
                        "положительным. Повторите ввод.");
            }
        }
        for (int i = 0; i <massMember.length ; i++) {
            for (int j = 0; j <massStr[i].length() ; j++) {
                if (!Character.isDigit(massStr[i].charAt(j)) && massStr[i].charAt(j)!='-') {
                    throw new NumberFormatException("Значение "+massStr[i]+" не является " +
                            "цифрой. Повторите ввод.");
                }
            }
            massMember[i]=Integer.parseInt(massStr[i]);
        }
        return massMember;
    }
    /* Метод осуществляет вычисление арифметической прогрессии */
    static void arithmeticProgression (int [] massMember) {
        int result=0;
        for (int i = 0; i <massMember.length ; i=i+3) {
            for (int j = 0; j <massMember[i+COUNT_OF_DATA-1]; j++) {
                result+=massMember[i]+massMember[i+1]*j;
            }
            System.out.printf("Результат арифметической прогрессии с первым членом %d и шагом %d для %d членов = %d",
                    massMember[i],massMember[i+1], massMember[i+COUNT_OF_DATA-1], result);
            System.out.println();
            result=0;
        }
    }
}
