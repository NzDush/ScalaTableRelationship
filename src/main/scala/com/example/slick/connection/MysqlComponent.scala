package com.example.slick.connection

import slick.driver.MySQLDriver

trait MysqlComponent extends DatabaseComponent {

  val driver = MySQLDriver
  import driver.api._

  val db = Database.forConfig("mysqlDatabase")

}
