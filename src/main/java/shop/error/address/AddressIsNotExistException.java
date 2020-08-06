package shop.error.address;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import shop.error.CustomBaseException;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Address is not Exist (internal error)!")
public class AddressIsNotExistException extends CustomBaseException {
    public AddressIsNotExistException(String msg) {
        super(msg);
    }
}
