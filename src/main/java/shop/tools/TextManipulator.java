package shop.tools;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TextManipulator {

    public TextManipulator() {
    }

    public String characterListToString(List<Character> finalPassword) {
        StringBuilder sb = new StringBuilder();
        for (Character character : finalPassword) {
            sb.append(character);
        }
        return sb.toString().trim();
    }
}
