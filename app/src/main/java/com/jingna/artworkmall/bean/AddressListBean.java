package com.jingna.artworkmall.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/12/24.
 */

public class AddressListBean implements Serializable {

    /**
     * status : 200
     * data : [{"id":14,"memberId":"47","consignee":"齐连超","adress":"机场路313号","acquiescentAdress":"1","location":"黑龙江省-哈尔滨市-道里区","consigneeTel":"15244615473","zipCode":"000000","status":"1","createDate":"2019-12-24 10:28:48"}]
     * totalPage : 0
     * totalCount : 1
     */

    private String status;
    private int totalPage;
    private int totalCount;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * id : 14
         * memberId : 47
         * consignee : 齐连超
         * adress : 机场路313号
         * acquiescentAdress : 1
         * location : 黑龙江省-哈尔滨市-道里区
         * consigneeTel : 15244615473
         * zipCode : 000000
         * status : 1
         * createDate : 2019-12-24 10:28:48
         */

        private int id;
        private String memberId;
        private String consignee;
        private String adress;
        private String acquiescentAdress;
        private String location;
        private String consigneeTel;
        private String zipCode;
        private String status;
        private String createDate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMemberId() {
            return memberId;
        }

        public void setMemberId(String memberId) {
            this.memberId = memberId;
        }

        public String getConsignee() {
            return consignee;
        }

        public void setConsignee(String consignee) {
            this.consignee = consignee;
        }

        public String getAdress() {
            return adress;
        }

        public void setAdress(String adress) {
            this.adress = adress;
        }

        public String getAcquiescentAdress() {
            return acquiescentAdress;
        }

        public void setAcquiescentAdress(String acquiescentAdress) {
            this.acquiescentAdress = acquiescentAdress;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getConsigneeTel() {
            return consigneeTel;
        }

        public void setConsigneeTel(String consigneeTel) {
            this.consigneeTel = consigneeTel;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }
    }
}
