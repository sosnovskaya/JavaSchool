import java.math.BigDecimal;

public class TerminalImpl implements Terminal {

    private final TerminalServer server =  new TerminalServer();
    private final PinValidator pinValidator = new PinValidator(server);

    @Override
    public BigDecimal checkAccount() throws TerminalException.WrongPinFormat, TerminalException.AccountIsLockedException {
        if(pinValidator.validate()){
            return server.getAccountSum();
        }
        return null;
    }

    @Override
    public boolean withdrawMoney(BigDecimal amount) throws TerminalException.NotEnoughMoney, TerminalException.WrongPinFormat, TerminalException.AccountIsLockedException {
        if(pinValidator.validate()) {
            return server.withdrawFromAccount(amount);
        }
        return false;
    }

    @Override
    public boolean putMoney(BigDecimal amount) throws TerminalException.AccountIsLockedException, TerminalException.WrongPinFormat {
        if(pinValidator.validate()) {
            return server.addToAccount(amount);
        }
        return false;
    }
}
