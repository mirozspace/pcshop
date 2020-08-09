package shop.error.role;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import shop.error.CustomBaseException;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "User role is not exist!")
public class URoleIsNotExistException extends CustomBaseException {
   
	private static final long serialVersionUID = 1L;

	public URoleIsNotExistException(String msg) {
        super(msg);
    }
}
