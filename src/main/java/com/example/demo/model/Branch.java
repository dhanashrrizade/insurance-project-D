package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="branch")
public class Branch {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int Id;
	    private String branchName;
	    private String address;

		public int getId() {
			return Id;
		}

		public void setId(int Id) {
			this.Id = Id;
		}

		public String getBranchName() {
			return branchName;
		}

		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}

		

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		@Override
		public String toString() {
			return "Branch [Id=" + Id + ", branchName=" + branchName + ", address=" + address + "]";
		}

	   
}
