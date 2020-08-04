package shop.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User login is not correct!!")
public class UserLogIsNotCorrect extends CustomBaseException{
    public UserLogIsNotCorrect(String message) {
        super(message);
    }
}
