package shop.service.interfaces;

import shop.models.service.ReturnQueryServiceModel;

public interface ReturnQueryService {

    /**
     * Adds user's return ask to db
     * @param rqsm ReturnQueryServiceModel
     * @return
     */
    ReturnQueryServiceModel addReturnQuery(ReturnQueryServiceModel rqsm);

    /**
     * Removes user's return ask from db
     * @param returnQueryId
     */
    void deleteReturnQuery(String returnQueryId);

}
