package fr.velupsa.myfirstapp;

import android.app.Activity;
import android.app.Dialog;
import android.widget.Button;
import android.widget.TextView;

// class/objet qui permet de créer des popup personnalisable

public class CustomPopup extends Dialog {

    // attributs qui vont caractériser ce qu'est une popup
    // nécessaire à la construction de l'objet "CustomPopup"
    private String title;
    private String subTitle;
    private Button yesButton, noButton;
    private TextView titleView, subTitleView;

    // constructor
    // va permettre lorsque l'on va instancier le nouvel objet CustomPopup de créer tous
    // les éléments nécessaire

    public CustomPopup (Activity activity) {

        // faire appel au constructeur de "Dialog"
        super(activity, R.style.Theme_AppCompat_DayNight_Dialog);
        setContentView(R.layout.my_popup_template);

        //pour instancier/initialiser chacun des objets de la custom popup
        this.title = "Mon titre";
        this.subTitle = "Mon super sous-titre";
        this.yesButton = findViewById(R.id.yesButton);
        this.noButton = findViewById(R.id.noButton);
        this.titleView = findViewById(R.id.title);
        this.subTitleView = findViewById(R.id.subTitle);
    }

    public void setTitle(String title){ this.title = title; }

    public void setSubTitle(String subTitle) { this.subTitle = subTitle; }

    public Button getYesButton() { return yesButton; }

    public Button getNoButton() { return noButton; }


    // méthode qui permet de construire l'objet popup à partir des méthodes précèdentes
    public void build(){
        // afficher la popup (appartient à l'objet Dialog)
        show();
        titleView.setText(title);
        subTitleView.setText(subTitle);

    }

}
