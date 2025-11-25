create database BankingSystem;
use BankingSystem;

CREATE TABLE Signup1(
        Formno VARCHAR(20),
        Name VARCHAR(100),
        Father_Name VARCHAR(30),
        Mother_Name VARCHAR(30),
        Date_Of_Birth VARCHAR(30),
        Gender VARCHAR(30),
        Email VARCHAR(45) unique,
        Marital_Status VARCHAR(30),
        Address VARCHAR(100),
        City VARCHAR(100),
        Nationality VARCHAR(50),
        Postal_Code VARCHAR(30)
);



CREATE TABLE Signup2(
        Formno VARCHAR(100),
        Religion VARCHAR(100),
        Category VARCHAR(100),
        Income VARCHAR(100),
        Education VARCHAR(100),
        Occupation VARCHAR(100),
        NID VARCHAR(45) unique,
        Existing_Account VARCHAR(30)
);

CREATE TABLE Signup3 (
    formno VARCHAR(20) PRIMARY KEY,
    accountType VARCHAR(50),
    cardnumber VARCHAR(20) UNIQUE,
    pinnumber VARCHAR(10) unique,
    facility TEXT,
    balance DECIMAL(12, 2) DEFAULT 0.00
);

drop table Signup1;
select * from Signup1;
select * from Signup2;
select * from Signup3;
desc Signup1;

