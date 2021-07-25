package android.example.covidtracker

data class RVDataClass(
    val state:String,
    val confirmed:Long,
    val active:Long,
    val recovered:Long,
    val deaths:Long,
)
