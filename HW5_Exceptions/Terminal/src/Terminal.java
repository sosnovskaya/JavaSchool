import java.math.BigDecimal;

public interface Terminal {

    BigDecimal checkAccount() throws TerminalException.WrongPinFormat, TerminalException.AccountIsLockedException;

    boolean withdrawMoney(BigDecimal amount) throws TerminalException.NotEnoughMoney, TerminalException.WrongPinFormat, TerminalException.AccountIsLockedException;

    boolean putMoney(BigDecimal amount) throws TerminalException.AccountIsLockedException, TerminalException.WrongPinFormat;
}
