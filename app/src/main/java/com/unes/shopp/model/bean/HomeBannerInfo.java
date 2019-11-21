package com.unes.shopp.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeBannerInfo {
    /**
     * code : 0
     * result : {"recItems":[],"threshold":300,"banners":{"418":[{"categoryId":-1,"description":"","picUrl":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190724/vNTT-0-1563963169770.jpg","redirectType":310,"showText":0,"target":"https://shop.unesmall.com/licheng/","title":"","type":418,"weight":1},{"categoryId":-1,"description":"","itemNum":1000,"picUrl":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190821/vNTT-0-1566358717485.jpg","redirectType":311,"showText":0,"target":"15","title":"富勒烯冻干粉","type":418,"weight":1},{"categoryId":-1,"description":"","itemNum":717,"picUrl":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190821/vNTT-0-1566358876536.jpg","redirectType":311,"showText":0,"target":"30","title":"","type":418,"weight":1}],"421":[{"categoryId":-1,"description":"","itemNum":1000,"picUrl":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190724/vNTT-0-1563963333478.png","redirectType":311,"showText":0,"soldCount":65,"target":"15","title":"精选活动","type":421,"weight":1},{"categoryId":-1,"description":"","itemNum":10000,"picUrl":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190819/vNTT-0-1566177722856.jpg","redirectType":311,"showText":0,"soldCount":99,"target":"58","title":"","type":421,"weight":1},{"categoryId":-1,"description":"","itemNum":1000,"picUrl":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190725/vNTT-0-1564023152987.jpg","redirectType":311,"showText":0,"soldCount":65,"target":"15","title":"创业大礼包","type":421,"weight":1}],"422":[{"categoryId":-1,"description":"","itemNum":1000,"onlineEndTime":1567267200000,"onlineStartTime":1562829000000,"picUrl":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190724/vNTT-0-1563964261957.jpg","redirectType":311,"showText":1,"target":"18","title":"秒杀活动","type":422,"weight":1},{"categoryId":-1,"description":"123","itemNum":4700,"onlineEndTime":1567267200000,"onlineStartTime":1565884800000,"picUrl":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190816/vNTT-0-1565927102904.jpg","redirectType":311,"showText":1,"target":"54","title":"test秒杀","type":422,"weight":1},{"categoryId":-1,"description":"123","itemNum":504,"onlineEndTime":1567267200000,"onlineStartTime":1565280000000,"picUrl":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190816/vNTT-0-1565927375468.jpg","redirectType":311,"showText":1,"target":"31","title":"测试秒杀","type":422,"weight":1}]},"cid":-1,"nowTime":1566370449639}
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
         * recItems : []
         * threshold : 300
         * banners : {"418":[{"categoryId":-1,"description":"","picUrl":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190724/vNTT-0-1563963169770.jpg","redirectType":310,"showText":0,"target":"https://shop.unesmall.com/licheng/","title":"","type":418,"weight":1},{"categoryId":-1,"description":"","itemNum":1000,"picUrl":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190821/vNTT-0-1566358717485.jpg","redirectType":311,"showText":0,"target":"15","title":"富勒烯冻干粉","type":418,"weight":1},{"categoryId":-1,"description":"","itemNum":717,"picUrl":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190821/vNTT-0-1566358876536.jpg","redirectType":311,"showText":0,"target":"30","title":"","type":418,"weight":1}],"421":[{"categoryId":-1,"description":"","itemNum":1000,"picUrl":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190724/vNTT-0-1563963333478.png","redirectType":311,"showText":0,"soldCount":65,"target":"15","title":"精选活动","type":421,"weight":1},{"categoryId":-1,"description":"","itemNum":10000,"picUrl":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190819/vNTT-0-1566177722856.jpg","redirectType":311,"showText":0,"soldCount":99,"target":"58","title":"","type":421,"weight":1},{"categoryId":-1,"description":"","itemNum":1000,"picUrl":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190725/vNTT-0-1564023152987.jpg","redirectType":311,"showText":0,"soldCount":65,"target":"15","title":"创业大礼包","type":421,"weight":1}],"422":[{"categoryId":-1,"description":"","itemNum":1000,"onlineEndTime":1567267200000,"onlineStartTime":1562829000000,"picUrl":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190724/vNTT-0-1563964261957.jpg","redirectType":311,"showText":1,"target":"18","title":"秒杀活动","type":422,"weight":1},{"categoryId":-1,"description":"123","itemNum":4700,"onlineEndTime":1567267200000,"onlineStartTime":1565884800000,"picUrl":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190816/vNTT-0-1565927102904.jpg","redirectType":311,"showText":1,"target":"54","title":"test秒杀","type":422,"weight":1},{"categoryId":-1,"description":"123","itemNum":504,"onlineEndTime":1567267200000,"onlineStartTime":1565280000000,"picUrl":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190816/vNTT-0-1565927375468.jpg","redirectType":311,"showText":1,"target":"31","title":"测试秒杀","type":422,"weight":1}]}
         * cid : -1
         * nowTime : 1566370449639
         */

        private int threshold;
        private BannersBean banners;
        private int cid;
        private long nowTime;
        private List<?> recItems;

        public int getThreshold() {
            return threshold;
        }

        public void setThreshold(int threshold) {
            this.threshold = threshold;
        }

        public BannersBean getBanners() {
            return banners;
        }

        public void setBanners(BannersBean banners) {
            this.banners = banners;
        }

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public long getNowTime() {
            return nowTime;
        }

        public void setNowTime(long nowTime) {
            this.nowTime = nowTime;
        }

        public List<?> getRecItems() {
            return recItems;
        }

        public void setRecItems(List<?> recItems) {
            this.recItems = recItems;
        }

        public static class BannersBean {
            @SerializedName("418")
            private List<_$418Bean> _$418;
            @SerializedName("421")
            private List<_$421Bean> _$421;
            @SerializedName("422")
            private List<_$422Bean> _$422;

            public List<_$418Bean> get_$418() {
                return _$418;
            }

            public void set_$418(List<_$418Bean> _$418) {
                this._$418 = _$418;
            }

            public List<_$421Bean> get_$421() {
                return _$421;
            }

            public void set_$421(List<_$421Bean> _$421) {
                this._$421 = _$421;
            }

            public List<_$422Bean> get_$422() {
                return _$422;
            }

            public void set_$422(List<_$422Bean> _$422) {
                this._$422 = _$422;
            }

            public static class _$418Bean {
                /**
                 * categoryId : -1
                 * description :
                 * picUrl : http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190724/vNTT-0-1563963169770.jpg
                 * redirectType : 310
                 * showText : 0
                 * target : https://shop.unesmall.com/licheng/
                 * title :
                 * type : 418
                 * weight : 1
                 * itemNum : 1000
                 */

                private int categoryId;
                private String description;
                private String picUrl;
                private int redirectType;
                private int showText;
                private String target;
                private String title;
                private int type;
                private int weight;
                private int itemNum;

                public int getCategoryId() {
                    return categoryId;
                }

                public void setCategoryId(int categoryId) {
                    this.categoryId = categoryId;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public int getRedirectType() {
                    return redirectType;
                }

                public void setRedirectType(int redirectType) {
                    this.redirectType = redirectType;
                }

                public int getShowText() {
                    return showText;
                }

                public void setShowText(int showText) {
                    this.showText = showText;
                }

                public String getTarget() {
                    return target;
                }

                public void setTarget(String target) {
                    this.target = target;
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

                public int getWeight() {
                    return weight;
                }

                public void setWeight(int weight) {
                    this.weight = weight;
                }

                public int getItemNum() {
                    return itemNum;
                }

                public void setItemNum(int itemNum) {
                    this.itemNum = itemNum;
                }
            }

            public static class _$421Bean {
                /**
                 * categoryId : -1
                 * description :
                 * itemNum : 1000
                 * picUrl : http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190724/vNTT-0-1563963333478.png
                 * redirectType : 311
                 * showText : 0
                 * soldCount : 65
                 * target : 15
                 * title : 精选活动
                 * type : 421
                 * weight : 1
                 */

                private int categoryId;
                private String description;
                private int itemNum;
                private String picUrl;
                private int redirectType;
                private int showText;
                private int soldCount;
                private String target;
                private String title;
                private int type;
                private int weight;

                public int getCategoryId() {
                    return categoryId;
                }

                public void setCategoryId(int categoryId) {
                    this.categoryId = categoryId;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public int getItemNum() {
                    return itemNum;
                }

                public void setItemNum(int itemNum) {
                    this.itemNum = itemNum;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public int getRedirectType() {
                    return redirectType;
                }

                public void setRedirectType(int redirectType) {
                    this.redirectType = redirectType;
                }

                public int getShowText() {
                    return showText;
                }

                public void setShowText(int showText) {
                    this.showText = showText;
                }

                public int getSoldCount() {
                    return soldCount;
                }

                public void setSoldCount(int soldCount) {
                    this.soldCount = soldCount;
                }

                public String getTarget() {
                    return target;
                }

                public void setTarget(String target) {
                    this.target = target;
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

                public int getWeight() {
                    return weight;
                }

                public void setWeight(int weight) {
                    this.weight = weight;
                }
            }

            public static class _$422Bean {
                /**
                 * categoryId : -1
                 * description :
                 * itemNum : 1000
                 * onlineEndTime : 1567267200000
                 * onlineStartTime : 1562829000000
                 * picUrl : http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190724/vNTT-0-1563964261957.jpg
                 * redirectType : 311
                 * showText : 1
                 * target : 18
                 * title : 秒杀活动
                 * type : 422
                 * weight : 1
                 */

                private int categoryId;
                private String description;
                private int itemNum;
                private long onlineEndTime;
                private long onlineStartTime;
                private String picUrl;
                private int redirectType;
                private int showText;
                private String target;
                private String title;
                private int type;
                private int weight;

                public int getCategoryId() {
                    return categoryId;
                }

                public void setCategoryId(int categoryId) {
                    this.categoryId = categoryId;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public int getItemNum() {
                    return itemNum;
                }

                public void setItemNum(int itemNum) {
                    this.itemNum = itemNum;
                }

                public long getOnlineEndTime() {
                    return onlineEndTime;
                }

                public void setOnlineEndTime(long onlineEndTime) {
                    this.onlineEndTime = onlineEndTime;
                }

                public long getOnlineStartTime() {
                    return onlineStartTime;
                }

                public void setOnlineStartTime(long onlineStartTime) {
                    this.onlineStartTime = onlineStartTime;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public int getRedirectType() {
                    return redirectType;
                }

                public void setRedirectType(int redirectType) {
                    this.redirectType = redirectType;
                }

                public int getShowText() {
                    return showText;
                }

                public void setShowText(int showText) {
                    this.showText = showText;
                }

                public String getTarget() {
                    return target;
                }

                public void setTarget(String target) {
                    this.target = target;
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

                public int getWeight() {
                    return weight;
                }

                public void setWeight(int weight) {
                    this.weight = weight;
                }
            }
        }
    }
}
