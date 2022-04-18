package com.example.pr1_carlos_cristina

class PatinetsVo {
    var nombre: String? = null
    var info: String? = null
    var foto = 0

    constructor() {}
    constructor(nombre: String?, info: String?, foto: Int) {
        this.nombre = nombre
        this.info = info
        this.foto = foto
    }
}