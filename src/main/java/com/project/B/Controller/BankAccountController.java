package com.project.B.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.B.Model.BankAccount;
import com.project.B.Repo.BankAccountConn;

class OverdraftException extends Exception
{
	public OverdraftException(String msg) 
	{
		super(msg);
	}
}
class AlreadyExits extends Exception
{
	public AlreadyExits(String msg) 
	{
		super(msg);
	}
}
@Controller
public class BankAccountController {

	@Autowired
	private BankAccountConn BAC;
	
	@RequestMapping("/")
	public String isLand()
	{
		return "createAccount.jsp";
	}
	@RequestMapping("/WB")
	public String isWB()
	{
		return "withdrawal.jsp";
	}
	@RequestMapping("/DM")
	public String isDM()
	{
		return "depositeMoney.jsp";
	}
	@RequestMapping("/UB")
	public String isUB()
	{
		return "serch.jsp";
	}
	@RequestMapping("/insert")
	public String isCreateAcc(@ModelAttribute BankAccount b,Model m)
	{
		List<BankAccount> lb=BAC.findAll();
		for(BankAccount b1:lb)
		{
			if(b.getAccountHolderName().equals(b1.getAccountHolderName()))
			{
				try
				{
					throw new AlreadyExits("UserName Already Exits Please try Another UserName..!");
				}
				catch(Exception e)
				{
					m.addAttribute("msg", e);
				}
				return "/";
			}
		}
		BAC.save(b);
		m.addAttribute("msg", "Account created successully..!");
		return "/";
	}
	@RequestMapping("/CB")
	public String isFetch(Model m)
	{
		List<BankAccount> lb = BAC.findAll();
		m.addAttribute("bank", lb);
		return "userAccount.jsp";
	}
	@RequestMapping("/with")
	public String isWithd(@ModelAttribute BankAccount b,Model m)
	{
		List<BankAccount> lb = BAC.findAll();
		BankAccount b1 = BAC.findByAccountHolderName(b.getAccountHolderName());
		for(BankAccount b2:lb)
		{
			if(b2.getBalance()<b.getBalance())
			{
				try
				{
					throw new OverdraftException("OverdraftException");
				}
				catch(Exception e)
				{
					m.addAttribute("emsg", e);
				}
			}
			else
			{
				if(BAC!=null)
				{
					double bal=b1.getBalance()-b.getBalance();
					b1.setBalance(bal);
					BAC.save(b1);
					m.addAttribute("msg", "Rs."+b.getBalance()+" Withdrwal successfull..!");
				}
			}
		}
		return "/WB";
	}
	
	@RequestMapping("/depo")
	public String isDepo(@ModelAttribute BankAccount b,Model m)
	{
		BankAccount b1 = BAC.findByAccountHolderName(b.getAccountHolderName());
		if(BAC!=null)
		{
			double bal=b1.getBalance()+b.getBalance();
			b1.setBalance(bal);
			BAC.save(b1);
			m.addAttribute("msg", "Rs."+b.getBalance()+" Deposite successfull..!");
		}		
		return "/DM";
	}
	@RequestMapping("/s")
	public String isFetchUB(Model m,@ModelAttribute BankAccount b)
	{
		BankAccount b1 = BAC.findByAccountHolderName(b.getAccountHolderName());
		m.addAttribute("bank","Rs."+b1.getBalance()+" Current Balance..");
		return "/UB";
	}
	@RequestMapping("d/{acountId}")
	public String isFetchUB(Model m,@PathVariable int acountId)
	{
		BAC.deleteById(acountId);
		return "/CB";
	}
}
