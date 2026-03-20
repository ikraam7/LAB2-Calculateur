package com.example.calculateur;

import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Déclaration des champs de saisie
    private EditText fieldSurface, fieldPieces;

    // Checkbox pour piscine
    private CheckBox checkPiscine;

    // TextView pour afficher les résultats
    private TextView textBase, textSupp, textTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liaison entre XML et Java
        fieldSurface = findViewById(R.id.field_surface);
        fieldPieces = findViewById(R.id.field_pieces);
        checkPiscine = findViewById(R.id.check_piscine);

        textBase = findViewById(R.id.text_base);
        textSupp = findViewById(R.id.text_supp);
        textTotal = findViewById(R.id.text_total);

        Button btn = findViewById(R.id.btn_calcul);

        // Action lors du clic sur le bouton
        btn.setOnClickListener(v -> calculer());
    }

    // Méthode de calcul des impôts
    private void calculer() {

        // Vérifier si les champs sont vides
        if (fieldSurface.getText().toString().isEmpty() ||
                fieldPieces.getText().toString().isEmpty()) {

            Toast.makeText(this, "Remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        // Récupération des valeurs saisies
        double surface = Double.parseDouble(fieldSurface.getText().toString());
        int pieces = Integer.parseInt(fieldPieces.getText().toString());

        // Vérifier si la piscine est cochée
        boolean piscine = checkPiscine.isChecked();

        // Calcul de l'impôt de base
        double impotBase = surface * 2;

        // Calcul du supplément
        double supplement = pieces * 50 + (piscine ? 100 : 0);

        // Calcul du total
        double total = impotBase + supplement;

        // Affichage des résultats
        textBase.setText("Impôt de base : " + impotBase);
        textSupp.setText("impôt supplémentaire : " + supplement);
        textTotal.setText("impôt Total : " + total);
    }


}