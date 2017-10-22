package com.gibsoncool.comefromscratch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.gibsoncool.comefromscratch.testData.Student;

import java.lang.reflect.Constructor;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.Class)
    Button btClass;
    @BindView(R.id.getClass)
    Button btGetClass;
    @BindView(R.id.forName)
    Button btClassForName;
    @BindView(R.id.show_detail)
    TextView tvDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.Class, R.id.getClass, R.id.forName})
    public void btnClick(Button btn) {
        Class<?> studentClass;
        Object instance = null;
        try {
            switch (btn.getId()) {
                case R.id.Class:
                    studentClass = Student.class;
                    Constructor<?> constructor = studentClass.getConstructor(String.class, int.class);
                    constructor.setAccessible(true);
                    instance = constructor.newInstance("from Class", 21);

                    break;
                case R.id.getClass:
                    studentClass = new Student("cxx", 23).getClass();
                    Constructor<?> constructor2 = studentClass.getConstructor(String.class, int.class);
                    instance = constructor2.newInstance("from getClass", 22);

                    break;
                case R.id.forName:
                    studentClass = Class.forName("com.gibsoncool.comefromscratch.testData.Student");
                    Constructor<?> constructor3 = studentClass.getConstructor(String.class, int.class);
                    instance = constructor3.newInstance("from Class.forName", 23);

                    break;
            }
        } catch (Exception e) {
            tvDetail.setText(e.toString());
        }
        tvDetail.setText(instance.toString());
    }

}
