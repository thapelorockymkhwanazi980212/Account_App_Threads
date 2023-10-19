
package za.ac.tut.bl;

/**
 *
 * @author Thapelo Mkhwanazi
 */
public class WithdrawAccountThread extends Thread 
{
    private AccountManager am;
    private double amount;

    public WithdrawAccountThread(AccountManager account, double amount) 
    {
        this.amount = amount;
        this.am = account;
    }

    @Override
    public void run()
    {
        am.withdraw(amount);
    }
}
