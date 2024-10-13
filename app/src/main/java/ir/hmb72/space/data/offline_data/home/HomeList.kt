package ir.hmb72.space.data.offline_data.home


import android.content.Context
import ir.hmb72.space.R
import ir.hmb72.space.data.model.home.CategoryModel
import ir.hmb72.space.data.model.home.PlanetModel
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.hmb72.space.utils.ALL
import ir.hmb72.space.utils.COMETS
import ir.hmb72.space.utils.MOONS
import ir.hmb72.space.utils.PLANET
import ir.hmb72.space.utils.SATELLITES
import ir.hmb72.space.utils.STARS
import javax.inject.Inject

class HomeList @Inject constructor(@ApplicationContext private val context: Context) {

    val listCategory = listOf(
        CategoryModel(1, ALL),
        CategoryModel(2, PLANET),
        CategoryModel(3, STARS),
        CategoryModel(4, COMETS),
        CategoryModel(5, SATELLITES),
        CategoryModel(6, MOONS)
    )
    val listPlanet = listOf(

        PlanetModel(
            1,
            context.getString(R.string.Mercury),
            R.drawable.img_palent_mercury,
            2439.7,
            4870.0,
            listOf(),
            context.getString(R.string.description_mercury)

        ),
        PlanetModel(
            2,
            context.getString(R.string.Venus),
            R.drawable.img_planet_venus,
            108000000.0,
            12104.0,
            listOf(),
            context.getString(R.string.description_venus)
        ),
        PlanetModel(
            3,
            context.getString(R.string.Earth),
            R.drawable.img_planet_earth,
            150000000.0,
            12742.0,
            listOf(),
            context.getString(R.string.description_earth)
        ),
        PlanetModel(
            4,
            context.getString(R.string.Mars),
            R.drawable.img_planet_mars,
            228000000.0,
            6779.0,
            listOf(),
            context.getString(R.string.description_mars)
        ),
        PlanetModel(
            5,
            context.getString(R.string.Jupiter),
            R.drawable.img_planet_jupiter,
            778000000.0,
            14983.0,
            listOf(),
            context.getString(R.string.description_jupiter)
        ),
        PlanetModel(
            6,
            context.getString(R.string.Saturn),
            R.drawable.img_planet_saturn,
            1450000000.0,
            125046.0,
            listOf(),
            context.getString(R.string.description_saturn)
        ),
        PlanetModel(
            7,
            context.getString(R.string.Uranus),

            R.drawable.img_planet_uranus,
            2809000000.0,
            51118.0,
            listOf(),
            context.getString(R.string.description_uranus)
        ),
        PlanetModel(
            8,
            context.getString(R.string.Neptune),
            R.drawable.img_planet_neptune,
            4555000000.0,
            49540.0,
            listOf(),
            context.getString(R.string.description_neptune)
        ),


        )
    val listStars = listOf(

        PlanetModel(
            1,
            context.getString(R.string.Polaris),
            R.drawable.img_star_polaris,
            4110000000.0,
            31000000.0,
            null,
            context.getString(R.string.description_polaris)
        ),
        PlanetModel(
            2,
            context.getString(R.string.Sirius),
            R.drawable.img_star_sirius,
            80000000.0,
            2370000.0,
            null,
            context.getString(R.string.description_sirius)
        ),
        PlanetModel(
            3,
            context.getString(R.string.Alpha_Centauri),
            R.drawable.img_star_alpha_centauri2,
            40000000000000.0,
            1670400.0,
            null,
            context.getString(R.string.description_alpha_centaur)
        ),
        PlanetModel(
            4,
            context.getString(R.string.Betelgeuse),
            R.drawable.img_star_betelgeuse,
            6022400000000.0,
            970000000.0,
            null,
            context.getString(R.string.description_betelgeuse)
        ),
        PlanetModel(
            5,
            context.getString(R.string.Rigel),
            R.drawable.img_star_rigel,
            8140600000000.0,
            108000000.0,
            null,
            context.getString(R.string.description_rigel)
        ),
        PlanetModel(
            6,
            context.getString(R.string.Vega),
            R.drawable.img_star_vega,
            239000000000000.0,
            2900000.0,
            null,
            context.getString(R.string.description_vega)
        ),
        PlanetModel(
            7,
            context.getString(R.string.Pleiades),
            R.drawable.img_star_pleiades,
            411000000000000.0,
            113520000000000.0,
            null,
            context.getString(R.string.description_pleiades)
        ),
        PlanetModel(
            8,
            context.getString(R.string.Antares),
            R.drawable.img_star_antares,
            5203000000000.0,
            949760000.0,
            null,
            context.getString(R.string.description_antares)
        ),
        PlanetModel(
            9,
            context.getString(R.string.Canopus),
            R.drawable.img_star_canopus,
            2928600000000.0,
            97440000.0,
            null,
            context.getString(R.string.description_canopus)
        ),
    )
    val listComet = listOf(
        PlanetModel(
            1,
            context.getString(R.string.hale_bopp),
            R.drawable.img_comet_hale_bopp,
            null,
            null,
            null,
            context.getString(R.string.description_hale_bopp)
        ),
        PlanetModel(
            2,
            context.getString(R.string.halley),
            R.drawable.img_comet_halley
            ,
            null,
            null,
            null,
            context.getString(R.string.description_halley)
        ),
        PlanetModel(
            3,
            context.getString(R.string.shoemaker_levy),
            R.drawable.img_comet_shoemaker_levy,
            null,
            null,
            null,
            context.getString(R.string.description_shoemaker_levy)
        ),
        PlanetModel(
            4,
            context.getString(R.string.wilson_harrington),
            R.drawable.img_comet_wilson_harrington,
            null,
            null,
            null,
            context.getString(R.string.description_wilson_harrington)
        ),
        PlanetModel(
            5,
            context.getString(R.string.wise_shimizu),
           R.drawable.img_comet_wise_shimizu,
            null,
            null,
            null,
            context.getString(R.string.description_wise_shimizu)
        ),PlanetModel(
            6,
            context.getString(R.string.berry_yang),
           R.drawable.img_comet_berry_yang,
            null,
            null,
            null,
            context.getString(R.string.description_berry_yang)
        ),PlanetModel(
            6,
            context.getString(R.string.scotti_corley),
           R.drawable.img_comet_scotti_corley,
            null,
            null,
            null,
            context.getString(R.string.description_scotti_corley)
        ),
    )
    val listSatellite = listOf(
        PlanetModel(
            1,
            context.getString(R.string.sputnik),
            R.drawable.img_satellite_sputnik,
            null,
            null,
            null,
            context.getString(R.string.description_sputnik)
        ),
        PlanetModel(
            2,
            context.getString(R.string.explorer),
            R.drawable.img_satellite_expoler,
            null,
            null,
            null,
            context.getString(R.string.description_explorer)
        ),
        PlanetModel(
            3,
            context.getString(R.string.hubble),
            R.drawable.img_satellite_hubble,
            null,
            null,
            null,
            context.getString(R.string.description_hubble)
        ),
        PlanetModel(
            4,
            context.getString(R.string.international_space_station),
            R.drawable.img_satellite_space_station,
            null,
            null,
            null,
            context.getString(R.string.description_international_space_station)
        ),
        PlanetModel(
            5,
            context.getString(R.string.hatef),
            R.drawable.img_satellite_hatef,
            null,
            null,
            null,
            context.getString(R.string.description_hatef)
        ),
        PlanetModel(
            6,
            context.getString(R.string.gps),
            R.drawable.img_satellite_gps,
            null,
            null,
            null,
            context.getString(R.string.description_gps)
        ),
        PlanetModel(
            7,
            context.getString(R.string.starlink),
            R.drawable.img_satellite_starlink,
            null,
            null,
            null,
            context.getString(R.string.description_starlink)
        ),
        PlanetModel(
            8,
            context.getString(R.string.jamez_web),
            R.drawable.img_satellite_jemzweb,
            null,
            null,
            null,
            context.getString(R.string.description_jamez_web)
        ),


        )
    val listMoons = listOf(
        PlanetModel(1 ,context.getString(R.string.moon_earth) , R.drawable.img_moon_earth , null ,null ,null ,context.getString(R.string.description_moon_earth) ),
        PlanetModel(2 ,context.getString(R.string.moon_jupiter_callisto) ,R.drawable.img_moon_jupiter_callisto , null ,null ,null ,context.getString(R.string.description_moon_jupiter_callisto) ),
        PlanetModel(3 ,context.getString(R.string.moon_jupiter_europa) , R.drawable.img_moon_jupiter_europa , null ,null ,null ,context.getString(R.string.description_moon_jupiter_europa) ),
        PlanetModel(4 ,context.getString(R.string.moon_jupiter_ganymed) , R.drawable.img_moon_jupiter_ganymed, null ,null ,null ,context.getString(R.string.description_moon_jupiter_ganymed) ),
        PlanetModel(6 ,context.getString(R.string.moon_jupiter_io) , R.drawable.img_moon_jupiter_io, null ,null ,null ,context.getString(R.string.description_moon_jupiter_io) ),
        PlanetModel(7 ,context.getString(R.string.moon_mars_deimos) , R.drawable.img_moon_mars_deimos, null ,null ,null ,context.getString(R.string.description_moon_mars_deimos) ),
        PlanetModel(8 ,context.getString(R.string.moon_mars_phobos) , R.drawable.img_moon_mars_phobos , null ,null ,null ,context.getString(R.string.description_moon_mars_phobos) ),
        PlanetModel(9,context.getString(R.string.moon_saturn_dione) , R.drawable.img_moon_saturn_dione , null ,null ,null ,context.getString(R.string.description_moon_saturn_dione) ),
        PlanetModel(10 ,context.getString(R.string.moon_saturn_enselados) , R.drawable.img_moon_saturn_enselados, null ,null ,null ,context.getString(R.string.description_moon_saturn_enselados) ),
        PlanetModel(11,context.getString(R.string.moon_saturn_mimas) , R.drawable.img_moon_saturn_mimas, null ,null ,null ,context.getString(R.string.description_moon_saturn_mimas) ),
        PlanetModel(12 ,context.getString(R.string.moon_saturn_rhea) , R.drawable.img_moon_saturn_rhea, null ,null ,null ,context.getString(R.string.description_moon_saturn_rhea) ),
        PlanetModel(13,context.getString(R.string.moon_saturn_tethys) , R.drawable.img_moon_saturn_tethys, null ,null ,null ,context.getString(R.string.description_moon_saturn_tethys) ),
        PlanetModel(14,context.getString(R.string.moon_saturn_titan) , R.drawable.img_moon_saturn_titan, null ,null ,null ,context.getString(R.string.description_moon_saturn_titan) ),
        PlanetModel(15,context.getString(R.string.moon_uranos_ariel) , R.drawable.img_moon_uranos_ariel, null ,null ,null ,context.getString(R.string.description_moon_uranos_ariel) ),
        PlanetModel(16,context.getString(R.string.moon_uranos_oberon) , R.drawable.img_moon_uranos_oberon, null ,null ,null ,context.getString(R.string.description_moon_uranos_oberon) ),
        PlanetModel(17,context.getString(R.string.moon_uranos_titania) , R.drawable.img_moon_uranos_titania, null ,null ,null ,context.getString(R.string.description_moon_uranos_titania) ),
    )
    val listNews = listOf(
        PlanetModel(1 ,context.getString(R.string.one) ,null ,null ,null,null,context.getString(R.string.description_one)),
        PlanetModel(2 ,context.getString(R.string.two), null ,null ,null,null,context.getString(R.string.description_two)),
        PlanetModel(3 ,context.getString(R.string.three), null ,null ,null,null,context.getString(R.string.description_three)),
        PlanetModel(4 ,context.getString(R.string.four), null ,null ,null,null,context.getString(R.string.description_four)),
        PlanetModel(5 ,context.getString(R.string.five), null ,null ,null,null,context.getString(R.string.description_five)),
        PlanetModel( 6,context.getString(R.string.six), null ,null ,null,null,context.getString(R.string.description_six)),
        PlanetModel( 7,context.getString(R.string.seven), null ,null ,null,null,context.getString(R.string.description_seven)),
        PlanetModel( 8,context.getString(R.string.eight), null ,null ,null,null,context.getString(R.string.description_eight)),
        PlanetModel( 9,context.getString(R.string.nine), null ,null ,null,null,context.getString(R.string.description_nine)),
        PlanetModel( 10,context.getString(R.string.ten), null ,null ,null,null,context.getString(R.string.description_ten)),


    )
    val combinedlist: List<PlanetModel> = listPlanet + listStars + listComet + listSatellite + listMoons

}