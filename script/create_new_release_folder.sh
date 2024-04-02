#!/bin/bash

# Когда радар научится в subdir начать релизить так:
# for quadrant in "languages-and-frameworks" "libraries" "methods-and-patterns" "utilities"
#     do mkdir -p radar/$(date '+%Y-%m-%d')/"${quadrant}"
# done

mkdir -p radar/$(date '+%Y-%m-%d')