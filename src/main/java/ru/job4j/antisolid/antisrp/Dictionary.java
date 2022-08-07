package ru.job4j.antisolid.antisrp;
/*
Основная задача данного класса состоит в методах работы со словарем из некоторого файла на жестком диске
Содержит 3 метода:
 public File initDictionary
 Устанавливает директорию для работы.

 public List<String> findWords (String word)
 Ищет слова в файле

 public boolean inputWord
 Записывает новые слова в файл

По принципу SRP : Никогда не должно быть больше одной причины изменить класс.
Класс Dictionary содержит методы, выполняющие разные обязанности
Значит коснтрукция класса не соответсвует SRP.
 */






import java.io.File;
import java.util.List;

public class Dictionary {

    File dic;

    public File initDictionary(String path) {
        return null;
    }

    public List<String> findWords(String word) {
        return null;
    }

    public boolean inputWord(String word) {
        return false;
    }

}
