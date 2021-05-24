package com.example.dadadada.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.core.view.BaseMVVMActivity;
import com.example.dadadada.BR;
import com.example.dadadada.R;
import com.example.dadadada.common.SpUtils;
import com.example.dadadada.databinding.CqunData;
import com.example.dadadada.entity.CreateQunEntity;
import com.example.dadadada.entity.CreateQunFanEntity;
import com.example.dadadada.mvvm.viewmodel.CreateQunViewModel;
import com.example.net.retrofit.BaseRespEntity;


public class CQunActivity extends BaseMVVMActivity<CreateQunViewModel, CqunData> {

    public CreateQunEntity entity=new CreateQunEntity();
    private ImageView imageFanhui;
    private LinearLayout huodongType;
    private android.widget.LinearLayout tianjiaChengyuan;
    private RecyclerView chengyuanRecycle;
    private TextView titleText;
    private Button titleTextBaocun;
    private ImageView huodongIamge;
    private TextView huodongText;


    @Override
    protected void initData() {
        mV.setReqData(this);
        initView();
        imageFanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        huodongType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = SpUtils.id(CQunActivity.this);
                entity.setOwner(Integer.parseInt(id));
                AlertDialog.Builder builder = new AlertDialog.Builder(CQunActivity.this);
                builder.setIcon(R.drawable.aa);
                builder.setTitle("请选择活动类型:");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showMsg("确定");
                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showMsg("取消");
                    }
                });

                final String[] item={"团建","聚餐","旅游","会议","户外游玩"};
                final int[] icomitem={R.drawable.huodong,R.drawable.aa,R.drawable.jia,R.drawable.head_shape};

                builder.setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String aa=item[i];
                        int iiii=icomitem[i];
                        huodongIamge.setImageResource(iiii);
                        huodongText.setText(aa);
                        entity.setGrouptypename(aa);
                        switch (i){
                            case 0:
                                entity.setGrouptypeid(1);
                                entity.setImgpath("https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2858426577,4189650377&fm=26&gp=0.jpg");
                                break;
                            case 1:
                                entity.setGrouptypeid(2);
                                entity.setImgpath("https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2858426577,4189650377&fm=26&gp=0.jpg");
                                break;
                            case 2:
                                entity.setGrouptypeid(3);
                                entity.setImgpath("https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2858426577,4189650377&fm=26&gp=0.jpg");
                                break;
                            case 3:
                                entity.setGrouptypeid(4);
                                entity.setImgpath("https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2858426577,4189650377&fm=26&gp=0.jpg");
                                break;
                            case 4:
                                entity.setGrouptypeid(4);
                                entity.setImgpath("https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2858426577,4189650377&fm=26&gp=0.jpg");
                                break;
                        }
                    }
                });

                AlertDialog alertDialog = builder.create();

                alertDialog.show();
            }
        });

        tianjiaChengyuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  startActivity(new Intent(CQunActivity.this,));
            }
        });
    }

    @Override
    protected int getVariable() {
        return BR.reqData;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_c_qun;
    }

    @Override
    protected CreateQunViewModel createViewModel() {
        return new CreateQunViewModel(this);
    }

    public void onCreateQun(CreateQunEntity entity){
        mViewModel.createqun(entity).observe(this, new Observer<BaseRespEntity<CreateQunFanEntity>>() {
            @Override
            public void onChanged(BaseRespEntity<CreateQunFanEntity> createQunFanEntityBaseRespEntity) {
                if(createQunFanEntityBaseRespEntity!=null){
                    String msg = createQunFanEntityBaseRespEntity.getMsg();

                    if(msg.equals("请求成功")){
                        showMsg("创建成功");
                    }else{
                        showMsg("创建失败--不知道什么原因");
                    }
                }


            }
        });
    }

    private void initView() {
        imageFanhui = (ImageView) findViewById(R.id.image_fanhui);
        huodongType = (LinearLayout) findViewById(R.id.huodong_type);
        tianjiaChengyuan = (LinearLayout) findViewById(R.id.tianjia_chengyuan);
        chengyuanRecycle = (RecyclerView) findViewById(R.id.chengyuan_recycle);
        titleText = (TextView) findViewById(R.id.title_text);
        titleTextBaocun = (Button) findViewById(R.id.title_text_baocun);
        huodongIamge = (ImageView) findViewById(R.id.huodong_iamge);
        huodongText = (TextView) findViewById(R.id.huodong_text);
    }
}