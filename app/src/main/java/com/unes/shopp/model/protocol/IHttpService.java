package com.unes.shopp.model.protocol;

/**
 * @author WJQ
 */
import com.google.gson.JsonObject;
import com.unes.shopp.model.bean.AddShopCartInfo;

import org.json.JSONObject;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/** Retrofit接口 */
public interface IHttpService {

    String HOST_URL = "https://api.unesmall.com/api/h/1.0/";


    int TYPE_HOMEBANNER= 0;
    int TYPE_HOMEFETCHCATES= 1;
    int TYPE_LISTITEMS=2;
    int TYPE_SCHOOLDETAILONE= 4;
    int TYPE_LOGININFO= 5;
    int TYPE_SHOPPINGCARTINFO= 6;
    int TYPE_CHANGESHOPPINGCARTINFO= 7;
    int TYPE_MINEINFO= 8;
    int TYPE_ALLPRICE= 9;
    int TYPE_POSTHORDER= 10;
    int TYPE_OTTOCART= 100;

    @POST("homeBanner.json")
    @FormUrlEncoded
    Call<JsonObject> getHomeBannerInfo(
            @Field("k") String value);


    @GET("fetchCates.json")
    Call<JsonObject> getHomeFetchCatesInfo();


    @POST("listItems.json")
    @FormUrlEncoded
    Call<JsonObject> getHomeListItemsInfo(
            @Field("q") String q,
            @Field("orderColumn") String orderColumn,
            @Field("sortType") String sortType,
                    @Field("itemTypes") String itemTypes,
                    @Field("pg") String pg,
                    @Field("sz") String sz);



    @POST("fetchCourse.json")
    @FormUrlEncoded
    Call<JsonObject> getSchoolOneInfo(
            @Field("type") String type,
            @Field("courseCategory") String courseCategory,
            @Field("pg")  String pg,
            @Field("sz") String sz);



    @POST("login.json")
    @FormUrlEncoded
    Call<JsonObject> getLoginInfo(
            @Field("m") String username,
            @Field("p") String password);


    @POST("oCartItems.json")
   // @FormUrlEncoded    使用Retrofit框架，加载POST请求方式接口时，出现Form-encoded method must contain at least one @Field.的问题。原因是，该请求方式没有请求参数，而在注解部分使用了 @FormUrlEncoded，去掉该注解即可
    Call<JsonObject> getShoppingCartInfo(
            @Header("ticket") String ticket);


    @FormUrlEncoded    //这句代表header不是 Content-Type: application/json  而是 Content-Type: application/x-www-form-urlencoded
    @POST("addCart.json")
    Call<JsonObject> changeShoppingCartInfo(@Header("ticket") String header,@Field("items") String items);



    //@FormUrlEncoded    //这句代表header不是 Content-Type: application/json  而是 Content-Type: application/x-www-form-urlencoded
    @POST("mineInfo.json")
    Call<JsonObject> getMineInfo(@Header("ticket") String header);


    @FormUrlEncoded    //这句代表header不是 Content-Type: application/json  而是 Content-Type: application/x-www-form-urlencoded
    @POST("hOrderPublicCouponList.json")
    Call<JsonObject> posthOrderPublicCouponList(@Header("ticket") String header,@Field("orderMinPrice") int orderMinPrice);

    @FormUrlEncoded    //这句代表header不是 Content-Type: application/json  而是 Content-Type: application/x-www-form-urlencoded
    @POST("hOrder.json")
    Call<JsonObject> posthOrder(@Header("ticket") String ticket, @Field("items")String items,@Field("pType") String pType, @Field("orderType") String orderType,
                                @Field("adTime") long adTime, @Field("msg")String msg,@Field("isTaxFree") int isTaxFree, @Field("point")int point,
                                @Field("couonId")int couonId, @Field("idCard")String idCard,@Field("from")String from, @Field("isCommint")String isCommint);

}
