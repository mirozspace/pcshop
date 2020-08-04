package shop.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Store wit this name exist!")
public class StoreExistException extends CustomBaseException {
    public StoreExistException(String msg) {
        super(msg);
    }
}
