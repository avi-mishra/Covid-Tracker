package android.example.covidtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    var cases= ArrayList<RVDataClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runBlocking {
            fetchResults()
        }

    }


    suspend fun fetchResults() {
        GlobalScope.launch (Dispatchers.Main){
            val response= withContext(Dispatchers.IO){
                Retrofit.api.getAll()
            }
            if(response.isSuccessful){
                var case= response.body()?.statewise
                if (case != null) {
                    for (i in 0..case.size - 1) {
                        var obj = case.get(i).state?.let {
                            case.get(i).confirmed?.let { it1 ->
                                case.get(i).active?.let { it2 ->
                                    case.get(i).recovered?.let { it3 ->
                                        case.get(i).deaths?.let { it4 ->
                                            RVDataClass(
                                                it,
                                                it1.toLong(),
                                                it2.toLong(),
                                                it3.toLong(),
                                                it4.toLong()
                                            )
                                        }
                                    }
                                }
                            }
                        }
                        if (obj != null) {
                            cases.add(obj)
                        }
                    }
                    rvStates.layoutManager=LinearLayoutManager(this@MainActivity)
                    rvStates.adapter=MyAdapter(cases)
                }
            }
        }
    }
}