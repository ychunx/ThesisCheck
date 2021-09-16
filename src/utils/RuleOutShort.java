package utils;

@SuppressWarnings({"ALL", "unused"})
public class RuleOutShort extends Exception {

// --注释掉检查 START (2021/9/16 20:57):
//    @SuppressWarnings("unused")
//    public RuleOutShort() {
//        super();
//    }
// --注释掉检查 STOP (2021/9/16 20:57)

    public RuleOutShort(String message) {
        super(message);
    }

    public RuleOutShort(String message, Throwable cause) {
        super(message, cause);
    }

    public RuleOutShort(Throwable cause) {
        super(cause);
    }

}
