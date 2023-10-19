
package za.ac.tut.bl;

import za.ac.tut.entity.Account;

/**
 *
 * @author Thapelo Mkhwanazi
 */
public class AccountManager implements AccountManagerInterface 
{

    private Account account;

    public AccountManager(Account account) 
    {
        this.account = account;
    }
    
    
    
    @Override
    public synchronized void deposit(double amount) 
    {
        double balance, initialBalance;
        
        System.out.println(Thread.currentThread().getName() + " turn. Intial amount:R" + amount); // 'Thread.currentThread().getName()' the statement get the name of the thread
        
        for (int i = 0; i < 5; i++) 
        {
             balance = account.getBalance(); //getting the balance from the account
             initialBalance = balance; //so meaning intial balance is 100
             balance = balance + amount;
             account.setBalance(balance); // overwriting the balance into the account to the new balance
             System.out.println(Thread.currentThread().getName()+ "-->Initial balance :R" + initialBalance + "-->Deposited amount: R" + amount + 
                     "-->Remaining account balance: R" + account.getBalance());
        }
    }

    @Override
    public synchronized void withdraw(double amount) 
    {
       double balance, initialBalance;
       
        System.out.println(Thread.currentThread().getName() + " turn. Intial amount:R" + amount);
        
        for (int i = 0; i < 5; i++) 
        {
            balance = account.getBalance();
            initialBalance = balance;
            
            if(balance >= amount)
            {
                balance = balance - amount;
                account.setBalance(balance);
                System.out.println(Thread.currentThread().getName()+ "-->Initial balance :R" + initialBalance + "-->Requested amount: R" + amount + 
                     "-->Remaining account balance: R" + account.getBalance());
            }
            else
            {
                //System.out.println("Insufficient balance!!!");
                break;
            }
        }
        
        System.out.println("");
    }
    
}
