package com.example.abdelrhman.Presnter;

import android.content.Context;
import android.widget.Toast;

import com.example.abdelrhman.Models.UserResponce;
import com.example.abdelrhman.Rerotfit.ApiClinte;
import com.example.abdelrhman.Rerotfit.ApiMethod;
import com.example.abdelrhman.UserView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPresnter {
    Context context;
    UserView userView;
    public UserPresnter(Context context, UserView userView)
    {
        this.context=context;
        this.userView=userView;
    }
    public void getUser(String pageId)
    {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("page",pageId);
        ApiMethod apiInterface = ApiClinte.getClient().create(ApiMethod.class);
        Call<UserResponce> call = apiInterface.User(queryMap);
        call.enqueue(new Callback<UserResponce>() {
            @Override
            public void onResponse(Call<UserResponce> call, Response<UserResponce> response) {
                userView.showUsers(response.body().getData());
            }


            @Override
            public void onFailure(Call<UserResponce> call, Throwable t) {
                Toast.makeText(context,"succec",Toast.LENGTH_LONG).show();

            }
        });
    }

    }

