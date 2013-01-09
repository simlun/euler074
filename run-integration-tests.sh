#!/bin/bash

fail() {
    echo "Expected: $1"
    echo "Actual: $2"
    echo "FAIL"
    exit 1
}

./build.sh

ACTUAL=`./run.sh --up-to 2 --chain-length 1`
EXPECTED=2
[[ "$EXPECTED" == "$ACTUAL" ]] && echo "OK" || fail "$EXPECTED" "$ACTUAL"

ACTUAL=`./run.sh --up-to 1 --chain-length 1`
EXPECTED=1
[[ "$EXPECTED" == "$ACTUAL" ]] && echo "OK" || fail "$EXPECTED" "$ACTUAL"

ACTUAL=`./run.sh -u 1000 -c 20`
EXPECTED=7 # This value was found by running the program at commit cbb1962
[[ "$EXPECTED" == "$ACTUAL" ]] && echo "OK" || fail "$EXPECTED" "$ACTUAL"

ACTUAL=`./run.sh --chain-length 20 --up-to 1000`
EXPECTED=7 # This value was found by running the program at commit cbb1962
[[ "$EXPECTED" == "$ACTUAL" ]] && echo "OK" || fail "$EXPECTED" "$ACTUAL"

ACTUAL=`./run.sh --up-to 2500 --chain-length 20`
EXPECTED=21 # This value was found by running the program at commit cbb1962
[[ "$EXPECTED" == "$ACTUAL" ]] && echo "OK" || fail "$EXPECTED" "$ACTUAL"

