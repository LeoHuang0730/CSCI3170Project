Group Number: 7

Name and SID of group members:<br>
Chin Tsz Yeung (SID: 1155176266)<br>
Huang Kwok Wai (SID: 1155175207)<br>
Lee Hing Tik (SID: 1155174697)<br>

List of files:<br>
./sample_data<br>
./sample_data/category.txt<br>
./sample_data/manufacturer.txt<br>
./sample_data/part.txt<br>
./sample_data/salesperson.txt<br>
./sample_data/transaction.txt<br>
<br>
./src<br>
./src/Main.java<br>
./src/AdminOps.java<br>
./src/ManagerOps.java<br>
./src/SalesOps.java<br>
./src/adminCreate.sql<br>
./src/adminDelete.sql<br>
./src/checkPartAvailability.sql<br>
./src/countSalesRecords.sql<br>
./src/listAllSalespersons.sql<br>
./src/nMostPopularParts.sql<br>
./src/searchManufacturerName.sql<br>
./src/searchPartName.sql<br>
./src/sellPart.sql<br>
./src/showTotalSalesByManufacturer.sql<br>
<br>
./.gitignore<br>
<br>
./ojdbc10-19.24.0.0.jar<br>
<br>

Compilation in Terminal
1. Download the zip file of the project
2. Unzip the zip file and go into CSCI3170Project folder
3. Compile the java files by running the following command in the terminal
```
javac -cp ojdbc10-19.24.0.0.jar src/*.java
```
<br>

Execution in Terminal
1. After compilation, run the following command in the terminal
```
java -cp ojdbc10-19.24.0.0.jar src/Main.java
```



