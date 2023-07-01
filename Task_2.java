/**
 * 2) Реализуйте алгоритм сортировки пузырьком числового массива, 
 * результат после каждой итерации запишите в лог-файл.
 */
package HomeWork_2;

import java.io.IOException;
import java.util.logging.*;

public class Task_2 {
    public static void main(String[] args) throws IOException {

        Logger logger = Logger.getLogger(Task_2.class.getName());
        //ConsoleHandler ch = new ConsoleHandler();
        FileHandler fh = new FileHandler("HomeWork_2//log.txt");
        //logger.addHandler(ch);
        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();
        //XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(sFormat);
        //fh.setFormatter(xml);
        
        logger.log(Level.WARNING, "Начало сортировки");
        



        int[] arr = {72, 0, -2, 66, -4, 3, 11};

        System.out.println("Было :");               //Вывод начального массива
        for(int el : arr)
            System.out.print(el+" ");
        
        boolean swapped;
        do {
            swapped = false;
            for( int i = 0; i < arr.length - 1; i++ ) {
                String res= "";                             //Создал пустую строку 
                if ( arr[i] > arr[i+1] ) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped = true;
                    for(int el : arr)                       // Заполнил пустую строку для вывода лога
                        res+=el+" ";
                    logger.info("Промежуточный результат "+res);
                }
            }
        } while ( swapped );
        System.out.println("\nСтало :");                    //Вывод результата сортировки
        for(int el : arr)
            System.out.print(el+" ");
        
        logger.log(Level.WARNING, "Сортировка закончена!");
            
     
    }
    
    
        
    
}
