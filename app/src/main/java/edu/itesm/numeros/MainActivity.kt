package edu.itesm.numeros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import edu.itesm.numeros.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var mList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater) // Construimos interfaz gráfica
        setContentView(binding.root)
        initUI()

    }

    private fun initUI()
    {
        //Plus button
        binding.agregar.setOnClickListener {
            if(binding.textBox.text.toString().toIntOrNull()!=null) {
                mList.add(binding.textBox.text.toString().toInt())
                binding.textBox.text = null
                showMutableListInt(mList)
            }else {
                Toast.makeText(this, "Valor no válido", Toast.LENGTH_LONG).show()
            }

        }
        //Clear collection button
        binding.clearButton.setOnClickListener {
            mList.clear()
            showMutableListInt(mList)
        }
        //Regular mean button
        binding.promedio.setOnClickListener {
            binding.resultados.text = mList.average().toString()
        }
        //Max button
        binding.mayor.setOnClickListener {
            binding.resultados.text = mList.maxOrNull().toString()
        }
        //Promedio de pares button
        binding.pares.setOnClickListener {
            binding.resultados.text = mList.filter { x -> x % 2 == 0 }.average().toString()
        }
    }


    private fun showMutableListInt(list : MutableList<Int>)
    {
        binding.collectionContent.text = list.toString()
    }
}