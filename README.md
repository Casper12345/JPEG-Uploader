### About:

This is a JPEG uploader created to satisfy the JPEG uploader challenge.
The JPEG uploader recognises files of type:  .jpeg and .jpg
The application is targeted for Unix type servers and uses Unix style path separator notation.
The name of the main upload folder at root is set in the class UploadFolderProperties, by changing the
string UPLOADFOLDER and the folder is constructed at run time.
The application uses a REST-ful style and does not store any state globally and passes variables via
cookies and POST requests.

All code for this submission was entirely written by Casper Nielsen.

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
 
 


