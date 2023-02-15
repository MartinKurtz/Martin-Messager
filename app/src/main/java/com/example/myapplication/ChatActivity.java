package com.example.myapplication;

import android.app.Activity;
import android.app.SearchableInfo;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;

import java.util.Date;

public class ChatActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_view);
        View searchbar = findViewById(R.id.searchBar);
        View scrollable = findViewById(R.id.scrollChat);
        LinearLayout scrollableLinearLayout = findViewById(R.id.scrollChatLinearLayout);
        scrollableLinearLayout.setPadding((int) getResources().getDimension(R.dimen.scrollableLeftRightPadding),0,(int) getResources().getDimension(R.dimen.scrollableLeftRightPadding),0);

        //set background for behind the scrollable chats
        GradientDrawable scrollableBackground = new GradientDrawable();
        scrollableBackground.setColor(ContextCompat.getColor(scrollable.getContext(),R.color.ChatViewBackgroundColor));
        scrollable.setBackground(scrollableBackground);

        GradientDrawable searchBarBackground = new GradientDrawable();
        searchBarBackground.setColor(ContextCompat.getColor(scrollable.getContext(),R.color.SearchBarBackgroundColor));
        searchbar.setBackground(searchBarBackground);


        for(int i =0;i<1000;i++){
            ChatTopPartView chat = new ChatTopPartView(scrollableLinearLayout.getContext(),"Bruder binn ich fett und ich habe jetzt ganz viel zu sagen weil ich ganz viel gewicht hab","Deine Muddda",new Date(System.currentTimeMillis()),"ich");
            scrollableLinearLayout.addView(chat);
        }

    }
}
