package com.jingna.artworkmall.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/12/30.
 */

public class MarketingCouponUserfindByCouponsBean {

    /**
     * status : 200
     * data : [{"name":"满100-10优惠券","usageMode":0,"type":10,"parameter":10,"maxMoney":100,"sumDiscount":0,"createTime":"2019-12-20 19:57:01","pastTime":"2019-12-23 20:02:44"},{"name":"满100-10优惠券","usageMode":0,"type":10,"parameter":10,"maxMoney":100,"sumDiscount":0,"createTime":"2019-12-20 19:44:52","pastTime":"2019-12-23 20:02:44"}]
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
         * name : 满100-10优惠券
         * usageMode : 0
         * type : 10
         * parameter : 10
         * maxMoney : 100
         * sumDiscount : 0
         * createTime : 2019-12-20 19:57:01
         * pastTime : 2019-12-23 20:02:44
         */

        private String name;
        private int usageMode;
        private int type;
        private double parameter;
        private int maxMoney;
        private int sumDiscount;
        private String createTime;
        private String pastTime;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getUsageMode() {
            return usageMode;
        }

        public void setUsageMode(int usageMode) {
            this.usageMode = usageMode;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public double getParameter() {
            return parameter;
        }

        public void setParameter(double parameter) {
            this.parameter = parameter;
        }

        public int getMaxMoney() {
            return maxMoney;
        }

        public void setMaxMoney(int maxMoney) {
            this.maxMoney = maxMoney;
        }

        public int getSumDiscount() {
            return sumDiscount;
        }

        public void setSumDiscount(int sumDiscount) {
            this.sumDiscount = sumDiscount;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getPastTime() {
            return pastTime;
        }

        public void setPastTime(String pastTime) {
            this.pastTime = pastTime;
        }
    }
}
