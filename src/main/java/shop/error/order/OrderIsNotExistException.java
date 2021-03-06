package shop.error.order;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import shop.error.CustomBaseException;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Order is not exist!")
public class OrderIsNotExistException extends CustomBaseException {

	private static final long serialVersionUID = 1L;

	public OrderIsNotExistException(String msg) {
        super(msg);
    }
}
