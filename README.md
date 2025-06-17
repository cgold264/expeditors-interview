# Expeditors Take Home Assessment

## Overview
This project is a Maven-based Java application. It manages dependencies using Apache Maven.

## Setup Instructions

1. **Ensure Java (version 8 or higher) and Apache Maven are installed**
  ```sh
  java -version
  mvn -version
  ```

2. **Clone the repository:**
  ```sh
  git clone https://github.com/cgold264/expeditors-interview.git
  cd expeditors-interview
  ```
3. **Build the project:**
  ```sh
  mvn clean install
  ```
  This will download dependencies, compile the code, run tests, and package the application.

4. **Run the project:**
  ```sh
  mvn exec:java -Dexec.mainClass="com.expeditors.interview.Main"
  ```
  This will run the application with `Main` class.

5. **Running tests:**
  ```sh
  mvn test
  ```
  This will run all unit tests for the project.

## Project Design Overview

1. **Package Overview**

```
expeditors-interview/
│── pom.xml                  # Maven configuration file
│── src/
│   ├── main/
│   │   ├── java/com/example/app/
│   │   │   ├── Main.java # Main entry point
│   │   │   ├── Processor.java
│   │   │   ├── Person.java
│   │   │   ├── Residence.java   
│   │   │   ├── ResidenceManager.java   
│   ├── test/
│   │   ├── java/com/example/app/
│   │   │   ├── ResidenceManagerTests.java # Unit tests
│   │   │   ├── PersonManagerTests.java 
│   ├── data/
│   │   ├── data.txt #Data 
│   │   ├── output.txt #Solution output
│── target/                  # Compiled output
│── README.md                # Project documentation
│── .gitignore              
```


2. **Object Relationships**
 - The project is based on two fundamental objects, `Residence` and `Person`. A Residence represents a single household while a Person represents a single occupant of a Residence. It is assume that each Residence can have multiple occupants but an occupant to can only have a single Residence.

 - To manage the state of these relationships, `ResidenceManager` was created to track and update all residence data. `Processor` was created as a static class to manage the file interactions including reading, writing, and parsing the data. 

 - The following tables outline the structure of each class.

| Feature          | Residence | Person |
|-----------------|------------------|------------------|
| **Definition**  | Represents a single residence as shown in the data. | Represents a person/occupant from the data. |
| **Multiplicity** | One Residence instance can be linked to multiple instances of Person. | Each Person instance is linked to only one instance of Residence. |
| **Primary Key**  | Identified by First + Last names. | Identified by Address + State + City |
| **Example**      | A `Residence` can have multiple `People` that occupy a `Residence`. | Each `Person` belongs to exactly one `Residence`. |

| Feature          | ResidenceManager | Processor |
|-----------------|------------------|------------------|
| **Description**  | Manages the state of all Residence objects. | A static class responsible for file interactions related to Person and Residence objects. |
| **Multiplicity** | One instance can be linked to multiple instances of Residence. | This is a static class so there are no instantiations. |
| **Identification**  | Residences are tracked using their string representation as the key in a map. | Residence objects are parsed based on address, city, and state. Person objects are parsed from first name, last name, and age. |


3. **Performance Considerations**
 - The `ResidenceManager` stores all `Person` objects using an ArrayList. While the all `Person` objects are required to be in sorted order alphabetically, the amortized O(1) insertion for ArrayLists allows the data to efficiently scale. When printing the final output the objects are sorted using Collections.sort which has a time complexity of O(N*log N). Since we are only sorting once and only require the occupants to be sorted when we print, this option was selected. 
 - To track all `Residence` objects in the `ResidenceManager` class a hashmap was selected where the string representation acts as a key and the object itself acts as the value. A hashmap was selected for its O(1) insertion and O(1) access. This makes it incredibly efficient for retrieving residence's to add new occupants. Given more context, it could be better to index each residence by an ID value as opposed to a string representation of the address.

4. **Testing**
 - To test the functionality of `ResidenceManager` and `Processor` a small suite of unit tests were created. While these tests are not exhaustive, they are meant to address some of the core functionality of both classes. 


## Design Assumptions

1. **Data**
  - Data entries are consistently grouped by column. Assumed:
   ```
   [<first name>, <last name>, <address>, <city>, <state>, <age>]
   ```
    
  - Columns are grouped between sets of quotations and separated by commas.
  - There has been no standardization in the data. In order to compare residences, the data was standardized to only include alpha and numeric characters. 
  - As seen in the data, abbreviations such as 'apt', 'blvd', 'st', 'ave' are used. It is assumed that these abbreviations are consistent throughout. For example, there will not be cases where the same address will reference apartment as anything other than 'Apt'.
  - It is assumed capitalization is consistent for Person names. All entries in data have consistent capitalization with the first letter of the first and last name being capitalized. 

2. **Object Relationships**
  - There was no specific usage context given so classes were selected only from the context of what was seen in the data.
  - It is assumed that a residence is a one-to-many relationship with a person. There is no evidence in the data that to suggest that a person can have more than one residence. 
  - There was no clear indication to group residence types into subclasses. While it is clear there are at least two types of residences (apartments and non-apartments) it was not clear that there would be a significant reason to group residences by a subtype. 



