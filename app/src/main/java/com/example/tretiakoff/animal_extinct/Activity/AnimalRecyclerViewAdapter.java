package com.example.tretiakoff.animal_extinct.Activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tretiakoff.animal_extinct.Model.Arkive.ArkiveResponseDoc;
import com.example.tretiakoff.animal_extinct.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by tretiakoff on 07/06/2018.
 */

public class AnimalRecyclerViewAdapter extends RecyclerView.Adapter<AnimalRecyclerViewAdapter.TopRatedViewHolder> {

    private ArrayList<ArkiveResponseDoc> mAnimalList = new ArrayList<>();
    private LayoutInflater topRatedInflater;
    private OnTopRatedClickListener mOnTopRatedOnClickListener;

    public AnimalRecyclerViewAdapter(OnTopRatedClickListener mOnTopRatedOnClickListener) {
        this.mOnTopRatedOnClickListener = mOnTopRatedOnClickListener;
    }

    public static class TopRatedViewHolder extends RecyclerView.ViewHolder {

        private ImageView cover;
        private TextView title;
        RelativeLayout topRatedContainer;

        TopRatedViewHolder(View topRatedItemLayout) {
            super(topRatedItemLayout);
            topRatedContainer = (RelativeLayout) topRatedItemLayout;
            title = topRatedItemLayout.findViewById(R.id.item_cover_text);
            cover = topRatedItemLayout.findViewById(R.id.item_cover_image);
        }
    }


    @Override
    public TopRatedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View topRatedRl = topRatedInflater.from(parent.getContext()).inflate(R.layout.animal_list_view, parent, false);
        return new TopRatedViewHolder(topRatedRl);
    }

    @Override
    public void onBindViewHolder(TopRatedViewHolder holder, final int position) {

        final ArkiveResponseDoc mAnimal = mAnimalList.get(position);
        holder.title.setText(mAnimal.getNameCommon());

        Picasso.with(holder.topRatedContainer.getContext())
                .load(mAnimal.getThumbnailURL())
                .placeholder(R.drawable.placeholder)
                .into(holder.cover);

        holder.topRatedContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnTopRatedOnClickListener.onTopRatedClick(mAnimal);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mAnimalList.size();
    }

    public void setTopRatedList(ArrayList<ArkiveResponseDoc> animalList) {

        mAnimalList = animalList;
    }

    public interface OnTopRatedClickListener{
        void onTopRatedClick(ArkiveResponseDoc animal);
    }
}
