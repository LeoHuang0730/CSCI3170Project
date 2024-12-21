--commit after Insert 

-- Insert into category
INSERT INTO category (cID, cName) VALUES (1, 'CPU');
INSERT INTO category (cID, cName) VALUES (2, 'Motherboard');
INSERT INTO category (cID, cName) VALUES (3, 'Ram');
INSERT INTO category (cID, cName) VALUES (4, 'Storage');
INSERT INTO category (cID, cName) VALUES (5, 'Power Supply');
INSERT INTO category (cID, cName) VALUES (6, 'GPU');
INSERT INTO category (cID, cName) VALUES (7, 'Audio');
INSERT INTO category (cID, cName) VALUES (8, 'Network');
INSERT INTO category (cID, cName) VALUES (9, 'Notebook');

-- Insert into manufacturer
INSERT INTO manufacturer (mID, mName, mAddress, mPhoneNumber) VALUES (1, 'Intel', '2200 Mission College Blvd. Santa Clara, CA, USA', 27658080);
INSERT INTO manufacturer (mID, mName, mAddress, mPhoneNumber) VALUES (2, 'AMD', 'One AMD Place P.O. Box 3453 Sunnyvale, CA, USA', 27494000);
INSERT INTO manufacturer (mID, mName, mAddress, mPhoneNumber) VALUES (3, 'Gigabyte', '6 Bao Chiang Road, Taipei,Taiwan', 89124000);
INSERT INTO manufacturer (mID, mName, mAddress, mPhoneNumber) VALUES (4, 'MSI', '69 Lide Street, Taipei, Taiwan', 32345599);
INSERT INTO manufacturer (mID, mName, mAddress, mPhoneNumber) VALUES (5, 'Biostar', '18551 East Gale Avenue, City of Industry, CA, USA', 25811055);
INSERT INTO manufacturer (mID, mName, mAddress, mPhoneNumber) VALUES (6, 'Transcend', '70 XingZhong Road, Taipei, Taiwan', 27928000);
INSERT INTO manufacturer (mID, mName, mAddress, mPhoneNumber) VALUES (7, 'Corsair', '46221 Landing Parkway, Fremont, CA, USA', 28575518);
INSERT INTO manufacturer (mID, mName, mAddress, mPhoneNumber) VALUES (8, 'Seagate', '10200 S. De Anza Blvd, Cupertino, CA, USA', 27324283);
INSERT INTO manufacturer (mID, mName, mAddress, mPhoneNumber) VALUES (9, 'Antec', '47900 Fremont Blvd. Fremont, CA, USA', 27701200);
INSERT INTO manufacturer (mID, mName, mAddress, mPhoneNumber) VALUES (10, 'Creative', '1523 Cimarron Plaza, Stillwater, OK, USA', 27426622);
INSERT INTO manufacturer (mID, mName, mAddress, mPhoneNumber) VALUES (11, 'Belkin', '12045 E. Waterfront Drive Playa Vista, CA, USA', 27515100);
INSERT INTO manufacturer (mID, mName, mAddress, mPhoneNumber) VALUES (12, 'HP', '3000 Hanover Street Palo Alto, CA, USA', 28575518);
INSERT INTO manufacturer (mID, mName, mAddress, mPhoneNumber) VALUES (13, 'Lenovo', '1009 Think Place, Morrisville, NC, USA', 29684465);

-- Insert into part
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (1, 'AMD FX-8320', 1199, 2, 1, 36, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (2, 'AMD A8 5600K', 710, 2, 1, 36, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (3, 'CORE I3-3250', 1088, 1, 1, 36, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (4, 'CORE I7-4820K', 2599, 1, 1, 36, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (5, 'GA-H87N-WIFI', 999, 3, 2, 12, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (6, 'G1.SNIPER 5', 3299, 3, 2, 12, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (7, 'MSI Z87-G43', 1050, 4, 2, 12, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (8, 'NM70I-1037U', 579, 5, 2, 12, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (9, 'H61-BF UATX', 420, 1, 2, 12, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (10, 'Z87 XPOWER', 3899, 4, 2, 12, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (11, '8GB DDR3', 530, 6, 3, 60, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (12, '16GB DDR3', 1760, 7, 3, 60, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (13, 'SV35 2TB', 730, 8, 4, 60, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (14, 'SSHD 1TB', 720, 8, 4, 60, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (15, '256GB NEUTRON', 1650, 7, 4, 60, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (16, 'CX-430M 430W', 399, 7, 5, 60, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (17, 'HCG 520W', 539, 9, 5, 60, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (18, 'NEO ECO 450C-BR', 439, 9, 5, 60, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (19, 'GTX650TI', 1299, 3, 6, 36, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (20, 'HD7770 1GB', 850, 3, 6, 36, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (21, 'N760 HAWK', 2199, 4, 6, 36, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (22, 'R7770-PMD', 899, 4, 6, 36, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (23, 'Sound Blaster Play', 195, 10, 7, 12, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (24, 'Sound Blaster XZ', 1250, 10, 7, 12, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (25, 'AC1200 DB', 1070, 11, 8, 12, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (26, 'N600 Router', 488, 11, 8, 12, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (27, 'HP 2000 2D18TU', 3109, 12, 9, 18, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (28, 'ENVY 17 J002TX', 10898, 12, 9, 18, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (29, 'Probook 440', 6880, 12, 9, 18, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (30, 'G580G i5 3230', 4499, 13, 9, 18, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (31, 'Flex 15 Core I5', 7980, 13, 9, 18, 99);
INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (32, 'G710A i7 4702', 6509, 13, 9, 18, 99);

-- Insert into salesperson
INSERT INTO salesperson (sID, sName, sAddress, sPhoneNumber, sExperience) 
VALUES (1, 'Maria Fortner', '750, Rainbow Drive, Youngstown', 25037060, 4);

INSERT INTO salesperson (sID, sName, sAddress, sPhoneNumber, sExperience) 
VALUES (2, 'John Smith', '4718, Wildrose Lane, Bloomfield Township', 28592710, 2);

INSERT INTO salesperson (sID, sName, sAddress, sPhoneNumber, sExperience) 
VALUES (3, 'Colin Carlin', '2564, Vesta Drive, Chicago', 27689679, 1);

INSERT INTO salesperson (sID, sName, sAddress, sPhoneNumber, sExperience) 
VALUES (4, 'Kimberly Wooldridge', '1549, McKinley Avenue, Denver', 28366016, 2);

-- Insert into transaction
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (1, 1, 1, TO_DATE('13/09/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (2, 2, 2, TO_DATE('02/08/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (3, 3, 3, TO_DATE('07/11/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (4, 4, 4, TO_DATE('08/11/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (5, 5, 1, TO_DATE('20/09/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (6, 6, 2, TO_DATE('04/10/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (7, 7, 3, TO_DATE('01/08/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (8, 8, 4, TO_DATE('07/10/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (9, 11, 1, TO_DATE('21/10/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (10, 12, 2, TO_DATE('04/08/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (11, 11, 3, TO_DATE('12/11/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (12, 12, 4, TO_DATE('09/10/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (13, 13, 1, TO_DATE('03/11/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (14, 14, 2, TO_DATE('10/09/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (15, 15, 3, TO_DATE('28/11/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (16, 13, 4, TO_DATE('21/11/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (17, 16, 1, TO_DATE('21/10/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (18, 17, 2, TO_DATE('16/08/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (19, 18, 3, TO_DATE('11/09/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (20, 16, 4, TO_DATE('30/09/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (21, 19, 1, TO_DATE('24/11/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (22, 20, 2, TO_DATE('17/10/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (23, 21, 3, TO_DATE('13/09/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (24, 22, 4, TO_DATE('03/09/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (25, 23, 1, TO_DATE('02/10/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (26, 24, 2, TO_DATE('15/08/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (27, 23, 3, TO_DATE('15/10/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (28, 24, 4, TO_DATE('26/11/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (29, 25, 1, TO_DATE('30/10/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (30, 26, 2, TO_DATE('15/11/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (31, 25, 3, TO_DATE('01/10/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (32, 26, 4, TO_DATE('21/09/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (33, 27, 1, TO_DATE('08/10/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (34, 28, 2, TO_DATE('18/08/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (35, 29, 3, TO_DATE('20/10/2016', 'DD/MM/YYYY'));
INSERT INTO transaction (tID, pID, sID, tDate) VALUES (36, 30, 4, TO_DATE('02/10/2016', 'DD/MM/YYYY'));
