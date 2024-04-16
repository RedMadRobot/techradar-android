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
[asserts_compare]: https://github.com/RedMadRobot/techradar-android/blob/40aa61ad9935816067f1b933b0529d77c187b9b9/public/docs/assertions/assertj_kotest_compare.md
