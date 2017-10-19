### About:

The JPEG uploader recognises files of type:  .jpeg and .jpg
The application is targeted at Unix type servers and uses Unix style path separator notation.
The name of the main upload folder at root is set in the class UploadFolderProperties, by changing the
string UPLOADFOLDER and the folder is constructed at run time.
Maximum file size for uploads is set to 100MB and altogether maximum files size is set to 100MB. Those 
values can be changed in application.properties.
The application uses a REST-ful style and does not store any state globally and passes variables via
cookies and POST requests.

### Software stack:

The application is build using Java version 1.8.

Boostrap version 3.

Project Built using Maven.

Controllers, Models were written using Spring Boot Framework.

Git/Github used for version control.

ThymeLeaf was used as template engine.

HTML5, CSS3, jQuery and JavaScript were used for the front end. 

### How to Run the Program:

The program is build and run using Maven with the command:

 $ mvn spring-boot:run

### Repo:

The github repo can be found under: https://github.com/Casper12345/JPEG-Uploader

### Tests:

Unit tests were created using JUnit4.

To run tests using Maven use the following command:

 $ mvn test
 
 


