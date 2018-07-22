package com.example.ea.prolink;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

//import com.squareup.picasso.Picasso;

public class CourseActivity extends DrawerActivity {
    public String course_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_course);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        course_id = getIntent().getExtras().getString("courseID");
      /*  Intent newActivity = new Intent(getApplicationContext(), MaterialActivity.class);
        newActivity.putExtra("material_courseID", id);
        getApplicationContext().startActivity(newActivity);*/
        Toast.makeText(this, course_id,Toast.LENGTH_SHORT).show();
        //inflate your activity layout here!
        View contentView = inflater.inflate(R.layout.activity_course, null, false);
        mDrawerLayout.addView(contentView, 0);

    }


    public void materials(View view) {
        Intent materials = new Intent(CourseActivity.this,MaterialActivity.class);
        materials.putExtra("courseID", course_id);
        startActivity(materials);

    }

    public void grades(View view) {
        Intent grades = new Intent(CourseActivity.this,GradesActivity.class);
        grades.putExtra("courseID", course_id);
       startActivity(grades);


    }

    public void questions(View view) {
        Intent questions = new Intent(CourseActivity.this,QuestionsActivity.class);
        questions.putExtra("courseID", course_id);
        startActivity(questions);

    }

    public void assignments(View view) {
        Intent assignments = new Intent(CourseActivity.this,AssignmentsActivity.class);
        assignments.putExtra("courseID", course_id);
        startActivity(assignments);

    }
}
