package com.jingna.artworkmall.bean;

/**
 * Created by Administrator on 2019/12/24.
 */

public class MemUsergetOneBean {

    /**
     * status : 200
     * data : {"goodsNum":0,"browseRecord":0,"memberUserInfo":{"id":47,"memBirthday":"2019-02-22 09:05:49","memName":"15244615473","headPhoto":"123","username":"15244615473","password":"111111","phoneNum":"15244615473","gender":"0"}}
     */

    private String status;
    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * goodsNum : 0
         * browseRecord : 0
         * memberUserInfo : {"id":47,"memBirthday":"2019-02-22 09:05:49","memName":"15244615473","headPhoto":"123","username":"15244615473","password":"111111","phoneNum":"15244615473","gender":"0"}
         */

        private int goodsNum;
        private int browseRecord;
        private MemberUserInfoBean memberUserInfo;

        public int getGoodsNum() {
            return goodsNum;
        }

        public void setGoodsNum(int goodsNum) {
            this.goodsNum = goodsNum;
        }

        public int getBrowseRecord() {
            return browseRecord;
        }

        public void setBrowseRecord(int browseRecord) {
            this.browseRecord = browseRecord;
        }

        public MemberUserInfoBean getMemberUserInfo() {
            return memberUserInfo;
        }

        public void setMemberUserInfo(MemberUserInfoBean memberUserInfo) {
            this.memberUserInfo = memberUserInfo;
        }

        public static class MemberUserInfoBean {
            /**
             * id : 47
             * memBirthday : 2019-02-22 09:05:49
             * memName : 15244615473
             * headPhoto : 123
             * username : 15244615473
             * password : 111111
             * phoneNum : 15244615473
             * gender : 0
             */

            private int id;
            private String memBirthday;
            private String memName;
            private String headPhoto;
            private String username;
            private String password;
            private String phoneNum;
            private String gender;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMemBirthday() {
                return memBirthday;
            }

            public void setMemBirthday(String memBirthday) {
                this.memBirthday = memBirthday;
            }

            public String getMemName() {
                return memName;
            }

            public void setMemName(String memName) {
                this.memName = memName;
            }

            public String getHeadPhoto() {
                return headPhoto;
            }

            public void setHeadPhoto(String headPhoto) {
                this.headPhoto = headPhoto;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getPhoneNum() {
                return phoneNum;
            }

            public void setPhoneNum(String phoneNum) {
                this.phoneNum = phoneNum;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }
        }
    }
}
