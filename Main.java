import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println(calc(input));

    }

    public static String calc(String input) throws Exception {
        int number1;
        int number2;
        String result;
        String oper = null;
        boolean isRoman;
        int k = 0;
        String[] operations = {"+", "-", "*", "/"};
        for (int i = 0; i < operations.length; i++) {
            if (input.contains(operations[i])) {
                oper = operations[i];
                k++;
            }
        }
        if (k == 0) {
            throw new Exception("Неизвестная операция");
        }

        String[] arr = input.split("[+\\-*/]");
        if (arr.length != 2) {
            throw new Exception("Неверное колличество операндов");
        }
        if (Roman.isRoman(arr[0]) && Roman.isRoman(arr[1])) {
            number1 = Roman.convertToArabian(arr[0]);
            number2 = Roman.convertToArabian(arr[1]);
            isRoman = true;
        } else if (!Roman.isRoman(arr[0]) && !Roman.isRoman(arr[1])) {
            number1 = Integer.parseInt(arr[0]);
            number2 = Integer.parseInt(arr[1]);
            isRoman = false;
        } else {
            throw new Exception("Числа должны быть в одном формате");
        }
        if (number1 > 10 || number2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        int arabian = 0;
        switch (oper) {
            case "+":
                arabian = number1 + number2;
                break;
            case "-":
                arabian = number1 - number2;
                break;
            case "*":
                arabian = number1 * number2;
                break;
            case "/":
                arabian = number1 / number2;
                break;
        }
        if (isRoman) {
            if (arabian <= 0) {
                throw new Exception("Римское число должно быть больше нуля");
            }
            result = Roman.convertToRoman(arabian);
        } else {
            result = String.valueOf(arabian);
        }
        return result;
    }
}

class Roman {
    static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "VIIII", "X", "XI", "XII",
            "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII",
            "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV",
            "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
            "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII",
            "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV",
            "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static boolean isRoman(String val) {
        for (int i = 0; i < romanArray.length; i++) {
            if (val.equals(romanArray[i])) {
                return true;
            }
        }
        return false;
    }

    public static int convertToArabian(String roman) {
        for (int i = 0; i < romanArray.length; i++) {
            if (roman.equals(romanArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String convertToRoman(int arabian) {
        return romanArray[arabian];
    }
}



