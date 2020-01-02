package com.jingna.artworkmall.bean;

import java.util.List;

/**
 * Created by Administrator on 2020/1/2.
 */

public class MemUserfindByTeamBean {

    /**
     * status : 200
     * data : [{"id":3,"memBirthday":"2019-12-26","memName":"18686817319","headPhoto":"upload/headPhoto/ceshitupian.jpg","username":"18686817319","password":"e10adc3949ba59abbe56e057f20f883e","memBalance":0,"memIntegral":1,"memStatus":0,"phoneNum":"18686817319","isFrozen":0,"gender":"1","updateTime":"2019-12-26 15:55:43","invitationCode":"j36948d64N","memberUserInfos":[]},{"id":20,"memName":"13349417696","headPhoto":"upload/headPhoto/ceshitupian.jpg","username":"13349417696","password":"fe1a10e4576c9db0b40e26b9ffa38ea5","memBalance":0,"memIntegral":0,"memStatus":0,"phoneNum":"13349417696","isFrozen":0,"gender":"0","invitationCode":"lPd0lW39l2","memberUserInfos":[]}]
     */

    private String status;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 3
         * memBirthday : 2019-12-26
         * memName : 18686817319
         * headPhoto : upload/headPhoto/ceshitupian.jpg
         * username : 18686817319
         * password : e10adc3949ba59abbe56e057f20f883e
         * memBalance : 0
         * memIntegral : 1
         * memStatus : 0
         * phoneNum : 18686817319
         * isFrozen : 0
         * gender : 1
         * updateTime : 2019-12-26 15:55:43
         * invitationCode : j36948d64N
         * memberUserInfos : []
         */

        private int id;
        private String memBirthday;
        private String memName;
        private String headPhoto;
        private String username;
        private String password;
        private double memBalance;
        private double memIntegral;
        private int memStatus;
        private String phoneNum;
        private int isFrozen;
        private String gender;
        private String updateTime;
        private String invitationCode;
        private List<?> memberUserInfos;

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

        public double getMemBalance() {
            return memBalance;
        }

        public void setMemBalance(double memBalance) {
            this.memBalance = memBalance;
        }

        public double getMemIntegral() {
            return memIntegral;
        }

        public void setMemIntegral(double memIntegral) {
            this.memIntegral = memIntegral;
        }

        public int getMemStatus() {
            return memStatus;
        }

        public void setMemStatus(int memStatus) {
            this.memStatus = memStatus;
        }

        public String getPhoneNum() {
            return phoneNum;
        }

        public void setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
        }

        public int getIsFrozen() {
            return isFrozen;
        }

        public void setIsFrozen(int isFrozen) {
            this.isFrozen = isFrozen;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getInvitationCode() {
            return invitationCode;
        }

        public void setInvitationCode(String invitationCode) {
            this.invitationCode = invitationCode;
        }

        public List<?> getMemberUserInfos() {
            return memberUserInfos;
        }

        public void setMemberUserInfos(List<?> memberUserInfos) {
            this.memberUserInfos = memberUserInfos;
        }
    }
}
