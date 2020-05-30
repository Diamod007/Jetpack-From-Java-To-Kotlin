/*
 * Copyright 2018-2020 KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jetpack_java.sample_02_livedata.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jetpack_java.R;
import com.example.jetpack_java.sample_01_lifecycles.data.bean.LocationBean;
import com.example.jetpack_java.sample_02_livedata.data.bean.Moment;

import java.util.List;

/**
 * Create by KunMinX at 2020/5/29
 */
public class MomentAdapter extends RecyclerView.Adapter<MomentAdapter.ViewHolder> {

    private List<Moment> mList;
    private Context mContext;
    private OnItemClickListener mListener;

    public MomentAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    public void setList(List<Moment> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.adapter_moment, parent);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Moment moment = mList.get(position);

        holder.tvName.setText(moment.getUserName());
        holder.tvContent.setText(moment.getContent());
        holder.tvLocation.setText(moment.getLocation());
        Glide.with(mContext).load(moment.getUserAvatar()).into(holder.ivAvatar);
        Glide.with(mContext).load(moment.getImgUrl()).into(holder.ivPreview);

        holder.itemView.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onItemClick(mList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvContent;
        private TextView tvLocation;
        private ImageView ivAvatar;
        private ImageView ivPreview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvLocation = itemView.findViewById(R.id.tv_locate);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            ivPreview = itemView.findViewById(R.id.iv_preview);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Moment moment);
    }
}