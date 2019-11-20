package com.example.slick.models

import com.example.slick.connection.{DatabaseComponent, MysqlComponent}

//case class Manufacturer(id: Int, name: Option[String], country: Option[String])

trait ManufacturerTable extends MysqlComponent {
  this: DatabaseComponent =>
  import driver.api._

  type MANUFACTURER = (Int, String, String)
  class MANUFACTURERS(tag: Tag) extends Table[MANUFACTURER](tag, "Manufacturer"){
    def id = column[Int]("manufacturer_id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def country = column[String]("country")
    def * = (id, name, country)
  }
  lazy val manufacturers = TableQuery[MANUFACTURERS]

}