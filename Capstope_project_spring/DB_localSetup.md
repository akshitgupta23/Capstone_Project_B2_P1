Connect to mySql connection using jdbc

username= root
password= root@1234

Run following SQL query using mySQL workbench or oracle SQL Developer

create database global_bank_admin;

Then run SpringBoot Application

Enter values in Table using

use global_bank_admin;
Insert into Admin(username, password) Values("Peter", "123");