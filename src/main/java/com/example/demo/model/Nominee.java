package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="nominee")
public class Nominee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nomineeId;
	private String status;
	private String nomineename;
	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomineeId() {
		return nomineeId;
	}

	public void setNomineeId(String nomineeId) {
		this.nomineeId = nomineeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNomineename() {
		return nomineename;
	}

	public void setNomineename(String nomineename) {
		this.nomineename = nomineename;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Nominee [id=" + id + ", nomineeId=" + nomineeId + ", status=" + status + ", nomineename=" + nomineename
				+ ", userId=" + userId + "]";
	}

}


