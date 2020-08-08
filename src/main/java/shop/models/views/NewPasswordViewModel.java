package shop.models.views;

public class NewPasswordViewModel {

    private String lowercase;
    private String uppercase;
    private String digits;
    private String specialSymbols;
    private int lengthOfPassword;

    public NewPasswordViewModel() {
    }

    public int getLengthOfPassword() {
        return lengthOfPassword;
    }

    public void setLengthOfPassword(int lengthOfPassword) {
        this.lengthOfPassword = lengthOfPassword;
    }

    public String getLowercase() {
        return lowercase;
    }

    public void setLowercase(String lowercase) {
        this.lowercase = lowercase;
    }

    public String getUppercase() {
        return uppercase;
    }

    public void setUppercase(String uppercase) {
        this.uppercase = uppercase;
    }

    public String getDigits() {
        return digits;
    }

    public void setDigits(String digits) {
        this.digits = digits;
    }

    public String getSpecialSymbols() {
        return specialSymbols;
    }

    public void setSpecialSymbols(String specialSymbols) {
        this.specialSymbols = specialSymbols;
    }
}
