---
title:      Kotest assertions
ring:       adopt
quadrant:   libraries
tags: [unit testing]

---

[Docs](https://kotest.io/docs/assertions/assertions.html) | [Sources](https://github.com/kotest/kotest)

Kotest assertions - это современная библиотека тестовых ассертов для языка программирования Kotlin.

Kotest assertions предоставляет широкий спектр методов для сравнения объектов, коллекций, строк, чисел и других типов данных.

Библиотека предлагает удобный и выразительный синтаксис, который помогает разработчикам писать чистый и понятный код тестов.  
Кроме того, Kotest assertions обладает расширяемым API, позволяющим добавлять собственные матчеры.

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

📝 Полезные ссылки:

- [Сравнение библиотек ассертов для android проектов][asserts_compare]
- 🔒 База знаний: [Как написать первый тест](https://android.pages.redmadrobot.dev/knowledge/guide/testing/quickstart.html)

<!-- Links -->
[asserts_compare]: https://github.com/RedMadRobot/techradar-android/blob/40aa61ad9935816067f1b933b0529d77c187b9b9/public/docs/assertions/assertj_kotest_compare.md
