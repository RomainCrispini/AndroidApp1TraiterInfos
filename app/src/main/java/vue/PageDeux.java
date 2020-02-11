package vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.romain.app1.R;
import controleur.Controleur;

public class PageDeux extends AppCompatActivity {

    private TextView myWelcomeText;
    private Controleur monControleur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        this.monControleur = Controleur.getMonInstance();
        myWelcomeText = (TextView) findViewById(R.id.idWelcomeText);

        // ????????????????????????????????????? String strToDisplay = getString(R.id.idWelcomeText);
        //if (monControleur.getMaPersonne().getiSexePersonne() == 1)
        //    strToDisplay += " Monsieur " + monControleur.getMaPersonne().getStrNomPersonne();
        //else
        //    strToDisplay += " Madame " + monControleur.getMaPersonne().getStrNomPersonne();
       // myWelcomeText.setText(strToDisplay);
        //listenBackButton();

    }


    private void listenBackButton(){
        Button clickButton = (Button) findViewById(R.id.idBtnRetour);
        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageDeux.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}

