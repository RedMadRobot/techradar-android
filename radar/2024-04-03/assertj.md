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

<!-- Links -->
[asserts_compare]: https://github.com/RedMadRobot/techradar-android/blob/cb74ae5717440f6d71e3e52ae5caf34ac2b1a0c6/public/docs/assertions/assertj_kotest_compare.md
