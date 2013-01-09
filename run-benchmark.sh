#!/bin/bash
set -e
./build.sh
echo "Running..."
time ./run.sh
echo "Done!"
