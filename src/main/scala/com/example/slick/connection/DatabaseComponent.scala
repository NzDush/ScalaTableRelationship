package com.example.slick.connection

import slick.jdbc.JdbcProfile

trait DatabaseComponent {

  val driver: JdbcProfile
  import driver.api._

  def db: Database

}
