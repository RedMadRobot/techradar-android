---
title:      AssertJ
ring:       hold
quadrant:   libraries
tags: [unit testing]

---

На основе [сравнения библиотек ассертов][asserts_compare] принято решение использовать [Kotest-assertions](/libraries/kotest-assertion/) для android/kotlin проектов.

Оcновные причины:

- Слишком впечатляющее количество методов для сравнения -> много способов сломать тесты
- Интеграция с IDE работает далеко не всегда
- Нет поддержки kotlin

Допустимо использовать AssertJ на Java-проектах или если уже на проекте принят подход к написаню тестов с использованием AssertJ.

📝 Полезные ссылки

- 🔒 База знаний: [Как написать первый тест](https://android.pages.redmadrobot.dev/knowledge/guide/testing/quickstart.html)
- 🔒 База знаний: [Тестовая инфраструктура](https://android.pages.redmadrobot.dev/knowledge/guide/testing/infra.html)
- 🔒 База знаний: [Глубокое погружение в тестирование](https://android.pages.redmadrobot.dev/knowledge/guide/testing/deep-dive.html)

<!-- Links -->
[asserts_compare]: FIXME
