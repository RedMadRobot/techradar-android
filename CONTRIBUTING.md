# Welcome 🤖

Спасибо, что вкладываешь свое время в [RedMadRobot Technology Radar][radar-link]!

В данном документе под **страничкой** подразумевается любая технология/библиотека/инструмент из радара.

## Начало

Если хочется что-то поменять/улучшить, не связанное с контентом - лучше начать с [discussion][new-discussion].

В случае, когда что-то не работает - создавай [issue][new-issue].

При добавлении/изменении страничек, можно сразу создавать **pull requests**.

## Создание релиза

Выбранный статический генератор поддерживает релизы, с помощью которых он понимает, какие страницы поменялись/добавились.

Для создания нового релиза создай папку с именем в формате `YYYY-MM-DD` в директории `./radar`.

Или воспользуйся скриптом:

```bash
./script/create_new_release_folder.sh
```

И при добавлении/обновлении страничек - создавай новый релиз.  
(p.s. для исправления описания существующей страницы - релиз можно не создавать).

## Добавление новой технологии/библиотеки/инструмента

В начале каждого `md` файла должна быть [front-matter] шапка:

```yaml
---
title:      Лучшая библиотека в мире
ring:       trial
quadrant:   libraries-and-frameworks
info:       Какие могут быть слова! Вы только посмотрите!

---

Дальше markdown текст с подробным описанием.

```

Поддерживаемые аттрибуты:

- `title`: Название странички
- `quadrant`: Квадрант 😁. Один из: `libraries-and-frameworks` | `utilities` | `methods-and-patterns` | `languages`
- `ring`: Кольцевая секция в радаре. Одно из: `adopt` | `trial` | `assess` | `hold`
- `info`: (опционально) Короткое описание (его видно в [overview])
- `featured`: (опционально, по умолчанию `true`) Если установить в `false` - страничку не будет видно на радаре, а только в [overview].

Подробнее про квадранты и кольца смотри [how-to].

Так как страничка - это `markdown` файл - можно вставлять картинки, для этого положи ее в `./public/images/` и добави ссылку:

```markdown
![nice image](/images/nice-image.png)
```

Подробное описание лучше заполнять по следующему шаблону:

```markdown

## Описание

Какую проблему/задачу решает и для каких целей выбрали технологию/библиотеку

## Почему именно X (опционально)

Почему выбрали именно эту технологию, а не, например, `Y`?

## Полезные ссылки

Сюда можно приложить ссылки на следующее:

- Исходники
- Статьи/песочницы
- Пример чего-то реализованного на этой технологии/языке/библиотеке

```

Пример страницы - [camerax]

## Обновление уже существующей странички

❗ Название файла должно быть таким же, как и в предыдущих релизах.

При переводе технологии в `Adopt` - укажи, какие нашлись плюсы (это может быть что угодно).

При переводе технологии в `Hold` - будет круто, если ты укажешь, почему это произошло: любые минусы, нюансы, неудобства или чем заменили технологию.

<!-- Links -->
[radar-link]: https://github.com/RedMadRobot/techradar-android
[new-issue]: https://github.com/RedMadRobot/techradar-android/issues/new
[new-discussion]: https://github.com/RedMadRobot/techradar-android/discussions/new
[front-matter]: https://github.com/jxson/front-matter
[how-to]: https://redmadrobot.github.io/techradar-android/help-and-about-tech-radar.html
[overview]: https://redmadrobot.github.io/techradar-android/libraries-and-frameworks.html
[camerax]: https://redmadrobot.github.io/techradar-android/libraries-and-frameworks/camerax.html