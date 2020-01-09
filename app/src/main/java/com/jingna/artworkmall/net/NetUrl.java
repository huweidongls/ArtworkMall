package com.jingna.artworkmall.net;

/**
 * Created by Administrator on 2019/12/10.
 */

public class NetUrl {

    public static final String BASE_URL = "http://192.168.1.102:80/";//http://192.168.2.211:8080/
//    public static final String BASE_URL = "http://122.112.187.234:80/";//http://192.168.2.211:8080/
    public static final String H5BASE_URL = "http://39.98.188.171:8081/";//http://192.168.2.211:8080/
    public static final String MemUsersendMessage = "/MemUser/sendMessage";//发送验证码
    public static final String MemUserloginAPP = "/MemUser/loginAPP";//短信登录
    public static final String MemUserloginAppPassword = "/MemUser/loginAppPassword";//账号密码登录
    public static final String MemUseraddMember = "/MemUser/addMember";//注册
    public static final String MemAdresstoUpdate = "/MemAdress/toUpdate";//发布收货地址
    public static final String MemAdressqueryList = "/MemAdress/queryList";//地址列表
    public static final String MemAdresssetDefault="/MemAdress/setDefault";//设置会员默认地址
    public static final String MemAdresstoDelete = "/MemAdress/toDelete";//删除地址
    public static final String MemAdressgetOne = "/MemAdress/getOne";//获取单个会员收货地址信息
    public static final String MemUsergetOne = "/MemUser/getOne";//通过ID查询会员
    public static final String MemUsertoUpdate = "/MemUser/toUpdate";//新增个人信息详情
    public static final String AppBankCardqueryList = "/AppBankCard/queryList";//全部银行卡
    public static final String AppBankCardtoDelete = "/AppBankCard/toDelete";//删除银行卡
    public static final String AppBankCardtoUpdate = "/AppBankCard/toUpdate";//添加银行卡
    public static final String MemUserretrievePassword = "/MemUser/retrievePassword";//通过手机验证码设置新密码
    public static final String AppPlatformBalanceMybalance = "/AppPlatformBalance/Mybalance";//查询平台币余额
    public static final String AppPlatformBalancequeryList = "/AppPlatformBalance/queryList";//查询该用户平台币余额明细
    public static final String IndexPageApifindBannerCategory = "/IndexPageApi/findBannerCategory";//显示所有轮播图
    public static final String IndexPageApiqueryCard = "/IndexPageApi/queryCard";//首页体检卡
    public static final String AppGoodsShopqueryList = "/AppGoodsShop/queryList";//商品列表
    public static final String AppMemberSigntoUpdate = "/AppMemberSign/toUpdate";//用户签到
    public static final String AppMemberSignqueryList = "/AppMemberSign/queryList";//用户签到信息
    public static final String AppGoodsContentqueryList = "/AppGoodsContent/queryList";//内容列表接口
    public static final String AppOrderordersSubmitted = "/AppOrder/ordersSubmitted";//普通商品提交订单
    public static final String MarketingCouponUserfindByCoupons = "/MarketingCouponUser/findByCoupons";//查询该用户所有优惠券方法
    public static final String AppOrderqueryListJfsc = "/AppOrder/queryListJfsc";//查询订单(积分商城)
    public static final String AppOrderqueryListTjk = "/AppOrder/queryListTjk";//查询订单(体检卡)
    public static final String AppOrdergetByCard = "/AppOrder/getByCard";//体检卡详情
    public static final String AppOrdergetByGoods = "/AppOrder/getByGoods";//积分商城详情
    public static final String MemUserfindByTeam = "/MemUser/findByTeam";//查询我的团队
    public static final String MemUsergetByInformation = "/MemUser/getByInformation";//我的获取信息
    public static final String AppGoodsShopgetByTjk = "/AppGoodsShop/getByTjk";//体检卡商品详情
    public static final String AppGoodsShopgetByJfsc = "/AppGoodsShop/getByJfsc";//积分商城商品详情
    public static final String AppShopCategoryqueryList = "/AppShopCategory/queryList";//父分类列表接口
    public static final String AppShopCategoryqueryChildList = "/AppShopCategory/queryChildList";//子分类列表接口
    public static final String AppRechargeExtractwithdrawal = "/AppRechargeExtract/withdrawal";//去提现接口
    public static final String AppRechargeExtractwithdrawalApply = "/AppRechargeExtract/withdrawalApply";//提现申请
    public static final String AppRechargeExtractrechargePtb = "/AppRechargeExtract/rechargePtb";//充值平台币
    public static final String AppBankCardupdateDefault = "/AppBankCard/updateDefault";//设置默认银行卡接口
    public static final String MemUsergetByMyShop = "/MemUser/getByMyShop";//我的店铺
}
