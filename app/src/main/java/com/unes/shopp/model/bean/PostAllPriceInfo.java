package com.unes.shopp.model.bean;

import java.util.List;

public class PostAllPriceInfo {
    /**
     * status : 1
     * result : {"couponPackageList":[]}
     * code : 0
     */

    private int status;
    private ResultBean result;
    private int code;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBean {
        private List<?> couponPackageList;

        public List<?> getCouponPackageList() {
            return couponPackageList;
        }

        public void setCouponPackageList(List<?> couponPackageList) {
            this.couponPackageList = couponPackageList;
        }
    }
}
