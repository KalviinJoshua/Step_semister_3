public class Locker {
    private String code;
    private final int lockerNumber;
    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }
    public void changeCode(String currentCode, String newCode) {
        if (code.equals(currentCode)) {
            code = newCode;
            System.out.println("Code changed successfully.");
        } else {
            System.out.println("Code change rejected.");
        }
    }
    public int getLockerNumber() {
        return lockerNumber;
    }
    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");
        locker.changeCode("1234", "5678");
        locker.changeCode("0000", "9999");
    }
}