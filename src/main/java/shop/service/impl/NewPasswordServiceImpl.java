package shop.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.models.service.NewPasswordServiceModel;
import shop.service.NewPasswordService;
import shop.tools.ListFactoryForPassword;
import shop.tools.TextManipulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class NewPasswordServiceImpl implements NewPasswordService {

    private static final String IS_CHECKED = "checked";

    private final Random random;
    private final ListFactoryForPassword listFactoryForPassword;
    private final TextManipulator textManipulator;

    @Autowired
    public NewPasswordServiceImpl(Random random, ListFactoryForPassword listFactoryForPassword, TextManipulator textManipulator) {
        this.random = random;
        this.listFactoryForPassword = listFactoryForPassword;
        this.textManipulator = textManipulator;
    }

    @Override
    public String getRandomPassword(NewPasswordServiceModel model) {
        List<Character> resultPassword1 = createPasswordWithoutLength(model);
        if (resultPassword1 != null) {

            List<Character> finalPassword = new ArrayList<>();
            int lengthPassword = model.getLengthOfPassword();
            lengthPassword = Math.max(10, model.getLengthOfPassword());

            if (model.getLowercase() != null && model.getLowercase().equals(IS_CHECKED)) {
                List<Character> lower = this.listFactoryForPassword.getSmallLetters();
                finalPassword.add(lower.get(this.random.nextInt(lower.size())));
            }
            if (model.getUppercase() != null && model.getUppercase().equals(IS_CHECKED)) {
                List<Character> upper = this.listFactoryForPassword.getCapLetters();
                finalPassword.add(upper.get(this.random.nextInt(upper.size())));
            }
            if (model.getSpecialSymbols() != null && model.getSpecialSymbols().equals(IS_CHECKED)) {
                List<Character> special = this.listFactoryForPassword.getSpecialSymbols();
                for (int i = 0; i < 4; i++) {
                    finalPassword.add(special.get(this.random.nextInt(special.size())));
                }
            }
            if (model.getDigits() != null && model.getDigits().equals(IS_CHECKED)) {
                List<Character> digits = this.listFactoryForPassword.getNumbers();
                for (int i = 0; i < 2; i++) {
                    finalPassword.add(digits.get(this.random.nextInt(digits.size())));
                }
            }

            int additionalRotation = lengthPassword - finalPassword.size();
            for (int i = 0; i < additionalRotation; i++) {
                finalPassword.add(resultPassword1.get(this.random.nextInt(resultPassword1.size())));
            }
            return this.textManipulator.characterListToString(finalPassword);
        } else {
            return null;
        }
    }
    /**
     * Created password from user choice without user password length!
     *
     * @param model
     * @return List<Character>
     */
    private List<Character> createPasswordWithoutLength(NewPasswordServiceModel model) {

        if (model.getLowercase() == null && model.getUppercase() == null && model.getDigits() == null
                && model.getSpecialSymbols() == null)
            return null;

        List<Character> result = new ArrayList<>();
        if (model.getLowercase() != null && model.getLowercase().equals(IS_CHECKED)) {
            for (int i = 0; i < 2; i++) {
                result.addAll(this.listFactoryForPassword.getSmallLetters());
            }
        }
        if (model.getUppercase() != null && model.getUppercase().equals(IS_CHECKED)) {
            for (int i = 0; i < 2; i++) {
                result.addAll(this.listFactoryForPassword.getCapLetters());
            }
        }
        if (model.getDigits() != null && model.getDigits().equals(IS_CHECKED)) {
            for (int i = 0; i < 2; i++) {
                result.addAll(this.listFactoryForPassword.getNumbers());
            }
        }
        if (model.getSpecialSymbols() != null && model.getSpecialSymbols().equals(IS_CHECKED)) {
            for (int i = 0; i < 9; i++) {
                result.addAll(this.listFactoryForPassword.getSpecialSymbols());
            }
        }

        for (int i = 0; i < 5; i++) {
            Collections.shuffle(result);
        }
        return result;
    }
}