package com.example.rm30966.olimpiadas;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

public class HomeActivity extends AppCompatActivity{

    private Spinner spEsportes;
    private RadioGroup rgHorarios;
    private EditText edtNome, edtIdade;
    private TextView edtNomeD, edtIdadeD,edtModalidadeD, edtHorarioD;
    private AlertDialog.Builder builder;
    private Dialog confirmar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        edtNome = (EditText) findViewById(R.id.edNome);
        edtIdade = (EditText) findViewById(R.id.edIdade);

        rgHorarios = (RadioGroup) findViewById(R.id.rdgHorarios);

        spEsportes = (Spinner) findViewById(R.id.spModalidades);

        List<Modalidade> esportes = ModalidadeDAO.listar();
        ListAdapter adapter = new ArrayAdapter<Modalidade>(this, android.R.layout.simple_dropdown_item_1line, esportes);
        spEsportes.setAdapter((SpinnerAdapter) adapter);
    }

    public void reservar(View v)
    {
        confirmar = new Dialog(this);
        confirmar.setContentView(R.layout.dialog);

        edtNomeD = (TextView) confirmar.findViewById(R.id.edtNomeD);
        edtIdadeD = (TextView) confirmar.findViewById(R.id.edtIdadeD);
        edtHorarioD = (TextView) confirmar.findViewById(R.id.edtHorarioD);
        edtModalidadeD = (TextView) confirmar.findViewById(R.id.edtModalidadeD);

        edtNomeD.setText(edtNome.getText());
        edtIdadeD.setText(edtIdade.getText());

        int idSelecionado = rgHorarios.getCheckedRadioButtonId();
        RadioButton rbSelecionado = (RadioButton) findViewById(idSelecionado);
        edtHorarioD.setText(rbSelecionado.getText());

        edtModalidadeD.setText(spEsportes.getSelectedItem().toString());

        confirmar.show();
    }

    public void confirmaD(View v)
    {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmação");
        builder.setCancelable(true);
        builder.setNeutralButton("OK",  new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                confirmar.dismiss();
                edtIdade.setText("");
                edtNome.setText("");
                edtNome.requestFocus();
            }
        });

        builder.show();
    }

}
