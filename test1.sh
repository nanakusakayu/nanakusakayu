#!/bin/bash

echo "いつまでの規模(step数）を確認したいですか？"

read str

echo "追加step 削除step"

for((i=$str;i>0;i--))
do
echo -n $i"日前,"
git log --oneline --numstat --all --until=$i"days ago" | grep "\.java" | awk 'NF==3 {plus+=$1; minus+=$2} END {printf("+%d, -%d\n", plus, minus)}'
done
