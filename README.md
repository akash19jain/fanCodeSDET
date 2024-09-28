# API AUTOMATION FRAMEWORK - FANCODE

API Automation Framework for the given problem statement

## Problem Statement
**Task** : To Automate the Below Scenario.

**Scenario** :- All the users of City FanCode should have more than half of their todos task completed.

_Given_ User has the todo tasks

_And_ User belongs to the city FanCode

_Then_ User Completed task percentage should be greater than 50%

**Note :-**
- You can use any language to write api automation/Framework.
- Fancode City can be identified by lat between ( -40 to 5) and long between ( 5 to 100) in users api


## Prerequisites
Before using this framework, ensure that you have following installed on you machine:

* Java Development Kit (JDK) 
* Java Version 17
* Maven Build tool
* Eclipse or IntelliJ any Integrated Development Environment (IDE) 
* Git

## Setup
1. Clone the repository on local machine
  ```console
git clone https://github.com/akash19jain/fanCodeSDET.git
```
2. Open the project in your preferred IDE

3. Build the project using Maven to resolve the dependencies
    ```console
   mvn clean install
   ```
## Running Test 
1. Navigate to the testng.xml file under `src/test/resources/suites/testng.xml` and then Right Click on it select Run.

## Result
Once we run the test we can view the result of the test Run along with a report and the logs.

- The result can be viewed in the console tab along with all the logged messages and the overall result.
- A HTML report will be generated under `reports` folder. Open the file on any browser to view the HTML report.
- A log file is also generated under `logs` folder.

## Images
### CONSOLE RUN
<img width="1485" alt="Screenshot 2024-09-28 at 4 35 16 PM" src="https://github.com/user-attachments/assets/574b5d62-ee4a-4737-b57e-5b6e862e1c2d">


### HTML REPORT
<img width="1717" alt="Screenshot 2024-09-28 at 4 17 52 PM" src="https://github.com/user-attachments/assets/16da0898-fd5b-4cf5-bf59-335fa15b41ce">

### LOGS 
<img width="1208" alt="Screenshot 2024-09-28 at 4 23 40 PM" src="https://github.com/user-attachments/assets/b2115d75-2cef-46ec-bca4-ab6b77fd545e">



## Tools and Technologies used 
* Java
* Maven
* Intellij
* Rest Assured
* TestNG
* Lombok
* Log4j2
* Extent Reports
* Jackson API

## Folder Structure
<img width="308" alt="Screenshot 2024-09-28 at 3 54 42 PM" src="https://github.com/user-attachments/assets/b2a8cc83-df7f-4e96-886e-d468db6aeece">
