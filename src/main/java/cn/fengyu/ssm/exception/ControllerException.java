package cn.fengyu.ssm.exception;

/**
 * @author fengyu
 * @since 2016-01-22
 */
public class ControllerException extends  Exception {
    private String errmsg;
    private Integer errCode;


    public ControllerException(String message) {
        super(message);
        this.errmsg=message;
    }

    public ControllerException(String errMessage, Integer errCode) {
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
