package com.unes.shopp.model.bean;

public class LoginInfo {
    /**
     * code : 0
     * result : {"uid":38,"isAgency":1,"shopProfileId":34}
     * status : 1
     */

    private int code;
    private ResultBean result;
    private int status;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class ResultBean {
        /**
         * uid : 38
         * isAgency : 1
         * shopProfileId : 34
         */

        private int uid;
        private int isAgency;
        private int shopProfileId;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getIsAgency() {
            return isAgency;
        }

        public void setIsAgency(int isAgency) {
            this.isAgency = isAgency;
        }

        public int getShopProfileId() {
            return shopProfileId;
        }

        public void setShopProfileId(int shopProfileId) {
            this.shopProfileId = shopProfileId;
        }
    }
}
