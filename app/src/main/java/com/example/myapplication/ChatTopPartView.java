package com.example.myapplication;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;

import java.util.Date;

public class ChatTopPartView extends LinearLayout {
    public final CharSequence latestMessageText;
    private final Date timeStamp;
    public final CharSequence chatName;
    public final CharSequence latestSender;

    public ChatTopPartView(Context context, CharSequence latestMessageText,CharSequence chatName, Date timeStamp, CharSequence latestSender) {
        super(context);
        setOrientation(VERTICAL);
        this.latestMessageText=latestMessageText;
        this.chatName=chatName;
        this.timeStamp=timeStamp;
        this.latestSender=latestSender;
        int paddingLeftRight = getResources().getDimensionPixelSize(R.dimen.chatViewMessageBorderLeftRight);
        int paddingUpDown = getResources().getDimensionPixelSize(R.dimen.chatViewMessageBorderUpDown);
        setPadding(paddingUpDown,paddingLeftRight,paddingUpDown,paddingLeftRight);
        GradientDrawable background = new GradientDrawable();
        background.setCornerRadius(getResources().getDimension(R.dimen.chatMessageCornerRadius));
        background.setColor(ContextCompat.getColor(context,R.color.singleChatBackgroundColor));
        setBackground(background);

        TextView topText = new TextView(context);
        topText.setText(timeStamp.toString()+" "+chatName);
        addView(topText);

        TextView bottomText = new TextView(context);
        if(latestMessageText.length()>getResources().getInteger(R.integer.chatViewMaxMessageLength)){
            latestMessageText= latestMessageText.subSequence(0,getResources().getInteger(R.integer.chatViewMaxMessageLength)-3)+"...";
        }

        bottomText.setText(latestSender+": "+latestMessageText);
        addView(bottomText);

    }


}
