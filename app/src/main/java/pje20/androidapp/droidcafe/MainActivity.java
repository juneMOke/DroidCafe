package pje20.androidapp.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView donutImage;
    ImageView iceCreamImage;
    ImageView froyoImage;
    public static String MESSAGE="MSG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donutImage = findViewById(R.id.donut);
        iceCreamImage = findViewById(R.id.ice_cream);
        froyoImage = findViewById(R.id.froyo);
        donutImage.setOnClickListener(this);
        iceCreamImage.setOnClickListener(this);
        froyoImage.setOnClickListener(this);
    }
    public void displayToast(String message){
        //Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,OrderActivity.class);
        intent.putExtra(MESSAGE,message);
        startActivity(intent);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.donut):
                displayToast(getString(R.string.donut_order_message));
                break;
            case (R.id.ice_cream):
                displayToast(getString(R.string.ice_cream_order_message));
                break;
            case (R.id.froyo):
                displayToast(getString(R.string.froyo_order_message));
                break;
        }
    }
}