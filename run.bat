@echo off

set jar_file=target/FileParser-1.0-jar-with-dependencies.jar

if not exist %jar_file% (
    call mvn clean compile assembly:single
)

set resources_dir=src/main/resources
set input_file_type=plain_text
set input_file=%resources_dir%/test.csv
set output_file_type=excel
set output_file=%resources_dir%/testExcelOutput.xlsx

java -jar %jar_file% %input_file_type% %input_file% %output_file_type% %output_file%

pause