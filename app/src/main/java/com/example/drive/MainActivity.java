package com.example.drive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView lv_main;
    private TextView tvtime;
    private Button btnjiaojuan;
    private LinearLayout ll1;
    private TextView tvnum;
    private TextView tv;
    private ImageView img_pic;
    private RadioButton rb_a;
    private RadioButton rb_b;
    private RadioButton rb_c;
    private RadioButton rb_d;
    private RadioGroup radioGroup;
    private TextView tvdaan;
    private TextView tvjiexi;
    private LinearLayout ll2;
    private ImageView img_fanhui;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
        initListener();
        img_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll2.setVisibility(View.GONE);
                ll1.setVisibility(View.VISIBLE);
            }
        });
    }

    private void initListener() {


    }


    private void init() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url("http://apicloud.mob.com/tiku/kemu1/query?key=520520test&page=2&size=100").build();
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    String string = response.body().string();
                    Gson gson = new Gson();
                    final Item item = gson.fromJson(string, Item.class);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            lv_main.setAdapter(new BaseAdapter() {

                                class ViewHolder {
                                    public View rootView;
                                    public TextView tvnum;
                                    public TextView tv;
                                    public ImageView img_pic;
                                    public RadioButton rb_a;
                                    public RadioButton rb_b;
                                    public RadioButton rb_c;
                                    public RadioButton rb_d;
                                    public RadioGroup radioGroup;

                                    public ViewHolder(View rootView) {
                                        this.rootView = rootView;
                                        this.tvnum = (TextView) rootView.findViewById(R.id.tvnum);
                                        this.tv = (TextView) rootView.findViewById(R.id.tv);
                                        this.img_pic = (ImageView) rootView.findViewById(R.id.img_pic);
                                        this.rb_a = (RadioButton) rootView.findViewById(R.id.rb_a);
                                        this.rb_b = (RadioButton) rootView.findViewById(R.id.rb_b);
                                        this.rb_c = (RadioButton) rootView.findViewById(R.id.rb_c);
                                        this.rb_d = (RadioButton) rootView.findViewById(R.id.rb_d);
                                        this.radioGroup = (RadioGroup) rootView.findViewById(R.id.radioGroup);
                                    }

                                }

                                @Override
                                public int getCount() {
                                    return item.getResult().getList().size();
                                }

                                @Override
                                public Object getItem(int position) {
                                    return item.getResult().getList().get(position);
                                }

                                @Override
                                public long getItemId(int position) {
                                    return position;
                                }

                                @Override
                                public View getView(final int position, View convertView, ViewGroup parent) {
                                    convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item, parent, false);
                                    ViewHolder viewHolder = new ViewHolder(convertView);
                                    viewHolder.tv.setText(item.getResult().getList().get(position).getTitle());
                                    viewHolder.tvnum.setText(position + 1 + ".");
                                    tv.setText(item.getResult().getList().get(position).getTitle());
                                    tvnum.setText(position + 1 + ".");
                                    if (item.getResult().getList().get(position).getC().equals("")) {
                                        viewHolder.rb_a.setText(item.getResult().getList().get(position).getA());
                                        viewHolder.rb_b.setText(item.getResult().getList().get(position).getB());
                                        viewHolder.rb_c.setVisibility(View.GONE);
                                        viewHolder.rb_d.setVisibility(View.GONE);
                                    } else {
                                        viewHolder.rb_a.setText(item.getResult().getList().get(position).getA());
                                        viewHolder.rb_b.setText(item.getResult().getList().get(position).getB());
                                        viewHolder.rb_c.setText(item.getResult().getList().get(position).getC());
                                        viewHolder.rb_d.setText(item.getResult().getList().get(position).getD());
                                    }


                                    if (item.getResult().getList().get(position).getFile().equals("")) {

                                    } else {
                                        String file = item.getResult().getList().get(position).getFile();
                                        Glide.with(MainActivity.this).load(file).into(viewHolder.img_pic);
                                    }
                                    viewHolder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                        @Override
                                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                                            switch (checkedId) {
                                                case R.id.rb_a:
                                                    if (item.getResult().getList().get(position).getVal().equals("1")) {
                                                        Toast.makeText(MainActivity.this, "答案正确", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        Intent intent = new Intent(MainActivity.this, ErrorActivity.class);
                                                        intent.putExtra("position", item.getResult().getList().get(position).getExplainText());
                                                        startActivity(intent);
                                                    }
                                                    break;
                                                case R.id.rb_b:
                                                    if (item.getResult().getList().get(position).getVal().equals("2")) {
                                                        Toast.makeText(MainActivity.this, "答案正确", Toast.LENGTH_SHORT).show();

                                                    } else {
                                                        Intent intent = new Intent(MainActivity.this, ErrorActivity.class);
                                                        intent.putExtra("position", item.getResult().getList().get(position).getExplainText());
                                                        startActivity(intent);

                                                    }
                                                    break;
                                                case R.id.rb_c:
                                                    if (item.getResult().getList().get(position).getVal().equals("3")) {
                                                        Toast.makeText(MainActivity.this, "答案正确", Toast.LENGTH_SHORT).show();

                                                    } else {
                                                        Intent intent = new Intent(MainActivity.this, ErrorActivity.class);
                                                        intent.putExtra("position", item.getResult().getList().get(position).getExplainText());
                                                        startActivity(intent);

                                                    }
                                                    break;
                                                case R.id.rb_d:
                                                    if (item.getResult().getList().get(position).getVal().equals("4")) {
                                                        Toast.makeText(MainActivity.this, "答案正确", Toast.LENGTH_SHORT).show();

                                                    } else {
                                                        Intent intent = new Intent(MainActivity.this, ErrorActivity.class);
                                                        intent.putExtra("position", item.getResult().getList().get(position).getExplainText());
                                                        startActivity(intent);
                                                    }
                                                    break;
                                            }
                                        }
                                    });


                                    return convertView;
                                }
                            });
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initView() {
        lv_main = (ListView) findViewById(R.id.lv_main);
        tvtime = (TextView) findViewById(R.id.tvtime);

        btnjiaojuan = (Button) findViewById(R.id.btnjiaojuan);
        btnjiaojuan.setOnClickListener(this);
        ll1 = (LinearLayout) findViewById(R.id.ll1);
        ll1.setOnClickListener(this);
        tvnum = (TextView) findViewById(R.id.tvnum);
        tvnum.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(this);
        img_pic = (ImageView) findViewById(R.id.img_pic);
        img_pic.setOnClickListener(this);
        rb_a = (RadioButton) findViewById(R.id.rb_a);
        rb_a.setOnClickListener(this);
        rb_b = (RadioButton) findViewById(R.id.rb_b);
        rb_b.setOnClickListener(this);
        rb_c = (RadioButton) findViewById(R.id.rb_c);
        rb_c.setOnClickListener(this);
        rb_d = (RadioButton) findViewById(R.id.rb_d);
        rb_d.setOnClickListener(this);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnClickListener(this);
        tvdaan = (TextView) findViewById(R.id.tvdaan);
        tvdaan.setOnClickListener(this);
        tvjiexi = (TextView) findViewById(R.id.tvjiexi);
        tvjiexi.setOnClickListener(this);
        ll2 = (LinearLayout) findViewById(R.id.ll2);
        ll2.setOnClickListener(this);
        img_fanhui = (ImageView) findViewById(R.id.img_fanhui);
        img_fanhui.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnjiaojuan:

                break;
        }
    }
}
