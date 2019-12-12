package com.unes.shopp.model.bean;

import java.io.Serializable;
import java.util.List;

public class FetchItemsInfo implements Serializable{
    /**
     * code : 0
     * result : {"nowDate":1574839744985,"items":[{"activtyStatus":-1,"approveStatus":1,"baseSoldQuantity":100,"brandName":"unes","cateId":20000215,"desc":"化妆品","detail":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191104/vNTT-0-1572862763008.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191104/vNTT-0-1572862763104.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191104/vNTT-0-1572862762930.jpg","endTime":2204016119785,"extensionPic":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191104/vNTT-0-1572862782158.jpg","features":"{\"特别说明\":\"\",\"功效\":\"\",\"适用人群\":\"\",\"保质期\":\"\"}","hasBrokerageFee":0,"isNeedPostFee":0,"isTaxFree":1,"isrefund":0,"itemId":103,"itemNum":1000,"maxShare":"29.00","multiple":1,"pics":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191104/vNTT-0-1572862077446.jpg","price":19900,"refPrice":46800,"shopId":999,"soldCnt":0,"specification":"蛋白酶冻干粉50gX6支，溶媒3mlX6支，原液5mlX4支","title":"蛋白酶冻干粉","type":1}]}
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
         * nowDate : 1574839744985
         * items : [{"activtyStatus":-1,"approveStatus":1,"baseSoldQuantity":100,"brandName":"unes","cateId":20000215,"desc":"化妆品","detail":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191104/vNTT-0-1572862763008.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191104/vNTT-0-1572862763104.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191104/vNTT-0-1572862762930.jpg","endTime":2204016119785,"extensionPic":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191104/vNTT-0-1572862782158.jpg","features":"{\"特别说明\":\"\",\"功效\":\"\",\"适用人群\":\"\",\"保质期\":\"\"}","hasBrokerageFee":0,"isNeedPostFee":0,"isTaxFree":1,"isrefund":0,"itemId":103,"itemNum":1000,"maxShare":"29.00","multiple":1,"pics":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191104/vNTT-0-1572862077446.jpg","price":19900,"refPrice":46800,"shopId":999,"soldCnt":0,"specification":"蛋白酶冻干粉50gX6支，溶媒3mlX6支，原液5mlX4支","title":"蛋白酶冻干粉","type":1}]
         */

        private long nowDate;
        private List<ItemsBean> items;

        public long getNowDate() {
            return nowDate;
        }

        public void setNowDate(long nowDate) {
            this.nowDate = nowDate;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * activtyStatus : -1
             * approveStatus : 1
             * baseSoldQuantity : 100
             * brandName : unes
             * cateId : 20000215
             * desc : 化妆品
             * detail : http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191104/vNTT-0-1572862763008.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191104/vNTT-0-1572862763104.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191104/vNTT-0-1572862762930.jpg
             * endTime : 2204016119785
             * extensionPic : http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191104/vNTT-0-1572862782158.jpg
             * features : {"特别说明":"","功效":"","适用人群":"","保质期":""}
             * hasBrokerageFee : 0
             * isNeedPostFee : 0
             * isTaxFree : 1
             * isrefund : 0
             * itemId : 103
             * itemNum : 1000
             * maxShare : 29.00
             * multiple : 1
             * pics : http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191104/vNTT-0-1572862077446.jpg
             * price : 19900
             * refPrice : 46800
             * shopId : 999
             * soldCnt : 0
             * specification : 蛋白酶冻干粉50gX6支，溶媒3mlX6支，原液5mlX4支
             * title : 蛋白酶冻干粉
             * type : 1
             */

            private int activtyStatus;
            private int approveStatus;
            private int baseSoldQuantity;
            private String brandName;
            private int cateId;
            private String desc;
            private String detail;
            private long endTime;
            private String extensionPic;
            private String features;
            private int hasBrokerageFee;
            private int isNeedPostFee;
            private int isTaxFree;
            private int isrefund;
            private int itemId;
            private int itemNum;

            private String maxShare;
            private int multiple;
            private String pics;
            private int price;
            private int refPrice;
            private int shopId;
            private int soldCnt;
            private String specification;
            private String title;
            private int type;

            public int getActivtyStatus() {
                return activtyStatus;
            }

            public void setActivtyStatus(int activtyStatus) {
                this.activtyStatus = activtyStatus;
            }

            public int getApproveStatus() {
                return approveStatus;
            }

            public void setApproveStatus(int approveStatus) {
                this.approveStatus = approveStatus;
            }

            public int getBaseSoldQuantity() {
                return baseSoldQuantity;
            }

            public void setBaseSoldQuantity(int baseSoldQuantity) {
                this.baseSoldQuantity = baseSoldQuantity;
            }

            public String getBrandName() {
                return brandName;
            }

            public void setBrandName(String brandName) {
                this.brandName = brandName;
            }

            public int getCateId() {
                return cateId;
            }

            public void setCateId(int cateId) {
                this.cateId = cateId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public long getEndTime() {
                return endTime;
            }

            public void setEndTime(long endTime) {
                this.endTime = endTime;
            }

            public String getExtensionPic() {
                return extensionPic;
            }

            public void setExtensionPic(String extensionPic) {
                this.extensionPic = extensionPic;
            }

            public String getFeatures() {
                return features;
            }

            public void setFeatures(String features) {
                this.features = features;
            }

            public int getHasBrokerageFee() {
                return hasBrokerageFee;
            }

            public void setHasBrokerageFee(int hasBrokerageFee) {
                this.hasBrokerageFee = hasBrokerageFee;
            }

            public int getIsNeedPostFee() {
                return isNeedPostFee;
            }

            public void setIsNeedPostFee(int isNeedPostFee) {
                this.isNeedPostFee = isNeedPostFee;
            }

            public int getIsTaxFree() {
                return isTaxFree;
            }

            public void setIsTaxFree(int isTaxFree) {
                this.isTaxFree = isTaxFree;
            }

            public int getIsrefund() {
                return isrefund;
            }

            public void setIsrefund(int isrefund) {
                this.isrefund = isrefund;
            }

            public int getItemId() {
                return itemId;
            }

            public void setItemId(int itemId) {
                this.itemId = itemId;
            }

            public int getItemNum() {
                return itemNum;
            }

            public void setItemNum(int itemNum) {
                this.itemNum = itemNum;
            }

            public String getMaxShare() {
                return maxShare;
            }

            public void setMaxShare(String maxShare) {
                this.maxShare = maxShare;
            }

            public int getMultiple() {
                return multiple;
            }

            public void setMultiple(int multiple) {
                this.multiple = multiple;
            }

            public String getPics() {
                return pics;
            }

            public void setPics(String pics) {
                this.pics = pics;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getRefPrice() {
                return refPrice;
            }

            public void setRefPrice(int refPrice) {
                this.refPrice = refPrice;
            }

            public int getShopId() {
                return shopId;
            }

            public void setShopId(int shopId) {
                this.shopId = shopId;
            }

            public int getSoldCnt() {
                return soldCnt;
            }

            public void setSoldCnt(int soldCnt) {
                this.soldCnt = soldCnt;
            }

            public String getSpecification() {
                return specification;
            }

            public void setSpecification(String specification) {
                this.specification = specification;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
