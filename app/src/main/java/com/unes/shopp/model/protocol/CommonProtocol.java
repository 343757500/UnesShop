package com.unes.shopp.model.protocol;


import com.unes.shopp.model.bean.AddShopCartInfo;
import com.unes.shopp.model.bean.ChangeShopCartInfo;
import com.unes.shopp.model.bean.FetchItemsByIdInfo;
import com.unes.shopp.model.bean.FetchItemsInfo;
import com.unes.shopp.model.bean.HomeBannerInfo;
import com.unes.shopp.model.bean.HomeFetchCatesInfo;
import com.unes.shopp.model.bean.HomeListItemsInfo;
import com.unes.shopp.model.bean.LoginInfo;
import com.unes.shopp.model.bean.MineInfo;
import com.unes.shopp.model.bean.PostAllPriceInfo;
import com.unes.shopp.model.bean.PosthOrderInfo;
import com.unes.shopp.model.bean.SchoolDetailOneInfo;
import com.unes.shopp.model.bean.ShoppingCartInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * 网络请求
 *
 * @author WJQ
 */
public class CommonProtocol extends BaseProtocol {

    public void getHomeBannerInfo(final OnHttpCallback callback,String value) {
        super.execute(super.getHttpService().getHomeBannerInfo(value),
                callback, IHttpService.TYPE_HOMEBANNER, HomeBannerInfo.class);
    }


    public void getHomeFetchCatesInfo(final OnHttpCallback callback) {
        super.execute(super.getHttpService().getHomeFetchCatesInfo(),
                callback, IHttpService.TYPE_HOMEFETCHCATES, HomeFetchCatesInfo.class);
    }

    public void getHomelistItemsInfo(final OnHttpCallback callback,String q,String orderColumn,String sortType,String itemTypes,String pg,String sz) {
        super.execute(super.getHttpService().getHomeListItemsInfo(q,orderColumn,sortType,itemTypes,pg,sz),
                callback, IHttpService.TYPE_LISTITEMS, HomeListItemsInfo.class);
    }


    public void getSchoolOneInfo(final OnHttpCallback callback,String type,String courseCategory,String pg,String sz) {
        super.execute(super.getHttpService().getSchoolOneInfo(type,courseCategory,pg,sz),
                callback, IHttpService.TYPE_SCHOOLDETAILONE, SchoolDetailOneInfo.class);


    }


    public void getLoginInfo(final OnHttpCallback callback,String username ,String password){
        super.execute(super.getHttpService().getLoginInfo(username,password),callback,IHttpService.TYPE_LOGININFO,LoginInfo.class);
    }

    public void getShoppingCartInfo(final OnHttpCallback callback,String ticket){
        super.execute(super.getHttpService().getShoppingCartInfo(ticket),callback,IHttpService.TYPE_SHOPPINGCARTINFO,ShoppingCartInfo.class);
    }


    public void changeShoppingCartInfo(final OnHttpCallback callback,AddShopCartInfo items){
        super.execute(super.getHttpService().changeShoppingCartInfo(items.getTicket(),items.getItem_id()),callback,IHttpService.TYPE_CHANGESHOPPINGCARTINFO,ChangeShopCartInfo.class);
    }


    public void getMineInfo(final OnHttpCallback callback,String ticket){
        super.execute(super.getHttpService().getMineInfo(ticket),callback,IHttpService.TYPE_MINEINFO,MineInfo.class);
    }

    public void posthOrderPublicCouponList(final OnHttpCallback callback,String ticket,int orderMinPrice){
        super.execute(super.getHttpService().posthOrderPublicCouponList(ticket,orderMinPrice),callback,IHttpService.TYPE_ALLPRICE,PostAllPriceInfo.class);
    }


    public void posthOrder(OnHttpCallback callback, String ticket, String items, String pType, String orderType, long adTime, String msg, int isTaxFree, int point, int couonId, String idCard,String from, String isCommint) {
        super.execute(super.getHttpService().posthOrder(ticket,items,pType,orderType,adTime,msg,isTaxFree,point,couonId,idCard,from,isCommint),callback,IHttpService.TYPE_POSTHORDER,PosthOrderInfo.class);
    }

    public void getFetchItemsInfo(OnHttpCallback callback,String ticket ,String pids) {
            super.execute(super.getHttpService().getFetchItemsInfo(ticket,pids),callback,IHttpService.TYPE_FENCHITEMS,FetchItemsInfo.class);
        }

    public void getFodderItemByItemId(OnHttpCallback callback, String ticket, String itemId) {
        super.execute(super.getHttpService().getFodderItemByItemId(ticket,itemId),callback,IHttpService.TYPE_FENCHITEMSITEM,FetchItemsByIdInfo.class);
    }

}
