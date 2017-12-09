package july.com.tempdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 *Task是Android Framework中的一个概念，Task是由一系列相关的Activity组成的，是一组相关Activity的集合。Task是以栈的形式来管理的
 * http://blog.csdn.net/zhangjg_blog/article/details/10923643
 * activity 四种启动模式：standard，singleTop，singleTask，singleInstance，后三种重用实例时都会走onNewIntent
 *
 * activity 在设置了singleTask时，如果设置了taskAffinity，则优先查找taskAffinity相同的task栈；
 * 否则谁启动activity，activity就在谁所在的task里
 *
 *
 // 清除目标Activity上方的Activity(如果目标activity是standard的启动模式且启动时intent里没有设置FLAG_ACTIVITY_SINGLE_TOP这个flag，那么栈里的目标activity也会被finish掉，重新创建一个实例)
 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
 // 如果目标activity是非standard的启动模式或者启动时设置了FLAG_ACTIVITY_SINGLE_TOP flag，就不会清除目标Activity(防止页面闪一下)
 intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

 仅仅通过intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);启动的activity即使task里已经有实例了，依然会在栈顶创建一个新的实例

 仅仅通过intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);这两行代码来启动的activity，如果栈里已有activity的实例，那么清空此activity及其以上的activites，然后新建一个实例

 仅仅通过intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);能够达到跟singleTask启动模式的效果，如果栈里已有实例，则清空其上的activies，然后走onNewIntent

 仅仅通过intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);能够实现singleTop启动模式的效果

 singleTop启动模式 仅仅在当前栈里判断实例是否处于栈顶,在栈顶就复用，否则新建一个实例

 singleInstance启动模式 整个系统只有一个实例，独占一个栈，且由它启动的activity根据其taskAffinity来选择进哪个task,若不存在对应的task，则新建一个task并新建一个实例入栈
 *
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,SecondActivity.class));
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
//                intent.setAction("com.test.july");
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        Log.e("vivi","MainActivity111 onCreate,taskid = "+ getTaskId());
    }

}
