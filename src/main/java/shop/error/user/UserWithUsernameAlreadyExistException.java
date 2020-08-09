package shop.error.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import shop.error.CustomBaseException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Username already exist")
public class UserWithUsernameAlreadyExistException extends CustomBaseException {

	private static final long serialVersionUID = 1L;

	public UserWithUsernameAlreadyExistException(String msg) {
        super(msg);
    }
}
