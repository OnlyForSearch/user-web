package cn.fengyu.ssm.exception;

/**
 * @author fengyu
 * @since 2016-01-22
 */
public class ServiceException extends  Exception {
    private String errmsg;
    private Integer errCode;


    public ServiceException(String message) {
        super(message);
        this.errmsg=message;
    }

    public ServiceException(String errMessage, Integer errCode) {
        super(errMessage);
        this.errCode=errCode;

    }

    public String getErrmsg() {
        return errmsg;
    }

    public Integer getErrCode() {
        return errCode;
    }


}
