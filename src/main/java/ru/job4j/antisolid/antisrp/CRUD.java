package ru.job4j.antisolid.antisrp;
/*
Основная задача данного класса в работе с базаой данных
В данном классе реализовано 6 методов:

 public void init ()

 Создает подключение к базе данных

 public void createDB ()

 Создает БД

 public boolean createRecord

 Создает новую запись в БД

 public String findRecord

 выводит запись из БД

 public boolean updateRecord

 Изменяет запись в БД

 public boolean deleteRecord

 Удаляет запись из БД


По принципу SRP : Никогда не должно быть больше одной причины изменить класс.
Класс CRUD выполняет разные обязанности и изменене методов может привести к нарушением работы всей программы
Значит конструкция класса не соответсвует SRP.
 */


public class CRUD {

    public void init() {
    }

    public void createDB() {
    }

    public boolean createRecord(String s) {
        return false;
    }

    public String findRecord(String s) {
        return null;
    }
    public boolean updateRecord(String old, String newRecord) {
        return false;
    }
    public boolean deleteRecord(String del) {
        return false;
    }

}
