package shop.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Address is not Exist (internal error)!")
public class AddressIsNotExist extends CustomBaseException {
    public AddressIsNotExist(String msg) {
        super(msg);
    }
}
