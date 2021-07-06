package fr.velupsa.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    // Attribut qui permet de récupérer l'id du layout ImageView de image est l'associe à la classe MainActivity
    //
    /*private ImageView play;*/


    // attribut qui permet de récupérer le layout (activity_main3) depuis MainActivity afin de
    // de le stocker dans une variable (myLayout)
    private LinearLayout myLayout;

    private MainActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // on récupère le constructeur de la class dont on hérite
        // en l'occurrence ici "AppCompatActivity" (ça passe les infos d'une
        // classe à une autre)
        super.onCreate(savedInstanceState);
        // permets d'afficher le design de l'application, la vue par défaut
        setContentView(R.layout.activity_main3);

        // on récupère l'élément depuis l'attribut myLayout (this.myLayout)
        // ensuite avec findViewById() on récupère la vue qui a pour identifiant LinearLayout
        this.myLayout = (LinearLayout) findViewById(R.id.myDynamicLayout);

        this.activity = this;

        // Ajouter une image de manière dynamique (dans le code Java directement)
        // context = dans ce cas cela va être une instance de notre activité courante (ciblée à
        // à l'aide du mot-clé "this"
        ImageView image = new ImageView(this);
        ViewGroup.LayoutParams params = new ActionBar.LayoutParams(100, 100);
        image.setLayoutParams(params);
        // définir la source de l'image, à quel endroit elle se trouve
        image.setBackgroundResource(R.drawable.eric);
        // ajouter l'image au LinearLayout en ajouter une nouvelle vue (avec addView)
        myLayout.addView(image);

        // Ajouter un texte de manière dynamique (dans le code Java directement)
        TextView text = new TextView(this);
        text.setText(getResources().getString(R.string.dynamicText));
        text.setTextColor(getResources().getColor(R.color.colorRed));
        text.setTextSize(25);
        myLayout.addView(text);

        // boucle qui va générer dynamiquement un certain nombre de boutons et à chaque itérations
        // de boucle, le bouton aura une taille un peu plus grande
        // 2ème partir de la boucle : afficher via myPopup des messages sur des nouvelles fenêtres
        // lorsque l'utlisateur clique sur les boutons

        int textSize = 10;

        for (int i = 0; i < 6; i++){

            Button button = new Button(this);
            button.setText("Button" + i);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // on intègre ce code ici afin de générer la popup
                    //  instanciation/création du nouvel objet custompopup
                    CustomPopup customPopup = new CustomPopup(activity);
                    customPopup.setTitle("Bonne année 2021");
                    customPopup.setSubTitle("Abonnez vous à Borat");
                    customPopup.getYesButton().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getApplicationContext(), "OUI",Toast.LENGTH_SHORT).show();
                            customPopup.dismiss();
                        }
                    });
                    customPopup.getNoButton().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            customPopup.dismiss();
                        }
                    });
                    customPopup.build();
                }
            });
            button.setTextSize(textSize);
            myLayout.addView(button);
            textSize += 5;
        }



        /*AlertDialog.Builder myPopup = new AlertDialog.Builder(activity);
        myPopup.setTitle("Salut!");
        myPopup.setMessage("Salut les gens c'est veloup, bonne année les kheys");
        myPopup.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Vous avez cliqué sur OUI", Toast.LENGTH_SHORT).show();
            }
        });

        myPopup.setNegativeButton("NON", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity, "Vous n'êtes pas d'accord !", Toast.LENGTH_SHORT).show();
            }
        });

        // pour l'affichage
        myPopup.show();*/



        // On cast avec "(ImageView)" car findViewById() retour une View (Vue)
        /*this.play = (ImageView) findViewById(R.id.play);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent -> c'est ce qui va nous permettre de démarrer des actions et d'effectuer
                // des nouvelles instructions/actions par exemple créer une nouvelle activité/ faire
                // un appel sur tél etc...
                Intent otherActivity = new Intent(getApplicationContext(), CookieActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });*/

    }
}