package com.mockuai.marketingcenter.common.api;

import com.mockuai.marketingcenter.common.constant.ResponseCode;

public class MarketingResponse<T> implements Response<T> {

    private static final long serialVersionUID = 8295766534182699773L;
    private T module;
    private int resCode;
    private String message;
    private long totalCount;

    public MarketingResponse(int resCode) {
        this.resCode = resCode;
    }

    public MarketingResponse(int resCode, String message) {
        this.resCode = resCode;
        this.message = message;
    }

    public MarketingResponse(ResponseCode rtnCode) {
        this(rtnCode.getCode(), rtnCode.getMessage());
    }

    public MarketingResponse(ResponseCode rtnCode, String message) {
        this(rtnCode);
        this.message = message;
    }

    public MarketingResponse(T module) {
        this.module = module;
        this.resCode = ResponseCode.SUCCESS.getCode();
        this.message = ResponseCode.SUCCESS.getMessage();
    }

    public MarketingResponse(T module, long totalCount) {
        this.module = module;
        this.totalCount = totalCount;
        this.resCode = ResponseCode.SUCCESS.getCode();
        this.message = ResponseCode.SUCCESS.getMessage();
    }

    public T getModule() {
        return this.module;
    }

    public void setModule(T module) {
        this.module = module;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getResCode() {
        return this.resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public boolean isSuccess() {
        return ResponseCode.SUCCESS.getCode() == this.resCode;
    }
}