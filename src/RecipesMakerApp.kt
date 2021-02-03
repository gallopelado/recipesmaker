fun main(){
    var opcion: String = ""
    val ingredientes = listOf<String>("1.Agua", "2.Leche", "3.Carne", "4.Verduras"
        , "5.Frutas", "6.Cereal", "7.Huevos", "8.Aceite")
    val receta: MutableList<String?>? = mutableListOf("3.Carne")
    var recetas: MutableList<MutableList<String?>?>? = mutableListOf(receta)
    var bandera: Boolean = true
    var anotherreceta: MutableList<String?>? = mutableListOf()
    do {
        println(".: Bienvenido a RecipeMaker ::")
        println("\n")
        println("Selecciona la opción deseada")
        println("1. Hacer una receta")
        println("2. Ver mis recetas")
        println("3. Salir")
        opcion = readLine().toString()

        println("\n\n\n\n")
        when(opcion) {
            "1" -> {
                println("Ingredientes que puedes utilizar")
                println(ingredientes.toString())
                print("Elige un numero para seleccionar el ingrediente:(9 para salir)")
                var res = readLine()?.toInt()
                if (res == null) {
                    return
                }
                if(res !in 1..9) {
                    println("Solamente se admiten opciones del 1 al 9")
                    return
                }

                while(res != 0) {
                    for((index, value) in ingredientes.withIndex()){
                        if(res?.equals(index+1) == true){
                            bandera = true
                            anotherreceta?.add(value)

                            print("Elige un numero para seleccionar el ingrediente:(0 para salir)")
                            res = readLine()?.toInt()
                        } else {
                            bandera = false
                        }
                    }
                    recetas?.add(anotherreceta)
                    if(!bandera) println("No existe el ingrediente")
                }
            }
            "2" ->{
                println("-------Recetas guardadas-------")
                println(recetas?.toString())
                println("--------------")
            }
            "3" -> println("Saliste")
        }
    } while (!opcion.equals("3"))
}