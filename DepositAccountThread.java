
package za.ac.tut.bl;

/**
 *
 * @author Thapelo Mkhwanazi
 */
public class DepositAccountThread extends Thread
{
    private AccountManager am;
    private double amount;

    public DepositAccountThread(AccountManager am, double amount) 
    {
        this.am = am;
        this.amount = amount;
    }
    
    @Override
    public void run()
    {
       am.deposit(amount);
    }
}
