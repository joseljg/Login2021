package es.joseljg.loginusuario20_21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    public static final String EXTRA_OBJETO_USUARIO = "es.joseljg.registroActivity.objeto_usuario";
    private EditText edt_nombre = null;
    private EditText edt_direccion = null;
    private EditText edt_telefono = null;
    private EditText edt_email = null;
    private EditText edt_password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        edt_nombre = (EditText)findViewById(R.id.edt_nombre_registro);
        edt_direccion=(EditText)findViewById(R.id.edt_direccion_registro);
        edt_telefono=(EditText)findViewById(R.id.edt_telefono_registro);
        edt_email=(EditText)findViewById(R.id.edt_email_registro);
        edt_password=(EditText)findViewById(R.id.edt_password_registro);
    }


    public void registrar(View view) {
        boolean errores = false;
        String nombre = String.valueOf(edt_nombre.getText());
        String direccion = String.valueOf(edt_direccion.getText());
        String telefono = String.valueOf(edt_telefono.getText());
        String email = String.valueOf(edt_email.getText());
        String password = String.valueOf(edt_password.getText());
        // campos obligatorios del formulario de registro
        if(nombre.isEmpty()) {
            edt_nombre.setError("debes escribir un nombre");
            errores = true;
        }
        if(direccion.isEmpty())
        {
            edt_direccion.setError("debes escribir una direccion");
            errores = true;
        }
        if(telefono.isEmpty())
        {
            edt_telefono.setError("debes escribir una telefono");
            errores = true;
        }
        if(email.isEmpty())
        {
            edt_email.setError("debes escribir un email");
            errores = true;
        }
        if(password.isEmpty())
        {
            edt_password.setError("debes escribir un password");
            errores = true;
        }
        //-------------------------------------------------------------------
        if(errores == false)
        {
            Usuario u = new Usuario(nombre, direccion, telefono, email, password);
            Intent intent = new Intent(this,HomeActivity.class);
            intent.putExtra(EXTRA_OBJETO_USUARIO,u);
            startActivity(intent);
            Toast.makeText(this,"dado de alta correctamente " , Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(this," arregla los errores " , Toast.LENGTH_LONG).show();
        }

    }
}