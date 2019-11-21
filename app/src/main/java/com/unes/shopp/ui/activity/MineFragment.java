package com.unes.shopp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unes.shopp.R;
import com.unes.shopp.common.util.SharedPreUtil;


//这里不要继承basefragment  因为不能复用root导致渲染过多而出现问题
public class MineFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (SharedPreUtil.getInt(getActivity(),"Uid",0)!=0){
           return inflater.inflate(R.layout.activity_main,container,false);
        }else{
            Intent intent = new Intent(getContext(), LoginActivity.class);
            getActivity().startActivityForResult(intent,1000);
            return inflater.inflate(R.layout.activity_login,container,false);
        }

    }
}
