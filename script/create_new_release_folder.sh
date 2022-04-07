#!/bin/bash

# Когда радар научится в subdir начать релизить так:
# for quadrant in "languages" "libraries-and-frameworks" "methods-and-patterns" "utilities"
#     do mkdir -p radar/$(date '+%Y-%m-%d')/"${quadrant}"
# done

mkdir -p radar/$(date '+%Y-%m-%d')