package com.unes.shopp.model.bean;

import java.util.List;

public class HomeFetchCatesInfo {
    /**
     * code : 0
     * result : {"cates":[{"banners":[{"act":1,"redirectUrl":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg","type":1,"ur":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg"}],"categoryId":20000001,"isParent":1,"level":1,"name":"私人定制","parentId":0,"pic":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190725/vNTT-0-1564035617571.jpg"},{"banners":[{"act":1,"redirectUrl":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg","type":1,"ur":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg"}],"categoryId":20000002,"isParent":1,"level":2,"name":"热销套盒","parentId":20000001,"pic":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190725/vNTT-0-1564035744483.jpg"},{"banners":[{"act":1,"redirectUrl":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg","type":1,"ur":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg"}],"categoryId":20000003,"isParent":1,"level":2,"name":"护肤单品","parentId":20000001,"pic":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190627/vNTT-0-1561629696774.jpg"},{"banners":[{"act":1,"redirectUrl":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg","type":1,"ur":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg"}],"categoryId":20000007,"isParent":1,"level":2,"name":"明星原液","parentId":20000001,"pic":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190725/vNTT-0-1564035683721.jpg"},{"banners":[{"act":1,"redirectUrl":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg","type":1,"ur":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg"}],"categoryId":20000008,"isParent":1,"level":2,"name":"精准调配","parentId":20000001,"pic":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190725/vNTT-0-1564035717227.jpg"}],"suggest":"草莓"}
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
         * cates : [{"banners":[{"act":1,"redirectUrl":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg","type":1,"ur":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg"}],"categoryId":20000001,"isParent":1,"level":1,"name":"私人定制","parentId":0,"pic":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190725/vNTT-0-1564035617571.jpg"},{"banners":[{"act":1,"redirectUrl":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg","type":1,"ur":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg"}],"categoryId":20000002,"isParent":1,"level":2,"name":"热销套盒","parentId":20000001,"pic":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190725/vNTT-0-1564035744483.jpg"},{"banners":[{"act":1,"redirectUrl":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg","type":1,"ur":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg"}],"categoryId":20000003,"isParent":1,"level":2,"name":"护肤单品","parentId":20000001,"pic":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190627/vNTT-0-1561629696774.jpg"},{"banners":[{"act":1,"redirectUrl":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg","type":1,"ur":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg"}],"categoryId":20000007,"isParent":1,"level":2,"name":"明星原液","parentId":20000001,"pic":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190725/vNTT-0-1564035683721.jpg"},{"banners":[{"act":1,"redirectUrl":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg","type":1,"ur":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg"}],"categoryId":20000008,"isParent":1,"level":2,"name":"精准调配","parentId":20000001,"pic":"http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190725/vNTT-0-1564035717227.jpg"}]
         * suggest : 草莓
         */

        private String suggest;
        private List<CatesBean> cates;

        public String getSuggest() {
            return suggest;
        }

        public void setSuggest(String suggest) {
            this.suggest = suggest;
        }

        public List<CatesBean> getCates() {
            return cates;
        }

        public void setCates(List<CatesBean> cates) {
            this.cates = cates;
        }

        public static class CatesBean {
            /**
             * banners : [{"act":1,"redirectUrl":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg","type":1,"ur":"http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg"}]
             * categoryId : 20000001
             * isParent : 1
             * level : 1
             * name : 私人定制
             * parentId : 0
             * pic : http://upyun.unesmall.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20190725/vNTT-0-1564035617571.jpg
             */

            private int categoryId;
            private int isParent;
            private int level;
            private String name;
            private int parentId;
            private String pic;
            private List<BannersBean> banners;

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public int getIsParent() {
                return isParent;
            }

            public void setIsParent(int isParent) {
                this.isParent = isParent;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public List<BannersBean> getBanners() {
                return banners;
            }

            public void setBanners(List<BannersBean> banners) {
                this.banners = banners;
            }

            public static class BannersBean {
                /**
                 * act : 1
                 * redirectUrl : http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg
                 * type : 1
                 * ur : http://welinklife.b0.upaiyun.com/1/LTE=/SVRFTS1QVUJMSVNI/MA==/20141125/vNTT-0-1416917291815.jpg
                 */

                private int act;
                private String redirectUrl;
                private int type;
                private String ur;

                public int getAct() {
                    return act;
                }

                public void setAct(int act) {
                    this.act = act;
                }

                public String getRedirectUrl() {
                    return redirectUrl;
                }

                public void setRedirectUrl(String redirectUrl) {
                    this.redirectUrl = redirectUrl;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getUr() {
                    return ur;
                }

                public void setUr(String ur) {
                    this.ur = ur;
                }
            }
        }
    }
}
