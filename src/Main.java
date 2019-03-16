import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

        public static void main(String[] args) {
 try{
     Document doc = Jsoup.connect("http://edu.sfu-kras.ru/timetable?group=РФ16-33Б").get();


     Element Table = doc.select("table").get(1); //Выбираем таблицу с расписанием
     Elements Rows = Table.select("tr");//Выбираем строки в таблице
     boolean chetweek = true;
     int daycounter = 0;
     String Stringvar = "";
     String Day = "";
        System.out.print("Расписание  ебать!\n\n");

                    for (int i = 0; i < Rows.size(); i++){




                        Element row = Rows.get(i); //по номеру индекса получает строку
                        Elements cols = row.select("td");// разбиваем полученную строку по тегу  на столбы


                        switch (row.select("tr.heading").text()){
                            case "Понедельник":
                                daycounter = 1;
                                Day = "Понедельник";
                               break;
                            case "Вторник":
                                 daycounter = 2;
                                 Day = "Вторник";
                                 break;
                            case "Среда":
                                daycounter = 3;
                                Day = "Среда";
                                break;
                            case "Четверг":
                                daycounter = 4;
                                Day = "Четверг";
                                break;
                            case "Пятница":
                                daycounter = 5;
                                Day = "Пятница";
                                break;
                            case "Суббота":
                                daycounter = 6;
                                Day = "Суббота";
                                break;

                        }
                        if (cols.size() == 0){
                            continue;
                        }

                        if (chetweek){
                            if (cols.size() < 4){ Stringvar = cols.get(2).select("b").text() + cols.get(2).ownText();
                                System.out.print("     ");
                                System.out.print(Day);
                                System.out.print("   ");
                                System.out.print(cols.get(0).text()); //Порядок
                                System.out.print("   ");
                                System.out.print(cols.get(1).text()); // Время
                                System.out.print("   ");
                                System.out.print(Stringvar);
                                System.out.print("            ");
                                System.out.print(cols.get(2).select("a").text()); //препод и аудитория
                                System.out.print("\n");


                            continue;}
                            if (!cols.get(3).hasText()) {continue;}


                            System.out.print("     ");
                            System.out.print(Day);
                            System.out.print("   ");
                            System.out.print(cols.get(0).text()); //Порядок
                            System.out.print("   ");
                            System.out.print(cols.get(1).text()); // Время
                            System.out.print("   ");
                            if (cols.size()< 4){System.out.print(Stringvar);} else {
                                System.out.print(cols.get(3).select("b").text() + cols.get(3).ownText()); //Название и лекция, практика и т.д.
                            }

                            System.out.print("            ");
                            System.out.print(cols.get(3).select("a").text()); //препод и аудитория
                            System.out.print("\n");

                        } else {

                        if (!cols.get(2).hasText()) {continue;}
                        System.out.print("     ");
                        System.out.print(Day);
                        System.out.print("   ");
                        System.out.print(cols.get(0).text()); //Порядок
                        System.out.print("   ");
                        System.out.print(cols.get(1).text()); // Время
                        System.out.print("   ");
                        System.out.print(cols.get(2).select("b").text() + cols.get(2).ownText()); //Название и лекция, практика и т.д.


                        System.out.print("            ");
                        System.out.print(cols.get(2).select("a").text()); //препод и аудитория
                        System.out.print("\n");}

                    }




    } catch(IOException e)

    {
        System.out.println("Error : " + e.getMessage() + "\n");
    }
}}


