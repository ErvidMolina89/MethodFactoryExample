package com.ceiba.factoryimplementation.util

enum class PizzaType {
    ORIGINAL,
    SPECIAL,
    VEGETARIAN,
    MEXICAN,
    MEATS;
    fun getImage(): String{
        return when(this){
            ORIGINAL -> "https://placeralplato.com/files/2016/01/Pizza-con-pepperoni.jpg"
            SPECIAL -> "https://previews.123rf.com/images/suksao/suksao1504/suksao150400101/38717129-pizza-amante-carne-con-salchichas-salami-jam%C3%B3n-tocino-pepperoni-y-queso-en-el-restaurante-.jpg"
            VEGETARIAN -> "https://recetasdecocinafaciles.net/wp-content/uploads/2018/01/pizza-vegetariana.jpg"
            MEXICAN -> "https://t1.rg.ltmcdn.com/es/images/2/1/2/img_pizza_mexicana_7212_paso_7_600.jpg"
            MEATS -> "https://www.pizzaspiccolo.com.co//wp-content/uploads/2015/11/pizza-carnes-sp-1.jpg"
        }
    }
}