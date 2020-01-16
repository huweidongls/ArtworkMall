package com.jingna.artworkmall.bean;

/**
 * Created by Administrator on 2020/1/16.
 */

public class VersionBean {

    /**
     * status : 200
     * data : {"id":7,"versionNum":"v2","url":"guge","onOff":1,"versions":"v222222222"}
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
         * id : 7
         * versionNum : v2
         * url : guge
         * onOff : 1
         * versions : v222222222
         */

        private int id;
        private String versionNum;
        private String url;
        private int onOff;
        private String versions;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getVersionNum() {
            return versionNum;
        }

        public void setVersionNum(String versionNum) {
            this.versionNum = versionNum;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getOnOff() {
            return onOff;
        }

        public void setOnOff(int onOff) {
            this.onOff = onOff;
        }

        public String getVersions() {
            return versions;
        }

        public void setVersions(String versions) {
            this.versions = versions;
        }
    }
}
