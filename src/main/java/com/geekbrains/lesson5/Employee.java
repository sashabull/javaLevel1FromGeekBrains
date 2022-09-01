package com.geekbrains.lesson5;

/**
 * класс Сотрудник
 */
public class Employee {
    private String surname;         // фамилия
    private String name;            // Имя
    private String patronymic;      // отчество
    private String position;        // должность
    private String email;
    private String phone;           // телефон
    private Integer salary;         // зарплата
    private Integer age;            // возраст

    public Employee( String surname,
                     String name,
                     String patronymic,
                     String position,
                     String email,
                     String phone,
                     Integer salary,
                     Integer age
                    ){
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    /**
     * печать в консоль информацию по сотруднику
     */
    public void printInfoToConsole(){
        System.out.println(
                "ФИО: " + this.surname + " " + this.name + " " + this.patronymic +
                ", должн: " + this.position +
                ", е-почта: " + this.email +
                ", тел: " + this.phone +
                ", з/п: " + this.salary +
                ", возраст: " + this.age
                );
    }

    /**
     * получение возраста сотрудника
     * @return возраст
     */
    public int getAge(){
        return this.age;
    }
}
