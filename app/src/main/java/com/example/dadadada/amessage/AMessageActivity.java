package com.example.dadadada.amessage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.core.view.BaseActivity;
import com.example.dadadada.R;
import com.example.dadadada.amessage.adapter.MsgUserAdapter;
import com.example.dadadada.amessage.entity.MessageFLEntity;
import com.example.dadadada.amessage.entity.MessageUserEntity;
import com.example.dadadada.amessage.entity.ReceiveMsgEntity;
import com.example.dadadada.amessage.entity.SendMessageEntity;
import com.example.dadadada.amessage.model.MessageFLModel;
import com.example.dadadada.amessage.viewmodel.MessageFLViewModel;
import com.example.dadadada.amessage.viewmodel.MessageUserViewModel;
import com.example.dadadada.amessage.viewmodel.ReceiveMsgViewModel;
import com.example.dadadada.amessage.viewmodel.SendMessageViewModel;
import com.example.net.retrofit.BaseRespEntity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;

public class AMessageActivity extends BaseActivity {

    private EditText etSendMsg;
    private RecyclerView MsgUserRv;
    private MsgUserAdapter msgUserAdapter;
    private EditText mainNumber;
    private ReceiveMsgEntity receive = new ReceiveMsgEntity();
    private String SendMsg;
    private Button addFriendBt;
    private int UNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_message);
        initView();
        initData();

        receive = Msg();

        //获取消息分类
        MessageFl();
        //接收消息
        Receive();
        //与指定用户聊天记录
//        MessageUser();
    }

    private void initData() {
        //发送消息内容
        SendMsg = etSendMsg.getText().toString();


    }

    private void initView() {
        etSendMsg = findViewById(R.id.et_sendMsg);
        MsgUserRv = findViewById(R.id.MsgUser_rv);
        mainNumber = findViewById(R.id.main_number);
        addFriendBt = findViewById(R.id.addFriend_bt);
    }

    private void Receive() {
        ReceiveMsgViewModel receiveMsgViewModel = new ReceiveMsgViewModel(this);
        receiveMsgViewModel.getReceive(receive).observe(this, new Observer<BaseRespEntity<ReceiveMsgEntity>>() {
            @Override
            public void onChanged(BaseRespEntity<ReceiveMsgEntity> receiveMsgEntityBaseRespEntity) {
                List<ReceiveMsgEntity> list = new ArrayList<>();
                list.add(receiveMsgEntityBaseRespEntity.getData());
                msgUserAdapter = new MsgUserAdapter(AMessageActivity.this,list);
                MsgUserRv.setAdapter(msgUserAdapter);
                MsgUserRv.setLayoutManager(new LinearLayoutManager(AMessageActivity.this));
            }
        });
    }

    private void MessageUser() {
        MessageUserViewModel messageUserViewModel = new MessageUserViewModel(this);
        messageUserViewModel.getUser().observe(this, new Observer<BaseRespEntity<MessageUserEntity>>() {
            @Override
            public void onChanged(BaseRespEntity<MessageUserEntity> messageUserEntityBaseRespEntity) {

            }
        });
    }

    private void MessageFl() {

        MessageFLViewModel model = new MessageFLViewModel(this);
        model.getViewModel()
                .observe(this, new Observer<BaseRespEntity<MessageFLEntity>>() {
            @Override
            public void onChanged(BaseRespEntity<MessageFLEntity> messageFLEntityBaseRespEntity) {
                if (messageFLEntityBaseRespEntity==null){
                    showMsg("毫无训练痕迹");
                }else{
                    MessageFLEntity data = messageFLEntityBaseRespEntity.getData();
                }
            }
        });
    }

    //接收消息
    public void sendMsg(View view) {
        //对方电话号码
        UNumber = Integer.parseInt(mainNumber.getText().toString());

        SendMessageViewModel sendMessageViewModel = new SendMessageViewModel(this);
        sendMessageViewModel.getSend(receive).observe(this, new Observer<BaseRespEntity<SendMessageEntity>>() {
            @Override
            public void onChanged(BaseRespEntity<SendMessageEntity> sendMessageEntityBaseRespEntity) {

            }
        });
    }

    private ReceiveMsgEntity Msg() {
        ReceiveMsgEntity entity = new ReceiveMsgEntity();
        //发送或接收时间
        entity.setBlltime(time());
        //消息内容
        entity.setContent(SendMsg);
        //发送用户
        entity.setFromuser(147);
        //1已读/0未读
        entity.setIsread(0);
        //1接收/0发送
        entity.setMsgtype2(0);
        //消息类型
        entity.setMsgtypeid(0);
        //接收用户
        entity.setTouser(UNumber);
        return entity;
    }

    //当前时间
    private String time() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return format;
    }
}