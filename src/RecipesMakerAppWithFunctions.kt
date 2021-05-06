/**
 * Debe mostrar el menú
 */
fun makeRecipe(ingredientes: List<String>) : MutableList<MutableList<String?>?>? {

    var anotherReceta: MutableList<String?>? = mutableListOf()
    var recetas: MutableList<MutableList<String?>?>? = mutableListOf()

    if(ingredientes.isEmpty()) {
        throw Error("La lista debe estar cargada")
    }

    println("Ingredientes que puedes utilizar")
    println(ingredientes.toString())
    println("Elige un numero para seleccionar el ingrediente:(9 para salir)")
    var res = readLine()?.toInt() ?: 9
    var bandera = false

    if(res !in 1..9) {
        println("Solamente se admiten opciones del 1 al 9")
        return recetas
    }

    if(res.equals(9)) return recetas

    while (res != 0) {
        for ((index, value) in ingredientes.withIndex()){
            if (res?.equals(index+1)) {

                bandera = true
                anotherReceta?.add(value)

                println("Elige un número para seleccionar el ingrediente:(0 para salir)")
                res = readLine()?.toInt() ?: 0

            } else {
                bandera = false
            }
        }
        recetas?.add(anotherReceta)
        if(!bandera) println("No existe el ingrediente")
    }
    return recetas
}

/**
 * Mostrará el título de la categoría ingresada, así: Ver mis recetas
 */
fun viewRecipe(recetas: MutableList<MutableList<String?>?>?){
    println("-------Recetas guardadas-------")
    println(recetas?.toString())
    println("--------------")
}

fun main() {

    var opcion: String = ""
    val ingredientes = listOf<String>("1.Agua", "2.Leche", "3.Carne", "4.Verduras"
        , "5.Frutas", "6.Cereal", "7.Huevos", "8.Aceite")
    var recetas: MutableList<MutableList<String?>?>? = null

    do {
        println(".: Bienvenido a RecipeMaker V2::")
        println("\n")
        println("Selecciona la opción deseada")
        println("1. Hacer una receta")
        println("2. Ver mis recetas")
        println("3. Salir")
        opcion = readLine().toString()
        when(opcion) {
            "1" -> {
                recetas = makeRecipe(ingredientes)
            }
            "2" -> viewRecipe(recetas)
            "3" -> println("Saliste")
        }
    } while (!opcion.equals("3"))

}