## File Parser
> Este proyecto es un ejemplo de un parseador de ficheros. Puede convertir ficheros de texto plano (los campos deben de usar el separador ';') en ficheros excel y viceversa.

### Tecnologías necesarias
`Java` `Maven` `Docker`

### :gear: Instalación del proyecto
1. Clonar el repositorio:
```sh
> cd <folder path>
> git clone https://github.com/DomingoAlvarez99/file-parser
```

### :rocket: Ejecución
1. Compilar el programa: `> mvn clean compile assembly:single`
2. Ejecutar el programa: `> java -jar target/FileParser-1.0-jar-with-dependencies.jar {tipo_fichero_entrada} {fichero_entrada} {tipo_fichero_salida} {fichero_salida}`
3. Ejemplos:
```sh
> java -jar target/FileParser-1.0-jar-with-dependencies.jar plain_text entrada.csv plain_text salida.csv
> java -jar target/FileParser-1.0-jar-with-dependencies.jar excel entrada.xls plain_text salida.csv
```
