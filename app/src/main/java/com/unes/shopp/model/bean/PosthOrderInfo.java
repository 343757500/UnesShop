package com.unes.shopp.model.bean;

public class PosthOrderInfo {
    /**
     * code : 0
     * result : {"tradeStatus":2,"pType":4,"tradeId":"8557432661676938","tradeType":1}
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
         * tradeStatus : 2
         * pType : 4
         * tradeId : 8557432661676938
         * tradeType : 1
         */

        private int tradeStatus;
        private int pType;
        private String tradeId;
        private int tradeType;

        public int getTradeStatus() {
            return tradeStatus;
        }

        public void setTradeStatus(int tradeStatus) {
            this.tradeStatus = tradeStatus;
        }

        public int getPType() {
            return pType;
        }

        public void setPType(int pType) {
            this.pType = pType;
        }

        public String getTradeId() {
            return tradeId;
        }

        public void setTradeId(String tradeId) {
            this.tradeId = tradeId;
        }

        public int getTradeType() {
            return tradeType;
        }

        public void setTradeType(int tradeType) {
            this.tradeType = tradeType;
        }
    }
}
