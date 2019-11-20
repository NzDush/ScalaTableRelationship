package com.example.slick.models

import com.example.slick.connection.{DatabaseComponent, MysqlComponent}

//case class Asset(id: Int, name: String, value: Option[Double], employee_id: Int, manufacturer_id: Int)

trait AssetTable extends MysqlComponent with EmployeeTable with ManufacturerTable{
  this: DatabaseComponent =>
  import driver.api._

  type ASSET = (Int, String, Double, Int, Int)
  class ASSETS(tag: Tag) extends Table[ASSET](tag, "Asset"){
    def id = column[Int]("asset_id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def value = column[Double]("asset_value")
    def employee_id = column[Int]("employee_id")
    def manufacturer_id = column[Int]("manufacturer_id")
    def *  = (id, name, value, employee_id, manufacturer_id)
    def manufacturer = foreignKey("Manufacturer", manufacturer_id, manufacturers)(_.id)
    def employee = foreignKey("Empoyee", employee_id, employees)(_.id)
  }
  lazy val assets = TableQuery[ASSETS]

}