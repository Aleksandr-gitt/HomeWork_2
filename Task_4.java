/**
 * 4) К калькулятору из предыдущего ДЗ добавить логирование.
 */
package HomeWork_2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;


public class Task_4 {
    public static void main(String[] args) throws IOException{
        Logger logger = Logger.getLogger(Task_4.class.getName());
        //ConsoleHandler ch = new ConsoleHandler();
        FileHandler fh = new FileHandler("HomeWork_2//log2.txt");
        //logger.addHandler(ch);
        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();
        //XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(sFormat);
        //fh.setFormatter(xml);

        
        Scanner scan = new Scanner(System.in);
        logger.log(Level.WARNING, "Начало работы!");
        System.out.println("Что будем делать?");
        System.out.println("Сложение(+), Вычитание(-), Умножение(*), Деление(/) :");
        String choice = scan.nextLine();
        logger.info("Ввод символа операции");
        System.out.println("Введите первое число :");
        double a = scan.nextInt();
        logger.info("Ввод первого числа");
        System.out.println("Введите второе число :");
        double b = scan.nextInt();
        logger.info("Ввод второго числа");
        scan.close();
        double c;
        switch (choice) {
            case "+":
                c = a+b;
                System.out.printf("%1.2f + %1.2f = %1.2f \n", a,b,c);
                logger.info("Выполнена операция сложения");
                break;
            case "-":
                c = a-b;
                System.out.printf("%1.2f - %1.2f = %1.2f \n", a,b,c);
                logger.info("Выполнена операция разницы");
                break;
            case "*":
                c = a*b;
                System.out.printf("%1.2f * %1.2f = %1.2f \n", a,b,c);
                logger.info("Выполнена операция умножения");
                break;
            case "/":
                c = a/b;
                System.out.printf("%1.2f / %1.2f = %1.2f \n", a,b,c);
                logger.info("Выполнена операция деления");
                break;
            default: System.out.println("Я таким не занимаюсь!!!");
                logger.log(Level.WARNING, "Ошибка ввода действия для выполнения операций калькуляытора : "+choice);
                break;
        }
        
        
        
        logger.log(Level.WARNING,"Конец работы");
    }
}       