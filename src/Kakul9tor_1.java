import java.util.Scanner;

public class Kakul9tor_1 {


    public static void main(String[] args) {
        String B1;
        String oper;
        String B2;
        System.out.println("Введите уравнение:");
        Scanner scanner = new Scanner(System.in);
        String[] massiv = scanner.nextLine().split(" ");

//        if (massiv.length != 3) {
//            throw new RuntimeException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, x )");
//        } else {
            B1 = massiv[0];
            if (massiv.length > 1)
            {
                oper = massiv[1];
            }
            else {
            throw new RuntimeException("т.к. строка не является математической операцией");
            }
            if (massiv.length>2)
            {B2 = massiv[2];
            }
            else {
                throw new RuntimeException("т.к. строка не является математической операцией");
            }
//        }
        boolean tr1 =rom_arab2(B1);
        boolean tr2 =rom_arab2(B2);
        boolean ti1=AraTest(B1);
        boolean ti2=AraTest(B2);
        //String B1 = scanner.next();
        //String oper = scanner.next();
        // String B2 = scanner.next();
        if ((tr1 && !ti1 && !tr2 && ti2) || (!tr1 && ti1 && tr2 && !ti2)) // проверка инты+римляне
        {
            throw new ArithmeticException("т.к Используются одновременно разные системы счисления");
        }
        if ((!tr1 && !ti1 && !tr2 && !ti2)||(!tr1 && ti1 && !tr2 && !ti2)||(!tr1 && !ti1 && !tr2 && ti2)||(tr1 && !ti1 && !tr2 && !ti2)||(!tr1 && !ti1 && tr2 && !ti2)) // проверка на крокозябру
        {
            throw new ArithmeticException("т.к некорректные данные допустимый диапазон значений [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10][I, II, III, IV, V, VI, VII, VIII, IX, X]");
        }
        if (AraTest(B1) && AraTest(B2)) {
            int N1, N2;
            N1 = Integer.parseInt(B1);
            N2 = Integer.parseInt(B2);
            if (N1 < 1 || N2 < 1 || N1 > 10 || N2 > 10) {
                throw new ArithmeticException("т.к допустимый диапазон значений [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
            } else {
                if (massiv.length != 3) {
                    throw new RuntimeException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, x )");
                }
                int ITOG = calc(oper, N1, N2);
                System.out.println("Результат:" + ITOG);
            }
        } else {
            int N1 = rom_arab(B1);
            int N2 = rom_arab(B2);

            if (N1 == 0 || N2 == 0) {
                throw new ArithmeticException("т.к допустимый диапазон значений [I, II, III, IV, V, VI, VII, VIII, IX, X]");
            }
            if (N1 > 10 || N2 > 10) {
                throw new ArithmeticException("т.к допустимый диапазон значений [I, II, III, IV, V, VI, VII, VIII, IX, X]");
            } else {
                int ITOG = calc(oper, N1, N2);
                if (ITOG <= 0) {
                    throw new ArithmeticException("т.к. в римской системе нет таких чисел");
                } else {
                    String result = convert(ITOG);

                    System.out.println("Результат:" + result);
                }


            }
        }
    }

    public static boolean AraTest(String B1) {
        int N1;

//        String[] massiv=B1.split(""); // проверка на нолик в начале
//        if(massiv[0].equals("0")) {
//            throw new ArithmeticException("т.к. непиши 0 кроме как в 10ке сцуко пол часа жизни потратил");
//        }
        try {
            N1 = Integer.parseInt(B1);
            String[] massiv=B1.split(""); // проверка на нолик в начале
            if(massiv[0].equals("0")) {
                throw new ArithmeticException("т.к допустимый диапазон значений [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
            }
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    } // проверка на интовость


    public static int rom_arab(String B1) { // перевод римлян в арабов
        int N1 = 0;
        int[] decimal = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int B3=B1.length();
        if (B3>3 || B1.equals("0")||B1.equals("VV"))
        { throw new RuntimeException("т.к допустимый диапазон значений [I, II, III, IV, V, VI, VII, VIII, IX, X]"); }
        for (int i = 0; i < decimal.length; i++) {
            while (B1.indexOf(roman[i]) == 0) {
                N1 += decimal[i];
                B1 = B1.substring(roman[i].length());
            }
        }
        if (B1 == null || B1.isEmpty() || B1.trim().isEmpty())
        {
            return N1;
        }
        else
        {
            throw new RuntimeException("т.к допустимый диапазон значений [I, II, III, IV, V, VI, VII, VIII, IX, X]");
        }
    } //

    public static boolean rom_arab2(String B2) {
        int N2 = 0;
        int[] decimal = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < decimal.length; i++) {
            while (B2.indexOf(roman[i]) == 0) {
                N2 += decimal[i];
                B2 = B2.substring(roman[i].length());
            }
        }
        //if (B2 == "IIII" || B1 )
        if (N2 > 0) {
            return true;
        } else {
            return false;
        }

        //return N2;
    } // возможно пригодится если даник опять душнить будет

    public static String romanDigit(int n, String one, String five, String ten) {

        if (n >= 1) {
            if (n == 1) {
                return one;
            } else if (n == 2) {
                return one + one;
            } else if (n == 3) {
                return one + one + one;
            } else if (n == 4) {
                return one + five;
            } else if (n == 5) {
                return five;
            } else if (n == 6) {
                return five + one;
            } else if (n == 7) {
                return five + one + one;
            } else if (n == 8) {
                return five + one + one + one;
            } else if (n == 9) {
                return one + ten;
            }

        }
        return "";
    } // часть 1 перевода арабов в римлян

    public static String convert(int ITOG) {

        String romanOnes = romanDigit(ITOG % 10, "I", "V", "X");
        ITOG /= 10;
        String romanTens = romanDigit(ITOG % 10, "X", "L", "C");
        ITOG /= 10;
        String romanHundreds = romanDigit(ITOG % 10, "C", "D", "M");


        String result = romanHundreds + romanTens + romanOnes;
        return result;

    } //часть 2 перевода арабов в римлян

    public static int calc(String oper, int N1, int N2) //считалочка
    {
        int ITOG;
        switch (oper) {
            case "+":
                ITOG = N1 + N2;
                break;
            case "-":
                ITOG = N1 - N2;
                break;
            case "*":
                ITOG = N1 * N2;
                break;
            case "/":
                if (N2 > 0) {
                    ITOG = N1 / N2;
                } else {
                    throw new ArithmeticException("т.к Бесконечность так-то, но тз душное");
                }
                break;
            default:
                throw new IllegalArgumentException("Т.к не коректно введен оператор в уравнении");
        }
        return ITOG;
    }

}
