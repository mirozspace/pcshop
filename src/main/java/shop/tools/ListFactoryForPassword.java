package shop.tools;

import java.util.ArrayList;
import java.util.List;

public class ListFactoryForPassword {

    private List<Character> specialSymbols; //            = "-/.^&*_!@%=+>)";
    private List<Character> capLetters; //                     = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private List<Character> smallLetters; //             = "abcdefghijklmnopqrstuvwxyz";
    private List<Character> numbers; //                    = "0123456789";

    public ListFactoryForPassword() {
        this.setSpecialSymbols();
        this.setCapLetters();
        this.setSmallLetters();
        this.setNumbers();
    }

    public List<Character> getSpecialSymbols() {
        return specialSymbols;
    }

    public List<Character> getCapLetters() {
        return capLetters;
    }

    public List<Character> getSmallLetters() {
        return smallLetters;
    }

    public List<Character> getNumbers() {
        return numbers;
    }

    private void setSpecialSymbols() {
        this.specialSymbols = charArrayToList("-/.^&*_!@%+>)");
    }

    private void setCapLetters() {
        this.capLetters = charArrayToList("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }

    private void setSmallLetters() {
        this.smallLetters = charArrayToList("abcdefghijklmnopqrstuvwxyz");
    }

    private void setNumbers() {
        this.numbers = charArrayToList("0123456789");
    }

    private List<Character> charArrayToList(String str) {
        List<Character> list = new ArrayList<>();
        char[] specialSymbols = str.toCharArray();
        for (char specialSymbol : specialSymbols) {
            list.add(specialSymbol);
        }
        return list;
    }
}