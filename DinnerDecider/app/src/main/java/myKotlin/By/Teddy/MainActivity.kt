package myKotlin.By.Teddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.app.AlertDialog
import kotlin.By.Teddy.R

class MainActivity : AppCompatActivity() {


    val foodList = arrayListOf("Chinese", "Hamburger", "Pizza", "Mc Donalds", "Koti Pizza")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDeside.setOnClickListener {
            val random = Random()
            val randomFood = random.nextInt(foodList.count())
            lblSelectedFood.text = foodList[randomFood]
        }

        btnAddFood.setOnClickListener {
            if (txtAddFood.text.isNullOrBlank()){
                val mAlertDialog = AlertDialog.Builder(this@MainActivity)
                mAlertDialog.setIcon(R.mipmap.ic_launcher_round) //set alertdialog icon
                mAlertDialog.setTitle("Info!") //set alertdialog title
                mAlertDialog.setMessage("New food cant be empty") //set alertdialog message
                mAlertDialog.setPositiveButton("Yes") { dialog, id ->
                    //perform some tasks here
                    Toast.makeText(this@MainActivity, "OK", Toast.LENGTH_SHORT).show()
                }

                mAlertDialog.show()
            }
            else {
                val newFood = txtAddFood.text.toString()
                foodList.add(newFood)
                txtAddFood.text.clear()
                println(foodList)
            }

        }


    }
}
