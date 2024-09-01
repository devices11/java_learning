package schedule;

import java.util.ArrayList;
import java.util.HashMap;

public class Practicum {
    public static void main(String[] args) {
        //создаём двухуровневую хеш-таблицу для хранения расписания уроков
        AdvancedHashMap<Object, Object, Object> timetable = new AdvancedHashMap<>();
        //добавляем уроки, с указанием дня недели и номера урока
        timetable.put("Понедельник", 1, "Русский язык");
        timetable.put("Понедельник", 2, "Математика");
        timetable.put("Вторник", 1, "Физкультура");
        timetable.put("Вторник", 2, "Русский язык");

        //выводим первый урок во вторник
        System.out.println(timetable.get("Вторник", 1));

        //получаем и выводим все уроки в понедельник
        ArrayList<Object> mondayLessons = timetable.getAll("Понедельник");
        System.out.println(mondayLessons);
    }

}

class AdvancedHashMap<K1, K2, T> {
    //данные будем хранить в хеш-таблице из хеш-таблиц
    HashMap<K1, HashMap<K2, T>> internalHashMap = new HashMap<>();

    public void put(K1 k1, K2 k2, T t) {
        //получаем хеш-таблицу по первому ключу
        HashMap<K2, T> innerHashMap = internalHashMap.get(k1);
        if (innerHashMap == null) {
            //вложенной хеш-таблицы по первому ключу пока нет — создаём её и добавляем в internalHashMap
            innerHashMap = new HashMap<>();
            innerHashMap.put(k2, t);
        }
        //добавляем элемент во вложенную хеш-таблицу
        innerHashMap.put(k2, t);
        internalHashMap.put(k1, innerHashMap);
    }

    public T get(K1 k1, K2 k2) {
        //получаем хеш-таблицу по первому ключу
        HashMap<K2, T> innerHashMap = internalHashMap.get(k1);
        if (innerHashMap == null) {
            return null;
        }
        //получаем элемент из вложенной хеш-таблицы
        return innerHashMap.get(k2);
    }

    public ArrayList<T> getAll(K1 k1) {
        HashMap<K2, T> innerHashMap = internalHashMap.get(k1);
        if (innerHashMap == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(innerHashMap.values());
    }
}