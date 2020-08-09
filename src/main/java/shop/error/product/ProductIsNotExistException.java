package shop.error.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import shop.error.CustomBaseException;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "This product is not exist!")
public class ProductIsNotExistException extends CustomBaseException {

	private static final long serialVersionUID = 1L;

	public ProductIsNotExistException(String msg) {
        super(msg);
    }
}
