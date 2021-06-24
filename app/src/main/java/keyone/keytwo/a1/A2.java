package keyone.keytwo.a1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class A2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "Первый запуск!";
        } else {
            instanceState = "Повторный запуск!";
        }
        getIntent().getStringExtra("message");
        Log.d("intent",getIntent().getStringExtra("message"));
        ((TextView)findViewById(R.id.textView)).setText(getIntent().getStringExtra("message"));


        (findViewById(R.id.button)).setOnClickListener(v -> {
            Intent intentAnswer = new Intent();
            intentAnswer.putExtra("answer"," Andrej");
            setResult(A1.requestCodeLogin,intentAnswer);
            finish();
        });

        (findViewById(R.id.buttonBD)).setOnClickListener(v -> {
            Intent intentAnswer = new Intent();
            intentAnswer.putExtra("answer"," 01.01.2000");
            setResult(A1.requestCodeBD,intentAnswer);
            finish();
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
        Log.d("onStart()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(), "Повторный запуск!! - onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
        Log.d("Повторный запуск!! - onRestoreInstanceState()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
        Log.d("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
        Log.d("onPause()");
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
        Log.d("onSaveInstanceState()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
        Log.d("onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
        Log.d("onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
        Log.d("onDestroy()");
    }

}