#!/usr/bin/python

import os
import glob

def findLatestFiles():
    files = glob.glob("radar/*/*.md")
    latestFiles = dict()

    for filePath in files:
        fileName = filePath.split("/")[-1]
        latestFiles[fileName] = filePath

    return list(latestFiles.values())

def appendToFiles(files):
    link = "https://github.com/RedMadRobot/techradar-android/edit/main/"

    for filePath in files:
        with open(filePath, "a") as file:
            appendText = "\n" + "Links: [edit page]({}), [open discussion](https://github.com/RedMadRobot/techradar-android/discussions/new)".format(link + filePath) + "\n"
            file.write(appendText)

def main():
    contentFiles = findLatestFiles()
    appendToFiles(contentFiles)


if __name__ == "__main__":
    main()