package kr.co.song1126.ex89_youtubeapi_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

public class MainActivity extends AppCompatActivity {

    //YouTubePlayerView는 반드시 YouTubeBaseActivity안에서만 보여진다.
    //YouTubeBaseActivity 이 androidx. 를 상속받아 사용한 것이 아니라 그냥 Activity를 상속 받은 것이다.=> androidx에 관련된 모든 작업이 불가능하다.()

    YouTubePlayerView youTubePlayerView;

    //YouTubePlayerFragment 를 사용하면 프레그먼트가 플레이어뷰를 제어하므로
    //YouTubeBaseActivity를 상속받아서 사용할 필요가 없다.
    YouTubePlayerFragment youTubePlayerFragment;
    YouTubePlayerFragment youTubePlayerFragment2;

    YouTubeThumbnailView thumbnailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Support버전을 관리하는 getSupportFragmentManger를 사용할 수 없음
        youTubePlayerFragment=(YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtubeFragment01);
        youTubePlayerFragment.initialize("first", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo("cQMkMl69t0M");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });

        youTubePlayerFragment2=(YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtubeFragment02);
        youTubePlayerFragment2.initialize("second", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("2a3MtMHZXps");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });


        thumbnailView=findViewById(R.id.thumbView);
        thumbnailView.initialize("third", new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
                youTubeThumbnailLoader.setVideo("lVyRe56WmaI");
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });

//        youTubePlayerView=findViewById(R.id.youtubeView);
//        youTubePlayerView.initialize("first", new YouTubePlayer.OnInitializedListener() {
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                youTubePlayer.cueVideo("cQMkMl69t0M");//유투브의 동영상 ID : 주소창에서 V의 뒤에 쓰여진 문자열
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//
//            }
//        });

    }

    public void clickBtn(View view) {
        startActivity(new Intent(this, YouTubeDataActivity.class));

    }

    public void clickBtn02(View view) {
        startActivity(new Intent(this, YouTubeShowActivity.class));
    }
}
