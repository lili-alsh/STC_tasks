package Task_4;

import java.util.Scanner;

public class ArithmeticProgression {
    static int COUNT_OF_DATA = 3;

    public static void main(String[] args) {
        boolean flag = true;
        int quantity = getQuantity();
        int[] massMember = new int[quantity * 3];
        for (int i = 0; i < massMember.length / COUNT_OF_DATA; i++) {
            do {
                try {
                    int[] mass = strParsing(getString());
                    for (int j = 0; j < mass.length; j++) {
                        massMember[j + COUNT_OF_DATA * i] = mass[j];
                    }
                    flag = false;
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                    flag = true;
                }
            } while (flag);
        }
        arithmeticProgression(massMember);
    }

    /* Метод возвращает и считывает количество тестовых данных (выявляя не введен ли ноль или нечисловое значение).
     **/
    static int getQuantity() {
        Scanner scan = new Scanner(System.in);
        int count = 0;
        do {
            System.out.println("Введите количество арифметических прогрессий");
            String input = scan.nextLine();
            try {
                count = Integer.parseInt(input);
                if (count == 0) System.out.println("Вы ввели пустое значение. Повторите ввод");
            } catch (NumberFormatException e) {
                System.out.println("Недопустимый ввод. Повторите.");
            }
        } while (count <= 0);
        return count;
    }

    /* Метод считывает числа в строку, проверяя разделены ли цифры пробелом, убирая лишние пробелы в начале и конце
    строки, проверяя количество введеых цифр на соответствие COUNT_OF_DATA.
    **/
    static String getString() {
        Scanner scan = new Scanner(System.in);
        String member = "";
        boolean err = true;
        do {
            System.out.println("Введите три числа по тестовым данным через пробел, " +
                    "первое число - начальный символ, второе число - шаг прогрессии, " +
                    "третье число - количество членов прогрессии");
            String input = scan.nextLine();
            member = input.trim();
            String[] strMember = member.split(" ");
            if (!member.contains(" ")) {
                System.out.println("Необходимо числа разделить пробелом");
            } else if (strMember.length != COUNT_OF_DATA) {
                System.out.println("Введено мнее трех чисел. Повторите ввод.");
            } else if (strMember[COUNT_OF_DATA - 1].startsWith("0")) {
                System.out.println("Количество членов арифметической прогрессии не может быть неположительным");
            } else {
                err = false;
            }
        } while (member.isEmpty() || !member.contains(" ") || err);
        return member;
    }

    /* Метод преобразовывает строку в массив целых чисел.
    Если было введено нечисловое значение (за исключением '-') вместо числа пробрасывается в точку входа
    исключение.
    **/
    static int[] strParsing(String member) {
        String[] massStr = member.split(" ");
        int[] massMember = new int[massStr.length];

        for (int i = 0; i < massMember.length; i++) {
            for (int j = 0; j < massStr[i].length(); j++) {
                if (!Character.isDigit(massStr[i].charAt(j)) && massStr[i].charAt(j) != '-') {
                    throw new NumberFormatException("Значение " + massStr[i] + " не является " +
                            "цифрой. Повторите ввод.");
                }
            }
            massMember[i] = Integer.parseInt(massStr[i]);
        }
        return massMember;
    }

    /* Метод осуществляет вычисление арифметической прогрессии */
    static void arithmeticProgression(int[] massMember) {
        int result = 0;
        for (int i = 0; i < massMember.length; i = i + 3) {
            for (int j = 0; j < massMember[i + COUNT_OF_DATA - 1]; j++) {
                result += massMember[i] + massMember[i + 1] * j;
            }
            System.out.printf("Результат арифметической прогрессии с первым членом %d и шагом %d для %d членов = %d",
                    massMember[i], massMember[i+1], massMember[i + COUNT_OF_DATA - 1], result);
            System.out.println();
            result = 0;
        }
    }
}
