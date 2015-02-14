package ryanspenser.simpleui;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.os.Build;


public class MainActivity extends ActionBarActivity {
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        context=this;


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements OnClickListener {
        private View rootView;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            Button button1 = (Button)rootView.findViewById(R.id.button1);
            Button button2 = (Button)rootView.findViewById(R.id.button2);
            Button button3 = (Button)rootView.findViewById(R.id.button3);
            button1.setOnClickListener(this);
            button2.setOnClickListener(this);
            button3.setOnClickListener(this);

            return rootView;

        }
        /**
         *
         * @param src is View was clicked
          */
        public void onClick(View src){
            switch (src.getId()){
                case R.id.button1:
                    /*TextView tv1 = (TextView) rootView.findViewById(R.id.tv1);
                    tv1.setText("");
                    EditText ed = (EditText) rootView.findViewById(R.id.etb1);
                    tv1.setText(ed.getText());*/
                    Toast.makeText(context, "TextViews Updated", Toast.LENGTH_LONG).show();
                    break;
                case R.id.button2:
                    /*TextView tv3 = (TextView) rootView.findViewById(R.id.tv1);
                    TextView tv4 = (TextView) rootView.findViewById(R.id.tv2);
                    tv3.setText("");
                    tv4.setText("");*/
                    Toast.makeText(context, "TextViews Cleared", Toast.LENGTH_LONG).show();
                    break;
                case R.id.button3:
                    /*EditText ed1 = (EditText) rootView.findViewById(R.id.etb1);
                    TextView tv6 = (TextView) rootView.findViewById(R.id.tv2);
                    tv6.setText("");
                    tv6.setText(ed1.getText());*/
                    Toast.makeText(context, "TextViews Updated", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

}
