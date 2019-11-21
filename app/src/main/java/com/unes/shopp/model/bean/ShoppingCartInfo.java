package com.unes.shopp.model.bean;

import java.io.Serializable;
import java.util.List;

public class ShoppingCartInfo {
    /**
     * status : 1
     * result : {"uid":38,"items":[{"pics":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190830/vNTT-0-1567147914197.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190830/vNTT-0-1567147914271.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190830/vNTT-0-1567147914442.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190830/vNTT-0-1567147914878.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190830/vNTT-0-1567147915104.jpg","price":49900,"title":"白帽子舒缓特护冻干粉理肤定制套盒","itemId":19,"cateId":-1,"endTime":2200962092430,"soldCnt":0,"refPrice":199900,"itemNum":1000,"desc":"化妆品","specification":"舒缓特护冻干粉+舒缓修护溶媒液（50mg+3ml)*10                 舒缓安肤修护原液5ml*4","detail":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190812/vNTT-0-1565605458039.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492306355.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492306452.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492306723.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492306785.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492306871.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492306956.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492307075.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492307145.jpg","features":"{\"特别说明\":\"\",\"功效\":\"\",\"适用人群\":\"\",\"保质期\":\"\"}","cartCount":3,"shopId":999,"approveStatus":1,"brandName":"白帽子","type":1,"isTaxFree":0,"isrefund":1,"hasBrokerageFee":0,"baseSoldQuantity":350,"multiple":1,"activtyStatus":-1,"isNeedPostFee":0,"extensionPic":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190812/vNTT-0-1565605473426.jpg"},{"pics":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190929/vNTT-0-1569748628321.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191009/vNTT-0-1570616520676.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191009/vNTT-0-1570616520741.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191009/vNTT-0-1570616520774.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191009/vNTT-0-1570616521100.jpg","pointPrice":0,"price":21800,"title":"优理氏光果甘草水润原液","itemId":88,"cateId":20000236,"endTime":2202952630784,"soldCnt":0,"refPrice":31800,"itemNum":500,"desc":"化妆品","specification":"30ML","detail":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191009/vNTT-0-1570616537664.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191009/vNTT-0-1570616537703.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191009/vNTT-0-1570616537729.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191009/vNTT-0-1570616538565.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191009/vNTT-0-1570616538535.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191009/vNTT-0-1570616538243.jpg","features":"{\"特别说明\":\"\",\"功效\":\"\",\"适用人群\":\"\",\"保质期\":\"\"}","cartCount":1,"shopId":999,"approveStatus":1,"brandName":"白帽子","type":1,"isTaxFree":1,"isrefund":0,"hasBrokerageFee":0,"baseSoldQuantity":100,"multiple":1,"activtyStatus":-1,"isNeedPostFee":0,"extensionPic":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190929/vNTT-0-1569748796283.jpg"}]}
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
        /**
         * uid : 38
         * items : [{"pics":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190830/vNTT-0-1567147914197.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190830/vNTT-0-1567147914271.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190830/vNTT-0-1567147914442.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190830/vNTT-0-1567147914878.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190830/vNTT-0-1567147915104.jpg","price":49900,"title":"白帽子舒缓特护冻干粉理肤定制套盒","itemId":19,"cateId":-1,"endTime":2200962092430,"soldCnt":0,"refPrice":199900,"itemNum":1000,"desc":"化妆品","specification":"舒缓特护冻干粉+舒缓修护溶媒液（50mg+3ml)*10                 舒缓安肤修护原液5ml*4","detail":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190812/vNTT-0-1565605458039.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492306355.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492306452.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492306723.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492306785.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492306871.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492306956.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492307075.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492307145.jpg","features":"{\"特别说明\":\"\",\"功效\":\"\",\"适用人群\":\"\",\"保质期\":\"\"}","cartCount":3,"shopId":999,"approveStatus":1,"brandName":"白帽子","type":1,"isTaxFree":0,"isrefund":1,"hasBrokerageFee":0,"baseSoldQuantity":350,"multiple":1,"activtyStatus":-1,"isNeedPostFee":0,"extensionPic":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190812/vNTT-0-1565605473426.jpg"},{"pics":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190929/vNTT-0-1569748628321.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191009/vNTT-0-1570616520676.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191009/vNTT-0-1570616520741.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191009/vNTT-0-1570616520774.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191009/vNTT-0-1570616521100.jpg","pointPrice":0,"price":21800,"title":"优理氏光果甘草水润原液","itemId":88,"cateId":20000236,"endTime":2202952630784,"soldCnt":0,"refPrice":31800,"itemNum":500,"desc":"化妆品","specification":"30ML","detail":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191009/vNTT-0-1570616537664.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191009/vNTT-0-1570616537703.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191009/vNTT-0-1570616537729.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191009/vNTT-0-1570616538565.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191009/vNTT-0-1570616538535.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20191009/vNTT-0-1570616538243.jpg","features":"{\"特别说明\":\"\",\"功效\":\"\",\"适用人群\":\"\",\"保质期\":\"\"}","cartCount":1,"shopId":999,"approveStatus":1,"brandName":"白帽子","type":1,"isTaxFree":1,"isrefund":0,"hasBrokerageFee":0,"baseSoldQuantity":100,"multiple":1,"activtyStatus":-1,"isNeedPostFee":0,"extensionPic":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190929/vNTT-0-1569748796283.jpg"}]
         */

        private int uid;
        private List<ItemsBean> items;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean implements Serializable {
            /**
             * pics : http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190830/vNTT-0-1567147914197.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190830/vNTT-0-1567147914271.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190830/vNTT-0-1567147914442.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190830/vNTT-0-1567147914878.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190830/vNTT-0-1567147915104.jpg
             * price : 49900
             * title : 白帽子舒缓特护冻干粉理肤定制套盒
             * itemId : 19
             * cateId : -1
             * endTime : 2200962092430
             * soldCnt : 0
             * refPrice : 199900
             * itemNum : 1000
             * desc : 化妆品
             * specification : 舒缓特护冻干粉+舒缓修护溶媒液（50mg+3ml)*10                 舒缓安肤修护原液5ml*4
             * detail : http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190812/vNTT-0-1565605458039.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492306355.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492306452.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492306723.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492306785.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492306871.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492306956.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492307075.jpg;http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190614/vNTT-0-1560492307145.jpg
             * features : {"特别说明":"","功效":"","适用人群":"","保质期":""}
             * cartCount : 3
             * shopId : 999
             * approveStatus : 1
             * brandName : 白帽子
             * type : 1
             * isTaxFree : 0
             * isrefund : 1
             * hasBrokerageFee : 0
             * baseSoldQuantity : 350
             * multiple : 1
             * activtyStatus : -1
             * isNeedPostFee : 0
             * extensionPic : http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190812/vNTT-0-1565605473426.jpg
             * pointPrice : 0
             */

            private String pics;
            private int price;
            private String title;
            private int itemId;
            private int cateId;
            private long endTime;
            private int soldCnt;
            private int refPrice;
            private int itemNum;
            private String desc;
            private String specification;
            private String detail;
            private String features;
            private int cartCount;
            private int shopId;
            private int approveStatus;
            private String brandName;
            private int type;
            private int isTaxFree;
            private int isrefund;
            private int hasBrokerageFee;
            private int baseSoldQuantity;
            private int multiple;
            private int activtyStatus;
            private int isNeedPostFee;
            private String extensionPic;
            private int pointPrice;

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

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getItemId() {
                return itemId;
            }

            public void setItemId(int itemId) {
                this.itemId = itemId;
            }

            public int getCateId() {
                return cateId;
            }

            public void setCateId(int cateId) {
                this.cateId = cateId;
            }

            public long getEndTime() {
                return endTime;
            }

            public void setEndTime(long endTime) {
                this.endTime = endTime;
            }

            public int getSoldCnt() {
                return soldCnt;
            }

            public void setSoldCnt(int soldCnt) {
                this.soldCnt = soldCnt;
            }

            public int getRefPrice() {
                return refPrice;
            }

            public void setRefPrice(int refPrice) {
                this.refPrice = refPrice;
            }

            public int getItemNum() {
                return itemNum;
            }

            public void setItemNum(int itemNum) {
                this.itemNum = itemNum;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getSpecification() {
                return specification;
            }

            public void setSpecification(String specification) {
                this.specification = specification;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public String getFeatures() {
                return features;
            }

            public void setFeatures(String features) {
                this.features = features;
            }

            public int getCartCount() {
                return cartCount;
            }

            public void setCartCount(int cartCount) {
                this.cartCount = cartCount;
            }

            public int getShopId() {
                return shopId;
            }

            public void setShopId(int shopId) {
                this.shopId = shopId;
            }

            public int getApproveStatus() {
                return approveStatus;
            }

            public void setApproveStatus(int approveStatus) {
                this.approveStatus = approveStatus;
            }

            public String getBrandName() {
                return brandName;
            }

            public void setBrandName(String brandName) {
                this.brandName = brandName;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
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

            public int getHasBrokerageFee() {
                return hasBrokerageFee;
            }

            public void setHasBrokerageFee(int hasBrokerageFee) {
                this.hasBrokerageFee = hasBrokerageFee;
            }

            public int getBaseSoldQuantity() {
                return baseSoldQuantity;
            }

            public void setBaseSoldQuantity(int baseSoldQuantity) {
                this.baseSoldQuantity = baseSoldQuantity;
            }

            public int getMultiple() {
                return multiple;
            }

            public void setMultiple(int multiple) {
                this.multiple = multiple;
            }

            public int getActivtyStatus() {
                return activtyStatus;
            }

            public void setActivtyStatus(int activtyStatus) {
                this.activtyStatus = activtyStatus;
            }

            public int getIsNeedPostFee() {
                return isNeedPostFee;
            }

            public void setIsNeedPostFee(int isNeedPostFee) {
                this.isNeedPostFee = isNeedPostFee;
            }

            public String getExtensionPic() {
                return extensionPic;
            }

            public void setExtensionPic(String extensionPic) {
                this.extensionPic = extensionPic;
            }

            public int getPointPrice() {
                return pointPrice;
            }

            public void setPointPrice(int pointPrice) {
                this.pointPrice = pointPrice;
            }
        }
    }
}
