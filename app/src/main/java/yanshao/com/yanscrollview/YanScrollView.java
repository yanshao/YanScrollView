package yanshao.com.yanscrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created  on 2016/9/6 0006.
 * Wang丶Yan
 */
public class YanScrollView extends ScrollView {
    int  isScrolledToTop=0;
    int  starY = 0,moveY=0;
    public YanScrollView(Context context) {
        super(context);
    }

    public YanScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public YanScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        View contentView = getChildAt(0);
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                starY=(int)ev.getRawY();
                Log.e("yanshao","starY="+starY+"，getScrollY()="+getScrollY());

                break;
            case MotionEvent.ACTION_UP:
                this.setPadding(0,0,0,0);
                if (isScrolledToTop==0&&this.getScrollY()==0){
             if (yanScrollViewListener!=null){
                 yanScrollViewListener.DownPullListener();
                }
                }else if(isScrolledToTop==1&&contentView.getMeasuredHeight() <= getScrollY() + getHeight()){
                    if (yanScrollViewListener!=null){
                        yanScrollViewListener.UpPullListener();
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:


                moveY=(int)ev.getRawY(); Log.e("yanshao","moveY="+moveY+"，getScrollY()="+getScrollY());
                Log.e("yanshao","moveY-starY="+(moveY-starY));
                if (this.getScrollY()==0&&moveY-starY>0){
                    Log.e("yanshao","====================xia======================");isScrolledToTop=0;

                    this.setPadding(0,Math.abs(moveY-starY),0,0);
                }else if (contentView.getMeasuredHeight() <= getScrollY() + getHeight()&&moveY-starY<0){
                    isScrolledToTop=1;
                    this.setPadding(0,0,0,Math.abs(moveY-starY));
                }else{
                    isScrolledToTop=2;
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    public  static  YanScrollViewListener yanScrollViewListener;
    public void setOnYanScrollViewListener(YanScrollViewListener ScrollViewListener){
        yanScrollViewListener=ScrollViewListener;
    }

public   interface  YanScrollViewListener{
        void   DownPullListener();
            void   UpPullListener();
    }

}
