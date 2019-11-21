package com.unes.shopp.model.bean;

public class MineInfo {
    /**
     * code : 0
     * result : {"isAgency":1,"isExamine":false,"img":"https://upyun.52jcm.cn/dengji/WechatIMG310.png","ceo2Name":"山有木兮木有枝","pInvitationCode":"72341244","ceo2Address":{"community":"山有木兮木有枝","communityId":-1,"communityName":"山有木兮木有枝","dateCreated":1558693511000,"getDef":2,"id":31,"lastUpdated":1569483167000,"receiverAddress":"尖彭路黄边m3创意园306","receiverCity":"广州市","receiverDistrict":"","receiverMobile":"13580562037","receiverName":"山有木兮木有枝","receiver_state":"广东省","status":1,"type":1,"userId":28,"version":17},"agencyLevelId":1,"invitationCode":"22382232","isExpert":0,"ceo2ShopName":"秋之风","isBindingWx":false,"nickName":"44代理","mobile":"13580562044","pId":34,"pNickName":"20431080","agencyLevelName":"店主","ceo2VR":"","profileId":38,"ceo2Mobile":"13580562037","isShare":1}
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
         * isAgency : 1
         * isExamine : false
         * img : https://upyun.52jcm.cn/dengji/WechatIMG310.png
         * ceo2Name : 山有木兮木有枝
         * pInvitationCode : 72341244
         * ceo2Address : {"community":"山有木兮木有枝","communityId":-1,"communityName":"山有木兮木有枝","dateCreated":1558693511000,"getDef":2,"id":31,"lastUpdated":1569483167000,"receiverAddress":"尖彭路黄边m3创意园306","receiverCity":"广州市","receiverDistrict":"","receiverMobile":"13580562037","receiverName":"山有木兮木有枝","receiver_state":"广东省","status":1,"type":1,"userId":28,"version":17}
         * agencyLevelId : 1
         * invitationCode : 22382232
         * isExpert : 0
         * ceo2ShopName : 秋之风
         * isBindingWx : false
         * nickName : 44代理
         * mobile : 13580562044
         * pId : 34
         * pNickName : 20431080
         * agencyLevelName : 店主
         * ceo2VR :
         * profileId : 38
         * ceo2Mobile : 13580562037
         * isShare : 1
         */

        private int isAgency;
        private boolean isExamine;
        private String img;
        private String ceo2Name;
        private String pInvitationCode;
        private Ceo2AddressBean ceo2Address;
        private int agencyLevelId;
        private String invitationCode;
        private int isExpert;
        private String ceo2ShopName;
        private boolean isBindingWx;
        private String nickName;
        private String mobile;
        private int pId;
        private String pNickName;
        private String agencyLevelName;
        private String ceo2VR;
        private int profileId;
        private String ceo2Mobile;
        private int isShare;

        public int getIsAgency() {
            return isAgency;
        }

        public void setIsAgency(int isAgency) {
            this.isAgency = isAgency;
        }

        public boolean isIsExamine() {
            return isExamine;
        }

        public void setIsExamine(boolean isExamine) {
            this.isExamine = isExamine;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getCeo2Name() {
            return ceo2Name;
        }

        public void setCeo2Name(String ceo2Name) {
            this.ceo2Name = ceo2Name;
        }

        public String getPInvitationCode() {
            return pInvitationCode;
        }

        public void setPInvitationCode(String pInvitationCode) {
            this.pInvitationCode = pInvitationCode;
        }

        public Ceo2AddressBean getCeo2Address() {
            return ceo2Address;
        }

        public void setCeo2Address(Ceo2AddressBean ceo2Address) {
            this.ceo2Address = ceo2Address;
        }

        public int getAgencyLevelId() {
            return agencyLevelId;
        }

        public void setAgencyLevelId(int agencyLevelId) {
            this.agencyLevelId = agencyLevelId;
        }

        public String getInvitationCode() {
            return invitationCode;
        }

        public void setInvitationCode(String invitationCode) {
            this.invitationCode = invitationCode;
        }

        public int getIsExpert() {
            return isExpert;
        }

        public void setIsExpert(int isExpert) {
            this.isExpert = isExpert;
        }

        public String getCeo2ShopName() {
            return ceo2ShopName;
        }

        public void setCeo2ShopName(String ceo2ShopName) {
            this.ceo2ShopName = ceo2ShopName;
        }

        public boolean isIsBindingWx() {
            return isBindingWx;
        }

        public void setIsBindingWx(boolean isBindingWx) {
            this.isBindingWx = isBindingWx;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getPId() {
            return pId;
        }

        public void setPId(int pId) {
            this.pId = pId;
        }

        public String getPNickName() {
            return pNickName;
        }

        public void setPNickName(String pNickName) {
            this.pNickName = pNickName;
        }

        public String getAgencyLevelName() {
            return agencyLevelName;
        }

        public void setAgencyLevelName(String agencyLevelName) {
            this.agencyLevelName = agencyLevelName;
        }

        public String getCeo2VR() {
            return ceo2VR;
        }

        public void setCeo2VR(String ceo2VR) {
            this.ceo2VR = ceo2VR;
        }

        public int getProfileId() {
            return profileId;
        }

        public void setProfileId(int profileId) {
            this.profileId = profileId;
        }

        public String getCeo2Mobile() {
            return ceo2Mobile;
        }

        public void setCeo2Mobile(String ceo2Mobile) {
            this.ceo2Mobile = ceo2Mobile;
        }

        public int getIsShare() {
            return isShare;
        }

        public void setIsShare(int isShare) {
            this.isShare = isShare;
        }

        public static class Ceo2AddressBean {
            /**
             * community : 山有木兮木有枝
             * communityId : -1
             * communityName : 山有木兮木有枝
             * dateCreated : 1558693511000
             * getDef : 2
             * id : 31
             * lastUpdated : 1569483167000
             * receiverAddress : 尖彭路黄边m3创意园306
             * receiverCity : 广州市
             * receiverDistrict :
             * receiverMobile : 13580562037
             * receiverName : 山有木兮木有枝
             * receiver_state : 广东省
             * status : 1
             * type : 1
             * userId : 28
             * version : 17
             */

            private String community;
            private int communityId;
            private String communityName;
            private long dateCreated;
            private int getDef;
            private int id;
            private long lastUpdated;
            private String receiverAddress;
            private String receiverCity;
            private String receiverDistrict;
            private String receiverMobile;
            private String receiverName;
            private String receiver_state;
            private int status;
            private int type;
            private int userId;
            private int version;

            public String getCommunity() {
                return community;
            }

            public void setCommunity(String community) {
                this.community = community;
            }

            public int getCommunityId() {
                return communityId;
            }

            public void setCommunityId(int communityId) {
                this.communityId = communityId;
            }

            public String getCommunityName() {
                return communityName;
            }

            public void setCommunityName(String communityName) {
                this.communityName = communityName;
            }

            public long getDateCreated() {
                return dateCreated;
            }

            public void setDateCreated(long dateCreated) {
                this.dateCreated = dateCreated;
            }

            public int getGetDef() {
                return getDef;
            }

            public void setGetDef(int getDef) {
                this.getDef = getDef;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getLastUpdated() {
                return lastUpdated;
            }

            public void setLastUpdated(long lastUpdated) {
                this.lastUpdated = lastUpdated;
            }

            public String getReceiverAddress() {
                return receiverAddress;
            }

            public void setReceiverAddress(String receiverAddress) {
                this.receiverAddress = receiverAddress;
            }

            public String getReceiverCity() {
                return receiverCity;
            }

            public void setReceiverCity(String receiverCity) {
                this.receiverCity = receiverCity;
            }

            public String getReceiverDistrict() {
                return receiverDistrict;
            }

            public void setReceiverDistrict(String receiverDistrict) {
                this.receiverDistrict = receiverDistrict;
            }

            public String getReceiverMobile() {
                return receiverMobile;
            }

            public void setReceiverMobile(String receiverMobile) {
                this.receiverMobile = receiverMobile;
            }

            public String getReceiverName() {
                return receiverName;
            }

            public void setReceiverName(String receiverName) {
                this.receiverName = receiverName;
            }

            public String getReceiver_state() {
                return receiver_state;
            }

            public void setReceiver_state(String receiver_state) {
                this.receiver_state = receiver_state;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVersion() {
                return version;
            }

            public void setVersion(int version) {
                this.version = version;
            }
        }
    }
}
