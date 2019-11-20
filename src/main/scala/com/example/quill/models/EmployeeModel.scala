package com.example.quill.models

import com.example.quill.connection.MysqlComponent

case class Employee(employee_id: Int, name: String, address: String, salary: Double)

trait EmployeeModel extends MysqlComponent{

  import ctx._

  val employeeTable = quote {
    querySchema[Employee]("Employee"
//
    )
  }

}
