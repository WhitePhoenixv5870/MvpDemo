package com.jlkf.donglianrider.mvpprojectdemo.bean;

/**
 * Created by win7 on 2019/6/6.
 */

public class LoginBean {


    /**
     * userInfo : {"havaPassword":1,"mac_address":"","expire":1471228912,"user":{"id":3,"nickName":"13138895762","phone":"13138895762","password":"8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92","realName":null,"headImg":null,"sex":null,"idNumber":null,"birthday":null,"address":null,"site":null,"useTime":null,"cardPhotoPositive":null,"cardPhotoNegative":null,"oppenId":null,"status":1,"type":1,"registerType":1,"realStatus":1,"smokeType":0,"followIds":null,"deviceNum":"868583022564435","pushTime":null,"lastLoginTime":1559809957004,"useTimeLen":0,"integral":0,"experience":0,"level":1,"isRead":0,"commentRead":0,"giveRead":0,"createTime":1559804495000},"token":"472e74bc99824765bac2089ce1dbab03"}
     * storeInfo : {"access_token":"ab2f59b7860e3d7880229030df1a725a","cookie_key":"open_cookie_5643a519b689882e67","cookie_value":"YZ586230978565922817YZiKCd8ons"}
     */

    private UserInfoBean userInfo;
    private StoreInfoBean storeInfo;

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public StoreInfoBean getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(StoreInfoBean storeInfo) {
        this.storeInfo = storeInfo;
    }

    public static class UserInfoBean {
        /**
         * havaPassword : 1
         * mac_address :
         * expire : 1471228912
         * user : {"id":3,"nickName":"13138895762","phone":"13138895762","password":"8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92","realName":null,"headImg":null,"sex":null,"idNumber":null,"birthday":null,"address":null,"site":null,"useTime":null,"cardPhotoPositive":null,"cardPhotoNegative":null,"oppenId":null,"status":1,"type":1,"registerType":1,"realStatus":1,"smokeType":0,"followIds":null,"deviceNum":"868583022564435","pushTime":null,"lastLoginTime":1559809957004,"useTimeLen":0,"integral":0,"experience":0,"level":1,"isRead":0,"commentRead":0,"giveRead":0,"createTime":1559804495000}
         * token : 472e74bc99824765bac2089ce1dbab03
         */

        private int havaPassword;
        private String mac_address;
        private int expire;
        private UserBean user;
        private String token;

        public int getHavaPassword() {
            return havaPassword;
        }

        public void setHavaPassword(int havaPassword) {
            this.havaPassword = havaPassword;
        }

        public String getMac_address() {
            return mac_address;
        }

        public void setMac_address(String mac_address) {
            this.mac_address = mac_address;
        }

        public int getExpire() {
            return expire;
        }

        public void setExpire(int expire) {
            this.expire = expire;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public static class UserBean {
            /**
             * id : 3
             * nickName : 13138895762
             * phone : 13138895762
             * password : 8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92
             * realName : null
             * headImg : null
             * sex : null
             * idNumber : null
             * birthday : null
             * address : null
             * site : null
             * useTime : null
             * cardPhotoPositive : null
             * cardPhotoNegative : null
             * oppenId : null
             * status : 1
             * type : 1
             * registerType : 1
             * realStatus : 1
             * smokeType : 0
             * followIds : null
             * deviceNum : 868583022564435
             * pushTime : null
             * lastLoginTime : 1559809957004
             * useTimeLen : 0
             * integral : 0
             * experience : 0
             * level : 1
             * isRead : 0
             * commentRead : 0
             * giveRead : 0
             * createTime : 1559804495000
             */

            private int id;
            private String nickName;
            private String phone;
            private String password;
            private Object realName;
            private Object headImg;
            private Object sex;
            private Object idNumber;
            private Object birthday;
            private Object address;
            private Object site;
            private Object useTime;
            private Object cardPhotoPositive;
            private Object cardPhotoNegative;
            private Object oppenId;
            private int status;
            private int type;
            private int registerType;
            private int realStatus;
            private int smokeType;
            private Object followIds;
            private String deviceNum;
            private Object pushTime;
            private long lastLoginTime;
            private int useTimeLen;
            private int integral;
            private int experience;
            private int level;
            private int isRead;
            private int commentRead;
            private int giveRead;
            private long createTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public Object getRealName() {
                return realName;
            }

            public void setRealName(Object realName) {
                this.realName = realName;
            }

            public Object getHeadImg() {
                return headImg;
            }

            public void setHeadImg(Object headImg) {
                this.headImg = headImg;
            }

            public Object getSex() {
                return sex;
            }

            public void setSex(Object sex) {
                this.sex = sex;
            }

            public Object getIdNumber() {
                return idNumber;
            }

            public void setIdNumber(Object idNumber) {
                this.idNumber = idNumber;
            }

            public Object getBirthday() {
                return birthday;
            }

            public void setBirthday(Object birthday) {
                this.birthday = birthday;
            }

            public Object getAddress() {
                return address;
            }

            public void setAddress(Object address) {
                this.address = address;
            }

            public Object getSite() {
                return site;
            }

            public void setSite(Object site) {
                this.site = site;
            }

            public Object getUseTime() {
                return useTime;
            }

            public void setUseTime(Object useTime) {
                this.useTime = useTime;
            }

            public Object getCardPhotoPositive() {
                return cardPhotoPositive;
            }

            public void setCardPhotoPositive(Object cardPhotoPositive) {
                this.cardPhotoPositive = cardPhotoPositive;
            }

            public Object getCardPhotoNegative() {
                return cardPhotoNegative;
            }

            public void setCardPhotoNegative(Object cardPhotoNegative) {
                this.cardPhotoNegative = cardPhotoNegative;
            }

            public Object getOppenId() {
                return oppenId;
            }

            public void setOppenId(Object oppenId) {
                this.oppenId = oppenId;
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

            public int getRegisterType() {
                return registerType;
            }

            public void setRegisterType(int registerType) {
                this.registerType = registerType;
            }

            public int getRealStatus() {
                return realStatus;
            }

            public void setRealStatus(int realStatus) {
                this.realStatus = realStatus;
            }

            public int getSmokeType() {
                return smokeType;
            }

            public void setSmokeType(int smokeType) {
                this.smokeType = smokeType;
            }

            public Object getFollowIds() {
                return followIds;
            }

            public void setFollowIds(Object followIds) {
                this.followIds = followIds;
            }

            public String getDeviceNum() {
                return deviceNum;
            }

            public void setDeviceNum(String deviceNum) {
                this.deviceNum = deviceNum;
            }

            public Object getPushTime() {
                return pushTime;
            }

            public void setPushTime(Object pushTime) {
                this.pushTime = pushTime;
            }

            public long getLastLoginTime() {
                return lastLoginTime;
            }

            public void setLastLoginTime(long lastLoginTime) {
                this.lastLoginTime = lastLoginTime;
            }

            public int getUseTimeLen() {
                return useTimeLen;
            }

            public void setUseTimeLen(int useTimeLen) {
                this.useTimeLen = useTimeLen;
            }

            public int getIntegral() {
                return integral;
            }

            public void setIntegral(int integral) {
                this.integral = integral;
            }

            public int getExperience() {
                return experience;
            }

            public void setExperience(int experience) {
                this.experience = experience;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public int getIsRead() {
                return isRead;
            }

            public void setIsRead(int isRead) {
                this.isRead = isRead;
            }

            public int getCommentRead() {
                return commentRead;
            }

            public void setCommentRead(int commentRead) {
                this.commentRead = commentRead;
            }

            public int getGiveRead() {
                return giveRead;
            }

            public void setGiveRead(int giveRead) {
                this.giveRead = giveRead;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }
        }
    }

    public static class StoreInfoBean {
        /**
         * access_token : ab2f59b7860e3d7880229030df1a725a
         * cookie_key : open_cookie_5643a519b689882e67
         * cookie_value : YZ586230978565922817YZiKCd8ons
         */

        private String access_token;
        private String cookie_key;
        private String cookie_value;

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public String getCookie_key() {
            return cookie_key;
        }

        public void setCookie_key(String cookie_key) {
            this.cookie_key = cookie_key;
        }

        public String getCookie_value() {
            return cookie_value;
        }

        public void setCookie_value(String cookie_value) {
            this.cookie_value = cookie_value;
        }
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "userInfo=" + userInfo +
                ", storeInfo=" + storeInfo +
                '}';
    }
}
