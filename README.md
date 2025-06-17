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
   git clone https://github.com/cgold264/expeditors-assessment.git
   cd expeditors-assessment
    ```
3. **Build the project:**
   ```sh
   mvn clean install
   ```
   This will download dependencies, compile the code, run tests, and package the application.

4. **Run the project:**
  ```sh
  mvn exec:java -Dexec.mainClass="com.expeditors.assessment.Main"
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
expeditors-assessment/
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
│── target/                  # Compiled output (generated after build)
│── README.md                # Project documentation
│── .gitignore              
```


2. **Object Relationships**
 - The project is based on two fundamental objects, Residence and Person. 

| Feature          | Residence | Person |
|-----------------|------------------|------------------|
| **Definition**  | Represents a single residence as shown in the data. | Represents a person/occupant from the data. |
| **Multiplicity** | One Residence instance can be linked to multiple instances of Person. | Each Person instance is linked to only one instance of Residence. |
| **Primary Key**  | Identified by First + Last names. | Identified by Address + State + City |
| **Example**      | A `Residence` can have multiple `People` that occupy a residence. | Each `Person` belongs to exactly one `Residence`. |

- ResidenceManager wasTo manage the state of all Residence objects, the two following manager classes were created.

| Feature          | ResidenceManager | Processor |
|-----------------|------------------|------------------|
| **Description**  | Manages the state of all Residence objects. | Manages the state of all Person objects. |
| **Multiplicity** | One instance can be linked to multiple instances of Residence. | This is a static class so there are no instantiations. |
| **Usage**  | Identified by First + Last names. | Identified by Address + State + City |

- To manage data interactions (ie Reading, Writing, and Parsing) the Processor class was created.


3. **Performance Considerations**
- Both Residence stores all Person objects using an ArrayList. While the Person objects are required to be in sorted order, the amortized O(1) insertion for ArrayLists allows the data to efficiently scale. When printing the final output the objects are sorted using Collections.sort which has a time complexity of O(N*log N). Since we are only sorting once and only require the occupants to be sorted when we print, this option was selected. 

- 


## Design Assumptions

1. **Data**
    - Data entries are consistently grouped by column. Assumed:
   ```
   [<first name>, <last name>, <address>, <city>, <state>, <age>]
   ```
    
    - Columns are grouped between sets of quotations and separated by commas.
    - There has been no standardization in the data. In order to compare residences, the data was standardized to only include alpha and numeric characters. 
    - As seen in the data, abbreviations such as 'apt', 'blvd', 'st', 'ave' are used. It is assumed that these abbreviations are consistent throughout. For example, there will not be cases where the same address will reference apartment as anything other than 'Apt'.
    - It is assumed, capitalization is consistent for Person names. All entries in data have consistent capitalization with the first letter of the first and last name being capitalized. 

2. **Object Relationships**
  - There was no specific usage context given so classes were selected only from the context of what was seen in the data.
  - It is assumed that a residence is a one-to-many relationship with a person. There is no evidence in the data that to suggest that a person can have more than one residence. Therefore it is assumed that a person can only have one residence.
