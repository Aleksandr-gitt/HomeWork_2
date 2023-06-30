/**
 * Задание
1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
 Данные для фильтрации приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации:
Input:
{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

Итоговый SQL-запрос должен выглядеть как:
Output
select * from students where name = "Ivanov" and country = "Russia" and city = "Moscow"
 */

package HomeWork_2;

import java.io.*;

public class Task_1 {
    public static void main(String[] args) throws Exception {
        String sql = "select * from students where ";
        StringBuilder sb = new StringBuilder();
        FileReader fr = new FileReader("HomeWork_2//test.txt");
        int c;
        while ((c = fr.read()) != -1) {
            char ch = (char) c;
            sb.append(ch);   // получили sb = {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
        }
        fr.close();
         
        String str = sb.toString();
        str = str.replace("{"," ");      //  "name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
        str = str.replace(" \"", "");    // name":"Ivanov",country":"Russia",city":"Moscow",age":"null"}
        str = str.replace("}","");       // name":"Ivanov",country":"Russia",city":"Moscow",age":"null"
        str = str.replace("\":"," = ");  // name = "Ivanov",country = "Russia",city = "Moscow",age = "null"
        str = str.replace(",","  ");     // name = "Ivanov"  country = "Russia"  city = "Moscow"  age = "null"
        //System.out.println(str);
        
        String abc[] = str.split("  ");               // делим на два пробела
        StringBuilder sb2 = new StringBuilder();
        for (String el : abc){
            if (el.endsWith("\"null\"")==false){     // заполняем с не пустыми значениями(где нет NULL)
                sb2.append(el+" and ");                     // объединяем через AND
            }
        }
        int l = sb2.length();                               // ищем длину строки
        sb2.delete(l-5,l);                                  // и удаляем последний AND с пробелами(5 символов)
                
        System.out.println(sql+sb2);
    }
}
