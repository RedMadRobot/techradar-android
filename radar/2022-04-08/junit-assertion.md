---
title:      JUnit assertions
ring:       trial
quadrant:   libraries
tags: [unit testing]

---

[Docs](https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html) | [Sources](https://github.com/junit-team/junit5/tree/main/junit-jupiter-api)

Junit Assertions - это классическая библиотека тестовых ассертов, встроенная в фреймворк тестирования JUnit.

Junit Assertions предоставляет разработчикам набор методов для проверки результатов тестов в рамках фреймворка JUnit.  
Она включает в себя стандартные утверждения, такие как assertEquals, assertTrue, assertFalse и другие, которые позволяют проверять ожидаемые значения и условия в тестах.  
Junit Assertions также поддерживает работу с исключениями и набор методов для проверки объектов, массивов, строк и других типов данных.

➕ Плюсы:

1. Интеграция с фреймворком JUnit, что облегчает написание и запуск тестов.
2. Описание ошибок: для тех случаев, когда у JUnit есть методы - вполне нормальное

➖ Минусы:

1. Ограниченный функционал по сравнению с некоторыми современными библиотеками тестовых ассертов.
2. Читабельность: Йода-стиль assertEquals(expected, actual), надо помнить нюансы и отличия методов: что массивы надо сравнивать через assertArrayEquals, коллекции через assertIterableEquals и т.п.
3. Некоторые разработчики могут захотеть более продвинутые возможности, которых нет в Junit Assertions.
4. Коллекции: отсутствие проверки содержания элементов, неудобство при работе с Map и Set.
5. Отсутствие поддержки сложных структур данных.
6. Сгенерированная документация.

📝 Полезные ссылки:

- 🔒 База знаний: [Как написать первый тест](https://android.pages.redmadrobot.dev/knowledge/guide/testing/quickstart.html)
- 🔒 База знаний: [Тестовая инфраструктура](https://android.pages.redmadrobot.dev/knowledge/guide/testing/infra.html)
- 🔒 База знаний: [Глубокое погружение в тестирование](https://android.pages.redmadrobot.dev/knowledge/guide/testing/deep-dive.html)
