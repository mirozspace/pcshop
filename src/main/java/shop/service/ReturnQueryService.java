package shop.service;

import shop.models.service.ReturnQueryServiceModel;

public interface ReturnQueryService {

    ReturnQueryServiceModel addReturnQuery(ReturnQueryServiceModel rqsm);

    boolean deleteReturnQuery(String returnQueryId);

}
