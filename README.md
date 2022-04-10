# RedMadRobot Technology Radar

RedMadRobot Technology Radar, inspired by [AOE TechRadar](https://www.aoe.com/techradar/index.html)

## Build the radar

Install yarn.

Build the radar:

```bash
yarn build && yarn build-static && yarn generate-json
```

Serve

```bash
python3 -m http.server 8080
```

Then open here: [http://localhost:8080/build](http://localhost:8080/build)

## Usage

For a new Technology Radar release, create a folder of the release date (`YYYY-MM-DD`) under `radar/`, or use:

```bash
yarn newReleaseFolder
```

## Maintaining items

The items are written in Markdown format (.md)

Each file has a [front-matter](https://github.com/jxson/front-matter) header where the attributes of the item are listed:

```Markdown
---
title:      "React"
ring:       adopt
quadrant:   languages-and-frameworks
---
```

Text goes here. You can use **markdown** here.

Following front-matter attributes are possible:

- **title**: Name of the Item
- **quadrant**: Quadrant. One of `libraries-and-frameworks`, `methods-and-patterns`, `languages`, `utilities`
- **ring**: Ring section in radar. One of `trial`, `assess`, `adopt`, `hold`
- **info**: (optional) A short textual description of the item (visible in
  overview pages)
- **featured**: (optional, default "true") If you set this to `false`, the item
  will not be visible in the radar quadrants but still be available in the overview.

The name of the `.md` file acts as item identifier and may overwrite items with
the same name from older releases.

If an item is overwritten in a new release, the attributes from the new item are
merged with the old ones, and a new history entry is created for that item.

You can integrate images in your markdown. Put the image files in your `public/images/` folder and reference them:

```Markdown
![nice image](/images/nice-image.png)
```
