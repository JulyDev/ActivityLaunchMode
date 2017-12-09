package july.com.tempdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

/**
 * Created by vivili on 2017/12/6.
 */

public class ThirdActivity extends Activity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        findViewById(R.id.tv3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(ThirdActivity.this,SecondActivity.class));
                Intent intent = new Intent(ThirdActivity.this,SecondActivity.class);
//                intent.setAction("com.test.july");
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        Log.e("vivi","ThirdActivity333 onCreate,taskid = "+ getTaskId());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("vivi","ThirdActivity333 onNewIntent,taskid = "+ getTaskId());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
