package com.cookandroid.ch06_2023_no_xml

class Car(name:String, count: Int, color:String) {
    var name: String
    var count: Int
    var color: String
    init {
        this.name = name
        this.count = count
        this.color = color
    }

    fun infoColorPrint():String{
        return this.color;
    }

    fun someFun() {
        println("name: $name, count: $count")
    }
}