@echo off

set resources_dir=src/main/resources
set input_file_type=excel
set input_file=%resources_dir%/test.xlsx
set output_file_type=plain_text
set output_file=%resources_dir%/testDockerfile.csv

docker build --rm ^
    --build-arg INPUT_FILE_TYPE=%input_file_type% ^
    --build-arg INPUT_FILE=%input_file% ^
    --build-arg OUTPUT_FILE_TYPE=%output_file_type% ^
    --build-arg OUTPUT_FILE=%output_file% ^
    -t file_parser .

docker create --name temp_file_parser file_parser

set container_base_dir=/app

docker cp temp_file_parser:%container_base_dir%/%output_file% %output_file%
docker rm temp_file_parser