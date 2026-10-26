package cat.insmarianao

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doAfterTextChanged

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1 = findViewById<EditText>(R.id.numero1)
        val num2 = findViewById<EditText>(R.id.numero2)
        val checkSuma = findViewById<CheckBox>(R.id.checkSumar)
        val checkResta = findViewById<CheckBox>(R.id.checkRestar)
        val calcular = findViewById<Button>(R.id.botonAccion)
        val limpiar = findViewById<Button>(R.id.botonLimpiar)
        val infoRes = findViewById<TextView>(R.id.resultado)

        num1.doAfterTextChanged {
            limpiar.visibility = View.VISIBLE
        }
        num2.doAfterTextChanged {
            limpiar.visibility = View.VISIBLE
        }
        calcular.setOnClickListener {
            if(!checkSuma.isChecked && !checkResta.isChecked){
                Toast.makeText(this, "No s'ha marcat cap opció", Toast.LENGTH_SHORT).show()
            }
            else if(num1.text.isEmpty() || num2.text.isEmpty()){
                Toast.makeText(this, "Introdueix els dos números", Toast.LENGTH_SHORT).show()
            }
            else{
                if(checkSuma.isChecked && checkResta.isChecked){
                    infoRes.text = "El resultado de la suma es ${num1.text.toString().toInt() + num2.text.toString().toInt()}\nEl resultado de la resta es ${num1.text.toString().toInt() - num2.text.toString().toInt()}"
                }
                else if(checkSuma.isChecked){
                    infoRes.text = "El resultado de la suma es ${num1.text.toString().toInt() + num2.text.toString().toInt()}"
                }
                else{
                    infoRes.text = "El resultado de la resta es ${num1.text.toString().toInt() - num2.text.toString().toInt()}"
                }
                infoRes.visibility = View.VISIBLE
            }
        }
        limpiar.setOnClickListener {
            num1.text.clear()
            num2.text.clear()
            checkSuma.isChecked = false
            checkResta.isChecked = false
            limpiar.visibility = View.GONE
            infoRes.visibility = View.GONE
        }
    }
}