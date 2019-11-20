package com.example.slick.components

import com.example.slick.connection.{DatabaseComponent, MysqlComponent}
import com.example.slick.models.{AssetTable, ManufacturerTable}
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

object AssetComponent extends MysqlComponent with
                              ManufacturerTable with
                              AssetTable {

  this:DatabaseComponent =>
  import driver.api._

  def findById(asId: Int): Future[Seq[ASSET]] = {
    val query = {
      assets
        .filter(_.id === asId)
    }
    val action = query.result

//    val sql = action.statements.head
//    println(sql)

    val result = db.run(action)
    result
  }

  def findByIdWithTableMapping(asId: Int): Future[Seq[MANUFACTURER]] = {
    val query = {
      assets
        .filter(_.id === asId)
        .flatMap(_.manufacturer)
    }
    val action = query.result

//    val sql = action.statements.head
//    println(sql)

    val result = db.run(action)
    result
  }

  def findByIdExtended: Unit ={
    val result0 = Await.result(findById(3), Duration.Inf)
    val result1 = result0.head
    println(result1)
  }

}

