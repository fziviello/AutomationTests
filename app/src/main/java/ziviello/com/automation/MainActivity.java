package ziviello.com.automation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);

        final ImageView img1 = (ImageView) findViewById(R.id.img1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Foto Caricata", Toast.LENGTH_SHORT).show();
                Log.i("APP", "Click sul BTN_1");

                img1.setBackgroundResource(R.drawable.ic_launcher_background);


            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Foto Eliminata", Toast.LENGTH_SHORT).show();
                Log.i("APP","Click sul BTN_2");
                img1.setBackgroundResource(0);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("APP","Click sul BTN_3");

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://rw";
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(MainActivity.this, response.substring(0,500), Toast.LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this, "Errore Chiamata HTTP", Toast.LENGTH_SHORT).show();
                        Log.e("ErroreHttp:", String.valueOf(error));
                    }
                });

                queue.add(stringRequest);
            }

            });

    }


}
