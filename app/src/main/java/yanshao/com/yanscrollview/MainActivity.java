package yanshao.com.yanscrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    YanScrollView yanscroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yanscroll= (YanScrollView) findViewById(R.id.yanscroll);
        yanscroll.setOnYanScrollViewListener(new YanScrollView.YanScrollViewListener() {
            @Override
            public void DownPullListener() {
                Toast.makeText(MainActivity.this,"===下啦==",Toast.LENGTH_LONG).show();
            }

            @Override
            public void UpPullListener() {
                Toast.makeText(MainActivity.this,"===上啦==",Toast.LENGTH_LONG).show();
            }
        });
    }
}
