import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static String num;
    public static String num1;
    public static String num2;

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();


        String[] parts = str.split("\s[-+*/]"); // делим строку по пробелу и записываем результат в массив;
        String num1 = parts[0].trim();
        String num2 = parts[1].trim();

        String operation = str.replace(num1,"");
        char znak =operation.charAt(1);



        num1 = Dell(num1);


        switch (znak) {
            case '+':
                num2 = Dell(num2);


                OperationWithInt.addition(num1, num2);

                break;
            case '-':
                num2 = Dell(num2);
                num = num1.replace(num2, ""); // заменяем в строке num1 совпавшее значения с строкой num2 , на ничто

                break;
            case '*':
                OperationWithInt.multiplication(num2, num1);

                break;
            case '/':
                OperationWithInt.division(num2, num1);

                break;
            default:
                throw new IOException("Введено значение не по условию");


        }


        if (num.length() > 40) {
            System.out.println('"' + num.substring(0, 39) + "..." + '"');
        } else {
            System.out.println('"' + num + '"');
        }


    }


    public static String Dell(String a) throws IOException {                       // убераем " из строки
        if (a.charAt(0) == '"' && a.charAt(a.length() - 1) == '"') {
            a = a.substring(1, a.length() - 1);
        } else {
            throw new IOException("Введено значение не по условию");
        }

        if (a.length() > 10) {
            throw new IOException("Введено значение не по условию : длина строки не более 10 символов");
        }
        return a;


    }
}

