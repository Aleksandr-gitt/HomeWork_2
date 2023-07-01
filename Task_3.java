/**
Дана json-строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: 
Студент [фамилия] получил [оценка] по предмету [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
 */
package HomeWork_2;

import java.io.FileReader;

public class Task_3 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        FileReader fr = new FileReader("HomeWork_2//test2.txt");
        int c;
        while ((c = fr.read()) != -1) {
            char ch = (char) c;
            sb.append(ch);
        }
        fr.close();
        
        //System.out.println(sb);
        String str = sb.toString();
        str = str.replace("{","");
        str = str.replace("}",""); 
        str = str.replace("[","");
        str = str.replace("]",""); 
        str = str.replace(","," ");
        //System.out.println(str);
        
        String abc[] = str.split(" ");
        StringBuilder sb2 = new StringBuilder();
        
        for (String el : abc){
            sb2.append(el+" ");
            System.out.println(el);
        }
        
    }
}
