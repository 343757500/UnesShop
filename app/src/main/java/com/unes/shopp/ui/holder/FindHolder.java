package com.unes.shopp.ui.holder;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.unes.shopp.R;
import com.unes.shopp.base.BaseView;
import com.unes.shopp.common.ui.BaseAdapterRV;
import com.unes.shopp.common.ui.BaseHolderRV;
import com.unes.shopp.common.util.DateUtil;
import com.unes.shopp.common.util.DownloadListener;
import com.unes.shopp.common.util.DownloadUtil;
import com.unes.shopp.common.util.Utils;
import com.unes.shopp.model.bean.FetchItemsByIdInfo;
import com.unes.shopp.model.protocol.CommonProtocol;
import com.unes.shopp.model.protocol.IHttpService;
import com.unes.shopp.presenter.HomePagePresenter;
import com.unes.shopp.ui.adapter.FetchItemsAdapter;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


public class FindHolder extends BaseHolderRV<FetchItemsByIdInfo.ResultBean.FodderItemDOsBean> implements BaseView{

    private RecyclerView rv;
    private TextView tv_fetchName;
    private TextView tv_time;
    private TextView tv_content;
    private TextView tv_sendCount;
    private ImageView iv_fetchItem;
    private FrameLayout ll;
    private JCVideoPlayerStandard player_list_video;
    private TextView tv_sendCircle;

    public FindHolder(Context context, ViewGroup parent, BaseAdapterRV<FetchItemsByIdInfo.ResultBean.FodderItemDOsBean> adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_find);
    }

    @Override
    public void onFindViews(View itemView) {
        rv = itemView.findViewById(R.id.rv);
        rv.setLayoutManager(new GridLayoutManager(context,3));
        tv_fetchName = itemView.findViewById(R.id.tv_fetchName);
        tv_time = itemView.findViewById(R.id.tv_time);
        tv_content = itemView.findViewById(R.id.tv_content);
        tv_sendCount = itemView.findViewById(R.id.tv_sendCount);
        iv_fetchItem = itemView.findViewById(R.id.iv_fetchItem);
        player_list_video = itemView.findViewById(R.id.player_list_video);
        ll = itemView.findViewById(R.id.ll);
        tv_sendCircle = itemView.findViewById(R.id.tv_sendCircle);




                tv_sendCircle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Utils.copy(tv_content.getText().toString(), context);
                        String[] splitVal = bean.getFodderUrl().split("\\;");//转数组
                        final List<String> asList = Arrays.asList(splitVal);//图片   转集合

                        if (asList.size() > 0) {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    for (int i = 0; i < asList.size(); i++) {
                                       DownloadUtil downloadUtil= new DownloadUtil();
                                        downloadUtil.downloadFile(asList.get(i), new DownloadListener() {
                                            @Override
                                            public void onStart() {

                                            }

                                            @Override
                                            public void onProgress(int currentLength) {
                                                Log.e("111", currentLength+"---");
                                            }

                                            @Override
                                            public void onFinish(String localPath) {
                                                Toast.makeText(context,"保存数据完成",Toast.LENGTH_SHORT).show();
                                            }

                                            @Override
                                            public void onFailure(String erroInfo) {
                                                Log.e("111", erroInfo);
                                            }
                                        });
                                    }
                                }
                            }).start();

                        }else{
                            DownloadUtil downloadUtil= new DownloadUtil();
                            downloadUtil.downloadFile(bean.getFodderUrl(), new DownloadListener() {
                                @Override
                                public void onStart() {

                                }

                                @Override
                                public void onProgress(int currentLength) {

                                }

                                @Override
                                public void onFinish(String localPath) {
                                    Log.e("111", localPath);
                                }

                                @Override
                                public void onFailure(String erroInfo) {
                                    Log.e("111", erroInfo);
                                }
                            });
                        }


                    }
                });





    }

    @Override
    protected void onRefreshView(FetchItemsByIdInfo.ResultBean.FodderItemDOsBean bean, int position) {
        final String fodderUrl = bean.getFodderUrl();
        String[] splitVal = fodderUrl.split("\\;");//转数组
        List<String> asList = Arrays.asList(splitVal);//图片   转集合

        if (asList.size()>0){
            rv.setVisibility(View.VISIBLE);
            rv.setAdapter(new FetchItemsAdapter(context,asList));
        }else{
            rv.setVisibility(View.GONE);
        }


        if (StringUtils.endsWith(fodderUrl,".MP4")){
            boolean setUp = player_list_video.setUp(bean.getFodderUrl(), JCVideoPlayer.SCREEN_LAYOUT_LIST, "");
            //Picasso.with(context).load(Uri.parse(bean.getProfilePic())).into(player_list_video.thumbImageView);
            rv.setVisibility(View.GONE);
            player_list_video.setVisibility(View.VISIBLE);
        }else{
            rv.setVisibility(View.VISIBLE);
            player_list_video.setVisibility(View.GONE);
        }


        tv_fetchName.setText(bean.getNickname());
        tv_time.setText(DateUtil.getDateToString(bean.getLastUpdated(),"yy-mm-dd hh-mm-ss"));
        tv_content.setText(bean.getComment());
        tv_sendCount.setText("已发圈"+bean.getCountShare()+"次");
        Picasso.with(context).load(bean.getProfilePic()).into(iv_fetchItem);


    }

    @Override
    protected void onItemClick(View itemView, int position, FetchItemsByIdInfo.ResultBean.FodderItemDOsBean bean) {
        super.onItemClick(itemView, position, bean);
    }


    @Override
    public void onHttpSuccess(int reqType, Message obj) {
        if (reqType== IHttpService.TYPE_HOMEFETCHCATES){

        }
    }

    @Override
    public void onHttpError(int reqType, String error) {

    }
}
