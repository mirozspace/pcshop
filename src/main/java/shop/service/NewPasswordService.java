package shop.service;

import shop.models.service.NewPasswordServiceModel;

public interface NewPasswordService {

    String getRandomPassword(NewPasswordServiceModel newPasswordServiceModel);

}
