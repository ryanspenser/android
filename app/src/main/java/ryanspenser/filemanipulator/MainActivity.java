package ryanspenser.filemanipulator;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Context context = this;
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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
    public static class PlaceholderFragment extends Fragment implements OnClickListener{
    View rootView;
        //private String file = "myFile.txt";
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            rootView = inflater.inflate(R.layout.fragment_main, container, false);
            Button button1 = (Button) rootView.findViewById(R.id.button);
            Button button2 = (Button) rootView.findViewById(R.id.button2);
            Button button3 = (Button) rootView.findViewById(R.id.button3);
            button1.setOnClickListener(this);
            button2.setOnClickListener(this);
            button3.setOnClickListener(this);
            return rootView;
        }
        public void onClick(View src) {
            switch (src.getId()) {
                case R.id.button2: //Write Button
                    File file = new File(Environment.getDataDirectory().getPath() + "/test.txt");
                    if(!file.exists())
                    {
                        try {
                            file.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    EditText et = (EditText) rootView.findViewById(R.id.editText);
                    BufferedWriter bf = null;
                    try {
                        FileOutputStream fOut;
                        fOut = getActivity().openFileOutput(String.valueOf(file), Context.MODE_PRIVATE);
                        bf = new BufferedWriter(new OutputStreamWriter(fOut));
                        String text = et.getText().toString();
                        bf.write(text);
                        //fOut.write(text.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            bf.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case R.id.button: //Read Button
                    file = new File(Environment.getDataDirectory().getPath() + "/test.txt");
                    if(!file.exists())
                    {
                        try {
                            file.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    //String contents = "";
                    FileReader fr = null;
                    String line = "";
                    TextView tv = (TextView) rootView.findViewById(R.id.textView);
                    try {
                        //FileReader filereader = new FileReader(file);
                        //BufferedReader rbuf = new BufferedReader(filereader);
                        //contents = rbuf.readLine();
                        //FileInputStream fIn = getActivity().openFileInput(file);
                        //fIn.read();
                        fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);
                        line = br.readLine();
                        while (null != line) {
                            tv.append(line);
                            tv.append("\r\n");
                            line = br.readLine();
                            }
                        tv.setText(line);
                        }
                    catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    catch (IOException e) {
                            e.printStackTrace();
                        }
                    break;

                /*case R.id.button3: //Append Button
                    EditText et2 = (EditText) rootView.findViewById(R.id.editText);
                    String text2 = et2.getText().toString();
                    try {
                        File file = new File(Environment.getDataDirectory().getPath() + "/test.txt");
                        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(text2+ "\r\n");
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;*/
            }
        }
    }
}
