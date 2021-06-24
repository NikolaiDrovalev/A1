package keyone.keytwo.a1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.TextView;
import android.widget.Toast;

public class A1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "Первый запуск!";
        } else {
            instanceState = "Повторный запуск!";
        }
        Log.d(instanceState + " - onCreate()");
        (findViewById(R.id.button)).setOnClickListener(v -> {
            Intent intent = new Intent(this,A2.class);
            intent.putExtra("message","Привет, А2");
            //this.startActivity(intent);
            this.startActivityForResult(intent,requestCodeLogin);
        });

        (findViewById(R.id.buttonBD)).setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        });

        Log.d("mime",MimeTypeMap.getSingleton().getMimeTypeFromExtension("png"));
        Log.d("mime",MimeTypeMap.getSingleton().getMimeTypeFromExtension("jpg"));
        Log.d("mime",MimeTypeMap.getSingleton().getMimeTypeFromExtension("mp3"));
        Log.d("mime",MimeTypeMap.getSingleton().getMimeTypeFromExtension("avi"));
        Log.d("mime",MimeTypeMap.getSingleton().getMimeTypeFromExtension("tif"));
        Log.d("mime",MimeTypeMap.getSingleton().getMimeTypeFromExtension("svg"));
        Log.d("mime",MimeTypeMap.getSingleton().getMimeTypeFromExtension("zip"));
    }
    public static final int requestCodeLogin = 99;//запрос сделать изменить логин
    public static final int requestCodeBD = 98;//запрос сделать изменить дату рождкения

    @Override
    protected void onActivityResult(int requestCodeAnswer, int resultCode, Intent data) {
        super.onActivityResult(requestCodeLogin, resultCode, data);
        if(requestCodeAnswer==requestCodeLogin){
            ((TextView)findViewById(R.id.textView)).setText("логин изменен на"+data.getStringExtra("answer"));
        }else if(requestCodeAnswer==requestCodeBD){
            ((TextView)findViewById(R.id.textView)).setText("Дата рождения изменена на"+data.getStringExtra("answer"));
        }

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
