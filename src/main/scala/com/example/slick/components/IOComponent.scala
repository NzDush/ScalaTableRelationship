package com.example.slick.components

import com.example.slick.connection.MysqlComponent

trait IOComponent extends MysqlComponent{

  def printList(args: List[_]): Unit = {
    args.foreach(println)
  }

}
