package sg.edu.rp.c346.id22011555.l04_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText mobile;
    EditText table;

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView Datedisplay;
    TextView Timedisplay;

    TextView tabletype;

    RadioGroup smoke;

    Button btnReset;
    Button btnConfirm;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp=findViewById(R.id.datePicker);
        tp=findViewById(R.id.timePicker);
        btnDisplayDate=findViewById(R.id.ButtonDisplayDate);
        btnDisplayTime=findViewById(R.id.buttonDisplayTime);
        Datedisplay=findViewById(R.id.DateDisplay);
        Timedisplay=findViewById(R.id.TimeDisplay);
        btnReset = findViewById(R.id.togglereset);
        btnConfirm=findViewById(R.id.toggleconfirmation);
        name=findViewById(R.id.Editname);
        mobile=findViewById(R.id.MobileEdit);
        table=findViewById(R.id.TableEdit);
        smoke=findViewById(R.id.RadioGroupsmoke);
        tabletype=findViewById(R.id.TabletypeView);

        smoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tablechoice = tabletype.getText().toString();
                int checkedRadioId = smoke.getCheckedRadioButtonId();
                if (checkedRadioId == R.id.Smoking) {
                    tablechoice = "Smoking";
                } else if (checkedRadioId == R.id.NonSmoking){
                    tablechoice = "Non Smoking";
                }
                tabletype.setText(tablechoice);
            }
        });




        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour=tp.getHour();
                int minute=tp.getMinute();
                String time=Timedisplay.getText().toString();
                if (minute <10)
                    time= "Time is "+hour+":"+String.format("%02d", minute);
                else{
                    time="Time is "+hour+":"+minute;
                }
                Timedisplay.setText(time);


            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day=dp.getDayOfMonth();
                int month=dp.getMonth()+1;
                int year=dp.getYear();
                String DOY=Datedisplay.getText().toString();

                DOY="Date is "+ day+ "/"+month+"/"+year;

                Datedisplay.setText(DOY);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setHour(7);
                tp.setMinute(30);
                String DOY=Datedisplay.getText().toString();
                dp.updateDate(2020, (1-1),06);

            }
        });


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reservationorder= "Name: "+ name.getText()+ "Mobile: "+ mobile.getText()+ "Tables: "+ table.getText()+ "Date" +Datedisplay.getText().toString()+"Time: "+Timedisplay.getText().toString()+ "Option: "+tabletype.getText().toString();
                Toast.makeText(MainActivity.this,reservationorder, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
