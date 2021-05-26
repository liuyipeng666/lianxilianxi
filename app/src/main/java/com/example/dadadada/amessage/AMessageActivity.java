package com.example.dadadada.amessage;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.baweigame.xmpplibrary.XmppManager;
import com.baweigame.xmpplibrary.callback.IAddFriendCallback;
import com.baweigame.xmpplibrary.callback.IMsgCallback;
import com.baweigame.xmpplibrary.entity.MsgEntity;
import com.example.core.view.BaseActivity;
import com.example.dadadada.R;
import com.example.dadadada.amessage.adapter.MsgUserAdapter;
import com.example.dadadada.common.MsgUtils;
import com.example.dadadada.common.NetHelper;
import com.example.dadadada.common.SpUtils;

import org.jivesoftware.smack.chat2.Chat;
import org.jxmpp.jid.Jid;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;

public class AMessageActivity extends BaseActivity {

    private EditText etSendMsg;
    private RecyclerView MsgUserRv;
    private MsgUserAdapter msgUserAdapter;
    private EditText mainNumber;
    private String SendMsg;
    private Button addFriendBt;
    private String UNumber;
    private List<MsgEntity> msgEntities = new ArrayList<>();
    private Button btSendMsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_message);

        initView();
        initData();
    }

    private void initData() {
        addFriendBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String friendNum = mainNumber.getText().toString();
                NetHelper.doTask(new Runnable() {
                    @Override
                    public void run() {
                        UNumber = mainNumber.getText().toString();
                        String s =  UNumber + "@" + XmppManager.getInstance().getConnection().getServiceName();
                        XmppManager.getInstance().getXmppFriendManager().addFriend(s,friendNum);
                    }
                });
            }
        });

        btSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //对方电话号码
                UNumber = mainNumber.getText().toString();
                //发送消息内容
                SendMsg = etSendMsg.getText().toString();
                String friend = UNumber+"@"+XmppManager.getInstance().getConnection().getServiceName();
                Chat friendChat = XmppManager.getInstance().getXmppMsgManager().getFriendChat(friend);
                XmppManager.getInstance().getXmppMsgManager().sendSingleMessage(friendChat,SendMsg);
                String name = SpUtils.name(AMessageActivity.this);
                msgEntities.add(new MsgEntity(name,UNumber+"",SendMsg, MsgEntity.MsgType.Txt));
                msgUserAdapter.notifyDataSetChanged();
            }
        });




        XmppManager.getInstance().addMessageListener(new IMsgCallback() {
            @Override
            public void Success(MsgEntity msgEntity) {
                Log.d("ddd", "Failed: "+etSendMsg);
                msgEntities.add(msgEntity);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        msgUserAdapter.notifyDataSetChanged();
                    }
                });
            }

            @Override
            public void Failed(Throwable throwable) {
                Log.d("ddd", "Failed: "+throwable.getMessage());
            }
        });

        msgUserAdapter = new MsgUserAdapter(this,msgEntities);
        MsgUserRv.setLayoutManager(new LinearLayoutManager(this));
        MsgUserRv.setAdapter(msgUserAdapter);
    }

    private void initView() {
        etSendMsg = findViewById(R.id.et_sendMsg);
        MsgUserRv = findViewById(R.id.MsgUser_rv);
        mainNumber = findViewById(R.id.main_number);
        addFriendBt = findViewById(R.id.addFriend_bt);
        btSendMsg = findViewById(R.id.bt_sendMsg);
    }
}