package pl.zabrze.zs10.bazadanych4p;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private Button buttonDodaj;
    private EditText editTextSlowo;
    private SlowaDatabase slowaDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonDodaj = findViewById(R.id.button);
        editTextSlowo = findViewById(R.id.editTextTextPersonName);

        RoomDatabase.Callback mojCallback = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        };
        slowaDatabase = Room.databaseBuilder(getApplicationContext(),
                SlowaDatabase.class,
                "SlowaDB").addCallback(mojCallback)
                .allowMainThreadQueries()
                .build();


        buttonDodaj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nazwaSlowa = editTextSlowo.getText().toString();
                        Slowo slowo = new Slowo(nazwaSlowa);
                        dodajSlowoDoBazyWTle(slowo);
                    }
                }
        );

    }
    private void dodajSlowoDoBazyWTle(Slowo slowo){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        //w trakcie
                        /*slowaDatabase.getSlowaDAO().dodajSlowo(new Slowo("informatyk"));
                        slowaDatabase.getSlowaDAO().dodajSlowo(new Slowo("elektronik"));
                        slowaDatabase.getSlowaDAO().dodajSlowo(new Slowo("matematyka"));
                        slowaDatabase.getSlowaDAO().dodajSlowo(new Slowo("matura"));
                        slowaDatabase.getSlowaDAO().dodajSlowo(new Slowo("egzamin"));
                                                                         */
                        slowaDatabase.getSlowaDAO().dodajSlowo(slowo);
                        //po zrobieniu
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "dodano "+slowo+" do bazy", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
        );
    }
}