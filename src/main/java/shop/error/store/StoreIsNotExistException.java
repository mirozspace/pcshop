package shop.error.store;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import shop.error.CustomBaseException;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Store is not exist!")
public class StoreIsNotExistException extends CustomBaseException {
    public StoreIsNotExistException(String msg) {
        super(msg);
    }
}
