package com.example.gaston.tp1;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

/**
 * Created by Pato on 1/12/2017.
 */

public class PostOnClickListener implements View.OnClickListener {

    private Context context;
    private Post post;

    /**
     *
     * @param context necesario para inflar el ToastAlert
     * @param post el post con los datos a pasarle al Details en onClick
     */
    public PostOnClickListener(Context context, Post post) {
        this.context = context;
        this.post = post;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(context, post.getTitulo(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, DetailsActivity.class);
        String postSerializado = new Gson().toJson(post);
        intent.putExtra("post", postSerializado);
        context.startActivity(intent);
    }
}