#!/bin/bash

echo "何日前からのgit logを表示しますか？数字を入力してください。"

read str

echo "追加step, 削除step"

git log --oneline --numstat --all --since=$str"days ago" | grep "\.java" | awk 'NF==3 {plus+=$1; minus+=$2} END {printf("+%d, -%d\n", plus, minus)}'
