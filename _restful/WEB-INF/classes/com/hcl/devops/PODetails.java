package com.hcl.devops;

   public class PODetails {
   	private String product;
      private int qty;
      private int unitprice;
      private int totalprice;
      private String shiptoaddress;
   	
   	public String getProduct() {
   		return product;
   	}

   	public void setProduct(String value) {
   		product = value;
   	}

      public int getQty() {
         return qty;
      }

      public void setQty(int value) {
         qty = value;
      }

      public int getUnitPrice() {
         return unitprice;
      }

      public void setUnitPrice(int value) {
         unitprice = value;
      }

      public int getTotalPrice() {
         return totalprice;
      }

      public void setTotalPrice(int value) {
         totalprice = value;
      }

      public String getShipToAddress() {
         return shiptoaddress;
      }

      public void setShipToAddress(String value) {
         shiptoaddress = value;
      }
   }
   