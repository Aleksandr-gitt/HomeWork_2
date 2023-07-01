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
        String str = sb.toString();

        ChangeJsonfor3students(str);


    }
    
    public static void ChangeJsonfor3students(String str) {
        
        str = str.replace("{","");
        str = str.replace("}",""); 
        str = str.replace("[","");
        str = str.replace("]",""); 
        str = str.replace(","," ");
                
        String abc[] = str.split(" ");
        StringBuilder sb2 = new StringBuilder();
        
        for (String el : abc){
            sb2.append(el+" ");
        }    

        String str2 = sb2.toString();
        str2 = str2.replace(":"," ");
        str2 = str2.replace("\"","");
        String abc2[] = str2.split(" ");
        
        System.out.printf("Студент %s получил %s по предмету %s.\n",abc2[1],abc2[3],abc2[5]);
        System.out.printf("Студент %s получил %s по предмету %s.\n",abc2[7],abc2[9],abc2[11]);
        System.out.printf("Студент %s получил %s по предмету %s.\n",abc2[13],abc2[15],abc2[17]);
    }
    
}
