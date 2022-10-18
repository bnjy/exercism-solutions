import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class BankAccount {
    /* Class attributes */
    private final boolean OPEN = true;
    private final boolean CLOSED = false;

    private AtomicInteger balance;
    private AtomicBoolean status;

    /**
     * Class constructor
     */
    public BankAccount(){
        this.balance = new AtomicInteger(0);
        this.status = new AtomicBoolean(CLOSED);
    }

    /**
     * Method to open bank account.
     */
    public void open(){
        this.status.set(OPEN);
    }

    /**
     * Method to close bank account.
     */
    public void close(){
        this.status.set(CLOSED);
    }

    /**
     * mathod to deposit amount from bank account.
     * @param value, the integer value to deposit from the accoint balance.
     * @throws BankAccountActionInvalidException if account is closed or trying to deposit negative amount.
     */
    public synchronized void deposit(int value) throws BankAccountActionInvalidException{
        checkIfAccountIsClosed();
        checkIfAmountPositive(value);
        this.balance.addAndGet(value);
    }

    /**
     * method withdraw, withdraws an amount from the bank account balance.
     * @param value
     * @throws BankAccountActionInvalidException if account is closed, amount is positive,
     * account is empty or withdraw amount is greater than the account balance.
     */
    public synchronized void withdraw(int value) throws BankAccountActionInvalidException{
        checkIfAccountIsClosed();
        checkIfAmountPositive(value);
        checkIfAccountIsEmpty();
        checkIfAccountBalanceIsGreaterThanAmountWithdrawn(value);
        this.balance.addAndGet(-value);
    }

    /**
     * Method to get the balance for bank account with status open.
     * @return int balance, the current balance of the account.
     * @throws BankAccountActionInvalidException if the account is closed;
     */
    public int getBalance() throws BankAccountActionInvalidException{
        checkIfAccountIsClosed();
        return this.balance.get();
    }

    /**
     * Method to check if the account status is closed, meaning boolean status = false;
     * @throws BankAccountActionInvalidException if status of the account is closed.
     */
    private void checkIfAccountIsClosed() throws BankAccountActionInvalidException{
        if(!this.status.get()){
            throw new BankAccountActionInvalidException("Account closed");
        }
    }

    /**
     * Method to check if the withdraw amount is not bigger than the balance amount on the bank account.
     * @param value, the amount to withdraw from the bank account.
     * @throws BankAccountActionInvalidException if the param value is greater than the current balance of the account.
     */
    private void checkIfAccountBalanceIsGreaterThanAmountWithdrawn(int value) throws BankAccountActionInvalidException{
        if(value>balance.get()){
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        }
    }

    /**
     * Method to check if the bank account balance is empty/equals 0.
     * @throws BankAccountActionInvalidException if the balance on the bank account is empty.
     */
    private void checkIfAccountIsEmpty() throws BankAccountActionInvalidException{
        if(balance.get() == 0){
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        }
    }

    /**
     * Method to check if the given value from the client is positive.
     * @param value, given for bank account operations. can't be < 0.
     * @throws BankAccountActionInvalidException if value is negative number.
     */
    private void checkIfAmountPositive(int value) throws BankAccountActionInvalidException{
        if(value < 0){
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
    }
}