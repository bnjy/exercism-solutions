class BankAccount {
    private final boolean OPEN = true;
    private final boolean CLOSED = false;

    private int balance = 0;
    private boolean status = CLOSED;

    public void open(){
        this.status = OPEN;
    }

    public void close(){
        this.status = CLOSED;
    }

    public synchronized void deposit(int value) throws BankAccountActionInvalidException{
        checkIfAccountIsClosed();
        checkIfAmountPositive(value);
        this.balance += value;
    }

    public synchronized void withdraw(int value) throws BankAccountActionInvalidException{
        checkIfAccountIsClosed();
        checkIfAmountPositive(value);
        checkIfAccountIsEmpty();
        checkIfAccountBalanceIsGraterThanAmountWithdrawn(value);
        this.balance -= value;
    }

    public int getBalance() throws BankAccountActionInvalidException{
        checkIfAccountIsClosed();
        return this.balance;
    }

    private void checkIfAccountIsClosed() throws BankAccountActionInvalidException{
        if(!this.status){
            throw new BankAccountActionInvalidException("Account closed");
        }
    }

    private void checkIfAccountBalanceIsGraterThanAmountWithdrawn(int value) throws BankAccountActionInvalidException{
        if(value>balance){
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        }
    }

    private void checkIfAccountIsEmpty() throws BankAccountActionInvalidException{
        if(balance == 0){
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        }
    }

    private void checkIfAmountPositive(int value) throws BankAccountActionInvalidException{
        if(value < 0){
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
    }
}