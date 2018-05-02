import java.util.*

fun main(args: Array<String>) {

    BaseLugarTuristicoTemporal.datos.add(LugarTuristicoTemporal("Machachi","Desfiles","1820-actualidad","Cantonizacionn",9,"Paseo del Chagra",Date("1748/04/05"),null,"Mejia","Publico"))
    BaseLugarTuristicoTemporal.datos.add(LugarTuristicoTemporal("Latacunga","Desfiles","1811-actualidad","Fundacion",8,"Mama Negra",Date("1750/10/18"),null,"Ambato","Publico"))
    println(BaseLugarTuristicoTemporal.recuperarPorIndice(1))
    println()
    println(BaseLugarTuristicoTemporal.recuperarPorIndice(0))



    BaseLugares.datos.add(cantones("Pichincha","Turistico","1887-actualidad","Tomás Halflants",9,"Quito",arrayOf("Iglesia de la Basilica ", "Parque Metropolitano","La Carolina", "Parque de las Cuadras"),"Activo"))
    BaseLugares.datos.add(cantones("Chimborazo","Iglesias","1977-actualidad","Creacion Historica",8,"Riobamba",arrayOf("Iglesia la Concepcion", "Iglesia Balbanera","Iglesia Sagrado Corazon", "Plaza Sucre"),"Activo"))
    println(BaseLugares.recuperarPorIndice(1))
    println()
    println(BaseLugares.recuperarPorIndice(0))



}

open class LugarTuristico(val nNombre: String,
                          val nEstilo: String,
                          val nDuracion: String,
                          val nCreador: String,
                          val nCalificacion: Int) {
}

class LugarTuristicoTemporal(nombre: String,
                             Estilo: String,
                             tiempo: String,
                             Creador: String,
                             calificacion: Int,
                             val nNombreReal: String,
                             val nFechaInicio: Date,
                             val nFinalizacion: Date?,
                             val nProvincia: String,
                             val nPublicoOPrivado: String) : LugarTuristico(nombre, Estilo, tiempo, Creador, calificacion) {

    override fun toString(): String {
        return "Lugar: $nNombre" + '\n' +
                "Estilo: $nEstilo" + '\n' +
                "Duracion del Lugar Turistico o Evento: $nDuracion" + '\n' +
                "Creacion Lugar o Evento: $nCreador" + '\n' +
                "Califiacion Sitio Turistico: $nCalificacion" + '\n' +
                "Nombre Lugar Conocido: $nNombreReal" + '\n' +
                "Fecha de Creacion Fundacion del Lugar: $nFechaInicio" + '\n' +
                "Fecha De Finalizacion: $nFinalizacion" + '\n' +
                "Provincia: $nProvincia" + '\n' +
                "Sea Publico o Privado: $nPublicoOPrivado" + '\n'

    }
}

class cantones(nombre: String,
               Estilo: String,
               tiempo: String,
               Creador: String,
               calificacion: Int,
               val nCantonOrigen: String,
               var nOtrosLugares: Array<String>,
               val nEstado: String): LugarTuristico(nombre, Estilo, tiempo, Creador, calificacion) {

    fun getOtrosLugares(otrosLugares: Array<String>):String{
        var salida=""
        for (posicion in otrosLugares.indices)
            if((posicion+1)==otrosLugares.size){
                salida =salida+otrosLugares.get(posicion)
            }else salida =salida+otrosLugares.get(posicion)+", "
        return salida;
    }

    override fun toString(): String {
        return "Lugar: $nNombre" + '\n' +
                "Estilo: $nEstilo" + '\n' +
                "Duracion Del Evento: $nDuracion" + '\n' +
                "Creador: $nCreador" + '\n' +
                "Calificacion: $nCalificacion" + '\n' +
                "Fecha de Fundacion u Origen: $nCantonOrigen" + '\n' +
                "Otros Lugares: ${getOtrosLugares(this.nOtrosLugares)}" + '\n' +
                "Estado: $nEstado" + '\n'

    }
}

class BaseLugares{
    companion object {
        val datos: ArrayList<cantones> = ArrayList()

        fun recuperarPorIndice(indice:Int): cantones? {
            for (indiceArreglo in datos.indices){
                if(indiceArreglo == indice){
                    return datos[indiceArreglo]
                }
            }
            return null
        }
    }
}

class BaseLugarTuristicoTemporal{
    companion object {
        val datos: ArrayList<LugarTuristicoTemporal> = ArrayList()

        fun recuperarPorIndice(indice:Int): LugarTuristicoTemporal? {
            for (indiceArreglo in datos.indices){
                if(indiceArreglo == indice){
                    return datos[indiceArreglo]
                }
            }
            return null
        }
    }
}
