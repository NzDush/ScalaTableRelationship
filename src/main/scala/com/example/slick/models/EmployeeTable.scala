package com.example.slick.models

import com.example.slick.connection.{DatabaseComponent, MysqlComponent}

//case class Employee(id: Int, name: String, address: String, salary: Option[Double])

trait EmployeeTable extends MysqlComponent{
  this: DatabaseComponent =>
  import driver.api._

  type EMPLOYEE = (Int, String, String, Double)
  class EMPLOYEES(tag: Tag) extends Table[EMPLOYEE](tag, "Employee"){
    def id = column[Int]("employee_id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def address = column[String]("address")
    def salary = column[Double]("salary")
    def * = (id, name, address, salary)
  }
  lazy val employees = TableQuery[EMPLOYEES]

}