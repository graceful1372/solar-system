package ir.hmb72.space.data.model.home

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class PlanetModel(
    val id: Int,
    val name: String,
    val imageUrl :Int?,
    val distanceFromSun: Double?,
    val size: Double?,
    val moons: @RawValue List<Moon>?,
    val description: String?
):Parcelable{
    data class Moon(
        val id: Int,
        val name: String,
        val radius: Double,
        val distanceFromPlanet: Double,
        val description: String

    )
}
