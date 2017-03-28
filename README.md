# counterApi
This is a Springboot RESTful application for reading data from a file to achieve following tasks:
Task 1: Search the following texts, which will return the counts respectively.
  Sample Request:
  > curl http://host/counter-api/search -H"Authorization: Basic <<PASSWORD_FROM_APPLCATION_LOGS>>" - d’{“searchText”:[“Duis”, “Sed”, “Donec”, “Augue”, “Pellentesque”, “123”]}’ -H"Content- Type: application/json" – X POST
  Example: 
  > curl http://localhost:8080/counter-api/search -H"Authorization: Basic dXNlcjoyYTk0ZTBkNC0yOGYyLTRhNjctYWU2OC05ZDBlODg4YWM4ODY=" -d'{"searchText":["Duis","Sed","Donec","Augue","Pellentesque","123"]}' -H"Content-Type:application/json" -X POST
  Result in JSON:
  > {"counts": [{"Duis": 11}, {"Sed": 16}, {"Donec": 8}, {"Augue": 7}, {"Pellentesque": 6},{"123": 0}]}
  
Task 2: Provide the top 20 (as Path Variable) Texts, which has the highest counts in the Sample Paragraphs provided.
  Sample Request
  > curl http://host/counter-api/top/20 -H"Authorization: Basic <<PASSWORD_FROM_APPLCATION_LOGS>>" - H”Accept: text/csv”
  Example:
  > curl http://localhost:8080/counter-api/top/10 -H"Authorization: Basic dXNlcjoyYTk0ZTBkNC0yOGYyLTRhNjctYWU2OC05ZDBlODg4YWM4ODY=" -H "Accept:text/csv"
  Result in CSV:
  eget|17
  vel|17
  sed|16
  in|15
  et|14
  eu|13
  ut|13
  ac|12
  amet|12
  id|12
  
  RUNNIG THE APPLICATION:
  Step1: Clone the repository using below URL:
  https://github.com/poonammeghnani/counterApi.git
  
  Step2: Go to application directory and run below command to start the application:
  mvn spring-boot:run
  
  Step3: Using curl command on terminal send request to the application as shown in above example.
