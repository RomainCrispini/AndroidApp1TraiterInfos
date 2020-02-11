package vue;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import controleur.Controleur;
import com.romain.app1.R;

public class MainActivity extends AppCompatActivity {

    private EditText txtNom;
    private TextView txtRes;
    private RadioButton rbSexe;
    private Controleur monControleur;
    private EditText iAge;
    private ImageView imgImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Méthode initialisation au chargement
        init();
    }

    private void init(){

        // Récupération de l'instance du controleur
        this.monControleur = Controleur.getMonInstance();


        txtNom = (EditText) findViewById(R.id.idNom);
        txtRes = (TextView) findViewById(R.id.idTexteBienvenue);
        rbSexe = (RadioButton) findViewById(R.id.idRBtnHomme);
        iAge = (EditText) findViewById(R.id.idAge);
        imgImage = (ImageView) findViewById(R.id.idImage);

        // Les images sont au chargement invisibles
        imgImage.setVisibility(View.INVISIBLE);

        // Instanciation du listener
        ecouterBtnTraiter();

    }

    private void ecouterBtnTraiter(){

        Button clickTraiter = (Button) findViewById(R.id.idBtnTraiter);
        clickTraiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 * Cacher le clavier
                 */
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                String lenom = txtNom.getText().toString();

                Integer lage = 0;

                imgImage.setVisibility(View.VISIBLE);

                try{
                    lage = Integer.parseInt(iAge.getText().toString());
                }catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(), "Veuillez entrer un entier", Toast.LENGTH_SHORT);
                    toast.show();
                }

                Integer sexe = 0;
                if(rbSexe.isChecked()){
                    sexe = 1;
                    txtRes.setText("Bonjour Monsieur " + txtNom.getText().toString() + "\nVous avez " + iAge.getText().toString() + " ans");
                    //imgImage.setVisibility(View.VISIBLE);
                    imgImage.setImageResource(R.drawable.imghomme);
                }else{
                    txtRes.setText("Bonjour Madame " + txtNom.getText().toString() + "\nVous avez " + iAge.getText().toString() + " ans");
                    //imgImage.setVisibility(View.VISIBLE);
                    imgImage.setImageResource(R.drawable.imgfemme);
                }
                affichage(sexe, lenom, lage);
                //gotoSecondActivityWithTimer();
            }
        });



    }

    public void affichage(Integer iSexe, String strNom, Integer iAge){
        this.monControleur.creerPersonne(iSexe, strNom, iAge);
        //txtRes.setText("Bienvenue Monsieur " + txtNom.getText().toString());
        // txtRes.setText(monControleur.getMaPersonne().getStrMessage());
    }

    public void gotoSecondActivityWithTimer() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // do something
                Intent intent = new Intent(MainActivity.this, PageDeux.class);
                // If you just use this that is not a valid context. Use ActivityName.this
                startActivity(intent);
            }
        }, 2000);
    }


}
