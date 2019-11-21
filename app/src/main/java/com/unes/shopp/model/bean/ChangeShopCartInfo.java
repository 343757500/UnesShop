package com.unes.shopp.model.bean;

public class ChangeShopCartInfo {
    /**
     * code : 0
     * result : {"item_kinds":2}
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
         * item_kinds : 2
         */

        private int item_kinds;

        public int getItem_kinds() {
            return item_kinds;
        }

        public void setItem_kinds(int item_kinds) {
            this.item_kinds = item_kinds;
        }
    }
}
