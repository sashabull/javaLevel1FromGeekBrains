package com.geekbrains.lesson5;
import com.geekbrains.lesson5.Employee.*;

public class Main {
    public static void main(String[] args) {
        Employee[] emplArr = new Employee[9];
        emplArr[0] = new Employee( "Иванов", "Иван", "Иванович", "профессор", "почта@Ру","+7 495 1234567",100000, 90 );
        emplArr[1] = new Employee( "Петров", "Петр", "Петрович", "статский советник", "Лошадь@Ру","+7 495 2345678",200000, 80 );
        emplArr[2] = new Employee( "Сидоров", "Сидор", "Сидорович", "маменькин сынок", "Сидр@Ру","+7 495 3456789",300000, 70 );
        emplArr[3] = new Employee( "Васечкин", "Василий", "Васильевич", "василек", "Вася@Ру","+7 495 4567890",400000, 60 );
        emplArr[4] = new Employee( "Гульев", "Гулий", "Гульевич", "гулубок", "гуля@Ру","+7 495 5678901",500000, 50 );;
        emplArr[5] = new Employee( "Брюхеев", "Брюх", "Брюхович", "бри", "брю@Ру","+7 495 6789012",510000, 40 );;
        emplArr[6] = new Employee( "Жулия", "Жуль", "Жулевич", "жужу", "жу@Ру","+7 495 7890123",520000, 39 );;
        emplArr[7] = new Employee( "Дудыкин", "Дудочка", "Дудыкович", "дудя", "дудя@Ру","+7 495 8901234",530000, 38 );;
        emplArr[8] = new Employee( "Шмурдяев", "Шмурдя", "Шмурдяевич", "Шму", "шму@Ру","+7 495 9012345",490000, 37 );;
        for ( Employee emp: emplArr ) {
            if (emp.getAge() > 40 ){
                emp.printInfoToConsole() ;
            }
        }
    }
}
