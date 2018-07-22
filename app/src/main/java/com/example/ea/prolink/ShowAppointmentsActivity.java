package com.example.ea.prolink;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class ShowAppointmentsActivity extends AppCompatActivity {

    Button accepted,rejected,undefined;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_appointments);
        accepted = findViewById(R.id.accepted_appointments_btn);
        rejected = findViewById(R.id.rejected_appointments_btn);
        undefined = findViewById(R.id.undefined_appointments_btn);


        accepted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShowAppointmentsActivity.this,AcceptedAppointmentActivity.class));
            }
        });

        rejected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShowAppointmentsActivity.this,RejectedAppointmentActivity.class));

            }
        });
        undefined.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShowAppointmentsActivity.this,UndefinedAppointmentActivity.class));

            }
        });

    }


}
