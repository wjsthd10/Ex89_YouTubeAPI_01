package kr.co.song1126.ex89_youtubeapi_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class YouTubeShowActivity extends AppCompatActivity {

    TextView tv;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube_show);
        tv=findViewById(R.id.tv_list);
        et=findViewById(R.id.et_title);


    }

    public void clickBtn4(View view) {
        String key="AIzaSyDicI0tyC9xhhQ3-VyVVwl3zIvw3WPbbWw";
        String part="snippet";
        String query=et.getText().toString();
        int maxResult=10;

        Retrofit retrofit=RetrofitHelper.getInstance();
        RetrofitService retrofitService=retrofit.create(RetrofitService.class);

        Call<String> call=retrofitService.serchVideos(key,part,query,maxResult);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String data=response.body();
                tv.setText(data);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }
}
//todo 받아온 데이터들을 파싱해서 개별 뷰에 출력해보기  언제할거냐 너
