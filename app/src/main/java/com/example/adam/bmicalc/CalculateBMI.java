package com.example.adam.bmicalc;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalculateBMI extends AppCompatActivity {
    @BindView(R.id.etKilogramsInput)
    EditText KilogramsInput;
    @BindView(R.id.etMetersInput)
    EditText MetersInput;
    @BindView(R.id.btCalculate)
    Button Calculate;
    @BindView(R.id.tvBMINumOutput)
    TextView BMINumOutput;
    @BindView(R.id.tvBMITextOutput)
    TextView BMITextOutput;
    @BindView(R.id.BMIInfo)
    TextView BMIInfo;
    @BindView(R.id.ivBodyType)
    ImageView BodyType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btCalculate)
    public void BMI() {
        String BMIdesc;
        float heigth = Float.parseFloat(MetersInput.getText().toString());
        float weigth = Float.parseFloat(KilogramsInput.getText().toString());
        float bmi = weigth/(heigth*heigth);
        String yourBMI = Float.toString(bmi);
        if(bmi<=18.5){
            BMITextOutput.setText(R.string.Underweight);
            BMIInfo.setText(R.string.UnderweightDesc);
            Drawable drawable = getResources().getDrawable(R.drawable.underweight);
            BodyType.setImageDrawable(drawable);

        }else if(bmi>18.5&&bmi<=25){
            BMITextOutput.setText(R.string.Normal);
            BMIInfo.setText(R.string.NormalDesc);
            Drawable drawable = getResources().getDrawable(R.drawable.normal);
            BodyType.setImageDrawable(drawable);

        }else if(bmi>25&&bmi<=30){
            BMITextOutput.setText(R.string.Overweight);
            BMIInfo.setText(R.string.OverweightDesc);
            Drawable drawable = getResources().getDrawable(R.drawable.overweight);
            BodyType.setImageDrawable(drawable);
        }else if(bmi>30){
            BMITextOutput.setText(R.string.Obese);
            BMIInfo.setText(R.string.ObeseInfo);
            Drawable drawable = getResources().getDrawable(R.drawable.obese);
            BodyType.setImageDrawable(drawable);
        }
        BMINumOutput.setText(yourBMI);
    }
}
