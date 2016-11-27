package com.brainacad.studyproject;

public class Application {

    public static void main(String[] args) {
        ApplicationInitializer.initialize();


    }
}

/**
 *   class Application  викликає метод ApplicationInitializer, в якому реалізовона
 *
 *      //  CORE
 *
 *  Class ConnectionManager - приєднання до бази даних. Викороистовуєм паттерн Singleton.
 *
 *  Сlass JdbcConnectionPool - коннектимся до бази даних.
 *
 *  Сlass StubDataHolder - заглушка
 *
 *      // DAO
 *
 *     3 Даошки з троьома сущностями і 3 реалізації
 *
 *     // DOMAIN
 *     domain ето характеристика сущности.Domain должен описывать
 что-то.Например пользователя.(firstname,lustname).
 Может давать только описание сущности.
 *
 *      // GUI  реалізація інтерфейсу
 *
 *      // SERVICE ???
 *
 *
 *
 *
 *
 *
 */
