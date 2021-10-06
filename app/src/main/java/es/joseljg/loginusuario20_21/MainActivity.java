package es.joseljg.loginusuario20_21;

import static android.content.Intent.EXTRA_EMAIL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_EMAIL1 = "es.joseljg.MainActivity.email";
    public static final String EXTRA_PASSWORD1 = "es.joseljg.MainActivity.password";
    EditText edt_email = null;
    EditText edt_password = null;
    String usuarioSecreto ="pepe@gmail.com";
    String claveSecreta ="1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_email = (EditText) findViewById(R.id.edt_email);
        edt_password = (EditText) findViewById(R.id.edt_password);
    }


    public void entrar(View view) {
      //  Button b = (Button) view;
      //  b.setText("prueba");
        String email = String.valueOf(edt_email.getText());
        String password = String.valueOf(edt_password.getText());
        boolean validadoOK = validar(email,password);
        if(validadoOK)
        {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra(EXTRA_EMAIL1, email);
            intent.putExtra(EXTRA_PASSWORD1, password);
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"error en el email o en el password",Toast.LENGTH_LONG).show();
        }
    }

    private boolean validar(String email, String password) {
        if(email.isEmpty())
        {
            edt_email.setError("debes poner un email");
            return false;
        }
        if(password.isEmpty())
        {
            edt_password.setError("debes escribir un password");
            return false;
        }
        if(email.equalsIgnoreCase(usuarioSecreto) && password.equals(claveSecreta))
        {
            return true;
        }
        return false;
    }
}