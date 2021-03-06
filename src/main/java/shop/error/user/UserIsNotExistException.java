package shop.error.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import shop.error.CustomBaseException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User is not exist!")
public class UserIsNotExistException extends CustomBaseException {
    
	private static final long serialVersionUID = 1L;

	public UserIsNotExistException(String msg) {
        super(msg);
    }
}
