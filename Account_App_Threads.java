
package account_app_threads;

import za.ac.tut.bl.AccountManager;
import za.ac.tut.bl.DepositAccountThread;
import za.ac.tut.bl.WithdrawAccountThread;
import za.ac.tut.entity.Account;

/**
 *
 * @author Thapelo Mkhwanazi
 */
public class Account_App_Threads
{

    public static void main(String[] args) 
    {
        /*
         this is an app that uses threads, there is an account that students must access so this account must be secured and be access by all students safely
         it has deposit and withdraw methods
        */
        Account account = new Account();
        AccountManager am = new AccountManager(account);
        
        Thread t1 = new DepositAccountThread(am, 100);
        Thread t2 = new DepositAccountThread(am, 200);
        Thread t3 = new WithdrawAccountThread(am, 200);
        Thread t4 = new WithdrawAccountThread(am, 500.00);
        
        t1.setName("Thapelo");
        t2.setName("Kamogelo");
        t3.setName("Thabang");
        t4.setName("Rendani");
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
    
}
