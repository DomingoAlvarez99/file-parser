@echo off

set resources_dir=./src/main/resources
set input_file_type=excel
set input_file=%resources_dir%/test.xlsx
set output_file_type=plain_text
set output_file=test.csv

docker build --rm ^
    --build-arg INPUT_FILE_TYPE=%input_file_type% ^
    --build-arg INPUT_FILE=%input_file% ^
    --build-arg OUTPUT_FILE_TYPE=%output_file_type% ^
    --build-arg OUTPUT_FILE=%output_file% ^
    .