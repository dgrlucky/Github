

package com.hanzo.github.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.TextView;

import com.hanzo.github.R;
import com.hanzo.github.mvp.model.FilePath;
import com.hanzo.github.ui.adapter.base.BaseAdapter;
import com.hanzo.github.ui.adapter.base.BaseViewHolder;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by ThirtyDegreesRay on 2017/8/27 12:05:09
 */

public class FilePathAdapter extends BaseAdapter<FilePathAdapter.ViewHolder, FilePath> {

    @Inject
    public FilePathAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.layout_item_file_path;
    }

    @Override
    protected ViewHolder getViewHolder(View itemView, int viewType) {
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        String pathName = data.get(position).getName();
        holder.arrow.setVisibility(View.VISIBLE);
        if(pathName.equals("")){
            holder.path.setText(".");
        }else{
            holder.path.setText(data.get(position).getName());
        }

    }

    class ViewHolder extends BaseViewHolder {
        @BindView(R.id.arrow) AppCompatImageView arrow;
        @BindView(R.id.path) TextView path;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
