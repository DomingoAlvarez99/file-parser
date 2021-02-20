@echo off

set base_project_dir=../../..

set jar_file=%base_project_dir%/target/FileParser-1.0-jar-with-dependencies.jar

if not exist %jar_file% (
    call mvn -f %base_project_dir% clean compile assembly:single
)

set input_file_type=plain_text
set input_file=test.csv
set output_file_type=excel
set output_file=testExcelOutput.xlsx

java -jar %jar_file% %input_file_type% %input_file% %output_file_type% %output_file%

pause