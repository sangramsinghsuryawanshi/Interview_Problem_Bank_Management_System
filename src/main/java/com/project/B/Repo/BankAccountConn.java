package com.project.B.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.B.Model.BankAccount;
import java.util.List;


public interface BankAccountConn extends JpaRepository<BankAccount, Integer> {
	public BankAccount findByAccountHolderName(String accountHolderName);
}
