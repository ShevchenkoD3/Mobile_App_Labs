package a.event_handling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.GestureDetector;
import androidx.core.view.GestureDetectorCompat;

import static android.view.View.VISIBLE;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private TextView gestureText;
    private Button button;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private ConstraintLayout myLayout;
    private GestureDetectorCompat gDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureText = findViewById(R.id.gestureText);
        myLayout = findViewById(R.id.activity_main);
        button = findViewById(R.id.button);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        this.gDetector = new GestureDetectorCompat(this, this);
        gDetector.setOnDoubleTapListener(this);

        gestureText.setEnabled(false);
        gestureText.setVisibility(View.INVISIBLE);

        textView2.setEnabled(false);
        textView3.setEnabled(false);

        textView2.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText("Button clicked");
            }
        });
        button.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                textView1.setText("Long button click");
                return true;
            }
        });

    }
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        this.gDetector.onTouchEvent(e);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(e);
    }
       @Override
      public boolean onCreateOptionsMenu(Menu menu) {

           getMenuInflater().inflate(R.menu.main_menu, menu);
           return true;
       }

       @Override
       public boolean onOptionsItemSelected(MenuItem item){
           int id = item.getItemId();
           switch (id)
           {
               case R.id.item1:
                   gestureText.setEnabled(false);
                   gestureText.setVisibility(View.INVISIBLE);
                   button.setEnabled(true);
                   button.setVisibility(VISIBLE);
                   textView1.setEnabled(true);
                   textView1.setVisibility(VISIBLE);
                   textView2.setEnabled(false);
                   textView3.setEnabled(false);
                   textView2.setVisibility(View.INVISIBLE);
                   textView3.setVisibility(View.INVISIBLE);
                   break;
               case R.id.item2:
                   gestureText.setEnabled(false);
                   gestureText.setVisibility(View.INVISIBLE);
                   button.setEnabled(false);
                   button.setVisibility(View.INVISIBLE);
                   textView1.setEnabled(false);
                   textView1.setVisibility(View.INVISIBLE);
                   textView2.setEnabled(true);
                   textView3.setEnabled(true);
                   textView2.setVisibility(VISIBLE);
                   textView3.setVisibility(VISIBLE);
                   myLayout.setOnTouchListener(new ConstraintLayout.OnTouchListener() {
                       public boolean onTouch(View v, MotionEvent m) {
                           handleTouch(m);
                           return true;
                       }
                   });
                   break;
               case R.id.item3:
                   gestureText.setEnabled(true);
                   gestureText.setVisibility(VISIBLE);
                   button.setEnabled(false);
                   button.setVisibility(View.INVISIBLE);
                   textView1.setEnabled(false);
                   textView1.setVisibility(View.INVISIBLE);
                   textView2.setEnabled(false);
                   textView3.setEnabled(false);
                   textView2.setVisibility(View.INVISIBLE);
                   textView3.setVisibility(View.INVISIBLE);
                   myLayout.setOnTouchListener(new ConstraintLayout.OnTouchListener() {
                       public boolean onTouch(View v, MotionEvent m) {
                           handleTouch(m);
                           return false;
                       }
                   });
                   break;
           }
           return super.onOptionsItemSelected(item);
       }

     void handleTouch(MotionEvent m) {

         int pointerCount = m.getPointerCount();

         for (int i = 0; i < pointerCount; i++)
         {
             int x = (int) m.getX(i);
             int y = (int) m.getY(i);
             int id = m.getPointerId(i);
             int action = m.getActionMasked();
             int actionIndex = m.getActionIndex();
             String actionString;


             switch (action)
             {
                 case MotionEvent.ACTION_DOWN:
                     actionString = "DOWN";
                     break;
                 case MotionEvent.ACTION_UP:
                     actionString = "UP";
                     break;
                 case MotionEvent.ACTION_POINTER_DOWN:
                     actionString = "PNTR DOWN";
                     break;
                 case MotionEvent.ACTION_POINTER_UP:
                     actionString = "PNTR UP";
                     break;
                 case MotionEvent.ACTION_MOVE:
                     actionString = "MOVE";
                     break;
                 default:
                     actionString = "";
             }

             String touchStatus = "Action: " + actionString + " Index: " +
                     actionIndex + " ID: " + id + " X: " + x + " Y: " + y;
             if (id == 0)
                 textView2.setText(touchStatus);
             else
                 textView3.setText(touchStatus);
         }
     }


    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        gestureText.setText("onSingleTapConfirmed");
        return true;

    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        gestureText.setText("onDoubleTap");
        return true;

    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        gestureText.setText("onDoubleTapEvent");
        return true;

    }

    @Override
    public boolean onDown(MotionEvent e) {
        gestureText.setText ("onDown");
        return true;

    }

    @Override
    public void onShowPress(MotionEvent e) {
        gestureText.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        gestureText.setText("onSingleTapUp");
        return true;

    }
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        gestureText.setText("onScroll");
        return true;

    }

    @Override
    public void onLongPress(MotionEvent e) {
        gestureText.setText("onLongPress");
    }
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        gestureText.setText("onFling");
        return true;
    }
}