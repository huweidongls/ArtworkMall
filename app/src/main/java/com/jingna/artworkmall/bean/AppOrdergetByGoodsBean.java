package com.jingna.artworkmall.bean;

import java.util.List;

/**
 * Created by Administrator on 2020/1/2.
 */

public class AppOrdergetByGoodsBean {

    /**
     * status : 200
     * data : {"id":"1577763445125","addresPhone":"13236636363","addresUname":"佛祖","addresName":"北京市-北京市-东城区汉广街41号408进门找胡小牛","orderStatus":"1","paymentMode":"平台币支付","createTime":"2019-12-31 11:37:17","orderRealPrice":98.4,"list":[],"num":1,"appPic":"upload/goods/2019-12-30/f67db3c583824459b9ec812b99741ef6.jpg","goodsName":"测试商品"}
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
         * id : 1577763445125
         * addresPhone : 13236636363
         * addresUname : 佛祖
         * addresName : 北京市-北京市-东城区汉广街41号408进门找胡小牛
         * orderStatus : 1
         * paymentMode : 平台币支付
         * createTime : 2019-12-31 11:37:17
         * orderRealPrice : 98.4
         * list : []
         * num : 1
         * appPic : upload/goods/2019-12-30/f67db3c583824459b9ec812b99741ef6.jpg
         * goodsName : 测试商品
         */

        private String id;
        private String addresPhone;
        private String addresUname;
        private String addresName;
        private String orderStatus;
        private String paymentMode;
        private String createTime;
        private double orderRealPrice;
        private int num;
        private String appPic;
        private String goodsName;
        private List<?> list;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAddresPhone() {
            return addresPhone;
        }

        public void setAddresPhone(String addresPhone) {
            this.addresPhone = addresPhone;
        }

        public String getAddresUname() {
            return addresUname;
        }

        public void setAddresUname(String addresUname) {
            this.addresUname = addresUname;
        }

        public String getAddresName() {
            return addresName;
        }

        public void setAddresName(String addresName) {
            this.addresName = addresName;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getPaymentMode() {
            return paymentMode;
        }

        public void setPaymentMode(String paymentMode) {
            this.paymentMode = paymentMode;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public double getOrderRealPrice() {
            return orderRealPrice;
        }

        public void setOrderRealPrice(double orderRealPrice) {
            this.orderRealPrice = orderRealPrice;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getAppPic() {
            return appPic;
        }

        public void setAppPic(String appPic) {
            this.appPic = appPic;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public List<?> getList() {
            return list;
        }

        public void setList(List<?> list) {
            this.list = list;
        }
    }
}
