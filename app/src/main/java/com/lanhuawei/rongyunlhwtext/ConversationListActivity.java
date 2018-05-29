package com.lanhuawei.rongyunlhwtext;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;

/**
 * Created by Ivan.L on  2018/5/28 .
 * 会话列表
 */

public class ConversationListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation_list);
        ConversationListFragment conversationListFragment = new ConversationListFragment(); Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon() .appendPath("conversationlist") //设置私聊会话，该会话聚合显示
                .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false") //设置系统会话，该会话非聚合显示
                .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "true") .build();
        conversationListFragment.setUri(uri); FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.conversationlist,conversationListFragment);
        transaction.commit();
    }
}
