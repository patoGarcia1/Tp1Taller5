package com.example.gaston.tp1;

/**
 * Created by fravega on 1/12/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends BaseAdapter {

    private Context context;
    private List<Post> postList;

    private PostAdapter() { }

    public PostAdapter(Context context, List<Post> postList) {
        this.postList = postList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public Object getItem(int i) {
        return postList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return (long) postList.get(i).getTitulo().hashCode();
    }

    @Override
    public View getView(int i, View postView, ViewGroup viewGroup) {
         postView = LayoutInflater.from(context).inflate(R.layout.layout_post, viewGroup, false);

        TextView titulo = (TextView)  postView.findViewById(R.id.titulo);
        //ImageView fotoImg = (ImageView) postView.findViewById(R.id.foto);

        Post post = postList.get(i);

        titulo.setText(post.getTitulo());
        //fotoImg.setImageResource(post.getFotoId());
         postView.setOnClickListener(new PostOnClickListener(context, post));

        return  postView;
    }
}