package com.tis.ejemploservicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.Debug
import com.tis.ejemploservicios.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val miCliente = getRetrofit()






    }
    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/breed/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
    private fun searchByName(query:String){

        //Implementar background processing
        CoroutineScope(Dispatchers.IO).launch {
            //El codigo generado en este bloque, se ejecutara en un hilo secundario
            val call:Response<DogsResponse> = getRetrofit().create(APIService::class.java).getDogsByBreads("$query/images")
            val puppies:DogsResponse? = call.body()
            Debug.logStack("Perros",puppies!!.images.toString(),1 )
        }


        //Implementar la logica de pintar la UI




    }
}