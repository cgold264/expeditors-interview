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
│   │   │   ├── PersonManager.java   
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
| **Definition**  | Represents the primary entity in the relationship. | Represents the dependent entity related to Object A. |
| **Multiplicity** | One instance can be linked to multiple instances of Person. | Each instance is linked to only one instance of Residence. |
| **Primary Key**  | Identified by First + Last names. | Identified by Address + State + City |
| **Example**      | A `Residence` can have multiple `People` that reside. | Each `Person` belongs to exactly one `Residence`. |

- To manage the state of all Residence and Person objects, the two following manager classes were created.
| Feature          | ResidenceManager | PersonManager |
|-----------------|------------------|------------------|
| **Definition**  | Represents the primary entity in the relationship. | Represents the dependent entity related to Object A. |
| **Multiplicity** | One instance can be linked to multiple instances of Person. | Each instance is linked to only one instance of Residence. |
| **Primary Key**  | Identified by First + Last names. | Identified by Address + State + City |
| **Example**      | A `Residence` can have multiple `People` that reside. | Each `Person` belongs to exactly one `Residence`. |

- To manage data interactions (ie Reading, Writing, and Parsing) the Processor class was created.
| Feature          | Processor |
|-----------------|------------------|
| **Definition**  | Represents the primary entity in the relationship. | 
| **Multiplicity** | One instance can be linked to multiple instances of Person. | 
| **Primary Key**  | Identified by First + Last names. |
| **Example**      | A `Residence` can have multiple `People` that reside. | 


3. **Performance Considerations**
- Both ResidenceManager and PersonManager store all objects using ArrayLists. While the Person objects are required to be in sorted order, the amortized O(1) insertion for ArrayLists. When printing the final output the objects are sorted using Collections.sort which has a time complexity of O(N*log N).  




## Design Assumptions

1. **Data**
    - Data entries are consistently grouped by column. Assumed:
   ```
   [<first name>, <last name>, <address>, <city>, <state>, <age>]
   ```
    
    - Columns are grouped between sets of quotations and separated by commas.
    - There has been no standardization in the data. When comparing addresses only alpha and numeric characters are used for comparison. 
    - Abbreviations are consistent. As seen in the data, abbreviations such as 'apt', 'blvd', 'st', 'ave' are used. It is assumed that these abrevations are consistent throughout. For example, there will not be cases where the same address will reference apartment as anything other than 'Apt'.

2. **Object Relationships**
  - Context: there is no specific use case or target audience established in the requirements prompt. 
  - It is assumed that a residence is a one-to-many relationship with a person. There is no evidence in the data that to suggest that a person can have more than one residence. Therefore it is assumed that a person can only have one residence.

3. **Performance Consideration**

