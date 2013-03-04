create database `rackspace`;

use rackspace;

CREATE TABLE `purchaseorder` (
  `poname` varchar(45) NOT NULL,
  `product` varchar(45) NOT NULL,
  `qty` int(11) NOT NULL,
  `unitprice` int(11) NOT NULL,
  `totalprice` int(11) NOT NULL,
  `shiptoaddress` varchar(45) NOT NULL,
  PRIMARY KEY (`poname`)
);

INSERT INTO purchaseorder values ('P101', 'Product 1', 10, 100, 1000, '127, New jersey, 24610');
INSERT INTO purchaseorder values ('P102', 'Product 2', 20, 110, 2200, '812, Embassy Heights, ORR, Bangalore');
INSERT INTO purchaseorder values ('P103', 'Product 3', 10, 120, 1200, 'HCL Technologies, Sector 18, SEZ, Noida, Delhi');
INSERT INTO purchaseorder values ('P104', 'Product 4', 10, 130, 1300, '7359, Frankfurt Strausse, Frankfurt GmBH');
INSERT INTO purchaseorder values ('P105', 'Product 5', 10, 140, 1400, '1D 101, Fairview Street, Edinburgh EH5 LK89');