#!/bin/bash

fail() {
    echo "Expected: $1"
    echo "Actual: $2"
    echo "FAIL"
    exit 1
}

./build.sh

ACTUAL=`./run.sh 2 1`
EXPECTED=2
[[ "$EXPECTED" == "$ACTUAL" ]] && echo "OK" || fail "$EXPECTED" "$ACTUAL"

ACTUAL=`./run.sh 1 1`
EXPECTED=1
[[ "$EXPECTED" == "$ACTUAL" ]] && echo "OK" || fail "$EXPECTED" "$ACTUAL"

