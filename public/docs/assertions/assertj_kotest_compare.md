# Сравнение библиотек ассертов для android проектов

Рассмотрим три популярные библиотеки assertions - [JUnit][junit_radar], [AssertJ][assertj_radar] и [Kotest][kotest_radar], на основе следующих критериев:

- Интеграция с AS
- Описание ошибки
- Читабельность
- Документация
- Сложные/вложенные структуры
- Поддержка фичей kotlin

## jUnit

➕ Плюсы:

1. Интеграция с фреймворком JUnit, что облегчает написание и запуск тестов.
2. Описание ошибок: для тех случаев, когда у JUnit есть методы - вполне нормальное

➖ Минусы:

1. Ограниченный функционал по сравнению с некоторыми современными библиотеками тестовых ассертов.
2. Читабельность: Йода-стиль assertEquals(expected, actual), надо помнить нюансы и отличия методов: что массивы надо сравнивать через assertArrayEquals, коллекции через assertIterableEquals и т.п.
3. Некоторые разработчики могут захотеть более продвинутые возможности, которых нет в Junit.
4. Коллекции: отсутствие проверки содержания элементов, неудобство при работе с Map и Set.
5. Отсутствие поддержки сложных структур данных.
6. Сгенерированная документация.

## AssertJ

➕ Плюсы

1. Удобочитаемый синтаксис, который делает код тестов более понятным.
2. Большой выбор методов для проверки различных условий.
3. Поддержка различных типов данных и структур, что позволяет писать разнообразные тесты.
4. Хорошая документация с примерами.
5. Из коробки есть поддержка [BDDAssertions][bbdassertions]

➖ Минусы

1. Слишком впечатляющее количество методов для сравнения — еще бы знать все.  
   Списки надо сравнивать через `containsExactly`, множества — через `hasSameElementsAs`, а словари — через `.usingRecursiveComparison().isEqualTo`.  
2. Интеграция с IDE: `Click to see difference` работает далеко не всегда.
3. Сравнение сложных структур: есть `.usingRecursiveComparison()`, который хорошо сравнивает. Однако ошибку хотелось бы иметь поподробнее.
4. При использовании `assertSoftly` очень легко потерять `it` - вызвать `assertThat` вместо `it.assertThat` - и проверки будут работать в обычном режиме.

## Kotest

➕ Плюсы:

1. Поддерживает и использует фичи Kotlin: `infix`, `reified`, `inline` и т.п.
2. Удобный и выразительный синтаксис, упрощающий написание и понимание тестов.  
   _Тест выглядит как предложение, что упрощает понимание происходящего._
3. Расширяемое API позволяет разработчикам создавать собственные матчеры
4. Активное сообщество и регулярные обновления, обеспечивающие поддержку и развитие библиотеки.
5. После проверок типа работают смарт-касты  
   _Например, это удобно когда `State` это sealed class, и нам нужно проверить именно содержимое `State.Content`._

➖ Минусы:

1. Ограничение на использование в проектах на языках, отличных от Kotlin.

## Сравнительная таблица

| Критерий                       | jUnit                | AssertJ                | Kotest              |
|--------------------------------|----------------------|------------------------|---------------------|
| Интеграция с AS                | ⚠️                   | ⚠️                     | ➕                  |
| Описание ошибки                | ⚠️                   | ⚠️                     | ➕                  |
| Читабельность                  | ➖                   | ➕                     | ➕                  |
| Документация                   | ➖ (сгенерированная) | ➕➖ (тяжело читается) | ➕➖ (нет примеров) |
| Сложные/вложенные структуры    | ➖                   | ⚠️                     | ➕                  |
| Поддержка фичей kotlin         | ➖                   | ➖                     | ➕                  |

[Примеры проверок каждой библиотеки][asserts_compare].

📝 Полезные ссылки:

- [Выбор библиотеки ассертов для проекта на Kotlin](https://habr.com/ru/articles/510206/)

<!-- Links -->
<<<<<<< Updated upstream
[asserts_compare]: FIXME
=======
[assertj_radar]: https://redmadrobot.github.io/techradar-android/libraries/assertj/
[kotest_radar]: https://redmadrobot.github.io/techradar-android/libraries/kotest-assertion/
[junit_radar]: https://redmadrobot.github.io/techradar-android/libraries/junit-assertion/
[asserts_compare]: https://github.com/RedMadRobot/techradar-android/blob/2f33c3effe6074d720aedd2bc4717daf5e42ec12/public/snippets/assertions/assertj_kotest_compare.kt
>>>>>>> Stashed changes
[bbdassertions]: https://joel-costigliola.github.io/assertj/core/api/org/assertj/core/api/BDDAssertions.html