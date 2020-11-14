package pje20.androidapp.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner mSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ((RadioButton)findViewById(R.id.sameday)).setChecked(true);

        mSpinner = (Spinner) findViewById(R.id.spinner_label);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.labels_array,R.layout.support_simple_spinner_dropdown_item);
        if (mSpinner!=null) {
            mSpinner.setOnItemSelectedListener(this);
            mSpinner.setAdapter(adapter);
        }

        Intent intent = getIntent();
        if (intent.getExtras() !=null)
            ((TextView)findViewById(R.id.order_textview)).setText(intent.getStringExtra(MainActivity.MESSAGE));

    }
    public void onRadioButtonClicked(View view){
        Boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.sameday :
                if (checked)
                    displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday :
                if (checked)
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup :
                if (checked)
                    displayToast(getString(R.string.pick_up));
                break;
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            displayToast(parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}