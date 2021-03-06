package shop.error.store;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import shop.error.CustomBaseException;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Store wit this name exist!")
public class StoreAlreadyExistException extends CustomBaseException {
  
	private static final long serialVersionUID = 1L;

	public StoreAlreadyExistException(String msg) {
        super(msg);
    }
}
