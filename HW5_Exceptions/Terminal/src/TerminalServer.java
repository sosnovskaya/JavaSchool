import java.math.BigDecimal;

public class TerminalServer {

    private BigDecimal accountSum = AccountSumRand.randomAccountSum();
    private boolean isBlocked = false;
    public int msToWait = 0;

    public BigDecimal getAccountSum() {
        return accountSum;
    }

    public void setAccountSum(BigDecimal accountSum) {
        this.accountSum = accountSum;
    }

    public boolean addToAccount(BigDecimal sum) throws TerminalException.AccountIsLockedException {
        if(isBlocked)
            throw new TerminalException.AccountIsLockedException(msToWait);
        setAccountSum(sum.add(getAccountSum()));
        return true;
    }

    public boolean withdrawFromAccount(BigDecimal sum) throws TerminalException.NotEnoughMoney {
        if(getAccountSum().compareTo(sum) < 0)
            throw new TerminalException.NotEnoughMoney();
        setAccountSum(getAccountSum().subtract(sum));
        return true;
    }

    public void block(){
        isBlocked = true;
        msToWait = 5;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                        msToWait--;
                    } catch (InterruptedException e) {

                    }
                }
                isBlocked = false;
            }
        }).start();

    }

    private String pin = "1234";

    public String getPin(){
        return pin;
    }
}
