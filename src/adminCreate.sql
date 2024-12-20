--Create All Table--
CREATE TABLE category
(
    cID   NUMBER(1) PRIMARY KEY,
    cName VARCHAR2(20) NOT NULL
);

CREATE TABLE manufacturer
(
    mID          NUMBER(2) PRIMARY KEY,
    mName        VARCHAR2(20) NOT NULL,
    mAddress     VARCHAR2(50) NOT NULL,
    mPhoneNumber NUMBER(8) NOT NULL
);

CREATE TABLE part
(
    pID                NUMBER(3) PRIMARY KEY,
    pName              VARCHAR2(20) NOT NULL,
    pPrice             NUMBER(5) NOT NULL,
    mID                NUMBER(2) NOT NULL,
    cID                NUMBER(1) NOT NULL,
    pWarrantyPeriod    NUMBER(2) NOT NULL,
    pAvailableQuantity NUMBER(2) NOT NULL,
    FOREIGN KEY (mID) REFERENCES manufacturer (mID),
    FOREIGN KEY (cID) REFERENCES category (cID)
);

CREATE TABLE salesperson
(
    sID          NUMBER(2) PRIMARY KEY,
    sName        VARCHAR2(20) NOT NULL,
    sAddress     VARCHAR2(50) NOT NULL,
    sPhoneNumber NUMBER(8) NOT NULL,
    sExperience  NUMBER(1) NOT NULL
);

CREATE TABLE transaction
(
    tID   NUMBER(4) PRIMARY KEY,
    pID   NUMBER(3) NOT NULL,
    sID   NUMBER(2) NOT NULL,
    tDate DATE NOT NULL,
    FOREIGN KEY (pID) REFERENCES part (pID),
    FOREIGN KEY (sID) REFERENCES salesperson (sID)
);