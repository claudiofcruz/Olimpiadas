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
import android.widget.Toast;

import java.util.List;

public class HomeActivity extends AppCompatActivity{

    private Spinner spEsportes;
    private RadioGroup rgHorarios;
    private EditText edtNome, edtIdade;
    private TextView txtNomeD, txtIdadeD,txtModalidadeD, txtHorarioD;
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
        if(edtNome.getText().toString().equals("") || edtIdade.getText().toString().equals(""))
        {
            Toast tst = Toast.makeText(this,R.string.msgErroHome,Toast.LENGTH_LONG);
            edtNome.requestFocus();
        }
        else
        {
            confirmar = new Dialog(this);
            confirmar.setContentView(R.layout.dialog);

            txtNomeD = (TextView) confirmar.findViewById(R.id.edtNomeD);
            txtIdadeD = (TextView) confirmar.findViewById(R.id.edtIdadeD);
            txtHorarioD = (TextView) confirmar.findViewById(R.id.edtHorarioD);
            txtModalidadeD = (TextView) confirmar.findViewById(R.id.edtModalidadeD);

            txtNomeD.setText(edtNome.getText());
            txtIdadeD.setText(edtIdade.getText());

            int idSelecionado = rgHorarios.getCheckedRadioButtonId();
            RadioButton rbSelecionado = (RadioButton) findViewById(idSelecionado);
            txtHorarioD.setText(rbSelecionado.getText());

            txtModalidadeD.setText(spEsportes.getSelectedItem().toString());

            confirmar.show();
        }
    }

    public void confirmaD(View v)
    {
        builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.lbConfirmarD);
        builder.setCancelable(true);
        builder.setNeutralButton(R.string.lbOKD,  new DialogInterface.OnClickListener() {
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
