package com.example.abdelrhman.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.abdelrhman.Models.User;
import com.example.abdelrhman.R;

import java.util.List;

public class UserAdapter  extends RecyclerView.Adapter<UserAdapter.UserHolder>{
    Context context;
    List<User>userList;
    public UserAdapter(Context context, List<User>userList)
    {
        this.context=context;
        this.userList=userList;

    }
    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user,parent,false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
       User user=userList.get(position);
        holder.fristName.setText(user.getFirstName());
        holder.lastName.setText(user.getLastName());
        Glide.with(context).load(user.getAvatar()).into(holder.userImage);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder {
        TextView fristName,lastName;
        ImageView userImage;
        public UserHolder(View itemView) {
            super(itemView);
            fristName=itemView.findViewById(R.id.fristName);
            lastName=itemView.findViewById(R.id.lastName);
            userImage=itemView.findViewById(R.id.userImage);
        }

    }
}
