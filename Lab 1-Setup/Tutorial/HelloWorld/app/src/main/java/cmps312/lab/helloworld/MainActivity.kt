package cmps312.lab.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showBtn.setOnClickListener {

            val x = "1111".toInt(); //casting the string value to integer

            val name = nameEdt.text.toString();
            displayTv.text = "Welcome Mr. $name to Android App Dev" ;
            Toast.makeText(this, "Wow button click works", Toast.LENGTH_SHORT).show()
        }
    }
}