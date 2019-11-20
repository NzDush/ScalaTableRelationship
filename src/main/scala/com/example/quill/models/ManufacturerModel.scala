package com.example.quill.models

import com.example.quill.connection.MysqlComponent

case class Manufacturer(manufacturer_id: Int, name: String, country: String)

trait ManufacturerModel extends MysqlComponent{

  import ctx._

  val manufacturerTable = quote {
    querySchema[Manufacturer]("Manufacturer"
//
    )
  }

}
