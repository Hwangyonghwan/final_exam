package com.example.sm.problem2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyBaseAdapter adapter;
    ListView listview;
    String name;
    int age;
    int salary;
    ArrayList<Employee> emp_list = new ArrayList<Employee>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // need something here

        adapter = new MyBaseAdapter(this, emp_list);
        listview = (ListView) findViewById(R.id.listView1) ;
        listview.setAdapter(adapter);
        listview.setOnItemClickListener((AdapterView.OnItemClickListener)adapter);
    }
    @Override
    public void onClick(View v){
        EditText edit_name = (EditText) findViewById(R.id.edit_name);
        EditText edit_age = (EditText) findViewById(R.id.edit_age);
        EditText edit_salary = (EditText) findViewById(R.id.edit_salary);
        name = edit_name.getText().toString();
        age = Integer.parseInt(edit_age.getText().toString());
        salary = Integer.parseInt(edit_salary.getText().toString());
        Employee employee = new Employee(name, age, salary);

        switch (v.getId()){
            case R.id.btn_inc:
                employee.increase();
                edit_salary.setText(employee.getSalary());
                break;

            case R.id.btn_dec:
                employee.decrease();
                edit_salary.setText(employee.getSalary());
                break;

            case R.id.btn_store:
                emp_list.add(employee);
                break;

            case R.id.btn_modify:
                emp_list.remove(employee);
                break;

            case R.id.btn_delete:
                emp_list.remove(employee);
                break;
        }
    }
}

interface Payment {
    void increase();
    void decrease();
}



